package br.com.gda.business.masterData.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.masterData.info.CurrencyInfo;
import br.com.gda.business.masterData.model.action.StdCurrencySelect;
import br.com.gda.business.masterData.model.checker.CurrencyCheckRead;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerQueue;
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
		List<ModelChecker<CurrencyInfo>> queue = new ArrayList<>();		
		ModelChecker<CurrencyInfo> checker;
		
		checker = new CurrencyCheckRead();
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	private List<ActionStd<CurrencyInfo>> buildActionsOnPassed(DeciTreeOption<CurrencyInfo> option) {
		List<ActionStd<CurrencyInfo>> actions = new ArrayList<>();
		
		actions.add(new StdCurrencySelect(option));
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
	
	
	
	@Override public ActionStd<CurrencyInfo> toAction() {
		return tree.toAction();
	}
}
