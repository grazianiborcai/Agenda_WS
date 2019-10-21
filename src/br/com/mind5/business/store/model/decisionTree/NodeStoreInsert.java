package br.com.mind5.business.store.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.store.info.StoreInfo;
import br.com.mind5.business.store.model.action.LazyStoreEnforceCreatedBy;
import br.com.mind5.business.store.model.action.LazyStoreEnforceCreatedOn;
import br.com.mind5.business.store.model.action.LazyStoreInsert;
import br.com.mind5.business.store.model.action.LazyStoreMergeUsername;
import br.com.mind5.business.store.model.action.StdStoreEnforceLChanged;
import br.com.mind5.business.store.model.checker.StoreCheckDummy;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeWriteTemplate;

public final class NodeStoreInsert extends DeciTreeWriteTemplate<StoreInfo> {
	
	public NodeStoreInsert(DeciTreeOption<StoreInfo> option) {
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

		ActionStd<StoreInfo> enforceLChanged = new StdStoreEnforceLChanged(option);
		ActionLazy<StoreInfo> enforceLChangedBy = new LazyStoreMergeUsername(option.conn, option.schemaName);
		ActionLazy<StoreInfo> enforceCreatedBy = new LazyStoreEnforceCreatedBy(option.conn, option.schemaName);
		ActionLazy<StoreInfo> enforceCreatedOn = new LazyStoreEnforceCreatedOn(option.conn, option.schemaName);
		ActionLazy<StoreInfo> insertStore = new LazyStoreInsert(option.conn, option.schemaName);		
		
		enforceLChanged.addPostAction(enforceLChangedBy);
		enforceLChangedBy.addPostAction(enforceCreatedBy);
		enforceCreatedBy.addPostAction(enforceCreatedOn);
		enforceCreatedOn.addPostAction(insertStore);
		
		actions.add(enforceLChanged);	
		return actions;
	}
}
