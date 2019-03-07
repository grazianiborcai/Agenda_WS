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
import br.com.gda.security.storeAuthorization.model.action.LazyStorauthNodeSelectL2;
import br.com.gda.security.storeAuthorization.model.action.StdStorauthEnforceCategOwnerKey;
import br.com.gda.security.storeAuthorization.model.checker.StorauthCheckCategOwner;

public final class NodeStorauthSelectCategOwner implements DeciTree<StorauthInfo> {
	private DeciTree<StorauthInfo> tree;
	
	
	public NodeStorauthSelectCategOwner(DeciTreeOption<StorauthInfo> option) {
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
		
		checker = new StorauthCheckCategOwner();
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override public ActionStd<StorauthInfo> toAction() {
		return tree.toAction();
	}
	
	
	
	private List<ActionStd<StorauthInfo>> buildActionsOnPassed(DeciTreeOption<StorauthInfo> option) {
		List<ActionStd<StorauthInfo>> actions = new ArrayList<>();
		
		ActionStd<StorauthInfo> enforceCategOwnerKey = new StdStorauthEnforceCategOwnerKey(option);	
		ActionLazy<StorauthInfo> nodeSelectL2 = new LazyStorauthNodeSelectL2(option.conn, option.schemaName);
		
		enforceCategOwnerKey.addPostAction(nodeSelectL2);
			
		actions.add(enforceCategOwnerKey);		
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
