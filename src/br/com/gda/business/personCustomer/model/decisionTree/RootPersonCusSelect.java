package br.com.gda.business.personCustomer.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.personCustomer.info.PersonCusInfo;
import br.com.gda.business.personCustomer.model.action.LazyPersonCusNodeEmail;
import br.com.gda.business.personCustomer.model.action.StdPersonCusEnforceEntityCateg;
import br.com.gda.business.personCustomer.model.checker.PersonCusCheckRead;
import br.com.gda.business.personCustomer.model.checker.PersonCusCheckRef;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciChoice;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTree;
import br.com.gda.model.decisionTree.DeciTreeHelper;
import br.com.gda.model.decisionTree.DeciTreeHelperOption;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class RootPersonCusSelect implements DeciTree<PersonCusInfo> {
	private DeciTree<PersonCusInfo> tree;
	
	
	public RootPersonCusSelect(DeciTreeOption<PersonCusInfo> option) {
		DeciTreeHelperOption<PersonCusInfo> helperOption = new DeciTreeHelperOption<>();
		
		helperOption.visitorChecker = buildDecisionChecker();
		helperOption.recordInfos = option.recordInfos;
		helperOption.conn = option.conn;
		helperOption.actionsOnPassed = buildActionsOnPassed(option);
		
		tree = new DeciTreeHelper<>(helperOption);
	}
	
	
	
	private ModelChecker<PersonCusInfo> buildDecisionChecker() {
		List<ModelChecker<PersonCusInfo>> queue = new ArrayList<>();		
		ModelChecker<PersonCusInfo> checker;
		
		checker = new PersonCusCheckRead();
		queue.add(checker);
		
		checker = new PersonCusCheckRef();
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override public ActionStd<PersonCusInfo> toAction() {
		return tree.toAction();
	}
	
	
	
	private List<ActionStd<PersonCusInfo>> buildActionsOnPassed(DeciTreeOption<PersonCusInfo> option) {
		List<ActionStd<PersonCusInfo>> actions = new ArrayList<>();
		
		ActionStd<PersonCusInfo> enforceEntityCateg = new StdPersonCusEnforceEntityCateg(option);
		ActionLazy<PersonCusInfo> nodeEmail = new LazyPersonCusNodeEmail(option.conn, option.schemaName);
		
		enforceEntityCateg.addPostAction(nodeEmail);
		
		actions.add(enforceEntityCateg);
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
