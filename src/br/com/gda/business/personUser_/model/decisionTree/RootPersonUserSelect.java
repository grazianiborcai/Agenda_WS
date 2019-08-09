package br.com.gda.business.personUser_.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.personUser_.info.PersonUserInfo;
import br.com.gda.business.personUser_.model.action.LazyPersonUserNodeEmail;
import br.com.gda.business.personUser_.model.action.StdPersonUserEnforceEntityCateg;
import br.com.gda.business.personUser_.model.checker.PersonUserCheckRead;
import br.com.gda.business.personUser_.model.checker.PersonUserCheckRef;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.model.decisionTree.DeciTreeReadTemplate;

public final class RootPersonUserSelect extends DeciTreeReadTemplate<PersonUserInfo> {
	
	public RootPersonUserSelect(DeciTreeOption<PersonUserInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<PersonUserInfo> buildDecisionCheckerHook(DeciTreeOption<PersonUserInfo> option) {
		List<ModelChecker<PersonUserInfo>> queue = new ArrayList<>();		
		ModelChecker<PersonUserInfo> checker;
		
		checker = new PersonUserCheckRead();
		queue.add(checker);
		
		checker = new PersonUserCheckRef();
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<PersonUserInfo>> buildActionsOnPassedHook(DeciTreeOption<PersonUserInfo> option) {
		List<ActionStd<PersonUserInfo>> actions = new ArrayList<>();
		
		ActionStd<PersonUserInfo> enforceEntityCateg = new StdPersonUserEnforceEntityCateg(option);
		ActionLazy<PersonUserInfo> nodeEmail = new LazyPersonUserNodeEmail(option.conn, option.schemaName);
		
		enforceEntityCateg.addPostAction(nodeEmail);
		
		actions.add(enforceEntityCateg);
		return actions;
	}
}
