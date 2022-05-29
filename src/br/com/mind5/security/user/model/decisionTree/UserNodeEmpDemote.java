package br.com.mind5.security.user.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.action.commom.ActionStdSuccessCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;
import br.com.mind5.security.user.info.UserInfo;
import br.com.mind5.security.user.model.action.UserVisiNodeSnapshot;
import br.com.mind5.security.user.model.action.UserVisiNodeUpdate;
import br.com.mind5.security.user.model.action.UserVisiRootSelect;
import br.com.mind5.security.user.model.action.UserVisiEnforceAuthCus;
import br.com.mind5.security.user.model.action.UserVisiEnforceCategCus;
import br.com.mind5.security.user.model.checker.UserCheckAuthEmployee;
import br.com.mind5.security.user.model.checker.UserCheckEmparchEmail;
import br.com.mind5.security.user.model.checker.UserCheckPersonData;

public final class UserNodeEmpDemote extends DeciTreeTemplateWrite<UserInfo> {
	
	public UserNodeEmpDemote(DeciTreeOption<UserInfo> option) {
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
		checker = new UserCheckAuthEmployee(checkerOption);
		queue.add(checker);	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;		
		checker = new UserCheckPersonData(checkerOption);
		queue.add(checker);	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.NOT_FOUND;		
		checker = new UserCheckEmparchEmail(checkerOption);
		queue.add(checker);	
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<UserInfo>> buildActionsOnPassedHook(DeciTreeOption<UserInfo> option) {
		List<ActionStd<UserInfo>> actions = new ArrayList<>();

		ActionStd<UserInfo> enforceCateg = new ActionStdCommom<UserInfo>(option, UserVisiEnforceCategCus.class);
		ActionLazy<UserInfo> enforceAuthGroup = new ActionLazyCommom<UserInfo>(option, UserVisiEnforceAuthCus.class);
		ActionLazy<UserInfo> update = new ActionLazyCommom<UserInfo>(option, UserVisiNodeUpdate.class);
		ActionLazy<UserInfo> snapshot = new ActionLazyCommom<UserInfo>(option, UserVisiNodeSnapshot.class);
		ActionLazy<UserInfo> select = new ActionLazyCommom<UserInfo>(option, UserVisiRootSelect.class);
		
		enforceCateg.addPostAction(enforceAuthGroup);			
		enforceAuthGroup.addPostAction(update);
		update.addPostAction(snapshot);
		snapshot.addPostAction(select);
		
		actions.add(enforceCateg);	
		return actions;
	}
	
	
	
	@Override protected List<ActionStd<UserInfo>> buildActionsOnFailedHook(DeciTreeOption<UserInfo> option) {
		List<ActionStd<UserInfo>> actions = new ArrayList<>();

		ActionStd<UserInfo> success = new ActionStdSuccessCommom<UserInfo>(option);
		
		actions.add(success);	
		return actions;
	}
}
