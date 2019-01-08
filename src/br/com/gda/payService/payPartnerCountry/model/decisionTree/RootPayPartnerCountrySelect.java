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
import br.com.gda.payService.payPartnerCountry.info.PayPartnerCountryInfo;
import br.com.gda.payService.payPartnerCountry.model.action.LazyPayPartnerCountryMergePayPartner;
import br.com.gda.payService.payPartnerCountry.model.action.StdPayPartnerCountrySelect;
import br.com.gda.payService.payPartnerCountry.model.checker.PayPartnerCountryCheckCountry;
import br.com.gda.payService.payPartnerCountry.model.checker.PayPartnerCountryCheckRead;

public final class RootPayPartnerCountrySelect implements DeciTree<PayPartnerCountryInfo> {
	private DeciTree<PayPartnerCountryInfo> tree;
	
	
	public RootPayPartnerCountrySelect(DeciTreeOption<PayPartnerCountryInfo> option) {
		DeciTreeHelperOption<PayPartnerCountryInfo> helperOption = new DeciTreeHelperOption<>();
		
		helperOption.visitorChecker = buildDecisionChecker(option);
		helperOption.recordInfos = option.recordInfos;
		helperOption.conn = option.conn;
		helperOption.actionsOnPassed = buildActionsOnPassed(option);
		
		tree = new DeciTreeHelper<>(helperOption);
	}
	
	
	
	private ModelChecker<PayPartnerCountryInfo> buildDecisionChecker(DeciTreeOption<PayPartnerCountryInfo> option) {
		final boolean EXIST_ON_DB = true;
		
		List<ModelChecker<PayPartnerCountryInfo>> queue = new ArrayList<>();		
		ModelChecker<PayPartnerCountryInfo> checker;
		ModelCheckerOption checkerOption;
		
		checker = new PayPartnerCountryCheckRead();
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;		
		checker = new PayPartnerCountryCheckCountry(checkerOption);
		queue.add(checker);	
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	private List<ActionStd<PayPartnerCountryInfo>> buildActionsOnPassed(DeciTreeOption<PayPartnerCountryInfo> option) {
		List<ActionStd<PayPartnerCountryInfo>> actions = new ArrayList<>();
		
		ActionStd<PayPartnerCountryInfo> select = new StdPayPartnerCountrySelect(option);
		ActionLazy<PayPartnerCountryInfo> mergePayPartner = new LazyPayPartnerCountryMergePayPartner(option.conn, option.schemaName);
		
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
	
	
	
	@Override public DeciResult<PayPartnerCountryInfo> getDecisionResult() {
		return tree.getDecisionResult();
	}
	
	
	
	@Override public ActionStd<PayPartnerCountryInfo> toAction() {
		return tree.toAction();
	}
}
