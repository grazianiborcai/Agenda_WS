package br.com.mind5.business.addressSnapshot.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.addressSnapshot.info.AddresnapInfo;
import br.com.mind5.business.addressSnapshot.model.action.StdAddresnapMergeStolis;
import br.com.mind5.business.addressSnapshot.model.action.StdAddresnapSuccess;
import br.com.mind5.business.addressSnapshot.model.checker.AddresnapCheckHasStore;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeReadTemplate;

public final class NodeAddresnapStolis extends DeciTreeReadTemplate<AddresnapInfo> {
	
	public NodeAddresnapStolis(DeciTreeOption<AddresnapInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<AddresnapInfo> buildDecisionCheckerHook(DeciTreeOption<AddresnapInfo> option) {
		List<ModelChecker<AddresnapInfo>> queue = new ArrayList<>();		
		ModelChecker<AddresnapInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new AddresnapCheckHasStore(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<AddresnapInfo>> buildActionsOnPassedHook(DeciTreeOption<AddresnapInfo> option) {
		List<ActionStd<AddresnapInfo>> actions = new ArrayList<>();		
		
		ActionStd<AddresnapInfo> mergeStolis = new StdAddresnapMergeStolis(option);	
		
		actions.add(mergeStolis);			
		return actions;
	}
	
	
	
	@Override protected List<ActionStd<AddresnapInfo>> buildActionsOnFailedHook(DeciTreeOption<AddresnapInfo> option) {
		List<ActionStd<AddresnapInfo>> actions = new ArrayList<>();		
		
		ActionStd<AddresnapInfo> success = new StdAddresnapSuccess(option);	
		
		actions.add(success);			
		return actions;
	}
}
