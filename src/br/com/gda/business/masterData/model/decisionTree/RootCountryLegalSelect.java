package br.com.gda.business.masterData.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.masterData.info.CountryLegalInfo;
import br.com.gda.business.masterData.model.action.LazyCountryLegalMergeCountry;
import br.com.gda.business.masterData.model.action.StdCountryLegalSelect;
import br.com.gda.business.masterData.model.checker.CountryLegalCheckRead;
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

public final class RootCountryLegalSelect implements DeciTree<CountryLegalInfo> {
	private DeciTree<CountryLegalInfo> tree;
	
	
	public RootCountryLegalSelect(DeciTreeOption<CountryLegalInfo> option) {
		DeciTreeHelperOption<CountryLegalInfo> helperOption = new DeciTreeHelperOption<>();
		
		helperOption.visitorChecker = buildDecisionChecker();
		helperOption.recordInfos = option.recordInfos;
		helperOption.conn = option.conn;
		helperOption.actionsOnPassed = buildActionsOnPassed(option);
		
		tree = new DeciTreeHelper<>(helperOption);
	}
	
	
	
	private ModelChecker<CountryLegalInfo> buildDecisionChecker() {
		List<ModelChecker<CountryLegalInfo>> queue = new ArrayList<>();		
		ModelChecker<CountryLegalInfo> checker;
		
		checker = new CountryLegalCheckRead();
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	private List<ActionStd<CountryLegalInfo>> buildActionsOnPassed(DeciTreeOption<CountryLegalInfo> option) {
		List<ActionStd<CountryLegalInfo>> actions = new ArrayList<>();
		
		ActionStd<CountryLegalInfo> select = new StdCountryLegalSelect(option);
		ActionLazy<CountryLegalInfo> mergeCountry = new LazyCountryLegalMergeCountry(option.conn, option.schemaName);
		
		select.addPostAction(mergeCountry);
		
		actions.add(select);
		return actions;
	}
	
	
	
	@Override public void makeDecision() {
		tree.makeDecision();
	}
		

	
	@Override public DeciChoice getDecisionMade() {
		return tree.getDecisionMade();
	}
	
	
	
	@Override public DeciResult<CountryLegalInfo> getDecisionResult() {
		return tree.getDecisionResult();
	}
	
	
	
	@Override public ActionStd<CountryLegalInfo> toAction() {
		return tree.toAction();
	}
}
