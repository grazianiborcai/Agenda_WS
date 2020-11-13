package br.com.mind5.paymentPartner.partnerMoip.multiPayMoip.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.common.ModelCheckerDummy;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;
import br.com.mind5.paymentPartner.partnerMoip.multiPayMoip.info.PaymoipInfo;
import br.com.mind5.paymentPartner.partnerMoip.multiPayMoip.model.action.LazyPaymoipNodeSetuparL2;
import br.com.mind5.paymentPartner.partnerMoip.multiPayMoip.model.action.StdPaymoipMergeSetupar;

public final class NodePaymoipSetuparL1 extends DeciTreeTemplateWrite<PaymoipInfo> {
	
	public NodePaymoipSetuparL1(DeciTreeOption<PaymoipInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<PaymoipInfo> buildCheckerHook(DeciTreeOption<PaymoipInfo> option) {	
		List<ModelChecker<PaymoipInfo>> queue = new ArrayList<>();		
		ModelChecker<PaymoipInfo> checker;

		checker = new ModelCheckerDummy<>();
		queue.add(checker);

		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<PaymoipInfo>> buildActionsOnPassedHook(DeciTreeOption<PaymoipInfo> option) {
		List<ActionStd<PaymoipInfo>> actions = new ArrayList<>();	
		
		ActionStd<PaymoipInfo> mergeSetupar = new StdPaymoipMergeSetupar(option);
		ActionLazy<PaymoipInfo> nodeL2 = new LazyPaymoipNodeSetuparL2(option.conn, option.schemaName);
		
		mergeSetupar.addPostAction(nodeL2);
		
		actions.add(mergeSetupar);		
		return actions;
	}
}
