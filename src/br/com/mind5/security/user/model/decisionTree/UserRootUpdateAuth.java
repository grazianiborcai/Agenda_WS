package br.com.mind5.security.user.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;
import br.com.mind5.security.user.info.UserInfo;
import br.com.mind5.security.user.model.action.UserVisiNodeAddressUpsert;
import br.com.mind5.security.user.model.action.UserVisiNodePersonUpdate;
import br.com.mind5.security.user.model.action.UserVisiNodePhoneUpsert;
import br.com.mind5.security.user.model.action.UserVisiNodeSnapshot;
import br.com.mind5.security.user.model.action.UserVisiNodeUpdateAuth;
import br.com.mind5.security.user.model.action.UserVisiRootSelect;
import br.com.mind5.security.user.model.checker.UserCheckOwner;
import br.com.mind5.security.user.model.checker.UserCheckUpdate;
import br.com.mind5.security.user.model.checker.UserCheckUsername;

public final class UserRootUpdateAuth extends DeciTreeTemplateWrite<UserInfo> {
	
	public UserRootUpdateAuth(DeciTreeOption<UserInfo> option) {
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

		ActionStd <UserInfo> nodeAuth      = new UserNodeAuth(option).toAction();
		ActionLazy<UserInfo> updateUser    = new ActionLazyCommom<UserInfo>(option, UserVisiNodeUpdateAuth.class);
		ActionLazy<UserInfo> updatePerson  = new ActionLazyCommom<UserInfo>(option, UserVisiNodePersonUpdate.class);
		ActionLazy<UserInfo> snapshot      = new ActionLazyCommom<UserInfo>(option, UserVisiNodeSnapshot.class);		
		ActionLazy<UserInfo> upsertAddress = new ActionLazyCommom<UserInfo>(option, UserVisiNodeAddressUpsert.class);	
		ActionLazy<UserInfo> upsertPhone   = new ActionLazyCommom<UserInfo>(option, UserVisiNodePhoneUpsert.class);		
		ActionLazy<UserInfo> select        = new ActionLazyCommom<UserInfo>(option, UserVisiRootSelect.class);	
			
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
