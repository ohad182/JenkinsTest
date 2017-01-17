package com.marvell.ci.impl.pipelines

import com.marvell.ci.impl.steps.TestStep
import com.marvell.ci.model.Stage


class TestPipeline implements Serializable {

    def script

    def stages = []


    // static builder(script, steps) {
    //     steps.echo "builder - enter"
    //     environment {
    //         chaim = "Test-Chaim"
    //     }
    //     script.echo "echo from script"
    //     steps.echo "chaim - ${env.chaim}"
    
    //     return new Builder(script, steps)
    // }

    // static class Builder implements Serializable {

    //     def stages = []

    //     def script

    //     def steps

        TestPipeline(def script) {
            this.script = script
            script.echo "TestPipeline"
            
        }  

        def withTestStage() {

            Stage testStage = new Stage(script,'TestStage')

            testStage.AddStep('Step1',new TestStep(script))
            stages << testStage
        }

        // def build() {
            
        //     return new Pipeline(this)
        // }

        def buildDefaultPipeline() {
            this.script.echo "building"
            withTestStage()
        }

 //   }

  
    void execute() {
        buildDefaultPipeline()
        // `stages.each { ... }` does not work, see https://issues.jenkins-ci.org/browse/JENKINS-26481
        for (Stage stage : stages) {
            stage.execute()
        }
    }

}
