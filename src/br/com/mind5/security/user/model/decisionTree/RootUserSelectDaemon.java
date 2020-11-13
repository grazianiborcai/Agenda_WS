package br.com.mind5.security.user.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;
import br.com.mind5.security.user.info.UserInfo;
import br.com.mind5.security.user.model.action.LazyUserEnforceCategDaemon;
import br.com.mind5.security.user.model.action.LazyUserMergeUserarch;
import br.com.mind5.security.user.model.action.LazyUserRootSelect;
import br.com.mind5.security.user.model.action.StdUserEnforceUsernameDaemon;
import br.com.mind5.security.user.model.checker.UserCheckReadDaemon;

public final class RootUserSelectDaemon extends DeciTreeTemplateRead<UserInfo> {
	
	public RootUserSelectDaemon(DeciTreeOption<UserInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<UserInfo> buildCheckerHook(DeciTreeOption<UserInfo> option) {
		List<ModelChecker<UserInfo>> queue = new ArrayList<>();		
		ModelChecker<UserInfo> checker;
		ModelCheckerOption checkerOption;		
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new UserCheckReadDaemon(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<UserInfo>> buildActionsOnPassedHook(DeciTreeOption<UserInfo> option) {
		List<ActionStd<UserInfo>> actions = new ArrayList<>();
		
		ActionStd<UserInfo> enforceUsername = new StdUserEnforceUsernameDaemon(option);
		ActionLazy<UserInfo> enforceCateg = new LazyUserEnforceCategDaemon(option.conn, option.schemaName);		
		ActionLazy<UserInfo> mergeUserarch = new LazyUserMergeUserarch(option.conn, option.schemaName);
		ActionLazy<UserInfo> select = new LazyUserRootSelect(option.conn, option.schemaName);
		
		enforceUsername.addPostAction(enforceCateg);
		enforceCateg.addPostAction(mergeUserarch);
		mergeUserarch.addPostAction(select);
		
		actions.add(enforceUsername);
		return actions;
	}
}
