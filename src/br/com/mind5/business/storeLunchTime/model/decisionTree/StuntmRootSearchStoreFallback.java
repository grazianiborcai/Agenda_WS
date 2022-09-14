package br.com.mind5.business.storeLunchTime.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.storeLunchTime.info.StuntmInfo;
import br.com.mind5.business.storeLunchTime.model.action.StuntmVisiEnforceIsDeletedOn;
import br.com.mind5.business.storeLunchTime.model.action.StuntmVisiEnforceStoreKey;
import br.com.mind5.business.storeLunchTime.model.action.StuntmVisiMergeStolis;
import br.com.mind5.business.storeLunchTime.model.action.StuntmVisiMergeWeekdayFallback;
import br.com.mind5.business.storeLunchTime.model.action.StuntmVisiNodeSearchStoreFallback;
import br.com.mind5.business.storeLunchTime.model.checker.StuntmCheckSearch;
import br.com.mind5.business.storeLunchTime.model.checker.StuntmCheckStore;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class StuntmRootSearchStoreFallback extends DeciTreeTemplateWrite<StuntmInfo> {
	
	public StuntmRootSearchStoreFallback(DeciTreeOption<StuntmInfo> option) {
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
		checker = new StuntmCheckSearch(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new StuntmCheckStore(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<StuntmInfo>> buildActionsOnPassedHook(DeciTreeOption<StuntmInfo> option) {
		List<ActionStd<StuntmInfo>> actions = new ArrayList<>();
		
		ActionStd<StuntmInfo> enforceStoreKey = new ActionStdCommom<StuntmInfo>(option, StuntmVisiEnforceStoreKey.class);
		ActionLazy<StuntmInfo> mergeStolis = new ActionLazyCommom<StuntmInfo>(option, StuntmVisiMergeStolis.class);
		ActionLazy<StuntmInfo> enforceIsDeletedOn = new ActionLazyCommom<StuntmInfo>(option, StuntmVisiEnforceIsDeletedOn.class);
		ActionLazy<StuntmInfo> mergeWeekday = new ActionLazyCommom<StuntmInfo>(option, StuntmVisiMergeWeekdayFallback.class);
		ActionLazy<StuntmInfo> nodeL1 = new ActionLazyCommom<StuntmInfo>(option, StuntmVisiNodeSearchStoreFallback.class);
		
		enforceStoreKey.addPostAction(mergeStolis);
		mergeStolis.addPostAction(enforceIsDeletedOn);
		enforceIsDeletedOn.addPostAction(mergeWeekday);
		mergeWeekday.addPostAction(nodeL1);
		
		actions.add(enforceStoreKey);		
		return actions; 
	}
}
