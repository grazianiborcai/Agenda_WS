package br.com.gda.business.feeStore.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.feeStore.info.FeetoreInfo;
import br.com.gda.business.feeStore.model.action.LazyFeetoreRootSelect;
import br.com.gda.business.feeStore.model.action.StdFeetoreEnforceCategServ;
import br.com.gda.business.feeStore.model.checker.FeeStoreCheckReadService;
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

public final class RootFeetoreSelectService implements DeciTree<FeetoreInfo> {
	private DeciTree<FeetoreInfo> tree;
	
	
	public RootFeetoreSelectService(DeciTreeOption<FeetoreInfo> option) {
		DeciTreeHelperOption<FeetoreInfo> helperOption = new DeciTreeHelperOption<>();
		
		helperOption.visitorChecker = buildDecisionChecker(option);
		helperOption.recordInfos = option.recordInfos;
		helperOption.conn = option.conn;
		helperOption.actionsOnPassed = buildActionsOnPassed(option);
		
		tree = new DeciTreeHelper<>(helperOption);
	}
	
	
	
	private ModelChecker<FeetoreInfo> buildDecisionChecker(DeciTreeOption<FeetoreInfo> option) {		
		List<ModelChecker<FeetoreInfo>> queue = new ArrayList<>();		
		ModelChecker<FeetoreInfo> checker;
		
		checker = new FeeStoreCheckReadService();
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	private List<ActionStd<FeetoreInfo>> buildActionsOnPassed(DeciTreeOption<FeetoreInfo> option) {
		List<ActionStd<FeetoreInfo>> actions = new ArrayList<>();
		
		ActionStd<FeetoreInfo> enforceCateg = new StdFeetoreEnforceCategServ(option);
		ActionLazy<FeetoreInfo> select = new LazyFeetoreRootSelect(option.conn, option.schemaName);
		
		enforceCateg.addPostAction(select);		
		
		actions.add(enforceCateg);
		return actions;
	}
	
	
	
	@Override public void makeDecision() {
		tree.makeDecision();
	}
		

	
	@Override public DeciChoice getDecisionMade() {
		return tree.getDecisionMade();
	}
	
	
	
	@Override public DeciResult<FeetoreInfo> getDecisionResult() {
		return tree.getDecisionResult();
	}
	
	
	
	@Override public ActionStd<FeetoreInfo> toAction() {
		return tree.toAction();
	}
}
