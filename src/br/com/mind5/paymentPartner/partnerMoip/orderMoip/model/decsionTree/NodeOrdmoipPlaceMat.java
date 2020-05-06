package br.com.mind5.paymentPartner.partnerMoip.orderMoip.model.decsionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.common.ModelCheckerDummy;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWriteV2;
import br.com.mind5.paymentPartner.partnerMoip.orderMoip.info.OrdmoipInfo;
import br.com.mind5.paymentPartner.partnerMoip.orderMoip.model.action.LazyOrdmoipEnforceReceiverStore;
import br.com.mind5.paymentPartner.partnerMoip.orderMoip.model.action.LazyOrdmoipNodePlaceL2;
import br.com.mind5.paymentPartner.partnerMoip.orderMoip.model.action.LazyOrdmoipNodeStoparL1;
import br.com.mind5.paymentPartner.partnerMoip.orderMoip.model.action.StdOrdmoipEnforceMatTxt;

public final class NodeOrdmoipPlaceMat extends DeciTreeTemplateWriteV2<OrdmoipInfo> {
	
	public NodeOrdmoipPlaceMat(DeciTreeOption<OrdmoipInfo> option) {
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
		
		ActionStdV1<OrdmoipInfo> enforceMatTxt = new StdOrdmoipEnforceMatTxt(option);	
		ActionLazyV1<OrdmoipInfo> nodeStopar = new LazyOrdmoipNodeStoparL1(option.conn, option.schemaName);
		ActionLazyV1<OrdmoipInfo> enforceReceiverStore = new LazyOrdmoipEnforceReceiverStore(option.conn, option.schemaName);
		ActionLazyV1<OrdmoipInfo> nodeL2 = new LazyOrdmoipNodePlaceL2(option.conn, option.schemaName);		
		
		enforceMatTxt.addPostAction(nodeStopar);
		nodeStopar.addPostAction(enforceReceiverStore);
		enforceReceiverStore.addPostAction(nodeL2);
		
		actions.add(enforceMatTxt);		
		return actions;
	}
}
