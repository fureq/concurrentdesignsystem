package com.concurrentdesignsystem;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class ConcurrentDesignSystemApplication {

    public static void main(String[] args) {
        //SpringApplication.run(ConcurrentDesignSystemApplication.class, args);
        List<Step> steps = new ArrayList<>();
        for (int i = 1; i <= 1200; i++) {
            String file = "test_data/temperature " + String.format("%05d", i) + ".k";
            System.out.println("Parsing file " + file);

            List<Node> nodes = new ArrayList<>();
            List<ElementSolid> elements = new ArrayList<>();
            try (BufferedReader in = new BufferedReader(new FileReader(file))) {
                String line = null;
                boolean parsingNodes = true;
                while ((line = in.readLine()) != null) {
                    if (line.startsWith("*NODE")) {
                        parsingNodes = true;
                        continue;
                    } else if (line.startsWith("*ELEMENT_SOLID")) {
                        parsingNodes = false;
                        continue;
                    } else if (line.startsWith("*END")) {
                        System.out.println("Finished processing");
                        continue;
                    }
                    String[] values = line.split(",");
                    if (parsingNodes) {
                        nodes.add(new Node(
                                Integer.parseInt(values[0].trim()),
                                Double.parseDouble(values[1].trim()),
                                Double.parseDouble(values[2].trim()),
                                Double.parseDouble(values[3].trim()),
                                Double.parseDouble(values[4].trim())));
                    } else {
                        elements.add(new ElementSolid(
                                Integer.parseInt(values[0].trim()),
                                Integer.parseInt(values[1].trim()),
                                Integer.parseInt(values[2].trim()),
                                Integer.parseInt(values[3].trim()),
                                Integer.parseInt(values[4].trim()),
                                Integer.parseInt(values[5].trim()),
                                Integer.parseInt(values[6].trim()),
                                Integer.parseInt(values[7].trim()),
                                Integer.parseInt(values[8].trim())
                        ));
                    }
                }
            } catch (Exception e) {
                System.out.println(e);
            }
            steps.add(new Step(i, nodes, elements));
        }
        try {
            PrintWriter printWriter = new PrintWriter("data.json", "UTF-8");
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
            objectMapper.writeValue(printWriter, steps);
            printWriter.close();
        } catch (Exception e) {
            System.out.print(e);
        }

    }
}
