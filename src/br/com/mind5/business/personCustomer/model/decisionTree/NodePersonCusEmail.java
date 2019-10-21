package br.com.mind5.business.personCustomer.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.personCustomer.info.PersonCusInfo;
import br.com.mind5.business.personCustomer.model.action.LazyPersonCusSelect;
import br.com.mind5.business.personCustomer.model.action.StdPersonCusEnforceEmail;
import br.com.mind5.business.personCustomer.model.checker.PersonCusCheckHasEmail;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeReadTemplate;

public final class NodePersonCusEmail extends DeciTreeReadTemplate<PersonCusInfo> {
	
	public NodePersonCusEmail(DeciTreeOption<PersonCusInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<PersonCusInfo> buildDecisionCheckerHook(DeciTreeOption<PersonCusInfo> option) {
		final boolean HAS_EMAIL = true;
		
		List<ModelChecker<PersonCusInfo>> queue = new ArrayList<>();		
		ModelChecker<PersonCusInfo> checker;
		ModelCheckerOption checkerOption;	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = HAS_EMAIL;		
		checker = new PersonCusCheckHasEmail(checkerOption);
		queue.add(checker);	
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<PersonCusInfo>> buildActionsOnPassedHook(DeciTreeOption<PersonCusInfo> option) {
		List<ActionStd<PersonCusInfo>> actions = new ArrayList<>();
		
		ActionStd<PersonCusInfo> enforceEmail = new StdPersonCusEnforceEmail(option);
	    ActionLazy<PersonCusInfo> select = new LazyPersonCusSelect(option.conn, option.schemaName);
		
	    enforceEmail.addPostAction(select);
		
		actions.add(enforceEmail);
		return actions;
	}
	
	
	
	@Override protected List<ActionStd<PersonCusInfo>> buildActionsOnFailedHook(DeciTreeOption<PersonCusInfo> option) {
		List<ActionStd<PersonCusInfo>> actions = new ArrayList<>();
		
		ActionStd<PersonCusInfo> nodeCpf = new NodePersonCusCpf(option).toAction();
		
		actions.add(nodeCpf);
		return actions;
	}
}
