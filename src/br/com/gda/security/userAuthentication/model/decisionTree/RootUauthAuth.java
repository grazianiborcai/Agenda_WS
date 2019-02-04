package br.com.gda.security.userAuthentication.model.decisionTree;

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
import br.com.gda.security.userAuthentication.info.UauthInfo;
import br.com.gda.security.userAuthentication.model.action.LazyUauthEnforceIsAuth;
import br.com.gda.security.userAuthentication.model.action.StdUauthSelectUpswd;
import br.com.gda.security.userAuthentication.model.checker.UauthCheckRead;

public final class RootUauthAuth implements DeciTree<UauthInfo> {
	private DeciTree<UauthInfo> tree;
	
	
	public RootUauthAuth(DeciTreeOption<UauthInfo> option) {
		DeciTreeHelperOption<UauthInfo> helperOption = new DeciTreeHelperOption<>();
		
		helperOption.visitorChecker = buildDecisionChecker();
		helperOption.recordInfos = option.recordInfos;
		helperOption.conn = option.conn;
		helperOption.actionsOnPassed = buildActionsOnPassed(option);
		
		tree = new DeciTreeHelper<>(helperOption);
	}
	
	
	
	private ModelChecker<UauthInfo> buildDecisionChecker() {
		List<ModelChecker<UauthInfo>> queue = new ArrayList<>();		
		ModelChecker<UauthInfo> checker;
		
		checker = new UauthCheckRead();
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override public ActionStd<UauthInfo> toAction() {
		return tree.toAction();
	}
	
	
	
	private List<ActionStd<UauthInfo>> buildActionsOnPassed(DeciTreeOption<UauthInfo> option) {
		List<ActionStd<UauthInfo>> actions = new ArrayList<>();
		
		ActionStd<UauthInfo> authUserPassword = new StdUauthSelectUpswd(option);
		ActionLazy<UauthInfo> enforceIsAuth = new LazyUauthEnforceIsAuth(option.conn, option.schemaName);
		
		authUserPassword.addPostAction(enforceIsAuth);	
		
		actions.add(authUserPassword);		
		return actions;
	}
	
	
	
	@Override public void makeDecision() {
		tree.makeDecision();
	}
		

	
	@Override public DeciChoice getDecisionMade() {
		return tree.getDecisionMade();
	}
	
	
	
	@Override public DeciResult<UauthInfo> getDecisionResult() {
		return tree.getDecisionResult();
	}
}
