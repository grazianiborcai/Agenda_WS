package br.com.gda.business.feeDefault.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.feeDefault.info.FeedefInfo;
import br.com.gda.business.feeDefault.model.action.LazyFeedefSelect;
import br.com.gda.business.feeDefault.model.action.StdFeedefEnforceCategServ;
import br.com.gda.business.feeDefault.model.checker.FeedefCheckReadService;
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

public final class RootFeedefSelectService implements DeciTree<FeedefInfo> {
	private DeciTree<FeedefInfo> tree;
	
	
	public RootFeedefSelectService(DeciTreeOption<FeedefInfo> option) {
		DeciTreeHelperOption<FeedefInfo> helperOption = new DeciTreeHelperOption<>();
		
		helperOption.visitorChecker = buildDecisionChecker(option);
		helperOption.recordInfos = option.recordInfos;
		helperOption.conn = option.conn;
		helperOption.actionsOnPassed = buildActionsOnPassed(option);
		
		tree = new DeciTreeHelper<>(helperOption);
	}
	
	
	
	private ModelChecker<FeedefInfo> buildDecisionChecker(DeciTreeOption<FeedefInfo> option) {		
		List<ModelChecker<FeedefInfo>> queue = new ArrayList<>();		
		ModelChecker<FeedefInfo> checker;
		
		checker = new FeedefCheckReadService();
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	private List<ActionStd<FeedefInfo>> buildActionsOnPassed(DeciTreeOption<FeedefInfo> option) {
		List<ActionStd<FeedefInfo>> actions = new ArrayList<>();
		
		ActionStd<FeedefInfo> enforceCateg = new StdFeedefEnforceCategServ(option);
		ActionLazy<FeedefInfo> mergeMat = new LazyFeedefSelect(option.conn, option.schemaName);
		
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
	
	
	
	@Override public DeciResult<FeedefInfo> getDecisionResult() {
		return tree.getDecisionResult();
	}
	
	
	
	@Override public ActionStd<FeedefInfo> toAction() {
		return tree.toAction();
	}
}
