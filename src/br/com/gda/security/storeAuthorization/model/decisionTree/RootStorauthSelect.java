package br.com.gda.security.storeAuthorization.model.decisionTree;

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
import br.com.gda.security.storeAuthorization.info.StorauthInfo;
import br.com.gda.security.storeAuthorization.model.action.LazyStorauthNodeSelectL1;
import br.com.gda.security.storeAuthorization.model.action.StdStorauthMergeUsername;
import br.com.gda.security.storeAuthorization.model.checker.StorauthCheckRead;

public final class RootStorauthSelect implements DeciTree<StorauthInfo> {
	private DeciTree<StorauthInfo> tree;
	
	
	public RootStorauthSelect(DeciTreeOption<StorauthInfo> option) {
		DeciTreeHelperOption<StorauthInfo> helperOption = new DeciTreeHelperOption<>();
		
		helperOption.visitorChecker = buildDecisionChecker();
		helperOption.recordInfos = option.recordInfos;
		helperOption.conn = option.conn;
		helperOption.actionsOnPassed = buildActionsOnPassed(option);
		
		tree = new DeciTreeHelper<>(helperOption);
	}
	
	
	
	private ModelChecker<StorauthInfo> buildDecisionChecker() {
		List<ModelChecker<StorauthInfo>> queue = new ArrayList<>();		
		ModelChecker<StorauthInfo> checker;
		
		checker = new StorauthCheckRead();
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override public ActionStd<StorauthInfo> toAction() {
		return tree.toAction();
	}
	
	
	
	private List<ActionStd<StorauthInfo>> buildActionsOnPassed(DeciTreeOption<StorauthInfo> option) {
		List<ActionStd<StorauthInfo>> actions = new ArrayList<>();
		
		ActionStd<StorauthInfo> mergeUsername = new StdStorauthMergeUsername(option);	
		ActionLazy<StorauthInfo> nodeSelectL1 = new LazyStorauthNodeSelectL1(option.conn, option.schemaName);	
		
		mergeUsername.addPostAction(nodeSelectL1);
		
		actions.add(mergeUsername);		
		return actions;
	}
	
	
	
	@Override public void makeDecision() {
		tree.makeDecision();
	}
		

	
	@Override public DeciChoice getDecisionMade() {
		return tree.getDecisionMade();
	}
	
	
	
	@Override public DeciResult<StorauthInfo> getDecisionResult() {
		return tree.getDecisionResult();
	}
}
