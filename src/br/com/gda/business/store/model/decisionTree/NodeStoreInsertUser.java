package br.com.gda.business.store.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.store.info.StoreInfo;
import br.com.gda.business.store.model.action.LazyStoreEnforceUserCateg;
import br.com.gda.business.store.model.action.LazyStoreInsertUser;
import br.com.gda.business.store.model.action.StdStoreEnforceAuthGroup;
import br.com.gda.business.store.model.checker.StoreCheckDummy;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.model.decisionTree.DeciTreeWriteTemplate;

public final class NodeStoreInsertUser extends DeciTreeWriteTemplate<StoreInfo> {
	
	public NodeStoreInsertUser(DeciTreeOption<StoreInfo> option) {
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
		
		ActionStd<StoreInfo> enforceAuthGroup = new StdStoreEnforceAuthGroup(option);
		ActionLazy<StoreInfo> enforceUserCateg = new LazyStoreEnforceUserCateg(option.conn, option.schemaName);
		ActionLazy<StoreInfo> insertUser = new LazyStoreInsertUser(option.conn, option.schemaName);
		
		enforceAuthGroup.addPostAction(enforceUserCateg);	
		enforceUserCateg.addPostAction(insertUser);	
		
		actions.add(enforceAuthGroup);	
		return actions;
	}
}
