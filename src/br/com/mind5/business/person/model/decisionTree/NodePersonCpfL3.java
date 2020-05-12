package br.com.mind5.business.person.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.person.info.PersonInfo;
import br.com.mind5.business.person.model.checker.PersonCheckHasPerson;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWriteV2;

public final class NodePersonCpfL3 extends DeciTreeTemplateWriteV2<PersonInfo> {
	
	public NodePersonCpfL3(DeciTreeOption<PersonInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<PersonInfo> buildCheckerHook(DeciTreeOption<PersonInfo> option) {
		List<ModelCheckerV1<PersonInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<PersonInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new PersonCheckHasPerson(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<PersonInfo>> buildActionsOnPassedHook(DeciTreeOption<PersonInfo> option) {
		List<ActionStdV1<PersonInfo>> actions = new ArrayList<>();
		
		ActionStdV1<PersonInfo> nodeCpfL4 = new NodePersonCpfL4(option).toAction();
		actions.add(nodeCpfL4);	
		
		return actions;
	}
	
	
	
	@Override protected List<ActionStdV1<PersonInfo>> buildActionsOnFailedHook(DeciTreeOption<PersonInfo> option) {
		List<ActionStdV1<PersonInfo>> actions = new ArrayList<>();
		
		ActionStdV1<PersonInfo> nodeCpfL5 = new NodePersonCpfL5(option).toAction();
		actions.add(nodeCpfL5);	
		
		return actions;
	}
}
