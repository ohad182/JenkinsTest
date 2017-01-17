
package com.marvell.ci.impl.steps

import com.marvell.ci.model.abstractStep

public class TestStep extends abstractStep {

    TestStep(Object script)
    {
        super(script,'step1-test')
    }

    @Override
    void execute(){

    }

    void Test1(){
        script.echo "Test1"
    }

    void Test2(){
        script.echo "Test2"
    }

    void Test3(){
        script.echo "Test3"
    }

}