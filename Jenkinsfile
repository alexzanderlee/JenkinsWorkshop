pipeline {
    agent {
        docker {
            // Custom image that has all our build tools: Git, Node, Maven, Docker
            image 'registry.devops-ci/swampfox/build-tools:0.2.1-nexus.devops-ci'
            // ... and mount the hosts docker socket so we can spin up sibling containers ...
            // noinspection GroovyAssignabilityCheck
            args '-v /certs/client:/certs/client' +
                    ' -e DOCKER_CERT_PATH' +
                    ' -e DOCKER_TLS_VERIFY' +
                    ' -e DOCKER_HOST' +
                    // ... and cache the maven dependencies
                    ' -v maven-m2-cache:/home/node/.m2' +
                    // ... and mount the Jenkins docker configuration so we share things like registry credentials
                    ' -v /var/jenkins_home/.docker/config.json:/docker-config/config.json:ro' +
                    // For some reason, tries to use 8.8.8.8 and 8.8.4.4 instead of the stuff DHCP would have handed down
                    // to the parent, but the search domain is correct
                    ' --dns 10.91.2.2 --dns 8.8.8.8'
        }
    }

    options {
        timeout(time: 1, unit: 'HOURS')
    }

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }
        stage('Build') {
            steps {
                sh 'mvn clean package'
            }
        }
    }

    post {
        success {
            archiveArtifacts 'target/*.war'
        }
    }
}