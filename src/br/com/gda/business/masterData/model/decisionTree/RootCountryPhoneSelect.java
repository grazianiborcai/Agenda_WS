package br.com.gda.business.masterData.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.masterData.info.CountryPhoneInfo;
import br.com.gda.business.masterData.model.action.StdCountryPhoneSelect;
import br.com.gda.business.masterData.model.checker.CountryPhoneCheckRead;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciChoice;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTree;
import br.com.gda.model.decisionTree.DeciTreeHelper;
import br.com.gda.model.decisionTree.DeciTreeHelperOption;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class RootCountryPhoneSelect implements DeciTree<CountryPhoneInfo> {
	private DeciTree<CountryPhoneInfo> tree;
	
	
	public RootCountryPhoneSelect(DeciTreeOption<CountryPhoneInfo> option) {
		DeciTreeHelperOption<CountryPhoneInfo> helperOption = new DeciTreeHelperOption<>();
		
		helperOption.visitorChecker = buildDecisionChecker();
		helperOption.recordInfos = option.recordInfos;
		helperOption.conn = option.conn;
		helperOption.actionsOnPassed = buildActionsOnPassed(option);
		
		tree = new DeciTreeHelper<>(helperOption);
	}
	
	
	
	private ModelChecker<CountryPhoneInfo> buildDecisionChecker() {
		List<ModelChecker<CountryPhoneInfo>> queue = new ArrayList<>();		
		ModelChecker<CountryPhoneInfo> checker;
		
		checker = new CountryPhoneCheckRead();
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	private List<ActionStd<CountryPhoneInfo>> buildActionsOnPassed(DeciTreeOption<CountryPhoneInfo> option) {
		List<ActionStd<CountryPhoneInfo>> actions = new ArrayList<>();
		
		actions.add(new StdCountryPhoneSelect(option));
		return actions;
	}
	
	
	
	@Override public void makeDecision() {
		tree.makeDecision();
	}
		

	
	@Override public DeciChoice getDecisionMade() {
		return tree.getDecisionMade();
	}
	
	
	
	@Override public DeciResult<CountryPhoneInfo> getDecisionResult() {
		return tree.getDecisionResult();
	}
	
	
	
	@Override public ActionStd<CountryPhoneInfo> toAction() {
		return tree.toAction();
	}
}
