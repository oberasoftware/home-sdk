node {
    git url: 'git@github.com:oberasoftware/home-sdk.git'
    def mvnHome = tool 'M3'

    stage 'checkout'
    checkout scm

    stage 'build'
    sh "${mvnHome}/bin/mvn -B clean install"

    stage 'release'
    sh "${mvnHome}/bin/mvn -B clean deploy -Dmaven.test.skip=true"

    stage 'archive'
    step([$class: 'ArtifactArchiver', artifacts: '**/target/*.jar', fingerprint: true])
}
