package br.com.mind5.paymentPartner.partnerMoip.creditCardMoip.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.common.ModelCheckerDummy;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWriteV2;
import br.com.mind5.paymentPartner.partnerMoip.creditCardMoip.info.CremoipInfo;
import br.com.mind5.paymentPartner.partnerMoip.creditCardMoip.model.action.LazyCremoipNodeAddressL2;
import br.com.mind5.paymentPartner.partnerMoip.creditCardMoip.model.action.StdCremoipMergeAddresnap;

public final class NodeCremoipAddressL1 extends DeciTreeTemplateWriteV2<CremoipInfo> {
	
	public NodeCremoipAddressL1(DeciTreeOption<CremoipInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<CremoipInfo> buildCheckerHook(DeciTreeOption<CremoipInfo> option) {
		List<ModelCheckerV1<CremoipInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<CremoipInfo> checker;	

		checker = new ModelCheckerDummy<>();
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<CremoipInfo>> buildActionsOnPassedHook(DeciTreeOption<CremoipInfo> option) {
		List<ActionStdV1<CremoipInfo>> actions = new ArrayList<>();
		
		ActionStdV1<CremoipInfo> mergeAddresnap = new StdCremoipMergeAddresnap(option);
		ActionLazyV1<CremoipInfo> nodeL2 = new LazyCremoipNodeAddressL2(option.conn, option.schemaName);
		
		mergeAddresnap.addPostAction(nodeL2);
		
		actions.add(mergeAddresnap);
		return actions;
	}
}
