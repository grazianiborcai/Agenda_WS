package br.com.mind5.business.storeWorkTimeSearch.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.storeWorkTimeSearch.info.StowotarchInfo;
import br.com.mind5.business.storeWorkTimeSearch.model.action.StowotarchVisiEnforceStoreKey;
import br.com.mind5.business.storeWorkTimeSearch.model.action.StowotarchVisiRootSelect;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.common.ModelCheckerDummy;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;

public final class StowotarchRootSelectStore extends DeciTreeTemplateRead<StowotarchInfo> {
	
	public StowotarchRootSelectStore(DeciTreeOption<StowotarchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<StowotarchInfo> buildCheckerHook(DeciTreeOption<StowotarchInfo> option) {
		List<ModelChecker<StowotarchInfo>> queue = new ArrayList<>();		
		ModelChecker<StowotarchInfo> checker;	
		

		checker = new ModelCheckerDummy<StowotarchInfo>();
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<StowotarchInfo>> buildActionsOnPassedHook(DeciTreeOption<StowotarchInfo> option) {
		List<ActionStd<StowotarchInfo>> actions = new ArrayList<>();
		
		ActionStd<StowotarchInfo> enforceStoreKey = new ActionStdCommom<StowotarchInfo>(option, StowotarchVisiEnforceStoreKey.class);
		ActionLazy<StowotarchInfo> select = new ActionLazyCommom<StowotarchInfo>(option, StowotarchVisiRootSelect.class);
		
		enforceStoreKey.addPostAction(select);
		
		actions.add(enforceStoreKey);		
		return actions; 
	}
}
