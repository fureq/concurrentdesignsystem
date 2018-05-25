# Concurrent Design System student project

## DB setup

To initialize your Docker DB instance with test data run following command:
```bash
docker-compose up
```

Each next time, you can just run your docker DB as usual, i.e.:
```bash
docker start concurrentdesignsystem_db
```

## Project start
Start project using Gradle command:
```bash
./gradlew bootRun
```