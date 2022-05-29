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
import br.com.mind5.security.user.model.action.UserVisiEnforceAuthAnonymous;
import br.com.mind5.security.user.model.action.UserVisiEnforceCategAnonymous;
import br.com.mind5.security.user.model.action.UserVisiEnforceUsernameAnonymous;
import br.com.mind5.security.user.model.action.UserVisiEnforceUsernameDaemon;
import br.com.mind5.security.user.model.action.UserVisiMergeUsername;
import br.com.mind5.security.user.model.action.UserVisiUpswdInsertAnonymous;
import br.com.mind5.security.user.model.checker.UserCheckInsertAnonymous;
import br.com.mind5.security.user.model.checker.UserCheckOwner;

public final class UserRootInsertAnonymous extends DeciTreeTemplateWrite<UserInfo> {
	
	public UserRootInsertAnonymous(DeciTreeOption<UserInfo> option) {
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
		checker = new UserCheckInsertAnonymous(checkerOption);
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

		ActionStd<UserInfo> enforceDaemon = new ActionStdCommom<UserInfo>(option, UserVisiEnforceUsernameDaemon.class);
		ActionLazy<UserInfo> enforceLChangedBy = new ActionLazyCommom<UserInfo>(option, UserVisiMergeUsername.class);
		ActionLazy<UserInfo> enforceUsername = new ActionLazyCommom<UserInfo>(option, UserVisiEnforceUsernameAnonymous.class);
		ActionLazy<UserInfo> enforceCateg = new ActionLazyCommom<UserInfo>(option, UserVisiEnforceCategAnonymous.class);
		ActionLazy<UserInfo> enforceAuthGroup = new ActionLazyCommom<UserInfo>(option, UserVisiEnforceAuthAnonymous.class);
		ActionLazy<UserInfo> insertUser = new ActionLazyCommom<UserInfo>(option, UserVisiNodeInsert.class);
		ActionLazy<UserInfo> snapshot = new ActionLazyCommom<UserInfo>(option, UserVisiNodeSnapshot.class);		
		ActionLazy<UserInfo> insertPassword = new ActionLazyCommom<UserInfo>(option, UserVisiUpswdInsertAnonymous.class);
		ActionLazy<UserInfo> select = new ActionLazyCommom<UserInfo>(option, UserVisiRootSelect.class);	
		
		enforceDaemon.addPostAction(enforceLChangedBy);
		enforceLChangedBy.addPostAction(enforceUsername);
		enforceUsername.addPostAction(enforceCateg);
		enforceCateg.addPostAction(enforceAuthGroup);			
		enforceAuthGroup.addPostAction(insertUser);
		insertUser.addPostAction(snapshot);				
		snapshot.addPostAction(insertPassword);
		insertPassword.addPostAction(select);
		
		actions.add(enforceDaemon);	
		return actions;
	}
}
