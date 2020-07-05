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
import br.com.mind5.security.user.model.action.LazyUserUpswdInsertRandom;
import br.com.mind5.security.user.model.action.LazyUserNodeInsert;
import br.com.mind5.security.user.model.action.LazyUserNodeInsertPerson;
import br.com.mind5.security.user.model.action.LazyUserNodeSnapshot;
import br.com.mind5.security.user.model.action.LazyUserNodeUpsertAddress;
import br.com.mind5.security.user.model.action.LazyUserNodeUpsertPhone;
import br.com.mind5.security.user.model.action.LazyUserNodeUsernameL1;
import br.com.mind5.security.user.model.action.LazyUserRootSelect;
import br.com.mind5.security.user.model.action.StdUserMergeUsername;
import br.com.mind5.security.user.model.checker.UserCheckAuthgroup;
import br.com.mind5.security.user.model.checker.UserCheckInsert;
import br.com.mind5.security.user.model.checker.UserCheckOwner;
import br.com.mind5.security.user.model.checker.UserCheckUsereg;

public final class RootUserInsert extends DeciTreeTemplateWriteV2<UserInfo> {
	
	public RootUserInsert(DeciTreeOption<UserInfo> option) {
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
		checker = new UserCheckUsereg(checkerOption);
		queue.add(checker);	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new UserCheckAuthgroup(checkerOption);
		queue.add(checker);		
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<UserInfo>> buildActionsOnPassedHook(DeciTreeOption<UserInfo> option) {
		List<ActionStdV1<UserInfo>> actions = new ArrayList<>();

		ActionStdV1<UserInfo> enforceLChangedBy = new StdUserMergeUsername(option);
		ActionLazyV1<UserInfo> nodeUsername = new LazyUserNodeUsernameL1(option.conn, option.schemaName);
		ActionLazyV1<UserInfo> insertUser = new LazyUserNodeInsert(option.conn, option.schemaName);		
		ActionLazyV1<UserInfo> insertPerson = new LazyUserNodeInsertPerson(option.conn, option.schemaName);
		ActionLazyV1<UserInfo> snapshot = new LazyUserNodeSnapshot(option.conn, option.schemaName);
		ActionLazyV1<UserInfo> insertPassword = new LazyUserUpswdInsertRandom(option.conn, option.schemaName);		
		ActionLazyV1<UserInfo> upsertAddress = new LazyUserNodeUpsertAddress(option.conn, option.schemaName);
		ActionLazyV1<UserInfo> upsertPhone = new LazyUserNodeUpsertPhone(option.conn, option.schemaName);		
		ActionLazyV1<UserInfo> select = new LazyUserRootSelect(option.conn, option.schemaName);	
		
		enforceLChangedBy.addPostAction(nodeUsername);
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
