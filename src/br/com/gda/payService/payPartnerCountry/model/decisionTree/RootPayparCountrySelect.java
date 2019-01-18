package br.com.gda.payService.payPartnerCountry.model.decisionTree;

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
import br.com.gda.payService.payPartnerCountry.info.PayparCountryInfo;
import br.com.gda.payService.payPartnerCountry.model.action.LazyPayparCountryMergePaypar;
import br.com.gda.payService.payPartnerCountry.model.action.StdPayparCountrySelect;
import br.com.gda.payService.payPartnerCountry.model.checker.PayparCountryCheckCountry;
import br.com.gda.payService.payPartnerCountry.model.checker.PayparCountryCheckRead;

public final class RootPayparCountrySelect implements DeciTree<PayparCountryInfo> {
	private DeciTree<PayparCountryInfo> tree;
	
	
	public RootPayparCountrySelect(DeciTreeOption<PayparCountryInfo> option) {
		DeciTreeHelperOption<PayparCountryInfo> helperOption = new DeciTreeHelperOption<>();
		
		helperOption.visitorChecker = buildDecisionChecker(option);
		helperOption.recordInfos = option.recordInfos;
		helperOption.conn = option.conn;
		helperOption.actionsOnPassed = buildActionsOnPassed(option);
		
		tree = new DeciTreeHelper<>(helperOption);
	}
	
	
	
	private ModelChecker<PayparCountryInfo> buildDecisionChecker(DeciTreeOption<PayparCountryInfo> option) {
		final boolean EXIST_ON_DB = true;
		
		List<ModelChecker<PayparCountryInfo>> queue = new ArrayList<>();		
		ModelChecker<PayparCountryInfo> checker;
		ModelCheckerOption checkerOption;
		
		checker = new PayparCountryCheckRead();
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;		
		checker = new PayparCountryCheckCountry(checkerOption);
		queue.add(checker);	
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	private List<ActionStd<PayparCountryInfo>> buildActionsOnPassed(DeciTreeOption<PayparCountryInfo> option) {
		List<ActionStd<PayparCountryInfo>> actions = new ArrayList<>();
		
		ActionStd<PayparCountryInfo> select = new StdPayparCountrySelect(option);
		ActionLazy<PayparCountryInfo> mergePayPartner = new LazyPayparCountryMergePaypar(option.conn, option.schemaName);
		
		select.addPostAction(mergePayPartner);
		
		actions.add(select);
		return actions;
	}
	
	
	
	@Override public void makeDecision() {
		tree.makeDecision();
	}
		

	
	@Override public DeciChoice getDecisionMade() {
		return tree.getDecisionMade();
	}
	
	
	
	@Override public DeciResult<PayparCountryInfo> getDecisionResult() {
		return tree.getDecisionResult();
	}
	
	
	
	@Override public ActionStd<PayparCountryInfo> toAction() {
		return tree.toAction();
	}
}
