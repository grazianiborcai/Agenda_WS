package br.com.mind5.paymentPartner.partnerMoip.orderMoip.model.decsionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.common.ModelCheckerDummy;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;
import br.com.mind5.paymentPartner.partnerMoip.orderMoip.info.OrdmoipInfo;
import br.com.mind5.paymentPartner.partnerMoip.orderMoip.model.action.LazyOrdmoipNodePayordistL2;
import br.com.mind5.paymentPartner.partnerMoip.orderMoip.model.action.StdOrdmoipMergePayordist;

public final class NodeOrdmoipPayordistL1 extends DeciTreeTemplateWrite<OrdmoipInfo> {
	
	public NodeOrdmoipPayordistL1(DeciTreeOption<OrdmoipInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<OrdmoipInfo> buildCheckerHook(DeciTreeOption<OrdmoipInfo> option) {
		List<ModelChecker<OrdmoipInfo>> queue = new ArrayList<>();		
		ModelChecker<OrdmoipInfo> checker;	
	
		checker = new ModelCheckerDummy<>();
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<OrdmoipInfo>> buildActionsOnPassedHook(DeciTreeOption<OrdmoipInfo> option) {
		List<ActionStd<OrdmoipInfo>> actions = new ArrayList<>();	
		
		ActionStd<OrdmoipInfo> mergePayordist = new StdOrdmoipMergePayordist(option);	
		ActionLazy<OrdmoipInfo> nodeL2 = new LazyOrdmoipNodePayordistL2(option.conn, option.schemaName);
		
		mergePayordist.addPostAction(nodeL2);
		
		actions.add(mergePayordist);		
		return actions;
	}
}
