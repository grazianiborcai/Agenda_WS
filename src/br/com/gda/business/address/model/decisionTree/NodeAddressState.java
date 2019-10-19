package br.com.gda.business.address.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.model.action.ActionStd;
import br.com.gda.business.address.info.AddressInfo;
import br.com.gda.business.address.model.action.StdAddressMergeState;
import br.com.gda.business.address.model.action.StdAddressSuccess;
import br.com.gda.business.address.model.checker.AddressCheckHasState;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.model.decisionTree.DeciTreeWriteTemplate;

public final class NodeAddressState extends DeciTreeWriteTemplate<AddressInfo> {
	
	public NodeAddressState(DeciTreeOption<AddressInfo> option) {
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
		checker = new AddressCheckHasState(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<AddressInfo>> buildActionsOnPassedHook(DeciTreeOption<AddressInfo> option) {
		List<ActionStd<AddressInfo>> actions = new ArrayList<>();		
		
		ActionStd<AddressInfo> mergeState = new StdAddressMergeState(option);	
		
		actions.add(mergeState);			
		return actions;
	}
	
	
	
	@Override protected List<ActionStd<AddressInfo>> buildActionsOnFailedHook(DeciTreeOption<AddressInfo> option) {
		List<ActionStd<AddressInfo>> actions = new ArrayList<>();		
		
		ActionStd<AddressInfo> success = new StdAddressSuccess(option);	
		
		actions.add(success);			
		return actions;
	}
}
