package br.com.gda.business.person.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.person.info.PersonInfo;
import br.com.gda.business.person.model.action.StdPersonSuccess;
import br.com.gda.business.person.model.checker.PersonCheckCpfLength;
import br.com.gda.business.person.model.checker.PersonCheckCpfNumber;
import br.com.gda.business.person.model.checker.PersonCheckCpfOnlyNumber;
import br.com.gda.business.person.model.checker.PersonCheckCpfSequence;
import br.com.gda.business.person.model.checker.PersonCheckExistCpf;
import br.com.gda.business.person.model.checker.PersonCheckHasCpf;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.model.decisionTree.DeciTreeWriteTemplate;

public final class NodePersonCpf extends DeciTreeWriteTemplate<PersonInfo> {
	
	public NodePersonCpf(DeciTreeOption<PersonInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<PersonInfo> buildDecisionCheckerHook(DeciTreeOption<PersonInfo> option) {
		final boolean DONT_EXIST_ON_DB = false;	
		
		List<ModelChecker<PersonInfo>> queue = new ArrayList<>();		
		ModelChecker<PersonInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checker = new PersonCheckHasCpf();
		queue.add(checker);
		
		checker = new PersonCheckCpfOnlyNumber();
		queue.add(checker);
		
		checker = new PersonCheckCpfLength();
		queue.add(checker);
		
		checker = new PersonCheckCpfSequence();
		queue.add(checker);
		
		checker = new PersonCheckCpfNumber();
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = DONT_EXIST_ON_DB;		
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
