package br.com.mind5.business.address.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.address.info.AddressInfo;
import br.com.mind5.business.address.model.action.LazyAddressDaoUpdate;
import br.com.mind5.business.address.model.action.StdAddressInsertAddresnap;
import br.com.mind5.business.address.model.checker.AddressCheckDummy;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeWriteTemplate;

public final class NodeAddressSnapshot extends DeciTreeWriteTemplate<AddressInfo> {
	
	public NodeAddressSnapshot(DeciTreeOption<AddressInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<AddressInfo> buildCheckerHook(DeciTreeOption<AddressInfo> option) {
		List<ModelChecker<AddressInfo>> queue = new ArrayList<>();		
		ModelChecker<AddressInfo> checker;	
		
		checker = new AddressCheckDummy();
		queue.add(checker);
		
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<AddressInfo>> buildActionsOnPassedHook(DeciTreeOption<AddressInfo> option) {
		List<ActionStdV1<AddressInfo>> actions = new ArrayList<>();
		
		ActionStdV1<AddressInfo> insertAddresnap = new StdAddressInsertAddresnap(option);
		ActionLazyV1<AddressInfo> update = new LazyAddressDaoUpdate(option.conn, option.schemaName);

		insertAddresnap.addPostAction(update);
		
		actions.add(insertAddresnap);		
		return actions;
	}
}
