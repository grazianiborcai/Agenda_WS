package br.com.mind5.business.address.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.address.info.AddressInfo;
import br.com.mind5.business.address.model.action.LazyAddressRootUpdate;
import br.com.mind5.business.address.model.action.StdAddressMergeAddarchStore;
import br.com.mind5.business.address.model.checker.AddressCheckExistStore;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class NodeAddressUpsertStore extends DeciTreeTemplateWrite<AddressInfo> {
	
	public NodeAddressUpsertStore(DeciTreeOption<AddressInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<AddressInfo> buildCheckerHook(DeciTreeOption<AddressInfo> option) {
		List<ModelChecker<AddressInfo>> queue = new ArrayList<>();		
		ModelChecker<AddressInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new AddressCheckExistStore(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<AddressInfo>> buildActionsOnPassedHook(DeciTreeOption<AddressInfo> option) {
		List<ActionStd<AddressInfo>> actions = new ArrayList<>();	
		
		ActionStd<AddressInfo> mergeAddarchStore = new StdAddressMergeAddarchStore(option);		
		ActionLazy<AddressInfo> update = new LazyAddressRootUpdate(option.conn, option.schemaName);
		
		mergeAddarchStore.addPostAction(update);
		
		actions.add(mergeAddarchStore);		
		return actions;
	}
	
	
	
	@Override protected List<ActionStd<AddressInfo>> buildActionsOnFailedHook(DeciTreeOption<AddressInfo> option) {
		List<ActionStd<AddressInfo>> actions = new ArrayList<>();	
		
		ActionStd<AddressInfo> insert = new RootAddressInsert(option).toAction();
		
		actions.add(insert);		
		return actions;
	}
}
