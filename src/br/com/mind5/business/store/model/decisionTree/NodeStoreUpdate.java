package br.com.mind5.business.store.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.store.info.StoreInfo;
import br.com.mind5.business.store.model.action.LazyStoreEnforceLChanged;
import br.com.mind5.business.store.model.action.LazyStoreMergeUsername;
import br.com.mind5.business.store.model.action.LazyStoreNodeSnapshot;
import br.com.mind5.business.store.model.action.StdStoreMergeToUpdate;
import br.com.mind5.business.store.model.checker.StoreCheckDummy;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeWriteTemplate;

public final class NodeStoreUpdate extends DeciTreeWriteTemplate<StoreInfo> {
	
	public NodeStoreUpdate(DeciTreeOption<StoreInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<StoreInfo> buildDecisionCheckerHook(DeciTreeOption<StoreInfo> option) {
		List<ModelChecker<StoreInfo>> queue = new ArrayList<>();		
		ModelChecker<StoreInfo> checker;
		
		checker = new StoreCheckDummy();
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<StoreInfo>> buildActionsOnPassedHook(DeciTreeOption<StoreInfo> option) {
		List<ActionStd<StoreInfo>> actions = new ArrayList<>();

		ActionStd<StoreInfo> mergeToUpdate = new StdStoreMergeToUpdate(option);
		ActionLazy<StoreInfo> enforceLChanged = new LazyStoreEnforceLChanged(option.conn, option.schemaName);
		ActionLazy<StoreInfo> enforceLChangedBy = new LazyStoreMergeUsername(option.conn, option.schemaName);
		ActionLazy<StoreInfo> snapshot = new LazyStoreNodeSnapshot(option.conn, option.schemaName);	
		
		mergeToUpdate.addPostAction(enforceLChanged);
		enforceLChanged.addPostAction(enforceLChangedBy);
		enforceLChangedBy.addPostAction(snapshot);
		
		actions.add(mergeToUpdate);
		return actions;
	}
}
