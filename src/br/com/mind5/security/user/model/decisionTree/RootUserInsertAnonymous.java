package br.com.mind5.security.user.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWriteV2;
import br.com.mind5.security.user.info.UserInfo;
import br.com.mind5.security.user.model.action.LazyUserEnforceAuthAnonymous;
import br.com.mind5.security.user.model.action.LazyUserEnforceCategAnonymous;
import br.com.mind5.security.user.model.action.LazyUserEnforceUsernameAnonymous;
import br.com.mind5.security.user.model.action.LazyUserMergeUsername;
import br.com.mind5.security.user.model.action.LazyUserNodeInsert;
import br.com.mind5.security.user.model.action.LazyUserNodeSnapshot;
import br.com.mind5.security.user.model.action.LazyUserRootSelect;
import br.com.mind5.security.user.model.action.LazyUserUpswdInsertAnonymous;
import br.com.mind5.security.user.model.action.StdUserEnforceUsernameDaemon;
import br.com.mind5.security.user.model.checker.UserCheckInsertAnonymous;
import br.com.mind5.security.user.model.checker.UserCheckOwner;

public final class RootUserInsertAnonymous extends DeciTreeTemplateWriteV2<UserInfo> {
	
	public RootUserInsertAnonymous(DeciTreeOption<UserInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<UserInfo> buildCheckerHook(DeciTreeOption<UserInfo> option) {
		List<ModelCheckerV1<UserInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<UserInfo> checker;
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
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<UserInfo>> buildActionsOnPassedHook(DeciTreeOption<UserInfo> option) {
		List<ActionStdV1<UserInfo>> actions = new ArrayList<>();

		ActionStdV1<UserInfo> enforceDaemon = new StdUserEnforceUsernameDaemon(option);
		ActionLazyV1<UserInfo> enforceLChangedBy = new LazyUserMergeUsername(option.conn, option.schemaName);
		ActionLazyV1<UserInfo> enforceUsername = new LazyUserEnforceUsernameAnonymous(option.conn, option.schemaName);
		ActionLazyV1<UserInfo> enforceCateg = new LazyUserEnforceCategAnonymous(option.conn, option.schemaName);
		ActionLazyV1<UserInfo> enforceAuthGroup = new LazyUserEnforceAuthAnonymous(option.conn, option.schemaName);
		ActionLazyV1<UserInfo> insertUser = new LazyUserNodeInsert(option.conn, option.schemaName);
		ActionLazyV1<UserInfo> snapshot = new LazyUserNodeSnapshot(option.conn, option.schemaName);		
		ActionLazyV1<UserInfo> insertPassword = new LazyUserUpswdInsertAnonymous(option.conn, option.schemaName);
		ActionLazyV1<UserInfo> select = new LazyUserRootSelect(option.conn, option.schemaName);	
		
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
