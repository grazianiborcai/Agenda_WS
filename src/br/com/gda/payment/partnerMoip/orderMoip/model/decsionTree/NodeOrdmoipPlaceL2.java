package br.com.gda.payment.partnerMoip.orderMoip.model.decsionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.model.decisionTree.DeciTreeWriteTemplate;
import br.com.gda.payment.partnerMoip.orderMoip.info.OrdmoipInfo;
import br.com.gda.payment.partnerMoip.orderMoip.model.action.LazyOrdmoipEnforceCustomer;
import br.com.gda.payment.partnerMoip.orderMoip.model.action.LazyOrdmoipEnforceProducts;
import br.com.gda.payment.partnerMoip.orderMoip.model.action.LazyOrdmoipEnforceAccount;
import br.com.gda.payment.partnerMoip.orderMoip.model.action.LazyOrdmoipEnforceAmount;
import br.com.gda.payment.partnerMoip.orderMoip.model.action.LazyOrdmoipEnforceOwnId;
import br.com.gda.payment.partnerMoip.orderMoip.model.action.LazyOrdmoipEnforceOrder;
import br.com.gda.payment.partnerMoip.orderMoip.model.action.LazyOrdmoipEnforceReceivers;
import br.com.gda.payment.partnerMoip.orderMoip.model.action.StdOrdmoipEnforceSubtotal;
import br.com.gda.payment.partnerMoip.orderMoip.model.checker.OrdmoipCheckPlace;

public final class NodeOrdmoipPlaceL2 extends DeciTreeWriteTemplate<OrdmoipInfo> {
	
	public NodeOrdmoipPlaceL2(DeciTreeOption<OrdmoipInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<OrdmoipInfo> buildDecisionCheckerHook(DeciTreeOption<OrdmoipInfo> option) {	
		List<ModelChecker<OrdmoipInfo>> queue = new ArrayList<>();		
		ModelChecker<OrdmoipInfo> checker;	
		
		checker = new OrdmoipCheckPlace();
		queue.add(checker);

		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<OrdmoipInfo>> buildActionsOnPassedHook(DeciTreeOption<OrdmoipInfo> option) {
		List<ActionStd<OrdmoipInfo>> actions = new ArrayList<>();		

		ActionStd<OrdmoipInfo> enforceSubtotal = new StdOrdmoipEnforceSubtotal(option);	
		ActionLazy<OrdmoipInfo> enforceAmount = new LazyOrdmoipEnforceAmount(option.conn, option.schemaName);
		ActionLazy<OrdmoipInfo> enforceProducts = new LazyOrdmoipEnforceProducts(option.conn, option.schemaName);
		ActionLazy<OrdmoipInfo> enforceAccount = new LazyOrdmoipEnforceAccount(option.conn, option.schemaName);
		ActionLazy<OrdmoipInfo> enforceReceivers = new LazyOrdmoipEnforceReceivers(option.conn, option.schemaName);
		ActionLazy<OrdmoipInfo> enforceCustomer = new LazyOrdmoipEnforceCustomer(option.conn, option.schemaName);
		ActionLazy<OrdmoipInfo> enforceOwnId = new LazyOrdmoipEnforceOwnId(option.conn, option.schemaName);
		ActionLazy<OrdmoipInfo> enforceOrder = new LazyOrdmoipEnforceOrder(option.conn, option.schemaName);
		
		enforceSubtotal.addPostAction(enforceAmount);
		enforceAmount.addPostAction(enforceProducts);
		enforceProducts.addPostAction(enforceAccount);
		enforceAccount.addPostAction(enforceReceivers);
		enforceReceivers.addPostAction(enforceCustomer);		
		enforceCustomer.addPostAction(enforceOwnId);
		enforceOwnId.addPostAction(enforceOrder);
		
		actions.add(enforceSubtotal);		
		return actions;
	}
}
