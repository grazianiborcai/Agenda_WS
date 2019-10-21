package br.com.mind5.business.personUser_.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.personUser_.info.PersonUserInfo;
import br.com.mind5.business.personUser_.model.action.LazyPersonUserMergeUser;
import br.com.mind5.business.personUser_.model.action.LazyPersonUserSelect;
import br.com.mind5.business.personUser_.model.action.StdPersonUserEnforceEmail;
import br.com.mind5.business.personUser_.model.checker.PersonUserCheckHasEmail;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeReadTemplate;

public final class NodePersonUserEmail extends DeciTreeReadTemplate<PersonUserInfo> {
	
	public NodePersonUserEmail(DeciTreeOption<PersonUserInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<PersonUserInfo> buildDecisionCheckerHook(DeciTreeOption<PersonUserInfo> option) {
		final boolean HAS_EMAIL = true;
		
		List<ModelChecker<PersonUserInfo>> queue = new ArrayList<>();		
		ModelChecker<PersonUserInfo> checker;
		ModelCheckerOption checkerOption;	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = HAS_EMAIL;		
		checker = new PersonUserCheckHasEmail(checkerOption);
		queue.add(checker);	
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<PersonUserInfo>> buildActionsOnPassedHook(DeciTreeOption<PersonUserInfo> option) {
		List<ActionStd<PersonUserInfo>> actions = new ArrayList<>();
		
		ActionStd<PersonUserInfo> enforceEmail = new StdPersonUserEnforceEmail(option);
	    ActionLazy<PersonUserInfo> select = new LazyPersonUserSelect(option.conn, option.schemaName);
	    ActionLazy<PersonUserInfo> mergeUser = new LazyPersonUserMergeUser(option.conn, option.schemaName);
		
	    enforceEmail.addPostAction(select);
	    select.addPostAction(mergeUser);
		
		actions.add(enforceEmail);
		return actions;
	}
	
	
	
	@Override protected List<ActionStd<PersonUserInfo>> buildActionsOnFailedHook(DeciTreeOption<PersonUserInfo> option) {
		List<ActionStd<PersonUserInfo>> actions = new ArrayList<>();
		
		ActionStd<PersonUserInfo> nodeCpf = new NodePersonUserCpf(option).toAction();
		
		actions.add(nodeCpf);
		return actions;
	}
}
