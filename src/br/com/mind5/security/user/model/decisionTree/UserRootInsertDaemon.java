package br.com.mind5.security.user.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;
import br.com.mind5.security.user.info.UserInfo;
import br.com.mind5.security.user.model.action.UserVisiNodeInsert;
import br.com.mind5.security.user.model.action.UserVisiNodeSnapshot;
import br.com.mind5.security.user.model.action.UserVisiRootSelect;
import br.com.mind5.security.user.model.action.UserVisiEnforceAuthDaemon;
import br.com.mind5.security.user.model.action.UserVisiEnforceCategDaemon;
import br.com.mind5.security.user.model.action.UserVisiEnforceUsernameDaemon;
import br.com.mind5.security.user.model.checker.UserCheckInsertDaemon;
import br.com.mind5.security.user.model.checker.UserCheckOwner;

public final class UserRootInsertDaemon extends DeciTreeTemplateWrite<UserInfo> {
	
	public UserRootInsertDaemon(DeciTreeOption<UserInfo> option) {
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
		checker = new UserCheckInsertDaemon(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new UserCheckOwner(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<UserInfo>> buildActionsOnPassedHook(DeciTreeOption<UserInfo> option) {
		List<ActionStd<UserInfo>> actions = new ArrayList<>();

		ActionStd<UserInfo> enforceUsername = new ActionStdCommom<UserInfo>(option, UserVisiEnforceUsernameDaemon.class);
		ActionLazy<UserInfo> enforceCateg = new ActionLazyCommom<UserInfo>(option, UserVisiEnforceCategDaemon.class);
		ActionLazy<UserInfo> enforceAuthGroup = new ActionLazyCommom<UserInfo>(option, UserVisiEnforceAuthDaemon.class);
		ActionLazy<UserInfo> insertUser = new ActionLazyCommom<UserInfo>(option, UserVisiNodeInsert.class);
		ActionLazy<UserInfo> snapshot = new ActionLazyCommom<UserInfo>(option, UserVisiNodeSnapshot.class);		
		ActionLazy<UserInfo> select = new ActionLazyCommom<UserInfo>(option, UserVisiRootSelect.class);	
		
		enforceUsername.addPostAction(enforceCateg);
		enforceCateg.addPostAction(enforceAuthGroup);			
		enforceAuthGroup.addPostAction(insertUser);
		insertUser.addPostAction(snapshot);				
		snapshot.addPostAction(select);
		
		actions.add(enforceUsername);	
		return actions;
	}
}
