package br.com.gda.security.user.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.model.decisionTree.DeciTreeReadTemplate;
import br.com.gda.security.user.info.UserInfo;
import br.com.gda.security.user.model.action.LazyUserEnforceUsernameKey;
import br.com.gda.security.user.model.action.LazyUserRootSelect;
import br.com.gda.security.user.model.action.StdUserEnforceUsernameDaemon;
import br.com.gda.security.user.model.checker.UserCheckReadDaemon;

public final class RootUserSelectDaemon extends DeciTreeReadTemplate<UserInfo> {
	
	public RootUserSelectDaemon(DeciTreeOption<UserInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<UserInfo> buildDecisionCheckerHook(DeciTreeOption<UserInfo> option) {
		List<ModelChecker<UserInfo>> queue = new ArrayList<>();		
		ModelChecker<UserInfo> checker;
		
		checker = new UserCheckReadDaemon();
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<UserInfo>> buildActionsOnPassedHook(DeciTreeOption<UserInfo> option) {
		List<ActionStd<UserInfo>> actions = new ArrayList<>();
		
		ActionStd<UserInfo> enforceUsername = new StdUserEnforceUsernameDaemon(option);
		ActionLazy<UserInfo> enforceUsernameKey = new LazyUserEnforceUsernameKey(option.conn, option.schemaName);
		ActionLazy<UserInfo> select = new LazyUserRootSelect(option.conn, option.schemaName);
		
		enforceUsername.addPostAction(enforceUsernameKey);
		enforceUsernameKey.addPostAction(select);
		
		actions.add(enforceUsername);
		return actions;
	}
}
