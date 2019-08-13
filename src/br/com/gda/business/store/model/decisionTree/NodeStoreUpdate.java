package br.com.gda.business.store.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.store.info.StoreInfo;
import br.com.gda.business.store.model.action.LazyStoreEnforceEntityCateg;
import br.com.gda.business.store.model.action.LazyStoreEnforceLChanged;
import br.com.gda.business.store.model.action.LazyStoreMergeUsername;
import br.com.gda.business.store.model.action.LazyStoreNodeSnapshot;
import br.com.gda.business.store.model.action.StdStoreMergeToUpdate;
import br.com.gda.business.store.model.checker.StoreCheckWrite;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.model.decisionTree.DeciTreeWriteTemplate;

public final class NodeStoreUpdate extends DeciTreeWriteTemplate<StoreInfo> {
	
	public NodeStoreUpdate(DeciTreeOption<StoreInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<StoreInfo> buildDecisionCheckerHook(DeciTreeOption<StoreInfo> option) {
		List<ModelChecker<StoreInfo>> queue = new ArrayList<>();		
		ModelChecker<StoreInfo> checker;	
		
		checker = new StoreCheckWrite();
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<StoreInfo>> buildActionsOnPassedHook(DeciTreeOption<StoreInfo> option) {
		List<ActionStd<StoreInfo>> actions = new ArrayList<>();

		ActionStd<StoreInfo> mergeToUpdate = new StdStoreMergeToUpdate(option);
		ActionLazy<StoreInfo> enforceLChanged = new LazyStoreEnforceLChanged(option.conn, option.schemaName);
		ActionLazy<StoreInfo> enforceLChangedBy = new LazyStoreMergeUsername(option.conn, option.schemaName);
		ActionLazy<StoreInfo> enforceEntityCateg = new LazyStoreEnforceEntityCateg(option.conn, option.schemaName);
		ActionLazy<StoreInfo> snapshot = new LazyStoreNodeSnapshot(option.conn, option.schemaName);	
		
		enforceLChanged.addPostAction(enforceLChangedBy);
		enforceLChangedBy.addPostAction(enforceEntityCateg);		
		enforceEntityCateg.addPostAction(snapshot);
		
		actions.add(mergeToUpdate);
		return actions;
	}
}
