package br.com.gda.security.jwtToken.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciChoice;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTree;
import br.com.gda.model.decisionTree.DeciTreeHelper;
import br.com.gda.model.decisionTree.DeciTreeHelperOption;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.security.jwtToken.info.JwtokenInfo;
import br.com.gda.security.jwtToken.model.action.StdJwtokenSuccess;
import br.com.gda.security.jwtToken.model.checker.JwtokenCheckToken;

public final class NodeJwtokenValidate implements DeciTree<JwtokenInfo> {
	private DeciTree<JwtokenInfo> tree;
	
	
	public NodeJwtokenValidate(DeciTreeOption<JwtokenInfo> option) {
		DeciTreeHelperOption<JwtokenInfo> helperOption = new DeciTreeHelperOption<>();
		
		helperOption.visitorChecker = buildDecisionChecker();
		helperOption.recordInfos = option.recordInfos;
		helperOption.conn = option.conn;
		helperOption.actionsOnPassed = buildActionsOnPassed(option);
		
		tree = new DeciTreeHelper<>(helperOption);
	}
	
	
	
	private ModelChecker<JwtokenInfo> buildDecisionChecker() {
		List<ModelChecker<JwtokenInfo>> queue = new ArrayList<>();		
		ModelChecker<JwtokenInfo> checker;
		
		checker = new JwtokenCheckToken();
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override public ActionStd<JwtokenInfo> toAction() {
		return tree.toAction();
	}
	
	
	
	private List<ActionStd<JwtokenInfo>> buildActionsOnPassed(DeciTreeOption<JwtokenInfo> option) {
		List<ActionStd<JwtokenInfo>> actions = new ArrayList<>();
		
		ActionStd<JwtokenInfo> success = new StdJwtokenSuccess(option);
		
		actions.add(success);
		return actions;
	}
	
	
	
	@Override public void makeDecision() {
		tree.makeDecision();
	}
		

	
	@Override public DeciChoice getDecisionMade() {
		return tree.getDecisionMade();
	}
	
	
	
	@Override public DeciResult<JwtokenInfo> getDecisionResult() {
		return tree.getDecisionResult();
	}
}
