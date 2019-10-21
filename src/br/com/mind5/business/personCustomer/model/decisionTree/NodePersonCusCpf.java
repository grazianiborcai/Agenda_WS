package br.com.mind5.business.personCustomer.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.personCustomer.info.PersonCusInfo;
import br.com.mind5.business.personCustomer.model.action.LazyPersonCusSelect;
import br.com.mind5.business.personCustomer.model.action.StdPersonCusEnforceCpf;
import br.com.mind5.business.personCustomer.model.checker.PersonCusCheckHasCpf;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeReadTemplate;

public final class NodePersonCusCpf extends DeciTreeReadTemplate<PersonCusInfo> {
	
	public NodePersonCusCpf(DeciTreeOption<PersonCusInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<PersonCusInfo> buildDecisionCheckerHook(DeciTreeOption<PersonCusInfo> option) {
		final boolean HAS_CPF = true;
		
		List<ModelChecker<PersonCusInfo>> queue = new ArrayList<>();		
		ModelChecker<PersonCusInfo> checker;
		ModelCheckerOption checkerOption;	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = HAS_CPF;		
		checker = new PersonCusCheckHasCpf(checkerOption);
		queue.add(checker);	
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<PersonCusInfo>> buildActionsOnPassedHook(DeciTreeOption<PersonCusInfo> option) {
		List<ActionStd<PersonCusInfo>> actions = new ArrayList<>();
		
		ActionStd<PersonCusInfo> enforceCpf = new StdPersonCusEnforceCpf(option);
	    ActionLazy<PersonCusInfo> select = new LazyPersonCusSelect(option.conn, option.schemaName);
		
	    enforceCpf.addPostAction(select);
		
		actions.add(enforceCpf);
		return actions;
	}
}
