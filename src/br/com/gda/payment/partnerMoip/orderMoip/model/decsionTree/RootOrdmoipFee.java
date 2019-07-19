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
import br.com.gda.payment.partnerMoip.orderMoip.model.action.LazyOrdmoipEnforceCustomer;
import br.com.gda.payment.partnerMoip.orderMoip.model.action.LazyOrdmoipEnforceFeeAccount;
import br.com.gda.payment.partnerMoip.orderMoip.model.action.LazyOrdmoipEnforceFeeAmount;
import br.com.gda.payment.partnerMoip.orderMoip.model.action.LazyOrdmoipEnforceFees;
import br.com.gda.payment.partnerMoip.orderMoip.model.action.LazyOrdmoipEnforceOrder;
import br.com.gda.payment.partnerMoip.orderMoip.model.action.LazyOrdmoipEnforceOrderId;
import br.com.gda.payment.partnerMoip.orderMoip.model.action.LazyOrdmoipEnforceReceivers;
import br.com.gda.payment.partnerMoip.orderMoip.model.action.StdOrdmoipEnforceSubtotal;
import br.com.gda.payment.partnerMoip.orderMoip.model.checker.OrdmoipCheckSyspar;
import br.com.gda.payment.partnerMoip.orderMoip.model.checker.OrdmoipCheckSysparData;
import br.com.gda.payment.partnerMoip.orderMoip.model.checker.OrdmoipCheckWriteFee;

public final class RootOrdmoipFee extends DeciTreeWriteTemplate<OrdmoipInfo> {
	
	public RootOrdmoipFee(DeciTreeOption<OrdmoipInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<OrdmoipInfo> buildDecisionCheckerHook(DeciTreeOption<OrdmoipInfo> option) {		
		final boolean EXIST_ON_DB = true;
		
		List<ModelChecker<OrdmoipInfo>> queue = new ArrayList<>();		
		ModelChecker<OrdmoipInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checker = new OrdmoipCheckWriteFee();
		queue.add(checker);
		
		checker = new OrdmoipCheckSysparData();
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;	
		checker = new OrdmoipCheckSyspar(checkerOption);
		queue.add(checker);

		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<OrdmoipInfo>> buildActionsOnPassedHook(DeciTreeOption<OrdmoipInfo> option) {
		List<ActionStd<OrdmoipInfo>> actions = new ArrayList<>();		

		ActionStd<OrdmoipInfo> enforceSubtotal = new StdOrdmoipEnforceSubtotal(option);	
		ActionLazy<OrdmoipInfo> enforceFeeAmount = new LazyOrdmoipEnforceFeeAmount(option.conn, option.schemaName);
		ActionLazy<OrdmoipInfo> enforceFees = new LazyOrdmoipEnforceFees(option.conn, option.schemaName);
		ActionLazy<OrdmoipInfo> enforceFeeAccount = new LazyOrdmoipEnforceFeeAccount(option.conn, option.schemaName);
		ActionLazy<OrdmoipInfo> enforceReceivers = new LazyOrdmoipEnforceReceivers(option.conn, option.schemaName);
		ActionLazy<OrdmoipInfo> enforceCustomer = new LazyOrdmoipEnforceCustomer(option.conn, option.schemaName);
		ActionLazy<OrdmoipInfo> enforceOrderId = new LazyOrdmoipEnforceOrderId(option.conn, option.schemaName);
		ActionLazy<OrdmoipInfo> enforceOrder = new LazyOrdmoipEnforceOrder(option.conn, option.schemaName);
		
		enforceSubtotal.addPostAction(enforceFeeAmount);
		enforceFeeAmount.addPostAction(enforceFees);
		enforceFees.addPostAction(enforceFeeAccount);
		enforceFeeAccount.addPostAction(enforceReceivers);
		enforceReceivers.addPostAction(enforceCustomer);		
		enforceCustomer.addPostAction(enforceOrderId);
		enforceOrderId.addPostAction(enforceOrder);
		
		actions.add(enforceSubtotal);		
		return actions;
	}
}
