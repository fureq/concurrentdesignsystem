FROM mongo

COPY ./test_data.json /init.json
CMD mongoimport --host mongodb --db concurrentdesignsystem --collection StepCollection --type json --file /init.json --jsonArray