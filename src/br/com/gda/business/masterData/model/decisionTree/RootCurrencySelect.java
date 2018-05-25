package br.com.gda.business.masterData.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.masterData.info.CurrencyInfo;
import br.com.gda.business.masterData.model.checker.CurrencyCheckRead;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerStack;
import br.com.gda.model.decisionTree.DeciAction;
import br.com.gda.model.decisionTree.DeciChoice;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTree;
import br.com.gda.model.decisionTree.DeciTreeHelper;
import br.com.gda.model.decisionTree.DeciTreeHelperOption;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class RootCurrencySelect implements DeciTree<CurrencyInfo> {
	private DeciTree<CurrencyInfo> tree;
	
	
	public RootCurrencySelect(DeciTreeOption<CurrencyInfo> option) {
		DeciTreeHelperOption<CurrencyInfo> helperOption = new DeciTreeHelperOption<>();
		
		helperOption.visitorChecker = buildDecisionChecker();
		helperOption.recordInfos = option.recordInfos;
		helperOption.conn = option.conn;
		helperOption.actionsOnPassed = buildActionsOnPassed(option);
		
		tree = new DeciTreeHelper<>(helperOption);
	}
	
	
	
	private ModelChecker<CurrencyInfo> buildDecisionChecker() {
		List<ModelChecker<CurrencyInfo>> stack = new ArrayList<>();		
		ModelChecker<CurrencyInfo> checker;
		
		checker = new CurrencyCheckRead();
		stack.add(checker);
		
		return new ModelCheckerStack<>(stack);
	}
	
	
	
	private List<DeciAction<CurrencyInfo>> buildActionsOnPassed(DeciTreeOption<CurrencyInfo> option) {
		List<DeciAction<CurrencyInfo>> actions = new ArrayList<>();
		
		actions.add(new ActionCurrencySelect(option));
		return actions;
	}
	
	
	
	@Override public void makeDecision() {
		tree.makeDecision();
	}
		

	
	@Override public DeciChoice getDecisionMade() {
		return tree.getDecisionMade();
	}
	
	
	
	@Override public DeciResult<CurrencyInfo> getDecisionResult() {
		return tree.getDecisionResult();
	}
}
