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
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWriteV1;

public final class RootStolateDeleteByStore extends DeciTreeTemplateWriteV1<StolateInfo> {
	
	public RootStolateDeleteByStore(DeciTreeOption<StolateInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<StolateInfo> buildCheckerHook(DeciTreeOption<StolateInfo> option) {
		List<ModelCheckerV1<StolateInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<StolateInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new StolateCheckDeleteByStore(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<StolateInfo>(queue);
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
