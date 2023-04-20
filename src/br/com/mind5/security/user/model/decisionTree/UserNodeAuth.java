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
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;
import br.com.mind5.security.user.info.UserInfo;
import br.com.mind5.security.user.model.action.UserVisiEnforceCodUser;
import br.com.mind5.security.user.model.action.UserVisiMergeUsername;
import br.com.mind5.security.user.model.checker.UserCheckUserarch;

public final class UserNodeAuth extends DeciTreeTemplateRead<UserInfo> {
	
	public UserNodeAuth(DeciTreeOption<UserInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<UserInfo> buildCheckerHook(DeciTreeOption<UserInfo> option) {
		List<ModelChecker<UserInfo>> queue = new ArrayList<>();		
		ModelChecker<UserInfo> checker;
		ModelCheckerOption checkerOption;	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new UserCheckUserarch(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<UserInfo>> buildActionsOnPassedHook(DeciTreeOption<UserInfo> option) {
		List<ActionStd<UserInfo>> actions = new ArrayList<>();
		
		ActionStd <UserInfo> mergeUsername  = new ActionStdCommom <UserInfo>(option, UserVisiMergeUsername.class);
		ActionLazy<UserInfo> enforceCodUser = new ActionLazyCommom<UserInfo>(option, UserVisiEnforceCodUser.class);
		
		mergeUsername.addPostAction(enforceCodUser);
		
		actions.add(mergeUsername);
		return actions;
	}
}
