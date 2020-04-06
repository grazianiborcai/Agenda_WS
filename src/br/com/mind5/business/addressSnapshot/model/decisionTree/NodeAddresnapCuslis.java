package br.com.mind5.business.addressSnapshot.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.addressSnapshot.info.AddresnapInfo;
import br.com.mind5.business.addressSnapshot.model.action.StdAddresnapMergeCuslis;
import br.com.mind5.business.addressSnapshot.model.checker.AddresnapCheckHasCustomer;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;

public final class NodeAddresnapCuslis extends DeciTreeTemplateRead<AddresnapInfo> {
	
	public NodeAddresnapCuslis(DeciTreeOption<AddresnapInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<AddresnapInfo> buildCheckerHook(DeciTreeOption<AddresnapInfo> option) {
		List<ModelCheckerV1<AddresnapInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<AddresnapInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new AddresnapCheckHasCustomer(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<AddresnapInfo>> buildActionsOnPassedHook(DeciTreeOption<AddresnapInfo> option) {
		List<ActionStdV1<AddresnapInfo>> actions = new ArrayList<>();		
		
		ActionStdV1<AddresnapInfo> mergeCuslis = new StdAddresnapMergeCuslis(option);	
		
		actions.add(mergeCuslis);			
		return actions;
	}
	
	
	
	@Override protected List<ActionStdV1<AddresnapInfo>> buildActionsOnFailedHook(DeciTreeOption<AddresnapInfo> option) {
		List<ActionStdV1<AddresnapInfo>> actions = new ArrayList<>();		
		
		ActionStdV1<AddresnapInfo> nodeStolis = new NodeAddresnapStolis(option).toAction();	
		
		actions.add(nodeStolis);			
		return actions;
	}
}
