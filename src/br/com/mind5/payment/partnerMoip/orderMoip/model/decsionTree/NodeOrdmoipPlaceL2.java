package br.com.mind5.payment.partnerMoip.orderMoip.model.decsionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeWriteTemplate;
import br.com.mind5.payment.partnerMoip.orderMoip.info.OrdmoipInfo;
import br.com.mind5.payment.partnerMoip.orderMoip.model.action.LazyOrdmoipEnforceAccount;
import br.com.mind5.payment.partnerMoip.orderMoip.model.action.LazyOrdmoipEnforceAmount;
import br.com.mind5.payment.partnerMoip.orderMoip.model.action.LazyOrdmoipEnforceCustomer;
import br.com.mind5.payment.partnerMoip.orderMoip.model.action.LazyOrdmoipEnforceOrder;
import br.com.mind5.payment.partnerMoip.orderMoip.model.action.LazyOrdmoipEnforceOwnId;
import br.com.mind5.payment.partnerMoip.orderMoip.model.action.LazyOrdmoipEnforceProducts;
import br.com.mind5.payment.partnerMoip.orderMoip.model.action.LazyOrdmoipEnforceReceivers;
import br.com.mind5.payment.partnerMoip.orderMoip.model.action.StdOrdmoipEnforceSubtotal;
import br.com.mind5.payment.partnerMoip.orderMoip.model.checker.OrdmoipCheckPlace;

public final class NodeOrdmoipPlaceL2 extends DeciTreeWriteTemplate<OrdmoipInfo> {
	
	public NodeOrdmoipPlaceL2(DeciTreeOption<OrdmoipInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<OrdmoipInfo> buildDecisionCheckerHook(DeciTreeOption<OrdmoipInfo> option) {	
		List<ModelChecker<OrdmoipInfo>> queue = new ArrayList<>();		
		ModelChecker<OrdmoipInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new OrdmoipCheckPlace(checkerOption);
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
