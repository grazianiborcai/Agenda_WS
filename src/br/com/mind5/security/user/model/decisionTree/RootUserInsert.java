package br.com.mind5.security.user.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;
import br.com.mind5.security.user.info.UserInfo;
import br.com.mind5.security.user.model.action.LazyUserEnforceCreatedBy;
import br.com.mind5.security.user.model.action.LazyUserNodeInsert;
import br.com.mind5.security.user.model.action.LazyUserNodeInsertPerson;
import br.com.mind5.security.user.model.action.LazyUserNodeSnapshot;
import br.com.mind5.security.user.model.action.LazyUserNodeUpsertAddress;
import br.com.mind5.security.user.model.action.LazyUserNodeUpsertPhone;
import br.com.mind5.security.user.model.action.LazyUserNodeUsernameL1;
import br.com.mind5.security.user.model.action.LazyUserRootSelect;
import br.com.mind5.security.user.model.action.LazyUserUpswdInsertRandom;
import br.com.mind5.security.user.model.action.StdUserMergeUsername;
import br.com.mind5.security.user.model.checker.UserCheckAuthgroup;
import br.com.mind5.security.user.model.checker.UserCheckInsert;
import br.com.mind5.security.user.model.checker.UserCheckLangu;
import br.com.mind5.security.user.model.checker.UserCheckOwner;
import br.com.mind5.security.user.model.checker.UserCheckUsereg;

public final class RootUserInsert extends DeciTreeTemplateWrite<UserInfo> {
	
	public RootUserInsert(DeciTreeOption<UserInfo> option) {
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
		checker = new UserCheckInsert(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new UserCheckOwner(checkerOption);
		queue.add(checker);	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new UserCheckLangu(checkerOption);
		queue.add(checker);	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new UserCheckUsereg(checkerOption);
		queue.add(checker);	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new UserCheckAuthgroup(checkerOption);
		queue.add(checker);		
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<UserInfo>> buildActionsOnPassedHook(DeciTreeOption<UserInfo> option) {
		List<ActionStd<UserInfo>> actions = new ArrayList<>();

		ActionStd<UserInfo> enforceLChangedBy = new StdUserMergeUsername(option);
		ActionLazy<UserInfo> enforceCreatedBy = new LazyUserEnforceCreatedBy(option.conn, option.schemaName);
		ActionLazy<UserInfo> nodeUsername = new LazyUserNodeUsernameL1(option.conn, option.schemaName);
		ActionLazy<UserInfo> insertUser = new LazyUserNodeInsert(option.conn, option.schemaName);
		ActionLazy<UserInfo> insertPerson = new LazyUserNodeInsertPerson(option.conn, option.schemaName);
		ActionLazy<UserInfo> snapshot = new LazyUserNodeSnapshot(option.conn, option.schemaName);
		ActionLazy<UserInfo> insertPassword = new LazyUserUpswdInsertRandom(option.conn, option.schemaName);
		ActionLazy<UserInfo> upsertAddress = new LazyUserNodeUpsertAddress(option.conn, option.schemaName);
		ActionLazy<UserInfo> upsertPhone = new LazyUserNodeUpsertPhone(option.conn, option.schemaName);
		ActionLazy<UserInfo> select = new LazyUserRootSelect(option.conn, option.schemaName);
		
		enforceLChangedBy.addPostAction(enforceCreatedBy);
		enforceCreatedBy.addPostAction(nodeUsername);
		nodeUsername.addPostAction(insertUser);
		insertUser.addPostAction(insertPerson);
		insertPerson.addPostAction(snapshot);
		snapshot.addPostAction(insertPassword);
		snapshot.addPostAction(upsertAddress);
		snapshot.addPostAction(upsertPhone);
		snapshot.addPostAction(select);
		
		actions.add(enforceLChangedBy);
		return actions;
	}
}
