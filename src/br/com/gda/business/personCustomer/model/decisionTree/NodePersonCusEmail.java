package br.com.gda.business.personCustomer.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.personCustomer.info.PersonCusInfo;
import br.com.gda.business.personCustomer.model.action.LazyPersonCusSelect;
import br.com.gda.business.personCustomer.model.action.StdPersonCusEnforceEmail;
import br.com.gda.business.personCustomer.model.checker.PersonCusCheckHasEmail;
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

public final class NodePersonCusEmail implements DeciTree<PersonCusInfo> {
	private DeciTree<PersonCusInfo> tree;
	
	
	public NodePersonCusEmail(DeciTreeOption<PersonCusInfo> option) {
		DeciTreeHelperOption<PersonCusInfo> helperOption = new DeciTreeHelperOption<>();
		
		helperOption.visitorChecker = buildDecisionChecker(option);
		helperOption.recordInfos = option.recordInfos;
		helperOption.conn = option.conn;
		helperOption.actionsOnPassed = buildActionsOnPassed(option);
		helperOption.actionsOnFailed = buildActionsOnFailed(option);
		
		tree = new DeciTreeHelper<>(helperOption);
	}
	
	
	
	private ModelChecker<PersonCusInfo> buildDecisionChecker(DeciTreeOption<PersonCusInfo> option) {
		final boolean HAS_EMAIL = true;
		
		List<ModelChecker<PersonCusInfo>> queue = new ArrayList<>();		
		ModelChecker<PersonCusInfo> checker;
		ModelCheckerOption checkerOption;	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = HAS_EMAIL;		
		checker = new PersonCusCheckHasEmail(checkerOption);
		queue.add(checker);	
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override public ActionStd<PersonCusInfo> toAction() {
		return tree.toAction();
	}
	
	
	
	private List<ActionStd<PersonCusInfo>> buildActionsOnPassed(DeciTreeOption<PersonCusInfo> option) {
		List<ActionStd<PersonCusInfo>> actions = new ArrayList<>();
		
		ActionStd<PersonCusInfo> enforceEmail = new StdPersonCusEnforceEmail(option);
	    ActionLazy<PersonCusInfo> select = new LazyPersonCusSelect(option.conn, option.schemaName);
		
	    enforceEmail.addPostAction(select);
		
		actions.add(enforceEmail);
		return actions;
	}
	
	
	
	private List<ActionStd<PersonCusInfo>> buildActionsOnFailed(DeciTreeOption<PersonCusInfo> option) {
		List<ActionStd<PersonCusInfo>> actions = new ArrayList<>();
		
		ActionStd<PersonCusInfo> nodeCpf = new NodePersonCusCpf(option).toAction();
		
		actions.add(nodeCpf);
		return actions;
	}
	
	
	
	@Override public void makeDecision() {
		tree.makeDecision();
	}
		

	
	@Override public DeciChoice getDecisionMade() {
		return tree.getDecisionMade();
	}
	
	
	
	@Override public DeciResult<PersonCusInfo> getDecisionResult() {
		return tree.getDecisionResult();
	}
}
