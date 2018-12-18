package br.com.gda.business.feeStore.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.feeStore.info.FeeStoreInfo;
import br.com.gda.business.feeStore.model.action.LazyFeeStoreSelect;
import br.com.gda.business.feeStore.model.action.StdFeeStoreEnforceCategServ;
import br.com.gda.business.feeStore.model.checker.FeeStoreCheckReadCateg;
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

public final class RootFeeStoreSelectService implements DeciTree<FeeStoreInfo> {
	private DeciTree<FeeStoreInfo> tree;
	
	
	public RootFeeStoreSelectService(DeciTreeOption<FeeStoreInfo> option) {
		DeciTreeHelperOption<FeeStoreInfo> helperOption = new DeciTreeHelperOption<>();
		
		helperOption.visitorChecker = buildDecisionChecker(option);
		helperOption.recordInfos = option.recordInfos;
		helperOption.conn = option.conn;
		helperOption.actionsOnPassed = buildActionsOnPassed(option);
		
		tree = new DeciTreeHelper<>(helperOption);
	}
	
	
	
	private ModelChecker<FeeStoreInfo> buildDecisionChecker(DeciTreeOption<FeeStoreInfo> option) {		
		List<ModelChecker<FeeStoreInfo>> queue = new ArrayList<>();		
		ModelChecker<FeeStoreInfo> checker;
		
		checker = new FeeStoreCheckReadCateg();
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	private List<ActionStd<FeeStoreInfo>> buildActionsOnPassed(DeciTreeOption<FeeStoreInfo> option) {
		List<ActionStd<FeeStoreInfo>> actions = new ArrayList<>();
		
		ActionStd<FeeStoreInfo> enforceCateg = new StdFeeStoreEnforceCategServ(option);
		ActionLazy<FeeStoreInfo> mergeMat = new LazyFeeStoreSelect(option.conn, option.schemaName);
		
		enforceCateg.addPostAction(mergeMat);		
		
		actions.add(enforceCateg);
		return actions;
	}
	
	
	
	@Override public void makeDecision() {
		tree.makeDecision();
	}
		

	
	@Override public DeciChoice getDecisionMade() {
		return tree.getDecisionMade();
	}
	
	
	
	@Override public DeciResult<FeeStoreInfo> getDecisionResult() {
		return tree.getDecisionResult();
	}
	
	
	
	@Override public ActionStd<FeeStoreInfo> toAction() {
		return tree.toAction();
	}
}
