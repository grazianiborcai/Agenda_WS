package br.com.gda.business.store.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.store.info.StoreInfo;
import br.com.gda.business.store.model.action.LazyStoreEnforcePersonKey;
import br.com.gda.business.store.model.action.LazyStoreInsertPerson;
import br.com.gda.business.store.model.action.StdStoreEnforceEntityCateg;
import br.com.gda.business.store.model.checker.StoreCheckHasPerson;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.model.decisionTree.DeciTreeWriteTemplate;

public final class NodeStoreInsertPerson extends DeciTreeWriteTemplate<StoreInfo> {
	
	public NodeStoreInsertPerson(DeciTreeOption<StoreInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<StoreInfo> buildDecisionCheckerHook(DeciTreeOption<StoreInfo> option) {
		final boolean HAS_PERSON = true;
		
		List<ModelChecker<StoreInfo>> queue = new ArrayList<>();		
		ModelChecker<StoreInfo> checker;
		ModelCheckerOption checkerOption;	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = HAS_PERSON;		
		checker = new StoreCheckHasPerson(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<StoreInfo>> buildActionsOnPassedHook(DeciTreeOption<StoreInfo> option) {
		List<ActionStd<StoreInfo>> actions = new ArrayList<>();
		
		ActionStd<StoreInfo> enforceEntityCateg = new StdStoreEnforceEntityCateg(option);
		ActionLazy<StoreInfo> enforcePersonKey = new LazyStoreEnforcePersonKey(option.conn, option.schemaName);
		ActionLazy<StoreInfo> insertPerson = new LazyStoreInsertPerson(option.conn, option.schemaName);	

		enforceEntityCateg.addPostAction(enforcePersonKey);
		enforcePersonKey.addPostAction(insertPerson);
		
		actions.add(enforceEntityCateg);	
		return actions;
	}
}
