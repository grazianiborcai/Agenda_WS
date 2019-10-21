package br.com.mind5.business.address.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.address.info.AddressInfo;
import br.com.mind5.business.address.model.checker.AddressCheckWriteA00;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeWriteTemplate;

public final class NodeAddressUpdateA00 extends DeciTreeWriteTemplate<AddressInfo> {
	
	public NodeAddressUpdateA00(DeciTreeOption<AddressInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<AddressInfo> buildDecisionCheckerHook(DeciTreeOption<AddressInfo> option) {
		List<ModelChecker<AddressInfo>> queue = new ArrayList<>();		
		ModelChecker<AddressInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new AddressCheckWriteA00(checkerOption);
		queue.add(checker);
		
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<AddressInfo>> buildActionsOnPassedHook(DeciTreeOption<AddressInfo> option) {
		List<ActionStd<AddressInfo>> actions = new ArrayList<>();
		
		ActionStd<AddressInfo> snapshot = new NodeAddressSnapshot(option).toAction();	
		
		actions.add(snapshot);		
		return actions;
	}
}
