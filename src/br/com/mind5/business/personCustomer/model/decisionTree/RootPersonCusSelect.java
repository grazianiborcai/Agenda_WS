package br.com.mind5.business.personCustomer.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.personCustomer.info.PersonCusInfo;
import br.com.mind5.business.personCustomer.model.action.LazyPersonCusNodeEmail;
import br.com.mind5.business.personCustomer.model.action.StdPersonCusEnforceEntityCateg;
import br.com.mind5.business.personCustomer.model.checker.PersonCusCheckRead;
import br.com.mind5.business.personCustomer.model.checker.PersonCusCheckRef;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeReadTemplate;

public final class RootPersonCusSelect extends DeciTreeReadTemplate<PersonCusInfo> {
	
	public RootPersonCusSelect(DeciTreeOption<PersonCusInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<PersonCusInfo> buildDecisionCheckerHook(DeciTreeOption<PersonCusInfo> option) {
		List<ModelChecker<PersonCusInfo>> queue = new ArrayList<>();		
		ModelChecker<PersonCusInfo> checker;
		
		checker = new PersonCusCheckRead();
		queue.add(checker);
		
		checker = new PersonCusCheckRef();
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<PersonCusInfo>> buildActionsOnPassedHook(DeciTreeOption<PersonCusInfo> option) {
		List<ActionStd<PersonCusInfo>> actions = new ArrayList<>();
		
		ActionStd<PersonCusInfo> enforceEntityCateg = new StdPersonCusEnforceEntityCateg(option);
		ActionLazy<PersonCusInfo> nodeEmail = new LazyPersonCusNodeEmail(option.conn, option.schemaName);
		
		enforceEntityCateg.addPostAction(nodeEmail);
		
		actions.add(enforceEntityCateg);
		return actions;
	}
}
