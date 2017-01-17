
package com.marvell.ci.impl.steps

import com.marvell.ci.model.abstractStep

public class TestStep extends abstractStep {

    TestStep(Object script,String name)
    {
        super(script,name)
    }

    @Override
    void execute(){
        Test1()
        Test2()
        Test3()
    }

    void Test1(){
        script.echo "Test1 - ${stepName}"
    }

    void Test2(){
        script.echo "Test2 - ${stepName}"
    }

    void Test3(){
        script.echo "Test3 - ${stepName}"
    }

}
