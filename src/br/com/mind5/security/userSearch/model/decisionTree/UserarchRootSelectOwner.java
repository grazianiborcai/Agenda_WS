package br.com.mind5.security.userSearch.model.decisionTree;

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
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;
import br.com.mind5.security.userSearch.info.UserarchInfo;
import br.com.mind5.security.userSearch.model.action.UserarchVisiRootSelectAuth;
import br.com.mind5.security.userSearch.model.action.UserarchVisiEnforceOwner;

public final class UserarchRootSelectOwner extends DeciTreeTemplateRead<UserarchInfo> {
	
	public UserarchRootSelectOwner(DeciTreeOption<UserarchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<UserarchInfo> buildCheckerHook(DeciTreeOption<UserarchInfo> option) {
		List<ModelChecker<UserarchInfo>> queue = new ArrayList<>();		
		ModelChecker<UserarchInfo> checker;

		checker = new ModelCheckerDummy<>();
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<UserarchInfo>> buildActionsOnPassedHook(DeciTreeOption<UserarchInfo> option) {
		List<ActionStd<UserarchInfo>> actions = new ArrayList<>();
		
		ActionStd<UserarchInfo> enforceOwner = new ActionStdCommom<UserarchInfo>(option, UserarchVisiEnforceOwner.class);
		ActionLazy<UserarchInfo> select = new ActionLazyCommom<UserarchInfo>(option, UserarchVisiRootSelectAuth.class);
		
		enforceOwner.addPostAction(select);
		
		actions.add(enforceOwner);
		return actions;
	}
}
