package br.com.mind5.paymentPartner.partnerMoip.multiPayMoip.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.common.ModelCheckerDummy;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWriteV2;
import br.com.mind5.paymentPartner.partnerMoip.multiPayMoip.info.PaymoipInfo;
import br.com.mind5.paymentPartner.partnerMoip.multiPayMoip.model.action.LazyPaymoipNodeSysparL2;
import br.com.mind5.paymentPartner.partnerMoip.multiPayMoip.model.action.StdPaymoipMergeSyspar;

public final class NodePaymoipSysparL1 extends DeciTreeTemplateWriteV2<PaymoipInfo> {
	
	public NodePaymoipSysparL1(DeciTreeOption<PaymoipInfo> option) {
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
		
		ActionStdV1<PaymoipInfo> mergeSyspar = new StdPaymoipMergeSyspar(option);
		ActionLazy<PaymoipInfo> nodeL2 = new LazyPaymoipNodeSysparL2(option.conn, option.schemaName);
		
		mergeSyspar.addPostAction(nodeL2);
		
		actions.add(mergeSyspar);		
		return actions;
	}
}
