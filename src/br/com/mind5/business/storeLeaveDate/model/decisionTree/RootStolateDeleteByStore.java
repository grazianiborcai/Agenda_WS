package br.com.mind5.business.storeLeaveDate.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.storeLeaveDate.info.StolateInfo;
import br.com.mind5.business.storeLeaveDate.model.action.LazyStolateMergeStolarch;
import br.com.mind5.business.storeLeaveDate.model.action.LazyStolateRootDelete;
import br.com.mind5.business.storeLeaveDate.model.action.StdStolateEnforceStoreKey;
import br.com.mind5.business.storeLeaveDate.model.checker.StolateCheckDeleteByStore;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeWriteTemplate;

public final class RootStolateDeleteByStore extends DeciTreeWriteTemplate<StolateInfo> {
	
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
		
		return new ModelCheckerQueue<StolateInfo>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<StolateInfo>> buildActionsOnPassedHook(DeciTreeOption<StolateInfo> option) {
		List<ActionStdV1<StolateInfo>> actions = new ArrayList<>();		
		
		ActionStdV1<StolateInfo> enforceStoreKey = new StdStolateEnforceStoreKey(option);
		ActionLazyV1<StolateInfo> mergeStolarch = new LazyStolateMergeStolarch(option.conn, option.schemaName);
		ActionLazyV1<StolateInfo> delete = new LazyStolateRootDelete(option.conn, option.schemaName);
		
		enforceStoreKey.addPostAction(mergeStolarch);
		mergeStolarch.addPostAction(delete);
		
		actions.add(enforceStoreKey);
		return actions;
	}
}
