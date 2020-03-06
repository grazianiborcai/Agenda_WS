package br.com.mind5.security.user.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeWriteTemplate;
import br.com.mind5.security.user.info.UserInfo;
import br.com.mind5.security.user.model.action.LazyUserNodeSnapshot;
import br.com.mind5.security.user.model.action.LazyUserNodeUpdatePerson;
import br.com.mind5.security.user.model.action.LazyUserNodeUpsertAddress;
import br.com.mind5.security.user.model.action.LazyUserNodeUpsertPhone;
import br.com.mind5.security.user.model.checker.UserCheckOwner;
import br.com.mind5.security.user.model.checker.UserCheckUpdate;
import br.com.mind5.security.user.model.checker.UserCheckUsername;

public final class RootUserUpdateAuth extends DeciTreeWriteTemplate<UserInfo> {
	
	public RootUserUpdateAuth(DeciTreeOption<UserInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<UserInfo> buildDecisionCheckerHook(DeciTreeOption<UserInfo> option) {
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
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<UserInfo>> buildActionsOnPassedHook(DeciTreeOption<UserInfo> option) {
		List<ActionStd<UserInfo>> actions = new ArrayList<>();
		//TODO: permitir alterar codAuthGroup por aqui ou criar um endpoint para isso ?
		ActionStd<UserInfo> updateUser = new NodeUserUpdate(option).toAction();
		ActionLazy<UserInfo> updatePerson = new LazyUserNodeUpdatePerson(option.conn, option.schemaName);
		ActionLazy<UserInfo> snapshot = new LazyUserNodeSnapshot(option.conn, option.schemaName);		
		ActionLazy<UserInfo> upsertAddress = new LazyUserNodeUpsertAddress(option.conn, option.schemaName);	
		ActionLazy<UserInfo> upsertPhone = new LazyUserNodeUpsertPhone(option.conn, option.schemaName);		
		ActionStd<UserInfo> select = new RootUserSelect(option).toAction();		
			
		updateUser.addPostAction(updatePerson);
		updatePerson.addPostAction(snapshot);
		snapshot.addPostAction(upsertAddress);
		snapshot.addPostAction(upsertPhone);
		
		actions.add(updateUser);
		actions.add(select);	
		return actions;
	}
}
