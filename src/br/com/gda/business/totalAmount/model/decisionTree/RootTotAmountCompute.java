package br.com.gda.business.totalAmount.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.totalAmount.info.TotAmountInfo;
import br.com.gda.business.totalAmount.model.action.StdTotAmountTwo;
import br.com.gda.business.totalAmount.model.checker.TotAmountCheckTwo;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciChoice;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTree;
import br.com.gda.model.decisionTree.DeciTreeHelper;
import br.com.gda.model.decisionTree.DeciTreeHelperOption;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class RootTotAmountCompute implements DeciTree<TotAmountInfo> {
	private DeciTree<TotAmountInfo> tree;
	
	
	public RootTotAmountCompute(DeciTreeOption<TotAmountInfo> option) {
		DeciTreeHelperOption<TotAmountInfo> helperOption = new DeciTreeHelperOption<>();
		
		helperOption.visitorChecker = buildDecisionChecker(option);
		helperOption.recordInfos = option.recordInfos;
		helperOption.conn = option.conn;
		helperOption.actionsOnPassed = buildActionsOnPassed(option);
		
		tree = new DeciTreeHelper<>(helperOption);
	}
	
	
	
	private ModelChecker<TotAmountInfo> buildDecisionChecker(DeciTreeOption<TotAmountInfo> option) {
		List<ModelChecker<TotAmountInfo>> queue = new ArrayList<>();		
		ModelChecker<TotAmountInfo> checker;	
		
		checker = new TotAmountCheckTwo();
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	private List<ActionStd<TotAmountInfo>> buildActionsOnPassed(DeciTreeOption<TotAmountInfo> option) {
		List<ActionStd<TotAmountInfo>> actions = new ArrayList<>();		
		
		ActionStd<TotAmountInfo> selectCart = new StdTotAmountTwo(option);			
		actions.add(selectCart);	
		
		return actions;
	}
	
	
	
	@Override public void makeDecision() {
		tree.makeDecision();
	}
		

	
	@Override public DeciChoice getDecisionMade() {
		return tree.getDecisionMade();
	}
	
	
	
	@Override public DeciResult<TotAmountInfo> getDecisionResult() {
		return tree.getDecisionResult();
	}
	
	
	
	@Override public ActionStd<TotAmountInfo> toAction() {
		return tree.toAction();
	}
}
