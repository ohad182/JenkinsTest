package com.marvell.ci.impl.pipelines

import com.marvell.ci.impl.steps.TestStep
import com.marvell.ci.model.Stage


class TestPipeline implements Serializable {

    def script
    def stages = []   

        TestPipeline(def script) {
            this.script = script
            script.echo "TestPipeline"            
        }  

        def withTestStage() {
            Stage testStage = new Stage(script,'TestStage1')

            testStage.AddStep('Step1',new TestStep(script,'step-test1'))
            stages << testStage
        }
   
        def withTestStage2() {
            Stage testStage = new Stage(script,'TestStage2')

            testStage.AddStep('Step1',new TestStep(script,'step-test2'))
            testStage.AddStep('Step1',new TestStep(script,'step-test3'))
            stages << testStage
        }
    
        def buildDefaultPipeline() {
            this.script.echo "building"
            withTestStage()
            withTestStage2()
        }

    void execute() {
        buildDefaultPipeline()
        // `stages.each { ... }` does not work, see https://issues.jenkins-ci.org/browse/JENKINS-26481
        for (Stage stage : stages) {
            stage.execute()
        }
    }

}
