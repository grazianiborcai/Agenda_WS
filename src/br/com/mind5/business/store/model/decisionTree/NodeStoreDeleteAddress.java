package br.com.mind5.business.store.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.store.info.StoreInfo;
import br.com.mind5.business.store.model.action.LazyStoreDeleteAddress;
import br.com.mind5.business.store.model.action.StdStoreEnforceAddressKey;
import br.com.mind5.business.store.model.action.StdStoreSuccess;
import br.com.mind5.business.store.model.checker.StoreCheckHasAddress;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeWriteTemplate;

public final class NodeStoreDeleteAddress extends DeciTreeWriteTemplate<StoreInfo> {
	
	public NodeStoreDeleteAddress(DeciTreeOption<StoreInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<StoreInfo> buildDecisionCheckerHook(DeciTreeOption<StoreInfo> option) {
		List<ModelChecker<StoreInfo>> queue = new ArrayList<>();		
		ModelChecker<StoreInfo> checker;
		ModelCheckerOption checkerOption;	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;		
		checker = new StoreCheckHasAddress(checkerOption);
		queue.add(checker);	
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<StoreInfo>> buildActionsOnPassedHook(DeciTreeOption<StoreInfo> option) {
		List<ActionStd<StoreInfo>> actions = new ArrayList<>();
		
		ActionStd<StoreInfo> enforceAddressKey = new StdStoreEnforceAddressKey(option);
		ActionLazy<StoreInfo> deleteAddress = new LazyStoreDeleteAddress(option.conn, option.schemaName);
		
		enforceAddressKey.addPostAction(deleteAddress);
		
		actions.add(enforceAddressKey);		
		return actions;
	}
	
	
	
	@Override protected List<ActionStd<StoreInfo>> buildActionsOnFailedHook(DeciTreeOption<StoreInfo> option) {
		List<ActionStd<StoreInfo>> actions = new ArrayList<>();
		
		actions.add(new StdStoreSuccess(option));		
		return actions;
	}
}
