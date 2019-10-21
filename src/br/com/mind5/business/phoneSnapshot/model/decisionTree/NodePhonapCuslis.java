package br.com.mind5.business.phoneSnapshot.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.phoneSnapshot.info.PhonapInfo;
import br.com.mind5.business.phoneSnapshot.model.action.StdPhonapMergeCuslis;
import br.com.mind5.business.phoneSnapshot.model.checker.PhonapCheckHasCustomer;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeReadTemplate;

public final class NodePhonapCuslis extends DeciTreeReadTemplate<PhonapInfo> {
	
	public NodePhonapCuslis(DeciTreeOption<PhonapInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<PhonapInfo> buildDecisionCheckerHook(DeciTreeOption<PhonapInfo> option) {
		List<ModelChecker<PhonapInfo>> queue = new ArrayList<>();		
		ModelChecker<PhonapInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new PhonapCheckHasCustomer(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<PhonapInfo>> buildActionsOnPassedHook(DeciTreeOption<PhonapInfo> option) {
		List<ActionStd<PhonapInfo>> actions = new ArrayList<>();		
		
		ActionStd<PhonapInfo> mergeCuslis = new StdPhonapMergeCuslis(option);	
		
		actions.add(mergeCuslis);			
		return actions;
	}
	
	
	
	@Override protected List<ActionStd<PhonapInfo>> buildActionsOnFailedHook(DeciTreeOption<PhonapInfo> option) {
		List<ActionStd<PhonapInfo>> actions = new ArrayList<>();		
		
		ActionStd<PhonapInfo> nodeStolis = new NodePhonapStolis(option).toAction();	
		
		actions.add(nodeStolis);			
		return actions;
	}
}
