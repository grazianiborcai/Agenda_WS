package br.com.gda.business.user.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.user.info.UserInfo;
import br.com.gda.business.user.model.action.LazyUserEnforceAddressKey;
import br.com.gda.business.user.model.action.LazyUserEnforceReference;
import br.com.gda.business.user.model.action.LazyUserEnforceUsername;
import br.com.gda.business.user.model.action.LazyUserEnforcePersonKey;
import br.com.gda.business.user.model.action.LazyUserEnforcePhoneKey;
import br.com.gda.business.user.model.action.LazyUserInsertPerson;
import br.com.gda.business.user.model.action.LazyUserInsertUpswd;
import br.com.gda.business.user.model.action.LazyUserNodeInsert;
import br.com.gda.business.user.model.action.LazyUserNodeUpsertAddress;
import br.com.gda.business.user.model.action.LazyUserNodeUpsertPhone;
import br.com.gda.business.user.model.action.LazyUserRootSelect;
import br.com.gda.business.user.model.action.StdUserEnforceLChanged;
import br.com.gda.business.user.model.checker.UserCheckAuthGroup;
import br.com.gda.business.user.model.checker.UserCheckCateg;
import br.com.gda.business.user.model.checker.UserCheckInsert;
import br.com.gda.business.user.model.checker.UserCheckOwner;
import br.com.gda.business.user.model.checker.UserCheckTechField;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciChoice;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTree;
import br.com.gda.model.decisionTree.DeciTreeHelper;
import br.com.gda.model.decisionTree.DeciTreeHelperOption;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class RootUserInsert implements DeciTree<UserInfo> {
	private DeciTree<UserInfo> tree;
	
	
	public RootUserInsert(DeciTreeOption<UserInfo> option) {
		DeciTreeHelperOption<UserInfo> helperOption = new DeciTreeHelperOption<>();
		
		helperOption.visitorChecker = buildDecisionChecker(option);
		helperOption.recordInfos = option.recordInfos;
		helperOption.conn = option.conn;
		helperOption.actionsOnPassed = buildActionsOnPassed(option);
		
		tree = new DeciTreeHelper<>(helperOption);
	}
	
	
	
	private ModelChecker<UserInfo> buildDecisionChecker(DeciTreeOption<UserInfo> option) {
		final boolean EXIST_ON_DB = true;
		
		List<ModelChecker<UserInfo>> queue = new ArrayList<>();		
		ModelChecker<UserInfo> checker;
		ModelCheckerOption checkerOption;		
		
		checker = new UserCheckInsert();
		queue.add(checker);
		
		checker = new UserCheckTechField();
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;		
		checker = new UserCheckOwner(checkerOption);
		queue.add(checker);	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;		
		checker = new UserCheckCateg(checkerOption);
		queue.add(checker);	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;		
		checker = new UserCheckAuthGroup(checkerOption);
		queue.add(checker);	
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override public ActionStd<UserInfo> toAction() {
		return tree.toAction();
	}
	
	
	
	private List<ActionStd<UserInfo>> buildActionsOnPassed(DeciTreeOption<UserInfo> option) {
		List<ActionStd<UserInfo>> actions = new ArrayList<>();
		
		ActionStd<UserInfo> enforceLChanged = new StdUserEnforceLChanged(option);
		ActionLazy<UserInfo> enforceUsername = new LazyUserEnforceUsername(option.conn, option.schemaName);
		ActionLazy<UserInfo> enforceReference = new LazyUserEnforceReference(option.conn, option.schemaName);
		ActionLazy<UserInfo> enforcePersonKey = new LazyUserEnforcePersonKey(option.conn, option.schemaName);		
		ActionLazy<UserInfo> insertPerson = new LazyUserInsertPerson(option.conn, option.schemaName);
		ActionLazy<UserInfo> insertUser = new LazyUserNodeInsert(option.conn, option.schemaName);
		ActionLazy<UserInfo> insertPassword = new LazyUserInsertUpswd(option.conn, option.schemaName);
		ActionLazy<UserInfo> enforceAddressKey = new LazyUserEnforceAddressKey(option.conn, option.schemaName);
		ActionLazy<UserInfo> upsertAddress = new LazyUserNodeUpsertAddress(option.conn, option.schemaName);
		ActionLazy<UserInfo> enforcePhoneKey = new LazyUserEnforcePhoneKey(option.conn, option.schemaName);
		ActionLazy<UserInfo> upsertPhone = new LazyUserNodeUpsertPhone(option.conn, option.schemaName);		
		ActionLazy<UserInfo> select = new LazyUserRootSelect(option.conn, option.schemaName);	
		
		enforceLChanged.addPostAction(enforceUsername);
		enforceUsername.addPostAction(enforceReference);
		enforceReference.addPostAction(enforcePersonKey);		
		enforcePersonKey.addPostAction(insertPerson);		
		insertPerson.addPostAction(insertUser);		
		
		insertUser.addPostAction(insertPassword);	
		
		insertUser.addPostAction(enforceAddressKey);
		enforceAddressKey.addPostAction(upsertAddress);
		
		insertUser.addPostAction(enforcePhoneKey);
		enforcePhoneKey.addPostAction(upsertPhone);	
		
		insertUser.addPostAction(select);
		
		actions.add(enforceLChanged);	
		return actions;
	}
	
	
	
	@Override public void makeDecision() {
		tree.makeDecision();
	}
		

	
	@Override public DeciChoice getDecisionMade() {
		return tree.getDecisionMade();
	}
	
	
	
	@Override public DeciResult<UserInfo> getDecisionResult() {
		return tree.getDecisionResult();
	}
}
