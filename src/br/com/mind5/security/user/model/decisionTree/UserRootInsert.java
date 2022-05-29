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
import br.com.mind5.security.user.model.action.UserVisiNodePersonInsert;
import br.com.mind5.security.user.model.action.UserVisiNodeSnapshot;
import br.com.mind5.security.user.model.action.UserVisiNodeAddressUpsert;
import br.com.mind5.security.user.model.action.UserVisiNodePhoneUpsert;
import br.com.mind5.security.user.model.action.UserVisiNodeUsernameL1;
import br.com.mind5.security.user.model.action.UserVisiRootSelect;
import br.com.mind5.security.user.model.action.UserVisiEnforceCreatedBy;
import br.com.mind5.security.user.model.action.UserVisiMergeUsername;
import br.com.mind5.security.user.model.action.UserVisiUpswdInsertRandom;
import br.com.mind5.security.user.model.checker.UserCheckAuthgroup;
import br.com.mind5.security.user.model.checker.UserCheckInsert;
import br.com.mind5.security.user.model.checker.UserCheckLangu;
import br.com.mind5.security.user.model.checker.UserCheckOwner;
import br.com.mind5.security.user.model.checker.UserCheckUsereg;

public final class UserRootInsert extends DeciTreeTemplateWrite<UserInfo> {
	
	public UserRootInsert(DeciTreeOption<UserInfo> option) {
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

		ActionStd<UserInfo> enforceLChangedBy = new ActionStdCommom<UserInfo>(option, UserVisiMergeUsername.class);
		ActionLazy<UserInfo> enforceCreatedBy = new ActionLazyCommom<UserInfo>(option, UserVisiEnforceCreatedBy.class);
		ActionLazy<UserInfo> nodeUsername = new ActionLazyCommom<UserInfo>(option, UserVisiNodeUsernameL1.class);
		ActionLazy<UserInfo> insertUser = new ActionLazyCommom<UserInfo>(option, UserVisiNodeInsert.class);
		ActionLazy<UserInfo> insertPerson = new ActionLazyCommom<UserInfo>(option, UserVisiNodePersonInsert.class);
		ActionLazy<UserInfo> snapshot = new ActionLazyCommom<UserInfo>(option, UserVisiNodeSnapshot.class);
		ActionLazy<UserInfo> insertPassword = new ActionLazyCommom<UserInfo>(option, UserVisiUpswdInsertRandom.class);
		ActionLazy<UserInfo> upsertAddress = new ActionLazyCommom<UserInfo>(option, UserVisiNodeAddressUpsert.class);
		ActionLazy<UserInfo> upsertPhone = new ActionLazyCommom<UserInfo>(option, UserVisiNodePhoneUpsert.class);
		ActionLazy<UserInfo> select = new ActionLazyCommom<UserInfo>(option, UserVisiRootSelect.class);
		
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
