package br.com.gda.business.person.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.person.info.PersonInfo;
import br.com.gda.business.person.model.checker.PersonCheckHasCpf;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.model.decisionTree.DeciTreeWriteTemplate;

public final class NodePersonUpdateL1 extends DeciTreeWriteTemplate<PersonInfo> {
	
	public NodePersonUpdateL1(DeciTreeOption<PersonInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<PersonInfo> buildDecisionCheckerHook(DeciTreeOption<PersonInfo> option) {
		List<ModelChecker<PersonInfo>> queue = new ArrayList<>();		
		ModelChecker<PersonInfo> checker;	
		
		checker = new PersonCheckHasCpf();
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<PersonInfo>> buildActionsOnPassedHook(DeciTreeOption<PersonInfo> option) {
		List<ActionStd<PersonInfo>> actions = new ArrayList<>();
		
		ActionStd<PersonInfo> nodeCpf = new NodePersonUpdateCpfNew(option).toAction();		
		actions.add(nodeCpf);	
		return actions;
	}
	
	
	
	@Override protected List<ActionStd<PersonInfo>> buildActionsOnFailedHook(DeciTreeOption<PersonInfo> option) {
		List<ActionStd<PersonInfo>> actions = new ArrayList<>();
		
		ActionStd<PersonInfo> nodeCpf = new NodePersonUpdateCpfErasure(option).toAction();		
		actions.add(nodeCpf);	
		return actions;
	}
}
