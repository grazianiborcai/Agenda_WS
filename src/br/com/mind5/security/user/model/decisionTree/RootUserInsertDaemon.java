package br.com.mind5.security.user.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;
import br.com.mind5.security.user.info.UserInfo;
import br.com.mind5.security.user.model.action.LazyUserEnforceAuthDaemon;
import br.com.mind5.security.user.model.action.LazyUserEnforceCategDaemon;
import br.com.mind5.security.user.model.action.LazyUserNodeInsert;
import br.com.mind5.security.user.model.action.LazyUserNodeSnapshot;
import br.com.mind5.security.user.model.action.LazyUserRootSelect;
import br.com.mind5.security.user.model.action.StdUserEnforceUsernameDaemon;
import br.com.mind5.security.user.model.checker.UserCheckInsertDaemon;
import br.com.mind5.security.user.model.checker.UserCheckOwner;

public final class RootUserInsertDaemon extends DeciTreeTemplateWrite<UserInfo> {
	
	public RootUserInsertDaemon(DeciTreeOption<UserInfo> option) {
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

		ActionStd<UserInfo> enforceUsername = new StdUserEnforceUsernameDaemon(option);
		ActionLazy<UserInfo> enforceCateg = new LazyUserEnforceCategDaemon(option.conn, option.schemaName);
		ActionLazy<UserInfo> enforceAuthGroup = new LazyUserEnforceAuthDaemon(option.conn, option.schemaName);
		ActionLazy<UserInfo> insertUser = new LazyUserNodeInsert(option.conn, option.schemaName);
		ActionLazy<UserInfo> snapshot = new LazyUserNodeSnapshot(option.conn, option.schemaName);		
		ActionLazy<UserInfo> select = new LazyUserRootSelect(option.conn, option.schemaName);	
		
		enforceUsername.addPostAction(enforceCateg);
		enforceCateg.addPostAction(enforceAuthGroup);			
		enforceAuthGroup.addPostAction(insertUser);
		insertUser.addPostAction(snapshot);				
		snapshot.addPostAction(select);
		
		actions.add(enforceUsername);	
		return actions;
	}
}
