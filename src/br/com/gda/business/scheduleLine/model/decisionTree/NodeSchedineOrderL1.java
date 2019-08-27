package br.com.gda.business.scheduleLine.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.scheduleLine.info.SchedineInfo;
import br.com.gda.business.scheduleLine.model.action.StdSchedineObfuscateOrder;
import br.com.gda.business.scheduleLine.model.checker.SchedineCheckHasOrder;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.model.decisionTree.DeciTreeWriteTemplate;

public final class NodeSchedineOrderL1 extends DeciTreeWriteTemplate<SchedineInfo> {
	
	public NodeSchedineOrderL1(DeciTreeOption<SchedineInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<SchedineInfo> buildDecisionCheckerHook(DeciTreeOption<SchedineInfo> option) {
		List<ModelChecker<SchedineInfo>> queue = new ArrayList<>();		
		ModelChecker<SchedineInfo> checker;	
		
		checker = new SchedineCheckHasOrder();
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<SchedineInfo>> buildActionsOnPassedHook(DeciTreeOption<SchedineInfo> option) {
		List<ActionStd<SchedineInfo>> actions = new ArrayList<>();
		
		ActionStd<SchedineInfo> nodeOrderL2 = new NodeSchedineOrderL2(option).toAction();
		
		actions.add(nodeOrderL2);
		return actions;
	}
	
	
	
	@Override protected List<ActionStd<SchedineInfo>> buildActionsOnFailedHook(DeciTreeOption<SchedineInfo> option) {
		List<ActionStd<SchedineInfo>> actions = new ArrayList<>();
		
		ActionStd<SchedineInfo> obfuscateOrder = new StdSchedineObfuscateOrder(option);
		
		actions.add(obfuscateOrder);
		return actions;
	}
}
