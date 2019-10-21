package br.com.mind5.business.person.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.person.info.PersonInfo;
import br.com.mind5.business.person.model.action.StdPersonSuccess;
import br.com.mind5.business.person.model.checker.PersonCheckCpfLength;
import br.com.mind5.business.person.model.checker.PersonCheckCpfNumber;
import br.com.mind5.business.person.model.checker.PersonCheckCpfOnlyNumber;
import br.com.mind5.business.person.model.checker.PersonCheckCpfSequence;
import br.com.mind5.business.person.model.checker.PersonCheckExistCpf;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeWriteTemplate;

public final class NodePersonCpfL2 extends DeciTreeWriteTemplate<PersonInfo> {
	
	public NodePersonCpfL2(DeciTreeOption<PersonInfo> option) {
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
		checker = new PersonCheckCpfOnlyNumber(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new PersonCheckCpfLength(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new PersonCheckCpfSequence(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new PersonCheckCpfNumber(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.NOT_FOUND;		
		checker = new PersonCheckExistCpf(checkerOption);
		queue.add(checker);	
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<PersonInfo>> buildActionsOnPassedHook(DeciTreeOption<PersonInfo> option) {
		List<ActionStd<PersonInfo>> actions = new ArrayList<>();
		
		ActionStd<PersonInfo> success = new StdPersonSuccess(option);
		actions.add(success);	
		return actions;
	}
}
