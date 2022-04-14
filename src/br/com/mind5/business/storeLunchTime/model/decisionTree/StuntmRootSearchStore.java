package br.com.mind5.business.storeLunchTime.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.storeLunchTime.info.StuntmInfo;
import br.com.mind5.business.storeLunchTime.model.action.StuntmVisiEnforceStoreKey;
import br.com.mind5.business.storeLunchTime.model.action.StuntmVisiRootSearch;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.common.ModelCheckerDummy;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;

public final class StuntmRootSearchStore extends DeciTreeTemplateRead<StuntmInfo> {
	
	public StuntmRootSearchStore(DeciTreeOption<StuntmInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<StuntmInfo> buildCheckerHook(DeciTreeOption<StuntmInfo> option) {
		List<ModelChecker<StuntmInfo>> queue = new ArrayList<>();		
		ModelChecker<StuntmInfo> checker;

		checker = new ModelCheckerDummy<>();
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<StuntmInfo>> buildActionsOnPassedHook(DeciTreeOption<StuntmInfo> option) {
		List<ActionStd<StuntmInfo>> actions = new ArrayList<>();
		
		ActionStd<StuntmInfo> enforceStoreKey = new ActionStdCommom<StuntmInfo>(option, StuntmVisiEnforceStoreKey.class);
		ActionLazy<StuntmInfo> search = new ActionLazyCommom<StuntmInfo>(option, StuntmVisiRootSearch.class);
		
		enforceStoreKey.addPostAction(search);
		
		actions.add(enforceStoreKey);		
		return actions; 
	}
}
