package br.com.mind5.business.store.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.store.info.StoreInfo;
import br.com.mind5.business.store.model.action.LazyStoreEnforceLChanged;
import br.com.mind5.business.store.model.action.LazyStoreMergeUsername;
import br.com.mind5.business.store.model.action.LazyStoreNodeSnapshot;
import br.com.mind5.business.store.model.action.LazyStoreNodeUpsertStorext;
import br.com.mind5.business.store.model.action.StdStoreMergeToUpdate;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.common.ModelCheckerDummy;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWriteV2;

public final class NodeStoreUpdate extends DeciTreeTemplateWriteV2<StoreInfo> {
	
	public NodeStoreUpdate(DeciTreeOption<StoreInfo> option) {
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

		ActionStdV1<StoreInfo> mergeToUpdate = new StdStoreMergeToUpdate(option);
		ActionLazy<StoreInfo> enforceLChanged = new LazyStoreEnforceLChanged(option.conn, option.schemaName);
		ActionLazy<StoreInfo> enforceLChangedBy = new LazyStoreMergeUsername(option.conn, option.schemaName);
		ActionLazy<StoreInfo> upsertStorext = new LazyStoreNodeUpsertStorext(option.conn, option.schemaName);
		ActionLazy<StoreInfo> snapshot = new LazyStoreNodeSnapshot(option.conn, option.schemaName);	
		
		mergeToUpdate.addPostAction(enforceLChanged);
		enforceLChanged.addPostAction(enforceLChangedBy);
		enforceLChangedBy.addPostAction(upsertStorext);
		upsertStorext.addPostAction(snapshot);
		
		actions.add(mergeToUpdate);
		return actions;
	}
}
