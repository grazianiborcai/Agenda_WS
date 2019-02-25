package br.com.gda.security.tokenAuthentication.model.decisionTree;

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
import br.com.gda.security.tokenAuthentication.info.TauthInfo;
import br.com.gda.security.tokenAuthentication.model.action.StdTauthMergeUsername;
import br.com.gda.security.tokenAuthentication.model.action.StdTauthValidateJwtoken;
import br.com.gda.security.tokenAuthentication.model.checker.TauthCheckRead;

public final class RootTauthToken implements DeciTree<TauthInfo> {
	private DeciTree<TauthInfo> tree;
	
	
	public RootTauthToken(DeciTreeOption<TauthInfo> option) {
		DeciTreeHelperOption<TauthInfo> helperOption = new DeciTreeHelperOption<>();
		
		helperOption.visitorChecker = buildDecisionChecker();
		helperOption.recordInfos = option.recordInfos;
		helperOption.conn = option.conn;
		helperOption.actionsOnPassed = buildActionsOnPassed(option);
		
		tree = new DeciTreeHelper<>(helperOption);
	}
	
	
	
	private ModelChecker<TauthInfo> buildDecisionChecker() {
		List<ModelChecker<TauthInfo>> queue = new ArrayList<>();		
		ModelChecker<TauthInfo> checker;
		
		checker = new TauthCheckRead();
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override public ActionStd<TauthInfo> toAction() {
		return tree.toAction();
	}
	
	
	
	private List<ActionStd<TauthInfo>> buildActionsOnPassed(DeciTreeOption<TauthInfo> option) {
		List<ActionStd<TauthInfo>> actions = new ArrayList<>();
		
		ActionStd<TauthInfo> validateToken = new StdTauthValidateJwtoken(option);
		ActionStd<TauthInfo> mergeUsername = new StdTauthMergeUsername(option);
		
		actions.add(validateToken);		
		actions.add(mergeUsername);	
		return actions;
	}
	
	
	
	@Override public void makeDecision() {
		tree.makeDecision();
	}
		

	
	@Override public DeciChoice getDecisionMade() {
		return tree.getDecisionMade();
	}
	
	
	
	@Override public DeciResult<TauthInfo> getDecisionResult() {
		return tree.getDecisionResult();
	}
}
