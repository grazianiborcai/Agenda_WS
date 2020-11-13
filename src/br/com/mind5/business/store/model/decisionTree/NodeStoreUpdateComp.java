package br.com.mind5.business.store.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.store.info.StoreInfo;
import br.com.mind5.business.store.model.action.LazyStoreCompUpdate;
import br.com.mind5.business.store.model.action.StdStoreEnforceCompKey;
import br.com.mind5.business.store.model.action.StdStoreSuccess;
import br.com.mind5.business.store.model.checker.StoreCheckHasComp;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWriteV2;

public final class NodeStoreUpdateComp extends DeciTreeTemplateWriteV2<StoreInfo> {
	
	public NodeStoreUpdateComp(DeciTreeOption<StoreInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<StoreInfo> buildCheckerHook(DeciTreeOption<StoreInfo> option) {
		List<ModelCheckerV1<StoreInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<StoreInfo> checker;
		ModelCheckerOption checkerOption;	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;		
		checker = new StoreCheckHasComp(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV2<StoreInfo>> buildActionsOnPassedHook(DeciTreeOption<StoreInfo> option) {
		List<ActionStdV2<StoreInfo>> actions = new ArrayList<>();
		
		ActionStdV2<StoreInfo> enforceCompKey = new StdStoreEnforceCompKey(option);
		ActionLazy<StoreInfo> updateCompany = new LazyStoreCompUpdate(option.conn, option.schemaName);
		
		enforceCompKey.addPostAction(updateCompany);
		
		actions.add(enforceCompKey);
		return actions;
	}
	
	
	
	@Override protected List<ActionStdV2<StoreInfo>> buildActionsOnFailedHook(DeciTreeOption<StoreInfo> option) {
		List<ActionStdV2<StoreInfo>> actions = new ArrayList<>();
		
		ActionStdV2<StoreInfo> success = new StdStoreSuccess(option);
		
		actions.add(success);
		return actions;
	}
}
