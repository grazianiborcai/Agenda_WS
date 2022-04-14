package br.com.mind5.business.storeLunchTime.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.storeLunchTime.info.StuntmInfo;
import br.com.mind5.business.storeLunchTime.model.action.StuntmVisiRootDelete;
import br.com.mind5.business.storeLunchTime.model.action.StuntmVisiEnforceStoreKey;
import br.com.mind5.business.storeLunchTime.model.action.StuntmVisiMergeStuntmarch_;
import br.com.mind5.business.storeLunchTime.model.checker.StuntmCheckDeleteFromStore;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class StuntmRootDeleteFromStore extends DeciTreeTemplateWrite<StuntmInfo> {
	
	public StuntmRootDeleteFromStore(DeciTreeOption<StuntmInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<StuntmInfo> buildCheckerHook(DeciTreeOption<StuntmInfo> option) {
		List<ModelChecker<StuntmInfo>> queue = new ArrayList<>();		
		ModelChecker<StuntmInfo> checker;
		ModelCheckerOption checkerOption;
			
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new StuntmCheckDeleteFromStore(checkerOption);
		queue.add(checker);
		
		 return new ModelCheckerHelperQueue<StuntmInfo>(queue);
	}
	
	
	
	@Override protected List<ActionStd<StuntmInfo>> buildActionsOnPassedHook(DeciTreeOption<StuntmInfo> option) {
		List<ActionStd<StuntmInfo>> actions = new ArrayList<>();
		
		ActionStd<StuntmInfo> enforceStoreKey = new ActionStdCommom<StuntmInfo>(option, StuntmVisiEnforceStoreKey.class);
		ActionLazy<StuntmInfo> mergeStuntmarch = new ActionLazyCommom<StuntmInfo>(option, StuntmVisiMergeStuntmarch_.class);
		ActionLazy<StuntmInfo> delete = new ActionLazyCommom<StuntmInfo>(option, StuntmVisiRootDelete.class);
		
		enforceStoreKey.addPostAction(mergeStuntmarch);
		mergeStuntmarch.addPostAction(delete);
		
		actions.add(enforceStoreKey);
		return actions;
	}
}
