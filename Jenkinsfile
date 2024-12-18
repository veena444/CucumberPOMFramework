pipeline
{
    agent any

    tools{
        maven 'maven'
        }


    stages
    {
        stage('Build')
        {
            steps
            {
                 git 'https://github.com/jglick/simple-maven-project-with-tests.git'
                 bat "mvn -Dmaven.test.failure.ignore=true clean package"
            }
            post
            {
                success
                {
                    junit '**/target/surefire-reports/TEST-*.xml'
                    archiveArtifacts 'target/*.jar'
                }
            }
        }



        stage("Deploy to QA"){
            steps{
                echo("deploy to qa")
            }
        }



        stage('Regression Automation Tests') {
            steps {
                catchError(buildResult: 'SUCCESS', stageResult: 'FAILURE') {
                    git 'https://github.com/veena444/CucumberPOMFramework.git'
                   bat "mvn clean test -Dsurefire.suiteXmlFiles=src/test/java/parallel/TestRunner.java"

                }
            }
        }




        stage('Publish Extent Report'){
            steps{
                     publishHTML([allowMissing: false,
                                  alwaysLinkToLastBuild: false,
                                  keepAll: true,
                                  reportDir: 'test-output/SparkReport',
                                  reportFiles: 'Index.html',
                                  reportName: 'HTML Regression Extent Report',
                                  reportTitles: ''])
            }
        }

        stage("Deploy to Stage"){
            steps{
                echo("deploy to Stage")
            }
        }




        stage("Deploy to PROD"){
            steps{
                echo("deploy to PROD")
            }
        }


    }
}