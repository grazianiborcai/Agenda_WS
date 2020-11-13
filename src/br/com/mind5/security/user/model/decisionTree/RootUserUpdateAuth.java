package br.com.mind5.security.user.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;
import br.com.mind5.security.user.info.UserInfo;
import br.com.mind5.security.user.model.action.LazyUserNodeSnapshot;
import br.com.mind5.security.user.model.action.LazyUserNodeUpdateAuth;
import br.com.mind5.security.user.model.action.LazyUserNodeUpdatePerson;
import br.com.mind5.security.user.model.action.LazyUserNodeUpsertAddress;
import br.com.mind5.security.user.model.action.LazyUserNodeUpsertPhone;
import br.com.mind5.security.user.model.action.LazyUserRootSelect;
import br.com.mind5.security.user.model.checker.UserCheckOwner;
import br.com.mind5.security.user.model.checker.UserCheckUpdate;
import br.com.mind5.security.user.model.checker.UserCheckUsername;

public final class RootUserUpdateAuth extends DeciTreeTemplateWrite<UserInfo> {
	
	public RootUserUpdateAuth(DeciTreeOption<UserInfo> option) {
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
		checker = new UserCheckUpdate(checkerOption);
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
		checker = new UserCheckUsername(checkerOption);
		queue.add(checker);	
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<UserInfo>> buildActionsOnPassedHook(DeciTreeOption<UserInfo> option) {
		List<ActionStd<UserInfo>> actions = new ArrayList<>();

		ActionStd<UserInfo> nodeAuth = new NodeUserAuth(option).toAction();
		ActionLazy<UserInfo> updateUser = new LazyUserNodeUpdateAuth(option.conn, option.schemaName);
		ActionLazy<UserInfo> updatePerson = new LazyUserNodeUpdatePerson(option.conn, option.schemaName);
		ActionLazy<UserInfo> snapshot = new LazyUserNodeSnapshot(option.conn, option.schemaName);		
		ActionLazy<UserInfo> upsertAddress = new LazyUserNodeUpsertAddress(option.conn, option.schemaName);	
		ActionLazy<UserInfo> upsertPhone = new LazyUserNodeUpsertPhone(option.conn, option.schemaName);		
		ActionLazy<UserInfo> select = new LazyUserRootSelect(option.conn, option.schemaName);	
			
		nodeAuth.addPostAction(updateUser);
		updateUser.addPostAction(updatePerson);
		updatePerson.addPostAction(snapshot);
		snapshot.addPostAction(upsertAddress);
		snapshot.addPostAction(upsertPhone);
		snapshot.addPostAction(select);
		
		actions.add(nodeAuth);
		return actions;
	}
}
