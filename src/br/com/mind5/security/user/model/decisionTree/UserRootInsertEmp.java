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
import br.com.mind5.security.user.model.action.UserVisiEnforceAuthEmp;
import br.com.mind5.security.user.model.action.UserVisiEnforceCategEmp;
import br.com.mind5.security.user.model.action.UserVisiMergePerson;
import br.com.mind5.security.user.model.action.UserVisiRootInsert;
import br.com.mind5.security.user.model.checker.UserCheckInsertEmp;
import br.com.mind5.security.user.model.checker.UserCheckLangu;
import br.com.mind5.security.user.model.checker.UserCheckOwner;
import br.com.mind5.security.user.model.checker.UserCheckPerson;

public final class UserRootInsertEmp extends DeciTreeTemplateWrite<UserInfo> {
	
	public UserRootInsertEmp(DeciTreeOption<UserInfo> option) {
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
		checker = new UserCheckInsertEmp(checkerOption);
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
		checker = new UserCheckPerson(checkerOption);
		queue.add(checker);	
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<UserInfo>> buildActionsOnPassedHook(DeciTreeOption<UserInfo> option) {
		List<ActionStd<UserInfo>> actions = new ArrayList<>();

		ActionStd <UserInfo> enforceCateg     = new ActionStdCommom <UserInfo>(option, UserVisiEnforceCategEmp.class);
		ActionLazy<UserInfo> enforceAuthGroup = new ActionLazyCommom<UserInfo>(option, UserVisiEnforceAuthEmp.class);
		ActionLazy<UserInfo> mergePerson      = new ActionLazyCommom<UserInfo>(option, UserVisiMergePerson.class);
		ActionLazy<UserInfo> insertUser       = new ActionLazyCommom<UserInfo>(option, UserVisiRootInsert.class);
		
		enforceCateg.addPostAction(enforceAuthGroup);			
		enforceAuthGroup.addPostAction(mergePerson);
		mergePerson.addPostAction(insertUser);
		
		actions.add(enforceCateg);	
		return actions;
	}
}
