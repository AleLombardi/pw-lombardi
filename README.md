# Build
mvn clean package && docker build -t com.mycompany/pw-lombardi .

# RUN

docker rm -f pw-lombardi || true && docker run -d -p 8080:8080 -p 4848:4848 --name pw-lombardi com.mycompany/pw-lombardi 