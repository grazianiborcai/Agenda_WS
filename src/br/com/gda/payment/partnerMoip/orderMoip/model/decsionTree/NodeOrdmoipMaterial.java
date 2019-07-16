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
import br.com.gda.payment.partnerMoip.orderMoip.model.action.LazyOrdmoipEnforceStoreAccount;
import br.com.gda.payment.partnerMoip.orderMoip.model.action.StdOrdmoipEnforceSubtotal;
import br.com.gda.payment.partnerMoip.orderMoip.model.action.LazyOrdmoipEnforceMatAmount;
import br.com.gda.payment.partnerMoip.orderMoip.model.action.LazyOrdmoipEnforceOrder;
import br.com.gda.payment.partnerMoip.orderMoip.model.action.LazyOrdmoipEnforceOrderId;
import br.com.gda.payment.partnerMoip.orderMoip.model.action.LazyOrdmoipEnforceMaterials;
import br.com.gda.payment.partnerMoip.orderMoip.model.action.LazyOrdmoipEnforceReceivers;
import br.com.gda.payment.partnerMoip.orderMoip.model.checker.OrdmoipCheckStoparData;

public final class NodeOrdmoipMaterial extends DeciTreeWriteTemplate<OrdmoipInfo> {
	
	public NodeOrdmoipMaterial(DeciTreeOption<OrdmoipInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<OrdmoipInfo> buildDecisionCheckerHook(DeciTreeOption<OrdmoipInfo> option) {
		List<ModelChecker<OrdmoipInfo>> queue = new ArrayList<>();		
		ModelChecker<OrdmoipInfo> checker;	
		
		checker = new OrdmoipCheckStoparData();
		queue.add(checker);

		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<OrdmoipInfo>> buildActionsOnPassedHook(DeciTreeOption<OrdmoipInfo> option) {
		List<ActionStd<OrdmoipInfo>> actions = new ArrayList<>();		

		ActionStd<OrdmoipInfo> enforceSubtotal = new StdOrdmoipEnforceSubtotal(option);	
		ActionLazy<OrdmoipInfo> enforceMatAmount = new LazyOrdmoipEnforceMatAmount(option.conn, option.schemaName);
		ActionLazy<OrdmoipInfo> enforceMaterials = new LazyOrdmoipEnforceMaterials(option.conn, option.schemaName);
		ActionLazy<OrdmoipInfo> enforceStoreAccount = new LazyOrdmoipEnforceStoreAccount(option.conn, option.schemaName);
		ActionLazy<OrdmoipInfo> enforceReceivers = new LazyOrdmoipEnforceReceivers(option.conn, option.schemaName);
		ActionLazy<OrdmoipInfo> enforceOrderId = new LazyOrdmoipEnforceOrderId(option.conn, option.schemaName);
		ActionLazy<OrdmoipInfo> enforceOrder = new LazyOrdmoipEnforceOrder(option.conn, option.schemaName);
		
		enforceSubtotal.addPostAction(enforceMatAmount);
		enforceMatAmount.addPostAction(enforceMaterials);
		enforceMaterials.addPostAction(enforceStoreAccount);
		enforceStoreAccount.addPostAction(enforceReceivers);
		enforceReceivers.addPostAction(enforceOrderId);
		enforceOrderId.addPostAction(enforceOrder);
		
		actions.add(enforceSubtotal);		
		return actions;
	}
}
