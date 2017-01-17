package com.marvell.ci.model

/**
* This class implements IStep so he can override execute 
*/
abstract class abstractStep implements IStep  {
    
    String stepName;
    Object script;
    
    abstractStep(Object script, String stepName) {
        this.script = script;
        this.stepName = stepName;
    }
    
    @Override
    abstract void execute();    
}