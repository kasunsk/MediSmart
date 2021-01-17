job ('channel example') {
    scm () {
        git('https://github.com/kasunsk/MediSmart.git')
    }
    steps {
        shell('./gradlew clean build --no-daemon')
    }
}