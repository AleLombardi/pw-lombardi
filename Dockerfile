FROM airhacks/glassfish
COPY ./target/pw-lombardi.war ${DEPLOYMENT_DIR}
