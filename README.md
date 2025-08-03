NAGP Home Assignment – Kubernetes and DevOps.
Blaze Rodrigues (blaze.rodrigues@nagarro.com)

Link for the code repository:
https://github.com/blazerodrigues/NAGP-KubernetesAndDevops
All source code is uploaded to GitHub.

Requirement Understanding:
We are required to design, containerize, and deploy a multi-tier architecture on Kubernetes involving one microservice and one database.
The system should simulate a simple real-world setup where the microservice fetches data from the database via an exposed API.
We should be able to build and push the docker images to Docker hub.

Requirements for API (microservice):
- Expose an API endpoint.
- On API invocation, it should fetch data from the database.
- API should be exposed outside the Kubernetes cluster.
- API should have 4 kubernetes pods.
- API should have rolling update support through kubernetes.

Requirements for Database:
- Database must include one table with some data.
- Database should support data persistence.
- Database should not be exposed outside the kubernetes cluster.
- Database should have 1 kubernetes pod.
- Database should NOT have rolling update support through kubernetes.
- Database should have kubernetes persistent storage.

Other Requirements:
- Microservice and Database should be on separate pods.
- The database configuration to be provided in API should be configurable from outside the pod definition file and application code (using Kubernetes ConfigMap).
- The database connection password should not be clearly visible in any Kubernetes YAML files (using Kubernetes Secrets).
- Database data should not be lost if the pod for database is re-deployed.
- Pod IPs should not be used for communication between tiers.
- Expose the API externally using Ingress.

Assumptions:
- Computer with Internet connection.
- Install IDE for coding.
- Install Java 17.
- Create Docker Hub account, Install Docker Desktop.
- Install Kubernetes kubectl.

Justification for resources utilized:
- Used Java Spring Boot to create the Microservice (API).
- Used Postgres Database for storing the data.
- Used Docker Desktop for Docker and Kubernetes.
- Although I have cloud experience, I did not use cloud due to payment constraints. 
  I did the entire setup on my laptop, which I can use anytime to practice Docker/Kubernetes.

Solution overview:
Created the API using Java Spring Boot.
<img width="959" height="473" alt="SS - IntelliJ" src="https://github.com/user-attachments/assets/64120c77-325e-46a7-82e1-c452340da8ba" />
 
Created Dockerfile to dockerize the application.
<img width="959" height="467" alt="SS - Dockerfile" src="https://github.com/user-attachments/assets/52eb702c-3feb-40eb-912f-71d534ae4d8b" />
 
Created YAML files to be used for Kubernetes
<img width="959" height="470" alt="SS - Kubernetes files" src="https://github.com/user-attachments/assets/1cbc2dfd-baed-4473-8dfa-f8a493157974" />

Ran the application and database using docker and kubernetes.

Show all objects deployed and running.
<img width="614" height="366" alt="SS - Kubernetes get all" src="https://github.com/user-attachments/assets/01728e17-be11-4831-b589-4a74a8049c82" />

Show an API call retrieving records from database.
<img width="959" height="140" alt="SS - API CURL" src="https://github.com/user-attachments/assets/ad72a9cf-088a-489d-abe4-a73e6f47566e" />

Kill API microservice pod and show it regenerates.
<img width="940" height="563" alt="image" src="https://github.com/user-attachments/assets/ea1d360c-8e47-4e04-b1f2-f7c44f147dd0" />

Kill database pod and show it regenerates and keeps old data.
<img width="940" height="257" alt="image" src="https://github.com/user-attachments/assets/2f588c9f-e6ea-4852-8d35-00d5031ffa15" />

Docker Hub URL for Docker image:
https://hub.docker.com/r/blazerodrigues/student-api
<img width="940" height="353" alt="image" src="https://github.com/user-attachments/assets/06e1fbcc-1792-4b3a-a0b5-64c9806400a6" />

URL for Service API tier to view the records from the backend:
curl http://student.local:32517/students
Note: student.local is mapped to 127.0.0.1 in C:\Windows\System32\drivers\etc\hosts file.
<img width="959" height="140" alt="SS - API CURL" src="https://github.com/user-attachments/assets/719431ab-0f08-4e6f-8d18-478b0dbbe2e9" />

Note: 32517 is the NodePort for Ingress Nginx Controller.
<img width="829" height="67" alt="SS - Ingress NodePort" src="https://github.com/user-attachments/assets/3b6d4688-54f5-44f7-9200-c21e16ce5865" />
 
Screen recording video link:
https://drive.google.com/file/d/1d4zXTDg6anI1uGCwFlCmqYwox21ZMbCn/view?usp=sharing

THANK YOU
