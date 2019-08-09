package br.com.gda.business.address.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.address.info.AddressInfo;
import br.com.gda.business.address.model.action.LazyAddressInsertAddresnap;
import br.com.gda.business.address.model.action.LazyAddressUpdate;
import br.com.gda.business.address.model.action.StdAddressInsert;
import br.com.gda.business.address.model.checker.AddressCheckWriteA00;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciTreeWriteTemplate;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class NodeAddressInsertA00 extends DeciTreeWriteTemplate<AddressInfo> {
	
	public NodeAddressInsertA00(DeciTreeOption<AddressInfo> option) {
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
		
		ActionStd<AddressInfo> insert = new StdAddressInsert(option);	
		ActionLazy<AddressInfo> insertAddresnap = new LazyAddressInsertAddresnap(option.conn, option.schemaName);
		ActionLazy<AddressInfo> update = new LazyAddressUpdate(option.conn, option.schemaName);

		insert.addPostAction(insertAddresnap);
		insertAddresnap.addPostAction(update);
		
		actions.add(insert);		
		return actions;
	}
}
