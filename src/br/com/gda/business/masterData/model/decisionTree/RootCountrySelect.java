package br.com.gda.business.masterData.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.masterData.info.CountryInfo;
import br.com.gda.business.masterData.model.checker.CountryCheckRead;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciChoice;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTree;
import br.com.gda.model.decisionTree.DeciTreeHelper;
import br.com.gda.model.decisionTree.DeciTreeHelperOption;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class RootCountrySelect implements DeciTree<CountryInfo> {
	private DeciTree<CountryInfo> tree;
	
	
	public RootCountrySelect(DeciTreeOption<CountryInfo> option) {
		DeciTreeHelperOption<CountryInfo> helperOption = new DeciTreeHelperOption<>();
		
		helperOption.visitorChecker = buildDecisionChecker();
		helperOption.recordInfos = option.recordInfos;
		helperOption.conn = option.conn;
		helperOption.actionsOnPassed = buildActionsOnPassed(option);
		
		tree = new DeciTreeHelper<>(helperOption);
	}
	
	
	
	private ModelChecker<CountryInfo> buildDecisionChecker() {
		List<ModelChecker<CountryInfo>> queue = new ArrayList<>();		
		ModelChecker<CountryInfo> checker;
		
		checker = new CountryCheckRead();
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	private List<ActionStd<CountryInfo>> buildActionsOnPassed(DeciTreeOption<CountryInfo> option) {
		List<ActionStd<CountryInfo>> actions = new ArrayList<>();
		
		actions.add(new ActionCountrySelect(option));
		return actions;
	}
	
	
	
	@Override public void makeDecision() {
		tree.makeDecision();
	}
		

	
	@Override public DeciChoice getDecisionMade() {
		return tree.getDecisionMade();
	}
	
	
	
	@Override public DeciResult<CountryInfo> getDecisionResult() {
		return tree.getDecisionResult();
	}
	
	
	
	@Override public ActionStd<CountryInfo> toAction() {
		return tree.toAction();
	}
}
