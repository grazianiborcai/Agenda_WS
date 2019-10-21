package br.com.mind5.business.store.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.store.info.StoreInfo;
import br.com.mind5.business.store.model.action.LazyStoreUpdate;
import br.com.mind5.business.store.model.action.StdStoreInsertStorap;
import br.com.mind5.business.store.model.checker.StoreCheckDummy;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeWriteTemplate;

public final class NodeStoreSnapshot extends DeciTreeWriteTemplate<StoreInfo> {
	
	public NodeStoreSnapshot(DeciTreeOption<StoreInfo> option) {
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
		
		ActionStd<StoreInfo> insertSnapshot = new StdStoreInsertStorap(option);		
		ActionLazy<StoreInfo> update = new LazyStoreUpdate(option.conn, option.schemaName);	
		
		insertSnapshot.addPostAction(update);
		
		actions.add(insertSnapshot);	
		return actions;
	}
}
