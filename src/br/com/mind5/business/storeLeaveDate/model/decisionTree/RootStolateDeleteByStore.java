package br.com.mind5.business.storeLeaveDate.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.storeLeaveDate.info.StolateInfo;
import br.com.mind5.business.storeLeaveDate.model.action.LazyStolateMergeStolarch;
import br.com.mind5.business.storeLeaveDate.model.action.LazyStolateRootDelete;
import br.com.mind5.business.storeLeaveDate.model.action.StdStolateEnforceStoreKey;
import br.com.mind5.business.storeLeaveDate.model.checker.StolateCheckDeleteByStore;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class RootStolateDeleteByStore extends DeciTreeTemplateWrite<StolateInfo> {
	
	public RootStolateDeleteByStore(DeciTreeOption<StolateInfo> option) {
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
		checker = new StolateCheckDeleteByStore(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<StolateInfo>(queue);
	}
	
	
	
	@Override protected List<ActionStd<StolateInfo>> buildActionsOnPassedHook(DeciTreeOption<StolateInfo> option) {
		List<ActionStd<StolateInfo>> actions = new ArrayList<>();		
		
		ActionStd<StolateInfo> enforceStoreKey = new StdStolateEnforceStoreKey(option);
		ActionLazy<StolateInfo> mergeStolarch = new LazyStolateMergeStolarch(option.conn, option.schemaName);
		ActionLazy<StolateInfo> delete = new LazyStolateRootDelete(option.conn, option.schemaName);
		
		enforceStoreKey.addPostAction(mergeStolarch);
		mergeStolarch.addPostAction(delete);
		
		actions.add(enforceStoreKey);
		return actions;
	}
}
