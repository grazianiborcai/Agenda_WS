package br.com.gda.security.storeAuthorization.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciChoice;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTree;
import br.com.gda.model.decisionTree.DeciTreeHelper;
import br.com.gda.model.decisionTree.DeciTreeHelperOption;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.security.storeAuthorization.info.StorauthInfo;
import br.com.gda.security.storeAuthorization.model.action.LazyStorauthMergeUsername;
import br.com.gda.security.storeAuthorization.model.action.StdStorauthMergeOwntore;
import br.com.gda.security.storeAuthorization.model.checker.StorauthCheckOwntore;

public final class NodeStorauthSelectL2 implements DeciTree<StorauthInfo> {
	private DeciTree<StorauthInfo> tree;
	
	
	public NodeStorauthSelectL2(DeciTreeOption<StorauthInfo> option) {
		DeciTreeHelperOption<StorauthInfo> helperOption = new DeciTreeHelperOption<>();
		
		helperOption.visitorChecker = buildDecisionChecker(option);
		helperOption.recordInfos = option.recordInfos;
		helperOption.conn = option.conn;
		helperOption.actionsOnPassed = buildActionsOnPassed(option);
		helperOption.actionsOnFailed = null;
		
		tree = new DeciTreeHelper<>(helperOption);
	}
	
	
	
	private ModelChecker<StorauthInfo> buildDecisionChecker(DeciTreeOption<StorauthInfo> option) {
		final boolean EXIST_ON_DB = true;
		
		List<ModelChecker<StorauthInfo>> queue = new ArrayList<>();		
		ModelChecker<StorauthInfo> checker;
		ModelCheckerOption checkerOption;	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;	
		checker = new StorauthCheckOwntore(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override public ActionStd<StorauthInfo> toAction() {
		return tree.toAction();
	}
	
	
	
	private List<ActionStd<StorauthInfo>> buildActionsOnPassed(DeciTreeOption<StorauthInfo> option) {
		List<ActionStd<StorauthInfo>> actions = new ArrayList<>();
		
		ActionStd<StorauthInfo> mergeOwntore = new StdStorauthMergeOwntore(option);	
		ActionLazy<StorauthInfo> mergeUsername = new LazyStorauthMergeUsername(option.conn, option.schemaName);
		
		mergeOwntore.addPostAction(mergeUsername);
			
		actions.add(mergeOwntore);		
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
