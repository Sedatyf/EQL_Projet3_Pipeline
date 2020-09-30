# Checking volumes
docker volume ls > /home/debian/scriptLogs/volume_output

# Search for volumes in the output
IS_JENKINS_DATA=$(grep 'jenkins_data' /home/debian/scriptLogs/volume_output)
IS_NEXUS_DATA=$(grep 'nexus_data' /home/debian/scriptLogs/volume_output)
IS_SONAR_DATA=$(grep 'sonar_data' /home/debian/scriptLogs/volume_output)
IS_SONAR_CONF=$(grep 'sonar_conf' /home/debian/scriptLogs/volume_output)
IS_SONAR_EXT=$(grep 'sonar_extensions' /home/debian/scriptLogs/volume_output)
IS_SONAR_LOGS=$(grep 'sonar_logs' /home/debian/scriptLogs/volume_output)

# Delete all stopped container
docker rm $(docker ps -aq)

# if IS_JENKINS_DATA is empty then create volume
if [ -z "$IS_JENKINS_DATA" ]
then
    echo "[!] No Jenkins volume detected"
    docker volume create jenkins_data
else
    echo "[*] Jenkins volume detected, moving on"
fi

# Run Jenkins
echo "[*] Launching Jenkins"
docker run -d -p 8095:8080 -p 50000:50000 -v jenkins_data:/var/jenkins_home --name jenkins jenkins/jenkins

# if IS_NEXUS_DATA is empty then create volume
if [ -z "$IS_NEXUS_DATA" ]
then
    echo "[!] No Nexus volume detected"
    docker volume create nexus_data
else
    echo "[*] Nexus volume detected, moving on"
fi

# Run Nexus
echo "[*] Launching Nexus"
docker run -d -p 8081:8081 --name nexus -v nexus_data:/nexus-data sonatype/nexus3

# if IS_SONAR_DATA is empty then create volume
if [ -z "$IS_SONAR_DATA" ]
then
    echo "[!] No Sonar Data volume detected"
    docker volume create sonar_data
else
    echo "[*] Sonar Data volume detected, moving on"
fi

if [ -z "$IS_SONAR_CONF" ]
then
    echo "[!] No Sonar Conf volume detected"
    docker volume create sonar_conf
else
    echo "[*] Sonar Conf volume detected, moving on"
fi

if [ -z "$IS_SONAR_EXT" ]
then
    echo "[!] No Sonar Extension volume detected"
    docker volume create sonar_extensions
else
    echo "[*] Sonar Extension volume detected, moving on"
fi

if [ -z "$IS_SONAR_LOGS" ]
then
    echo "[!] No Sonar Logs volume detected"
    docker volume create sonar_logs
else
    echo "[*] Sonar Logs detected, moving on"

# Run SonarQube
echo "[*] Launching SonarQube"
docker run --rm -d -p 9000:9000 --name sonar -v sonar_conf:/opt/sonarqube/conf -v sonar_data:/opt/sonarqube/data -v sonar_logs:/opt/sonarqube/logs -v sonar_extensions:/opt/sonarqube/extensions sonarqube
