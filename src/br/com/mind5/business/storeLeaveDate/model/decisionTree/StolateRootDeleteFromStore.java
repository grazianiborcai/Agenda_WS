package br.com.mind5.business.storeLeaveDate.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.storeLeaveDate.info.StolateInfo;
import br.com.mind5.business.storeLeaveDate.model.action.StolateVisiRootDelete;
import br.com.mind5.business.storeLeaveDate.model.action.StolateVisiEnforceStoreKey;
import br.com.mind5.business.storeLeaveDate.model.action.StolateVisiMergeStolarch;
import br.com.mind5.business.storeLeaveDate.model.checker.StolateCheckDeleteFromStore;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class StolateRootDeleteFromStore extends DeciTreeTemplateWrite<StolateInfo> {
	
	public StolateRootDeleteFromStore(DeciTreeOption<StolateInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<StolateInfo> buildCheckerHook(DeciTreeOption<StolateInfo> option) {
		List<ModelChecker<StolateInfo>> queue = new ArrayList<>();		
		ModelChecker<StolateInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new StolateCheckDeleteFromStore(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<StolateInfo>(queue);
	}
	
	
	
	@Override protected List<ActionStd<StolateInfo>> buildActionsOnPassedHook(DeciTreeOption<StolateInfo> option) {
		List<ActionStd<StolateInfo>> actions = new ArrayList<>();		
		
		ActionStd<StolateInfo> enforceStoreKey = new ActionStdCommom<StolateInfo>(option, StolateVisiEnforceStoreKey.class);
		ActionLazy<StolateInfo> mergeStolarch = new ActionLazyCommom<StolateInfo>(option, StolateVisiMergeStolarch.class);
		ActionLazy<StolateInfo> delete = new ActionLazyCommom<StolateInfo>(option, StolateVisiRootDelete.class);
		
		enforceStoreKey.addPostAction(mergeStolarch);
		mergeStolarch.addPostAction(delete);
		
		actions.add(enforceStoreKey);
		return actions;
	}
}
