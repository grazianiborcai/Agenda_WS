package br.com.gda.business.address.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.address.info.AddressInfo;
import br.com.gda.business.address.model.action.LazyAddressUpdate;
import br.com.gda.business.address.model.action.StdAddressInsertAddresnap;
import br.com.gda.business.address.model.checker.AddressCheckWriteA00;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciTreeWriteTemplate;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class NodeAddressUpdateA00 extends DeciTreeWriteTemplate<AddressInfo> {
	
	public NodeAddressUpdateA00(DeciTreeOption<AddressInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<AddressInfo> buildDecisionCheckerHook(DeciTreeOption<AddressInfo> option) {
		List<ModelChecker<AddressInfo>> queue = new ArrayList<>();		
		ModelChecker<AddressInfo> checker;	

		checker = new AddressCheckWriteA00();
		queue.add(checker);
		
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<AddressInfo>> buildActionsOnPassedHook(DeciTreeOption<AddressInfo> option) {
		List<ActionStd<AddressInfo>> actions = new ArrayList<>();
		
		ActionStd<AddressInfo> insertAddresnap = new StdAddressInsertAddresnap(option);	
		ActionLazy<AddressInfo> update = new LazyAddressUpdate(option.conn, option.schemaName);
		
		insertAddresnap.addPostAction(update);
		
		actions.add(insertAddresnap);		
		return actions;
	}
}
