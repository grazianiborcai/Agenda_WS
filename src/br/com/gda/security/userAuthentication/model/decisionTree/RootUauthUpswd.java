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
import br.com.gda.security.userAuthentication.model.action.LazyUauthAuthenticateUpswd;
import br.com.gda.security.userAuthentication.model.action.LazyUauthMergeUser;
import br.com.gda.security.userAuthentication.model.action.StdUauthEnforceCodUser;
import br.com.gda.security.userAuthentication.model.checker.UauthCheckRead;

public final class RootUauthUpswd implements DeciTree<UauthInfo> {
	private DeciTree<UauthInfo> tree;
	
	
	public RootUauthUpswd(DeciTreeOption<UauthInfo> option) {
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
		
		ActionStd<UauthInfo> enforceCodUser = new StdUauthEnforceCodUser(option);
		ActionLazy<UauthInfo> authenticateUpswd = new LazyUauthAuthenticateUpswd(option.conn, option.schemaName);
		ActionLazy<UauthInfo> mergeUser = new LazyUauthMergeUser(option.conn, option.schemaName);
		
		enforceCodUser.addPostAction(authenticateUpswd);	
		enforceCodUser.addPostAction(mergeUser);
		
		actions.add(enforceCodUser);		
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
