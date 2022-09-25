import hudson.tasks.test.AbstractTestResultAction
import hudson.model.Actionable
import java.text.SimpleDateFormat

def call(body) {

    def config = [:]
    body.resolveStrategy = Closure.DELEGATE_FIRST
    body.delegate = config
    body()
    def branch = "${BRANCH_NAME}"
    buildId = "${BUILD_ID}"
    def dateFormat = new SimpleDateFormat("yyyyMMddHHmm")
    def date = dateFormat.format(new Date())
    def FAILED_STAGE = 'none'

    def branchName = config.branchName
    def gitRepoUrl = config.gitRepoUrl
 
 def test = [
               age : config.age,
                ]   

pipeline {
agent {
      label "master"
    }
  stages {  
  stage ('checking config') {
      steps {
          echo "AGE= ${age}"
        } // steps
  } // stage
  } // stages
} // pipeline       
}//End of body

