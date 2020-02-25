package br.com.mind5.paymentPartner.partnerMoip.multiOrderMoip.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeReadTemplate;
import br.com.mind5.paymentPartner.partnerMoip.multiOrderMoip.info.MultmoipInfo;
import br.com.mind5.paymentPartner.partnerMoip.multiOrderMoip.model.action.LazyMultmoipOrdmoipPlace;
import br.com.mind5.paymentPartner.partnerMoip.multiOrderMoip.model.action.StdMultmoipMergePayordemist;
import br.com.mind5.paymentPartner.partnerMoip.multiOrderMoip.model.checker.MultmoipCheckDummy;

public final class NodeMultmoipOrdmoip extends DeciTreeReadTemplate<MultmoipInfo> {
	
	public NodeMultmoipOrdmoip(DeciTreeOption<MultmoipInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<MultmoipInfo> buildDecisionCheckerHook(DeciTreeOption<MultmoipInfo> option) {	
		List<ModelChecker<MultmoipInfo>> queue = new ArrayList<>();		
		ModelChecker<MultmoipInfo> checker;

		checker = new MultmoipCheckDummy();
		queue.add(checker);

		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<MultmoipInfo>> buildActionsOnPassedHook(DeciTreeOption<MultmoipInfo> option) {
		List<ActionStd<MultmoipInfo>> actions = new ArrayList<>();	
		
		ActionStd<MultmoipInfo> mergePayordemist = new StdMultmoipMergePayordemist(option);
		ActionLazy<MultmoipInfo> placeOrdmoip = new LazyMultmoipOrdmoipPlace(option.conn, option.schemaName);
		
		mergePayordemist.addPostAction(placeOrdmoip);
		
		actions.add(mergePayordemist);		
		return actions;
	}
}
