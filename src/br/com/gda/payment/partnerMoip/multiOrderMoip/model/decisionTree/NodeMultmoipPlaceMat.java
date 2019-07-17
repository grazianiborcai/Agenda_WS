package br.com.gda.payment.partnerMoip.multiOrderMoip.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.model.decisionTree.DeciTreeWriteTemplate;
import br.com.gda.payment.partnerMoip.multiOrderMoip.info.MultmoipInfo;
import br.com.gda.payment.partnerMoip.multiOrderMoip.model.checker.MultmoipCheckPlaceMat;

public final class NodeMultmoipPlaceMat extends DeciTreeWriteTemplate<MultmoipInfo> {
	
	public NodeMultmoipPlaceMat(DeciTreeOption<MultmoipInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<MultmoipInfo> buildDecisionCheckerHook(DeciTreeOption<MultmoipInfo> option) {	
		List<ModelChecker<MultmoipInfo>> queue = new ArrayList<>();		
		ModelChecker<MultmoipInfo> checker;
		
		checker = new MultmoipCheckPlaceMat();
		queue.add(checker);

		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<MultmoipInfo>> buildActionsOnPassedHook(DeciTreeOption<MultmoipInfo> option) {
		List<ActionStd<MultmoipInfo>> actions = new ArrayList<>();	
		
		ActionStd<MultmoipInfo> enforceSubtotal = new StdOrdmoipEnforceSubtotal(option);	
		ActionLazy<MultmoipInfo> enforceMatAmount = new LazyOrdmoipEnforceMatAmount(option.conn, option.schemaName);
		ActionLazy<MultmoipInfo> enforceMaterials = new LazyOrdmoipEnforceMaterials(option.conn, option.schemaName);
		ActionLazy<MultmoipInfo> enforceStoreAccount = new LazyOrdmoipEnforceStoreAccount(option.conn, option.schemaName);
		ActionLazy<MultmoipInfo> enforceReceivers = new LazyOrdmoipEnforceReceivers(option.conn, option.schemaName);
		ActionLazy<MultmoipInfo> enforceOrderId = new LazyOrdmoipEnforceOrderId(option.conn, option.schemaName);
		ActionLazy<MultmoipInfo> enforceOrder = new LazyOrdmoipEnforceOrder(option.conn, option.schemaName);
		
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
