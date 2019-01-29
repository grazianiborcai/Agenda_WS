package br.com.gda.security.userPassword.model.decisionTree;

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
import br.com.gda.security.userPassword.info.UpswdInfo;
import br.com.gda.security.userPassword.model.action.LazyUpswdEnforceHashToMatch;
import br.com.gda.security.userPassword.model.action.LazyUpswdNodeMatch;
import br.com.gda.security.userPassword.model.action.StdUpswdKeepUpswd;
import br.com.gda.security.userPassword.model.checker.UpswdCheckRead;

public final class RootUpswdAuth implements DeciTree<UpswdInfo> {
	private DeciTree<UpswdInfo> tree;
	
	
	public RootUpswdAuth(DeciTreeOption<UpswdInfo> option) {
		DeciTreeHelperOption<UpswdInfo> helperOption = new DeciTreeHelperOption<>();
		
		helperOption.visitorChecker = buildDecisionChecker();
		helperOption.recordInfos = option.recordInfos;
		helperOption.conn = option.conn;
		helperOption.actionsOnPassed = buildActionsOnPassed(option);
		
		tree = new DeciTreeHelper<>(helperOption);
	}
	
	
	
	private ModelChecker<UpswdInfo> buildDecisionChecker() {
		List<ModelChecker<UpswdInfo>> queue = new ArrayList<>();		
		ModelChecker<UpswdInfo> checker;
		
		checker = new UpswdCheckRead();
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override public ActionStd<UpswdInfo> toAction() {
		return tree.toAction();
	}
	
	
	
	private List<ActionStd<UpswdInfo>> buildActionsOnPassed(DeciTreeOption<UpswdInfo> option) {
		List<ActionStd<UpswdInfo>> actions = new ArrayList<>();
		
		ActionStd<UpswdInfo> select = new StdUpswdKeepUpswd(option);
		ActionLazy<UpswdInfo> enforceHashToMatch = new LazyUpswdEnforceHashToMatch(option.conn, option.schemaName);
		ActionLazy<UpswdInfo> nodeMatch = new LazyUpswdNodeMatch(option.conn, option.schemaName);
		
		select.addPostAction(enforceHashToMatch);		
		enforceHashToMatch.addPostAction(nodeMatch);
		
		actions.add(select);		
		return actions;
	}
	
	
	
	@Override public void makeDecision() {
		tree.makeDecision();
	}
		

	
	@Override public DeciChoice getDecisionMade() {
		return tree.getDecisionMade();
	}
	
	
	
	@Override public DeciResult<UpswdInfo> getDecisionResult() {
		return tree.getDecisionResult();
	}
}
