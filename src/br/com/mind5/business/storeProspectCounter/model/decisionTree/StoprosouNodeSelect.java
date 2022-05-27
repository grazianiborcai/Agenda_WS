package br.com.mind5.business.storeProspectCounter.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.storeProspectCounter.info.StoprosouInfo;
import br.com.mind5.business.storeProspectCounter.model.action.StoprosouVisiEnforceItemCounter;
import br.com.mind5.business.storeProspectCounter.model.action.StoprosouVisiMergeStopros;
import br.com.mind5.business.storeProspectCounter.model.action.StoprosouVisiObfuscateStopros;
import br.com.mind5.business.storeProspectCounter.model.checker.StoprosouCheckStoprarch;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;

public final class StoprosouNodeSelect extends DeciTreeTemplateRead<StoprosouInfo> {
	
	public StoprosouNodeSelect(DeciTreeOption<StoprosouInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<StoprosouInfo> buildCheckerHook(DeciTreeOption<StoprosouInfo> option) {
		List<ModelChecker<StoprosouInfo>> queue = new ArrayList<>();		
		ModelChecker<StoprosouInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new StoprosouCheckStoprarch(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<StoprosouInfo>> buildActionsOnPassedHook(DeciTreeOption<StoprosouInfo> option) {
		List<ActionStd<StoprosouInfo>> actions = new ArrayList<>();		
		
		ActionStd<StoprosouInfo> mergeStopros = new ActionStdCommom<StoprosouInfo>(option, StoprosouVisiMergeStopros.class);
		ActionLazy<StoprosouInfo> enforceItemCounter = new ActionLazyCommom<StoprosouInfo>(option, StoprosouVisiEnforceItemCounter.class);
		ActionLazy<StoprosouInfo> obfuscateStopros = new ActionLazyCommom<StoprosouInfo>(option, StoprosouVisiObfuscateStopros.class);
		
		mergeStopros.addPostAction(enforceItemCounter);
		enforceItemCounter.addPostAction(obfuscateStopros);
		
		actions.add(mergeStopros);	
		return actions;
	}
	
	
	
	@Override protected List<ActionStd<StoprosouInfo>> buildActionsOnFailedHook(DeciTreeOption<StoprosouInfo> option) {
		List<ActionStd<StoprosouInfo>> actions = new ArrayList<>();		
		
		ActionStd<StoprosouInfo> enforceItemCounter = new ActionStdCommom<StoprosouInfo>(option, StoprosouVisiEnforceItemCounter.class);
		ActionLazy<StoprosouInfo> obfuscateStopros = new ActionLazyCommom<StoprosouInfo>(option, StoprosouVisiObfuscateStopros.class);
		
		enforceItemCounter.addPostAction(obfuscateStopros);
		
		actions.add(enforceItemCounter);	
		return actions;
	}
}
