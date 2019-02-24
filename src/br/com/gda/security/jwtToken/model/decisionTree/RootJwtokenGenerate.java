package br.com.gda.security.jwtToken.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

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
import br.com.gda.security.jwtToken.info.JwtokenInfo;
import br.com.gda.security.jwtToken.model.action.LazyJwtokenEnforceExpiration;
import br.com.gda.security.jwtToken.model.action.LazyJwtokenEnforceToken;
import br.com.gda.security.jwtToken.model.action.StdJwtokenEnforceSecret;
import br.com.gda.security.jwtToken.model.checker.JwtokenCheckGenerate;

public final class RootJwtokenGenerate implements DeciTree<JwtokenInfo> {
	private DeciTree<JwtokenInfo> tree;
	
	
	public RootJwtokenGenerate(DeciTreeOption<JwtokenInfo> option) {
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
		
		checker = new JwtokenCheckGenerate();
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override public ActionStd<JwtokenInfo> toAction() {
		return tree.toAction();
	}
	
	
	
	private List<ActionStd<JwtokenInfo>> buildActionsOnPassed(DeciTreeOption<JwtokenInfo> option) {
		List<ActionStd<JwtokenInfo>> actions = new ArrayList<>();
		
		ActionStd<JwtokenInfo> enforceSecret = new StdJwtokenEnforceSecret(option);
		ActionLazy<JwtokenInfo> enforceExpiration = new LazyJwtokenEnforceExpiration(option.conn, option.schemaName);
		ActionLazy<JwtokenInfo> enforceToken = new LazyJwtokenEnforceToken(option.conn, option.schemaName);
		
		enforceSecret.addPostAction(enforceExpiration);
		enforceExpiration.addPostAction(enforceToken);
		
		actions.add(enforceSecret);
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
