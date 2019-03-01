package br.com.gda.business.user.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.user.info.UserInfo;
import br.com.gda.business.user.model.action.LazyUserDelete;
import br.com.gda.business.user.model.action.LazyUserDeletePerson;
import br.com.gda.business.user.model.action.LazyUserDeleteUpswd;
import br.com.gda.business.user.model.action.LazyUserEnforceLChanged;
import br.com.gda.business.user.model.action.LazyUserMergeUsername;
import br.com.gda.business.user.model.action.LazyUserNodeDeleteAddress;
import br.com.gda.business.user.model.action.LazyUserNodeDeletePhone;
import br.com.gda.business.user.model.action.LazyUserUpdate;
import br.com.gda.business.user.model.action.StdUserMergeToDelete;
import br.com.gda.business.user.model.checker.UserCheckExist;
import br.com.gda.business.user.model.checker.UserCheckDelete;
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

public final class RootUserDelete implements DeciTree<UserInfo> {
	private DeciTree<UserInfo> tree;
	
	
	public RootUserDelete(DeciTreeOption<UserInfo> option) {
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
		
		checker = new UserCheckDelete();
		queue.add(checker);
			
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;		
		checker = new UserCheckExist(checkerOption);
		queue.add(checker);
		
		 return new ModelCheckerQueue<UserInfo>(queue);
	}
	
	
	
	@Override public ActionStd<UserInfo> toAction() {
		return tree.toAction();
	}
	
	
	
	private List<ActionStd<UserInfo>> buildActionsOnPassed(DeciTreeOption<UserInfo> option) {
		List<ActionStd<UserInfo>> actions = new ArrayList<>();
		
		ActionStd<UserInfo> mergeToDelete = new StdUserMergeToDelete(option);
		ActionLazy<UserInfo> enforceLChanged = new LazyUserEnforceLChanged(option.conn, option.schemaName);
		ActionLazy<UserInfo> enforceLChangedBy = new LazyUserMergeUsername(option.conn, option.schemaName);
		ActionLazy<UserInfo> updateUser = new LazyUserUpdate(option.conn, option.schemaName);
		ActionLazy<UserInfo> deleteAddress = new LazyUserNodeDeleteAddress(option.conn, option.schemaName);
		ActionLazy<UserInfo> deletePhone = new LazyUserNodeDeletePhone(option.conn, option.schemaName);
		ActionLazy<UserInfo> deleteUser = new LazyUserDelete(option.conn, option.schemaName);	
		ActionLazy<UserInfo> deletePassword = new LazyUserDeleteUpswd(option.conn, option.schemaName);	
		ActionLazy<UserInfo> deletePerson = new LazyUserDeletePerson(option.conn, option.schemaName);
		
		mergeToDelete.addPostAction(enforceLChanged);		
		enforceLChanged.addPostAction(enforceLChangedBy);
		enforceLChangedBy.addPostAction(updateUser);
		updateUser.addPostAction(deleteAddress);		
		updateUser.addPostAction(deletePhone);
		updateUser.addPostAction(deleteUser);
		updateUser.addPostAction(deletePassword);
		updateUser.addPostAction(deletePerson);
		//TODO: delete token ? Ou colocar dentro de password ? 
		actions.add(mergeToDelete);
		
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
