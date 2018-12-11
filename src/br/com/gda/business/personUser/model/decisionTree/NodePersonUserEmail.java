package br.com.gda.business.personUser.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.personUser.info.PersonUserInfo;
import br.com.gda.business.personUser.model.action.LazyPersonUserSelect;
import br.com.gda.business.personUser.model.action.StdPersonUserEnforceEmail;
import br.com.gda.business.personUser.model.checker.PersonUserCheckHasEmail;
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

public final class NodePersonUserEmail implements DeciTree<PersonUserInfo> {
	private DeciTree<PersonUserInfo> tree;
	
	
	public NodePersonUserEmail(DeciTreeOption<PersonUserInfo> option) {
		DeciTreeHelperOption<PersonUserInfo> helperOption = new DeciTreeHelperOption<>();
		
		helperOption.visitorChecker = buildDecisionChecker(option);
		helperOption.recordInfos = option.recordInfos;
		helperOption.conn = option.conn;
		helperOption.actionsOnPassed = buildActionsOnPassed(option);
		helperOption.actionsOnFailed = buildActionsOnFailed(option);
		
		tree = new DeciTreeHelper<>(helperOption);
	}
	
	
	
	private ModelChecker<PersonUserInfo> buildDecisionChecker(DeciTreeOption<PersonUserInfo> option) {
		final boolean HAS_EMAIL = true;
		
		List<ModelChecker<PersonUserInfo>> queue = new ArrayList<>();		
		ModelChecker<PersonUserInfo> checker;
		ModelCheckerOption checkerOption;	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = HAS_EMAIL;		
		checker = new PersonUserCheckHasEmail(checkerOption);
		queue.add(checker);	
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override public ActionStd<PersonUserInfo> toAction() {
		return tree.toAction();
	}
	
	
	
	private List<ActionStd<PersonUserInfo>> buildActionsOnPassed(DeciTreeOption<PersonUserInfo> option) {
		List<ActionStd<PersonUserInfo>> actions = new ArrayList<>();
		
		ActionStd<PersonUserInfo> enforceEmail = new StdPersonUserEnforceEmail(option);
	    ActionLazy<PersonUserInfo> select = new LazyPersonUserSelect(option.conn, option.schemaName);
		
	    enforceEmail.addPostAction(select);
		
		actions.add(enforceEmail);
		return actions;
	}
	
	
	
	private List<ActionStd<PersonUserInfo>> buildActionsOnFailed(DeciTreeOption<PersonUserInfo> option) {
		List<ActionStd<PersonUserInfo>> actions = new ArrayList<>();
		
		ActionStd<PersonUserInfo> nodeCpf = new NodePersonUserCpf(option).toAction();
		
		actions.add(nodeCpf);
		return actions;
	}
	
	
	
	@Override public void makeDecision() {
		tree.makeDecision();
	}
		

	
	@Override public DeciChoice getDecisionMade() {
		return tree.getDecisionMade();
	}
	
	
	
	@Override public DeciResult<PersonUserInfo> getDecisionResult() {
		return tree.getDecisionResult();
	}
}
