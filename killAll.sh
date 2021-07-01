lsof -t -i:3000 | xargs kill -9
lsof -t -i:8081 | xargs kill -9
lsof -t -i:8082 | xargs kill -9
lsof -t -i:8083 | xargs kill -9
lsof -t -i:8080 | xargs kill -9
lsof -t -i:8761 | xargs kill -9