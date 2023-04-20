package br.com.mind5.security.user.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.common.ModelCheckerDummy;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;
import br.com.mind5.security.user.info.UserInfo;
import br.com.mind5.security.user.model.action.UserVisiCusparCreateOnConfig;
import br.com.mind5.security.user.model.action.UserVisiEnforceAuthCus;
import br.com.mind5.security.user.model.action.UserVisiEnforceCategCus;
import br.com.mind5.security.user.model.action.UserVisiRootInsert;

public final class UserRootInsertCus extends DeciTreeTemplateWrite<UserInfo> {
	
	public UserRootInsertCus(DeciTreeOption<UserInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<UserInfo> buildCheckerHook(DeciTreeOption<UserInfo> option) {
		List<ModelChecker<UserInfo>> queue = new ArrayList<>();		
		ModelChecker<UserInfo> checker;	
		
		checker = new ModelCheckerDummy<>();
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<UserInfo>> buildActionsOnPassedHook(DeciTreeOption<UserInfo> option) {
		List<ActionStd<UserInfo>> actions = new ArrayList<>();

		ActionStd <UserInfo> enforceCateg     = new ActionStdCommom <UserInfo>(option, UserVisiEnforceCategCus.class);
		ActionLazy<UserInfo> enforceAuthGroup = new ActionLazyCommom<UserInfo>(option, UserVisiEnforceAuthCus.class);
		ActionLazy<UserInfo> insertUser       = new ActionLazyCommom<UserInfo>(option, UserVisiRootInsert.class);
		ActionLazy<UserInfo> createCuspar     = new ActionLazyCommom<UserInfo>(option, UserVisiCusparCreateOnConfig.class);
		
		enforceCateg.addPostAction(enforceAuthGroup);
		enforceAuthGroup.addPostAction(insertUser);
		insertUser.addPostAction(createCuspar);
		
		actions.add(enforceCateg);	
		return actions;
	}
}
