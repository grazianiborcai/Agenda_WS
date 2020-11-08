package br.com.mind5.paymentPartner.partnerMoip.multiPayMoip.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.common.ModelCheckerDummy;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWriteV2;
import br.com.mind5.paymentPartner.partnerMoip.multiPayMoip.info.PaymoipInfo;
import br.com.mind5.paymentPartner.partnerMoip.multiPayMoip.model.action.LazyPaymoipNodeSetuparL2;
import br.com.mind5.paymentPartner.partnerMoip.multiPayMoip.model.action.StdPaymoipMergeSetupar;

public final class NodePaymoipSetuparL1 extends DeciTreeTemplateWriteV2<PaymoipInfo> {
	
	public NodePaymoipSetuparL1(DeciTreeOption<PaymoipInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<PaymoipInfo> buildCheckerHook(DeciTreeOption<PaymoipInfo> option) {	
		List<ModelCheckerV1<PaymoipInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<PaymoipInfo> checker;

		checker = new ModelCheckerDummy<>();
		queue.add(checker);

		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<PaymoipInfo>> buildActionsOnPassedHook(DeciTreeOption<PaymoipInfo> option) {
		List<ActionStdV1<PaymoipInfo>> actions = new ArrayList<>();	
		
		ActionStdV1<PaymoipInfo> mergeSetupar = new StdPaymoipMergeSetupar(option);
		ActionLazyV1<PaymoipInfo> nodeL2 = new LazyPaymoipNodeSetuparL2(option.conn, option.schemaName);
		
		mergeSetupar.addPostAction(nodeL2);
		
		actions.add(mergeSetupar);		
		return actions;
	}
}
