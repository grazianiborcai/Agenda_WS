package br.com.mind5.business.addressSnapshot.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.addressSnapshot.info.AddresnapInfo;
import br.com.mind5.business.addressSnapshot.model.action.StdAddresnapMergeEmplis;
import br.com.mind5.business.addressSnapshot.model.checker.AddresnapCheckHasEmployee;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class NodeAddresnapEmplis extends DeciTreeTemplateWrite<AddresnapInfo> {
	
	public NodeAddresnapEmplis(DeciTreeOption<AddresnapInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<AddresnapInfo> buildCheckerHook(DeciTreeOption<AddresnapInfo> option) {
		List<ModelChecker<AddresnapInfo>> queue = new ArrayList<>();		
		ModelChecker<AddresnapInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new AddresnapCheckHasEmployee(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<AddresnapInfo>> buildActionsOnPassedHook(DeciTreeOption<AddresnapInfo> option) {
		List<ActionStd<AddresnapInfo>> actions = new ArrayList<>();		
		
		ActionStd<AddresnapInfo> mergeEmplis = new StdAddresnapMergeEmplis(option);	
		
		actions.add(mergeEmplis);			
		return actions;
	}
	
	
	
	@Override protected List<ActionStd<AddresnapInfo>> buildActionsOnFailedHook(DeciTreeOption<AddresnapInfo> option) {
		List<ActionStd<AddresnapInfo>> actions = new ArrayList<>();		
		
		ActionStd<AddresnapInfo> nodeCuslis = new NodeAddresnapCuslis(option).toAction();	
		
		actions.add(nodeCuslis);			
		return actions;
	}
}
