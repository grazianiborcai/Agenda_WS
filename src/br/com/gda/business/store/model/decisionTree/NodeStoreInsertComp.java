package br.com.gda.business.store.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.store.info.StoreInfo;
import br.com.gda.business.store.model.action.LazyStoreEnforceCompKey;
import br.com.gda.business.store.model.action.LazyStoreInsertComp;
import br.com.gda.business.store.model.action.StdStoreEnforceEntityCateg;
import br.com.gda.business.store.model.checker.StoreCheckHasComp;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.model.decisionTree.DeciTreeWriteTemplate;

public final class NodeStoreInsertComp extends DeciTreeWriteTemplate<StoreInfo> {
	
	public NodeStoreInsertComp(DeciTreeOption<StoreInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<StoreInfo> buildDecisionCheckerHook(DeciTreeOption<StoreInfo> option) {
		final boolean HAS_COMPANY = true;
		
		List<ModelChecker<StoreInfo>> queue = new ArrayList<>();		
		ModelChecker<StoreInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = HAS_COMPANY;		
		checker = new StoreCheckHasComp(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<StoreInfo>> buildActionsOnPassedHook(DeciTreeOption<StoreInfo> option) {
		List<ActionStd<StoreInfo>> actions = new ArrayList<>();
		
		ActionStd<StoreInfo> enforceEntityCateg = new StdStoreEnforceEntityCateg(option);
		ActionLazy<StoreInfo> enforceCompKey = new LazyStoreEnforceCompKey(option.conn, option.schemaName);
		ActionLazy<StoreInfo> insertComp = new LazyStoreInsertComp(option.conn, option.schemaName);
		
		enforceEntityCateg.addPostAction(enforceCompKey);
		enforceCompKey.addPostAction(insertComp);
		
		actions.add(enforceEntityCateg);	
		return actions;
	}
}
