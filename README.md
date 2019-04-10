# webappjeaapi

### To run the Wildfly server in docker, run the following command in root 
#### Windows
```docker build -t webappjeaapi . && docker run --name api -p 8080:8080 -p 9990:9990 -p 8787:8787 webappjeaapi```
#### Linux
```sudo docker build -t webappjeaapi . && sudo docker run --name api -p 8080:8080 -p 9990:9990 -p 8787:8787 webappjeaapi ```
