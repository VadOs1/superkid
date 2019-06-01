# Build
- **gradle clean build**

# Run Jar
- **java -Dsuperkid.mail.username=name -Dsuperkid.mail.password=pass -jar -Dspring.profiles.active=dev build/libs/superkid-2.0.1-SNAPSHOT.war**

# Run Docker
- **docker run -p 80:80 -e spring.profiles.active=dev -e superkid.mail.username=name -e superkid.mail.password=pass vadimdissa/superkid-service:2.0.1**

# Run Docker compose
- **cd src/main/deployment/docker**
- **docker-compose up -d**

# AWS ECS Required Environment Variables
- **AWS_ACCESS_KEY_ID**
- **AWS_SECRET_ACCESS_KEY**

# AWS ECS Deployment
- **(aws ecr get-login --no-include-email --region us-east-1)**
- **docker tag vadimdissa/superkid-service:2.0.1 065320792144.dkr.ecr.us-east-1.amazonaws.com/vadimdissa/superkid-service:latest**
- **docker push 065320792144.dkr.ecr.us-east-1.amazonaws.com/vadimdissa/superkid-service:latest**