package br.com.gda.business.user.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.user.info.UserInfo;
import br.com.gda.business.user.model.action.LazyUserUpdatePerson;
import br.com.gda.business.user.model.action.StdUserEnforcePersonKey;
import br.com.gda.business.user.model.checker.UserCheckHasPerson;
import br.com.gda.business.user.model.checker.UserCheckUpdatePerson;
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

public final class NodeUserUpdatePerson implements DeciTree<UserInfo> {
	private DeciTree<UserInfo> tree;
	
	
	public NodeUserUpdatePerson(DeciTreeOption<UserInfo> option) {
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
		final boolean HAS_PERSON = true;
		
		List<ModelChecker<UserInfo>> queue = new ArrayList<>();		
		ModelChecker<UserInfo> checker;
		ModelCheckerOption checkerOption;	
			
		checker = new UserCheckUpdatePerson();
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = HAS_PERSON;		
		checker = new UserCheckHasPerson(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	private List<ActionStd<UserInfo>> buildActionsOnPassed(DeciTreeOption<UserInfo> option) {
		List<ActionStd<UserInfo>> actions = new ArrayList<>();
		
		ActionStd<UserInfo> enforcePersonKey = new StdUserEnforcePersonKey(option);
		ActionLazy<UserInfo> updatePerson = new LazyUserUpdatePerson(option.conn, option.schemaName);
		
		enforcePersonKey.addPostAction(updatePerson);
		
		actions.add(enforcePersonKey);
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
