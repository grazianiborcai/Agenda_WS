package br.com.mind5.business.storeWorkTime.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.storeWorkTime.info.StowotmInfo;
import br.com.mind5.business.storeWorkTime.model.action.LazyStowotmMergeStowotarch;
import br.com.mind5.business.storeWorkTime.model.action.LazyStowotmRootDelete;
import br.com.mind5.business.storeWorkTime.model.action.StdStowotmEnforceStoreKey;
import br.com.mind5.business.storeWorkTime.model.checker.StowotmCheckDeleteByStore;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class RootStowotmDeleteByStore extends DeciTreeTemplateWrite<StowotmInfo> {
	
	public RootStowotmDeleteByStore(DeciTreeOption<StowotmInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<StowotmInfo> buildCheckerHook(DeciTreeOption<StowotmInfo> option) {
		List<ModelCheckerV1<StowotmInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<StowotmInfo> checker;
		ModelCheckerOption checkerOption;
			
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new StowotmCheckDeleteByStore(checkerOption);
		queue.add(checker);
		
		 return new ModelCheckerHelperQueueV2<StowotmInfo>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<StowotmInfo>> buildActionsOnPassedHook(DeciTreeOption<StowotmInfo> option) {
		List<ActionStdV1<StowotmInfo>> actions = new ArrayList<>();
		
		ActionStdV1<StowotmInfo> enforceStoreKey = new StdStowotmEnforceStoreKey(option);
		ActionLazyV1<StowotmInfo> mergeStowotarch = new LazyStowotmMergeStowotarch(option.conn, option.schemaName);
		ActionLazyV1<StowotmInfo> delete = new LazyStowotmRootDelete(option.conn, option.schemaName);
		
		enforceStoreKey.addPostAction(mergeStowotarch);
		mergeStowotarch.addPostAction(delete);
		
		actions.add(enforceStoreKey);
		return actions;
	}
}
