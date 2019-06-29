package br.com.gda.payment.creditCard.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.payment.creditCard.info.CrecardInfo;
import br.com.gda.payment.creditCard.model.checker.CrecardCheckHasCuspar;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.model.decisionTree.DeciTreeWriteTemplate;

public final class NodeCrecardInsertL1 extends DeciTreeWriteTemplate<CrecardInfo> {
	
	public NodeCrecardInsertL1(DeciTreeOption<CrecardInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<CrecardInfo> buildDecisionCheckerHook(DeciTreeOption<CrecardInfo> option) {
		List<ModelChecker<CrecardInfo>> queue = new ArrayList<>();		
		ModelChecker<CrecardInfo> checker;	
		
		checker = new CrecardCheckHasCuspar();
		queue.add(checker);

		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<CrecardInfo>> buildActionsOnPassedHook(DeciTreeOption<CrecardInfo> option) {
		List<ActionStd<CrecardInfo>> actions = new ArrayList<>();		

		ActionStd<CrecardInfo> nodeInsertL3 = new NodeCrecardInsertL3(option).toAction();	
		
		actions.add(nodeInsertL3);		
		return actions;
	}
	
	
	
	@Override protected List<ActionStd<CrecardInfo>> buildActionsOnFailedHook(DeciTreeOption<CrecardInfo> option) {
		List<ActionStd<CrecardInfo>> actions = new ArrayList<>();		

		ActionStd<CrecardInfo> nodeInsertL2 = new NodeCrecardInsertL2(option).toAction();	
		
		actions.add(nodeInsertL2);		
		return actions;
	}
}
