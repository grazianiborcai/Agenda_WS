package br.com.mind5.paymentPartner.partnerMoip.multiOrderMoip.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateReadV1;
import br.com.mind5.paymentPartner.partnerMoip.multiOrderMoip.info.MultmoipInfo;
import br.com.mind5.paymentPartner.partnerMoip.multiOrderMoip.model.action.LazyMultmoipOrdmoipPlace;
import br.com.mind5.paymentPartner.partnerMoip.multiOrderMoip.model.action.StdMultmoipMergePayordemist;
import br.com.mind5.paymentPartner.partnerMoip.multiOrderMoip.model.checker.MultmoipCheckDummy;

public final class NodeMultmoipOrdmoip extends DeciTreeTemplateReadV1<MultmoipInfo> {
	
	public NodeMultmoipOrdmoip(DeciTreeOption<MultmoipInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<MultmoipInfo> buildCheckerHook(DeciTreeOption<MultmoipInfo> option) {	
		List<ModelCheckerV1<MultmoipInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<MultmoipInfo> checker;

		checker = new MultmoipCheckDummy();
		queue.add(checker);

		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<MultmoipInfo>> buildActionsOnPassedHook(DeciTreeOption<MultmoipInfo> option) {
		List<ActionStdV1<MultmoipInfo>> actions = new ArrayList<>();	
		
		ActionStdV1<MultmoipInfo> mergePayordemist = new StdMultmoipMergePayordemist(option);
		ActionLazyV1<MultmoipInfo> placeOrdmoip = new LazyMultmoipOrdmoipPlace(option.conn, option.schemaName);
		
		mergePayordemist.addPostAction(placeOrdmoip);
		
		actions.add(mergePayordemist);		
		return actions;
	}
}
