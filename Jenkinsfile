pipeline {
    agent any
    tools {
        maven "Maven 3.9.7"
    }
    parameters {
        choice(
            name: "PROJECT",
            choices: ['OrangeHRM','DemoQA'],
            description: 'Choose project'
        )
        choice(
            name: "TEST_SUITE",
            choices: ['All', 'Smoke', 'Regression', 'E2E'],
            description: 'Choose the suite of tests to run. Select "All" to run all suites.'
        )
        choice(
            name: "TEST_TYPE",
            choices: ['UI', 'API', 'TC_NUMBER'],
            description: 'Choose the type of tests to run'
        )
        string(
            name: "TESTCASE_NUMBER",
            defaultValue: "",
            description: 'Enter the test number to run specific test case or leave empty'
        )
    }
    stages {
        stage('Test') {
            steps {
                script {
                    def project = params.PROJECT ?: 'OrangeHRM'
                    def testSuite = params.TEST_SUITE
                    def testType = params.TEST_TYPE
                    def testNumber = params.TESTCASE_NUMBER

                    def suiteFiles = []
                    if (testSuite == 'All') {
                        suiteFiles = ['smoke_suite.xml', 'regression_suite.xml', 'E2E_suite.xml']
                    } else {
                        suiteFiles = ["${testSuite.toLowerCase()}_suite.xml"]
                    }

                    def groups = []
                    if (testType == 'TC_NUMBER' && testNumber) {
                        groups = [testNumber]
                    } else {
                        groups = [testType]
                    }

                    suiteFiles.each { suiteFile ->
                        sh "mvn clean test -P ${project} -DsuiteXmlFile=${suiteFile} -Dgroups=${groups.join(',')} -DfailIfNoTests=false"
                    }
                }
            }
            post {
                always {
                    allure([
                        includeProperties: false,
                        jdk: '17.0.1',
                        properties: [],
                        reportBuildPolicy: 'ALWAYS',
                        results: [[path: 'target/allure-results']]
                    ])
                }
            }
        }
    }
}