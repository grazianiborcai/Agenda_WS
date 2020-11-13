package br.com.mind5.business.store.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.store.info.StoreInfo;
import br.com.mind5.business.store.model.action.LazyStoreDaoInsert;
import br.com.mind5.business.store.model.action.LazyStoreEnforceCreatedBy;
import br.com.mind5.business.store.model.action.LazyStoreEnforceCreatedOn;
import br.com.mind5.business.store.model.action.LazyStoreMergeUsername;
import br.com.mind5.business.store.model.action.StdStoreEnforceLChanged;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.common.ModelCheckerDummy;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWriteV2;

public final class NodeStoreInsert extends DeciTreeTemplateWriteV2<StoreInfo> {
	
	public NodeStoreInsert(DeciTreeOption<StoreInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<StoreInfo> buildCheckerHook(DeciTreeOption<StoreInfo> option) {
		List<ModelCheckerV1<StoreInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<StoreInfo> checker;

		checker = new ModelCheckerDummy<>();
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<StoreInfo>> buildActionsOnPassedHook(DeciTreeOption<StoreInfo> option) {
		List<ActionStdV1<StoreInfo>> actions = new ArrayList<>();

		ActionStdV1<StoreInfo> enforceLChanged = new StdStoreEnforceLChanged(option);
		ActionLazy<StoreInfo> enforceLChangedBy = new LazyStoreMergeUsername(option.conn, option.schemaName);
		ActionLazy<StoreInfo> enforceCreatedBy = new LazyStoreEnforceCreatedBy(option.conn, option.schemaName);
		ActionLazy<StoreInfo> enforceCreatedOn = new LazyStoreEnforceCreatedOn(option.conn, option.schemaName);
		ActionLazy<StoreInfo> insertStore = new LazyStoreDaoInsert(option.conn, option.schemaName);		
		
		enforceLChanged.addPostAction(enforceLChangedBy);
		enforceLChangedBy.addPostAction(enforceCreatedBy);
		enforceCreatedBy.addPostAction(enforceCreatedOn);
		enforceCreatedOn.addPostAction(insertStore);
		
		actions.add(enforceLChanged);	
		return actions;
	}
}
