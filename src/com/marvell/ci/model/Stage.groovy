package com.marvell.ci.model

/**
* This class extends StageInfo so it has stageName and script, and implements Stage so he can override execute 
*/
class Stage implements IStage  {
    
    String stageName;
    Object script;
    def stepsMap = [:];

    Stage(Object script, String stageName) {
        this.script = script
        this.stageName = stageName
    }
    
    @Override
    void execute() {
        script.stage(stageName) {
           script.parallel (stepsMap);
        }
    }

    @Override
    void AddStep(name,func)
    {
        def commands = {func.execute()}
        stepsMap.put(name, commands)
    }
}
