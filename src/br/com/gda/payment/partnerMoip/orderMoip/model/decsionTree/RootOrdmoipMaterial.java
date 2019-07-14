package br.com.gda.payment.partnerMoip.orderMoip.model.decsionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.model.decisionTree.DeciTreeWriteTemplate;
import br.com.gda.payment.partnerMoip.orderMoip.info.OrdmoipInfo;
import br.com.gda.payment.partnerMoip.orderMoip.model.action.LazyOrdmoipEnforceStoreAccount;
import br.com.gda.payment.partnerMoip.orderMoip.model.action.LazyOrdmoipEnforceMatAmount;
import br.com.gda.payment.partnerMoip.orderMoip.model.action.LazyOrdmoipEnforceOrder;
import br.com.gda.payment.partnerMoip.orderMoip.model.action.LazyOrdmoipEnforceOrderId;
import br.com.gda.payment.partnerMoip.orderMoip.model.action.LazyOrdmoipEnforceMaterials;
import br.com.gda.payment.partnerMoip.orderMoip.model.action.LazyOrdmoipEnforceReceivers;
import br.com.gda.payment.partnerMoip.orderMoip.model.action.StdOrdmoipEnforceSubtotal;
import br.com.gda.payment.partnerMoip.orderMoip.model.checker.OrdmoipCheckCuspar;
import br.com.gda.payment.partnerMoip.orderMoip.model.checker.OrdmoipCheckCusparData;
import br.com.gda.payment.partnerMoip.orderMoip.model.checker.OrdmoipCheckMatData;
import br.com.gda.payment.partnerMoip.orderMoip.model.checker.OrdmoipCheckPayordemData;
import br.com.gda.payment.partnerMoip.orderMoip.model.checker.OrdmoipCheckStopar;
import br.com.gda.payment.partnerMoip.orderMoip.model.checker.OrdmoipCheckStoparData;

public final class RootOrdmoipMaterial extends DeciTreeWriteTemplate<OrdmoipInfo> {
	
	public RootOrdmoipMaterial(DeciTreeOption<OrdmoipInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<OrdmoipInfo> buildDecisionCheckerHook(DeciTreeOption<OrdmoipInfo> option) {		
		final boolean EXIST_ON_DB = true;
		
		List<ModelChecker<OrdmoipInfo>> queue = new ArrayList<>();		
		ModelChecker<OrdmoipInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checker = new OrdmoipCheckMatData();
		queue.add(checker);
		
		checker = new OrdmoipCheckPayordemData();
		queue.add(checker);
		
		checker = new OrdmoipCheckCusparData();
		queue.add(checker);
		
		checker = new OrdmoipCheckStoparData();
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;	
		checker = new OrdmoipCheckStopar(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;	
		checker = new OrdmoipCheckCuspar(checkerOption);
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
