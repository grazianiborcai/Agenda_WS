package br.com.mind5.paymentPartner.partnerMoip.customerMoip.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.common.ModelCheckerDummy;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWriteV2;
import br.com.mind5.paymentPartner.partnerMoip.customerMoip.info.CusmoipInfo;
import br.com.mind5.paymentPartner.partnerMoip.customerMoip.model.action.LazyCusmoipNodeUserL2;
import br.com.mind5.paymentPartner.partnerMoip.customerMoip.model.action.StdCusmoipMergeUserap;

public final class NodeCusmoipUserL1 extends DeciTreeTemplateWriteV2<CusmoipInfo> {
	
	public NodeCusmoipUserL1(DeciTreeOption<CusmoipInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<CusmoipInfo> buildCheckerHook(DeciTreeOption<CusmoipInfo> option) {
		List<ModelCheckerV1<CusmoipInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<CusmoipInfo> checker;	

		checker = new ModelCheckerDummy<>();
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV2<CusmoipInfo>> buildActionsOnPassedHook(DeciTreeOption<CusmoipInfo> option) {
		List<ActionStdV2<CusmoipInfo>> actions = new ArrayList<>();
		
		ActionStdV2<CusmoipInfo> mergeUserap = new StdCusmoipMergeUserap(option);
		ActionLazy<CusmoipInfo> nodeL2 = new LazyCusmoipNodeUserL2(option.conn, option.schemaName);
		
		mergeUserap.addPostAction(nodeL2);
		
		actions.add(mergeUserap);
		return actions;
	}
}
