package br.com.gda.business.user.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.user.info.UserInfo;
import br.com.gda.business.user.model.action.LazyUserEnforceEntityCateg;
import br.com.gda.business.user.model.action.LazyUserKeepUser;
import br.com.gda.business.user.model.action.LazyUserNodeUpdatePerson;
import br.com.gda.business.user.model.action.LazyUserNodeUpsertAddress;
import br.com.gda.business.user.model.action.LazyUserNodeUpsertPhone;
import br.com.gda.business.user.model.action.LazyUserUpdate;
import br.com.gda.business.user.model.action.StdUserEnforceLChanged;
import br.com.gda.business.user.model.checker.UserCheckExist;
import br.com.gda.business.user.model.checker.UserCheckOwner;
import br.com.gda.business.user.model.checker.UserCheckPerson;
import br.com.gda.business.user.model.checker.UserCheckWrite;
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

public final class RootUserUpdate implements DeciTree<UserInfo> {
	private DeciTree<UserInfo> tree;
	
	
	public RootUserUpdate(DeciTreeOption<UserInfo> option) {
		DeciTreeHelperOption<UserInfo> helperOption = new DeciTreeHelperOption<>();
		
		helperOption.visitorChecker = buildDecisionChecker(option);
		helperOption.recordInfos = option.recordInfos;
		helperOption.conn = option.conn;
		helperOption.schemaName = option.schemaName;
		helperOption.actionsOnPassed = buildActionsOnPassed(option);
		helperOption.actionsOnFailed = null;
		
		tree = new DeciTreeHelper<>(helperOption);
	}
	
	
	
	private ModelChecker<UserInfo> buildDecisionChecker(DeciTreeOption<UserInfo> option) {
		final boolean EXIST_ON_DB = true;
		
		List<ModelChecker<UserInfo>> queue = new ArrayList<>();		
		ModelChecker<UserInfo> checker;
		ModelCheckerOption checkerOption;		
		
		checker = new UserCheckWrite();
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
		checker = new UserCheckExist(checkerOption);
		queue.add(checker);	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;		
		checker = new UserCheckPerson(checkerOption);
		queue.add(checker);	
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	private List<ActionStd<UserInfo>> buildActionsOnPassed(DeciTreeOption<UserInfo> option) {
		List<ActionStd<UserInfo>> actions = new ArrayList<>();

		ActionStd<UserInfo> enforceLChanged = new StdUserEnforceLChanged(option);
		ActionLazy<UserInfo> enforceEntityCateg = new LazyUserEnforceEntityCateg(option.conn, option.schemaName);
		ActionLazy<UserInfo> keepUser = new LazyUserKeepUser(option.conn, option.schemaName);		
		ActionLazy<UserInfo> updateUser = new LazyUserUpdate(option.conn, option.schemaName);		
		ActionLazy<UserInfo> updatePerson = new LazyUserNodeUpdatePerson(option.conn, option.schemaName);
		ActionLazy<UserInfo> upsertAddress = new LazyUserNodeUpsertAddress(option.conn, option.schemaName);	
		ActionLazy<UserInfo> upsertPhone = new LazyUserNodeUpsertPhone(option.conn, option.schemaName);		
		ActionStd<UserInfo> select = new RootUserSelect(option).toAction();		
		
		enforceLChanged.addPostAction(enforceEntityCateg);
		enforceEntityCateg.addPostAction(keepUser);
		
		keepUser.addPostAction(updateUser);
		keepUser.addPostAction(updatePerson);
		keepUser.addPostAction(upsertAddress);		
		keepUser.addPostAction(upsertPhone);
		
		actions.add(enforceLChanged);
		actions.add(select);	
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
	
	
	
	@Override public ActionStd<UserInfo> toAction() {
		return tree.toAction();
	}
}
