package br.com.mind5.paymentPartner.partnerMoip.orderMoip.model.decsionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.common.ModelCheckerDummy;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWriteV2;
import br.com.mind5.paymentPartner.partnerMoip.orderMoip.info.OrdmoipInfo;
import br.com.mind5.paymentPartner.partnerMoip.orderMoip.model.action.LazyOrdmoipEnforceAccount;
import br.com.mind5.paymentPartner.partnerMoip.orderMoip.model.action.LazyOrdmoipEnforceAmount;
import br.com.mind5.paymentPartner.partnerMoip.orderMoip.model.action.LazyOrdmoipEnforceCustomer;
import br.com.mind5.paymentPartner.partnerMoip.orderMoip.model.action.LazyOrdmoipEnforceOrder;
import br.com.mind5.paymentPartner.partnerMoip.orderMoip.model.action.LazyOrdmoipEnforceOwnId;
import br.com.mind5.paymentPartner.partnerMoip.orderMoip.model.action.LazyOrdmoipEnforceProducts;
import br.com.mind5.paymentPartner.partnerMoip.orderMoip.model.action.LazyOrdmoipEnforceReceivers;
import br.com.mind5.paymentPartner.partnerMoip.orderMoip.model.action.LazyOrdmoipEnforceSubtotal;
import br.com.mind5.paymentPartner.partnerMoip.orderMoip.model.action.StdOrdmoipEnforceItemNum;

public final class NodeOrdmoipPlaceL2 extends DeciTreeTemplateWriteV2<OrdmoipInfo> {
	
	public NodeOrdmoipPlaceL2(DeciTreeOption<OrdmoipInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<OrdmoipInfo> buildCheckerHook(DeciTreeOption<OrdmoipInfo> option) {	
		List<ModelCheckerV1<OrdmoipInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<OrdmoipInfo> checker;	

		checker = new ModelCheckerDummy<>();
		queue.add(checker);

		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<OrdmoipInfo>> buildActionsOnPassedHook(DeciTreeOption<OrdmoipInfo> option) {
		List<ActionStdV1<OrdmoipInfo>> actions = new ArrayList<>();		

		ActionStdV1<OrdmoipInfo> enforceItemNum = new StdOrdmoipEnforceItemNum(option);	
		ActionLazy<OrdmoipInfo> enforceSubtotal = new LazyOrdmoipEnforceSubtotal(option.conn, option.schemaName);	
		ActionLazy<OrdmoipInfo> enforceAmount = new LazyOrdmoipEnforceAmount(option.conn, option.schemaName);
		ActionLazy<OrdmoipInfo> enforceProducts = new LazyOrdmoipEnforceProducts(option.conn, option.schemaName);
		ActionLazy<OrdmoipInfo> enforceAccount = new LazyOrdmoipEnforceAccount(option.conn, option.schemaName);
		ActionLazy<OrdmoipInfo> enforceReceivers = new LazyOrdmoipEnforceReceivers(option.conn, option.schemaName);
		ActionLazy<OrdmoipInfo> enforceCustomer = new LazyOrdmoipEnforceCustomer(option.conn, option.schemaName);
		ActionLazy<OrdmoipInfo> enforceOwnId = new LazyOrdmoipEnforceOwnId(option.conn, option.schemaName);
		ActionLazy<OrdmoipInfo> enforceOrder = new LazyOrdmoipEnforceOrder(option.conn, option.schemaName);
		
		enforceItemNum.addPostAction(enforceSubtotal);
		enforceSubtotal.addPostAction(enforceAmount);
		enforceAmount.addPostAction(enforceProducts);
		enforceProducts.addPostAction(enforceAccount);
		enforceAccount.addPostAction(enforceReceivers);
		enforceReceivers.addPostAction(enforceCustomer);		
		enforceCustomer.addPostAction(enforceOwnId);
		enforceOwnId.addPostAction(enforceOrder);
		
		actions.add(enforceItemNum);		
		return actions;
	}
}
