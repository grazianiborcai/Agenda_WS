package br.com.gda.payment.payOrderMoip.model.decsionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.model.decisionTree.DeciTreeWriteTemplate;
import br.com.gda.payment.payOrderMoip.info.PayordmoipInfo;
import br.com.gda.payment.payOrderMoip.model.action.LazyPayordmoipEnforceAmount;
import br.com.gda.payment.payOrderMoip.model.action.LazyPayordmoipEnforceProducts;
import br.com.gda.payment.payOrderMoip.model.action.StdPayordmoipEnforceSubtotals;
import br.com.gda.payment.payOrderMoip.model.checker.PayordmoipCheckPlace;

public final class RootPayormoipdPlace extends DeciTreeWriteTemplate<PayordmoipInfo> {
	
	public RootPayormoipdPlace(DeciTreeOption<PayordmoipInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<PayordmoipInfo> buildDecisionCheckerHook(DeciTreeOption<PayordmoipInfo> option) {		
		List<ModelChecker<PayordmoipInfo>> queue = new ArrayList<>();		
		ModelChecker<PayordmoipInfo> checker;	
		
		checker = new PayordmoipCheckPlace();
		queue.add(checker);

		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<PayordmoipInfo>> buildActionsOnPassedHook(DeciTreeOption<PayordmoipInfo> option) {
		List<ActionStd<PayordmoipInfo>> actions = new ArrayList<>();		

		ActionStd<PayordmoipInfo> enforceSubtotals = new StdPayordmoipEnforceSubtotals(option);	
		ActionLazy<PayordmoipInfo> enforceAmount = new LazyPayordmoipEnforceAmount(option.conn, option.schemaName);
		ActionLazy<PayordmoipInfo> enforceProducts = new LazyPayordmoipEnforceProducts(option.conn, option.schemaName);
		
		enforceSubtotals.addPostAction(enforceAmount);
		enforceAmount.addPostAction(enforceProducts);
		
		actions.add(enforceSubtotals);		
		return actions;
	}
}
