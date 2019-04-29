package br.com.gda.business.personUser_.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.personUser_.info.PersonUserInfo;
import br.com.gda.business.personUser_.model.action.LazyPersonUserNodeEmail;
import br.com.gda.business.personUser_.model.action.StdPersonUserEnforceEntityCateg;
import br.com.gda.business.personUser_.model.checker.PersonUserCheckRead;
import br.com.gda.business.personUser_.model.checker.PersonUserCheckRef;
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

public final class RootPersonUserSelect implements DeciTree<PersonUserInfo> {
	private DeciTree<PersonUserInfo> tree;
	
	
	public RootPersonUserSelect(DeciTreeOption<PersonUserInfo> option) {
		DeciTreeHelperOption<PersonUserInfo> helperOption = new DeciTreeHelperOption<>();
		
		helperOption.visitorChecker = buildDecisionChecker();
		helperOption.recordInfos = option.recordInfos;
		helperOption.conn = option.conn;
		helperOption.actionsOnPassed = buildActionsOnPassed(option);
		
		tree = new DeciTreeHelper<>(helperOption);
	}
	
	
	
	private ModelChecker<PersonUserInfo> buildDecisionChecker() {
		List<ModelChecker<PersonUserInfo>> queue = new ArrayList<>();		
		ModelChecker<PersonUserInfo> checker;
		
		checker = new PersonUserCheckRead();
		queue.add(checker);
		
		checker = new PersonUserCheckRef();
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override public ActionStd<PersonUserInfo> toAction() {
		return tree.toAction();
	}
	
	
	
	private List<ActionStd<PersonUserInfo>> buildActionsOnPassed(DeciTreeOption<PersonUserInfo> option) {
		List<ActionStd<PersonUserInfo>> actions = new ArrayList<>();
		
		ActionStd<PersonUserInfo> enforceEntityCateg = new StdPersonUserEnforceEntityCateg(option);
		ActionLazy<PersonUserInfo> nodeEmail = new LazyPersonUserNodeEmail(option.conn, option.schemaName);
		
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
	
	
	
	@Override public DeciResult<PersonUserInfo> getDecisionResult() {
		return tree.getDecisionResult();
	}
}
