package br.com.mind5.paymentPartner.partnerMoip.orderMoip.model.decsionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeWriteTemplate;
import br.com.mind5.paymentPartner.partnerMoip.orderMoip.info.OrdmoipInfo;
import br.com.mind5.paymentPartner.partnerMoip.orderMoip.model.checker.OrdmoipCheckDummy;
import br.com.mind5.paymentPartner.partnerMoip.orderMoip.model.action.LazyOrdmoipMergeSetupar;
import br.com.mind5.paymentPartner.partnerMoip.orderMoip.model.action.LazyOrdmoipNodeSetuparL2;
import br.com.mind5.paymentPartner.partnerMoip.orderMoip.model.action.StdOrdmoipEnforcePaypar;

public final class NodeOrdmoipSetuparL1 extends DeciTreeWriteTemplate<OrdmoipInfo> {
	
	public NodeOrdmoipSetuparL1(DeciTreeOption<OrdmoipInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<OrdmoipInfo> buildDecisionCheckerHook(DeciTreeOption<OrdmoipInfo> option) {
		List<ModelChecker<OrdmoipInfo>> queue = new ArrayList<>();		
		ModelChecker<OrdmoipInfo> checker;	
	
		checker = new OrdmoipCheckDummy();
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<OrdmoipInfo>> buildActionsOnPassedHook(DeciTreeOption<OrdmoipInfo> option) {
		List<ActionStd<OrdmoipInfo>> actions = new ArrayList<>();	
		
		ActionStd<OrdmoipInfo> enforcePaypar = new StdOrdmoipEnforcePaypar(option);
		ActionLazy<OrdmoipInfo> mergeSetupar = new LazyOrdmoipMergeSetupar(option.conn, option.schemaName);	
		ActionLazy<OrdmoipInfo> nodeL2 = new LazyOrdmoipNodeSetuparL2(option.conn, option.schemaName);
		
		enforcePaypar.addPostAction(mergeSetupar);
		mergeSetupar.addPostAction(nodeL2);
		
		actions.add(enforcePaypar);		
		return actions;
	}
}
