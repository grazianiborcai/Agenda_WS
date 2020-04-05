package br.com.mind5.business.addressSnapshot.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.addressSnapshot.info.AddresnapInfo;
import br.com.mind5.business.addressSnapshot.model.action.StdAddresnapMergeUselis;
import br.com.mind5.business.addressSnapshot.model.checker.AddresnapCheckHasUser;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeReadTemplate;

public final class NodeAddresnapUselis extends DeciTreeReadTemplate<AddresnapInfo> {
	
	public NodeAddresnapUselis(DeciTreeOption<AddresnapInfo> option) {
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
		checker = new AddresnapCheckHasUser(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<AddresnapInfo>> buildActionsOnPassedHook(DeciTreeOption<AddresnapInfo> option) {
		List<ActionStdV1<AddresnapInfo>> actions = new ArrayList<>();		
		
		ActionStdV1<AddresnapInfo> mergeUselis = new StdAddresnapMergeUselis(option);	
		
		actions.add(mergeUselis);			
		return actions;
	}
	
	
	
	@Override protected List<ActionStdV1<AddresnapInfo>> buildActionsOnFailedHook(DeciTreeOption<AddresnapInfo> option) {
		List<ActionStdV1<AddresnapInfo>> actions = new ArrayList<>();		
		
		ActionStdV1<AddresnapInfo> nodeEmp = new NodeAddresnapEmplis(option).toAction();	
		
		actions.add(nodeEmp);			
		return actions;
	}
}
