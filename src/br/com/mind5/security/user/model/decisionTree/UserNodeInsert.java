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
import br.com.mind5.security.user.model.action.UserVisiDaoInsert;
import br.com.mind5.security.user.model.action.UserVisiEnforceCreatedOn;
import br.com.mind5.security.user.model.action.UserVisiEnforceLChanged;

public final class UserNodeInsert extends DeciTreeTemplateWrite<UserInfo> {
	
	public UserNodeInsert(DeciTreeOption<UserInfo> option) {
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
		
		ActionStd <UserInfo> enforceLChanged  = new ActionStdCommom <UserInfo>(option, UserVisiEnforceLChanged.class);
		ActionLazy<UserInfo> enforceCreatedOn = new ActionLazyCommom<UserInfo>(option, UserVisiEnforceCreatedOn.class);
		ActionLazy<UserInfo> insertUser       = new ActionLazyCommom<UserInfo>(option, UserVisiDaoInsert.class);
		
		enforceLChanged.addPostAction(enforceCreatedOn);
		enforceCreatedOn.addPostAction(insertUser);
		
		actions.add(enforceLChanged);	
		return actions;
	}
}
