package br.com.mind5.business.person.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.person.info.PersonInfo;
import br.com.mind5.business.person.model.action.StdPersonSuccess;
import br.com.mind5.business.person.model.checker.PersonCheckHasEmail;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeWriteTemplate;

public final class NodePersonEmailL1 extends DeciTreeWriteTemplate<PersonInfo> {
	
	public NodePersonEmailL1(DeciTreeOption<PersonInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<PersonInfo> buildDecisionCheckerHook(DeciTreeOption<PersonInfo> option) {
		List<ModelChecker<PersonInfo>> queue = new ArrayList<>();		
		ModelChecker<PersonInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;
		checker = new PersonCheckHasEmail(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<PersonInfo>> buildActionsOnPassedHook(DeciTreeOption<PersonInfo> option) {
		List<ActionStd<PersonInfo>> actions = new ArrayList<>();
		
		ActionStd<PersonInfo> nodeCpf = new NodePersonEmailL2(option).toAction();		
		actions.add(nodeCpf);	
		return actions;
	}
	
	
	
	@Override protected List<ActionStd<PersonInfo>> buildActionsOnFailedHook(DeciTreeOption<PersonInfo> option) {
		List<ActionStd<PersonInfo>> actions = new ArrayList<>();
		
		ActionStd<PersonInfo> success = new StdPersonSuccess(option);
		actions.add(success);	
		return actions;
	}
}
