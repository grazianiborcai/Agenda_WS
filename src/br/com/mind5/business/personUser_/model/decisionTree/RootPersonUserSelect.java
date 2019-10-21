package br.com.mind5.business.personUser_.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.personUser_.info.PersonUserInfo;
import br.com.mind5.business.personUser_.model.action.LazyPersonUserNodeEmail;
import br.com.mind5.business.personUser_.model.action.StdPersonUserEnforceEntityCateg;
import br.com.mind5.business.personUser_.model.checker.PersonUserCheckRead;
import br.com.mind5.business.personUser_.model.checker.PersonUserCheckRef;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeReadTemplate;

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
