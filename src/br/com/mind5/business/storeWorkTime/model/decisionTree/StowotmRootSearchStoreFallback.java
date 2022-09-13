package br.com.mind5.business.storeWorkTime.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.storeWorkTime.info.StowotmInfo;
import br.com.mind5.business.storeWorkTime.model.action.StowotmVisiEnforceIsDeletedOn;
import br.com.mind5.business.storeWorkTime.model.action.StowotmVisiEnforceStoreKey;
import br.com.mind5.business.storeWorkTime.model.action.StowotmVisiMergeStolis;
import br.com.mind5.business.storeWorkTime.model.action.StowotmVisiMergeWeekdayFallback;
import br.com.mind5.business.storeWorkTime.model.action.StowotmVisiNodeSearchStoreFallback;
import br.com.mind5.business.storeWorkTime.model.checker.StowotmCheckSearch;
import br.com.mind5.business.storeWorkTime.model.checker.StowotmCheckStore;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class StowotmRootSearchStoreFallback extends DeciTreeTemplateWrite<StowotmInfo> {
	
	public StowotmRootSearchStoreFallback(DeciTreeOption<StowotmInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<StowotmInfo> buildCheckerHook(DeciTreeOption<StowotmInfo> option) {
		List<ModelChecker<StowotmInfo>> queue = new ArrayList<>();		
		ModelChecker<StowotmInfo> checker;
		ModelCheckerOption checkerOption;		
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new StowotmCheckSearch(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new StowotmCheckStore(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<StowotmInfo>> buildActionsOnPassedHook(DeciTreeOption<StowotmInfo> option) {
		List<ActionStd<StowotmInfo>> actions = new ArrayList<>();
		
		ActionStd<StowotmInfo> enforceStoreKey = new ActionStdCommom<StowotmInfo>(option, StowotmVisiEnforceStoreKey.class);
		ActionLazy<StowotmInfo> mergeStolis = new ActionLazyCommom<StowotmInfo>(option, StowotmVisiMergeStolis.class);
		ActionLazy<StowotmInfo> enforceIsDeletedOn = new ActionLazyCommom<StowotmInfo>(option, StowotmVisiEnforceIsDeletedOn.class);
		ActionLazy<StowotmInfo> mergeWeekday = new ActionLazyCommom<StowotmInfo>(option, StowotmVisiMergeWeekdayFallback.class);
		ActionLazy<StowotmInfo> nodeL1 = new ActionLazyCommom<StowotmInfo>(option, StowotmVisiNodeSearchStoreFallback.class);
		
		enforceStoreKey.addPostAction(mergeStolis);
		mergeStolis.addPostAction(enforceIsDeletedOn);
		enforceIsDeletedOn.addPostAction(mergeWeekday);
		mergeWeekday.addPostAction(nodeL1);
		
		actions.add(enforceStoreKey);		
		return actions; 
	}
}
