package br.com.mind5.paymentPartner.partnerMoip.customerMoip.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeWriteTemplate;
import br.com.mind5.paymentPartner.partnerMoip.customerMoip.info.CusmoipInfo;
import br.com.mind5.paymentPartner.partnerMoip.customerMoip.model.action.LazyCusmoipNodeUserL2;
import br.com.mind5.paymentPartner.partnerMoip.customerMoip.model.action.StdCusmoipMergeUserap;
import br.com.mind5.paymentPartner.partnerMoip.customerMoip.model.checker.CusmoipCheckDummy;

public final class NodeCusmoipUserL1 extends DeciTreeWriteTemplate<CusmoipInfo> {
	
	public NodeCusmoipUserL1(DeciTreeOption<CusmoipInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<CusmoipInfo> buildDecisionCheckerHook(DeciTreeOption<CusmoipInfo> option) {
		List<ModelChecker<CusmoipInfo>> queue = new ArrayList<>();		
		ModelChecker<CusmoipInfo> checker;	

		checker = new CusmoipCheckDummy();
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<CusmoipInfo>> buildActionsOnPassedHook(DeciTreeOption<CusmoipInfo> option) {
		List<ActionStdV1<CusmoipInfo>> actions = new ArrayList<>();
		
		ActionStdV1<CusmoipInfo> mergeUserap = new StdCusmoipMergeUserap(option);
		ActionLazyV1<CusmoipInfo> nodeL2 = new LazyCusmoipNodeUserL2(option.conn, option.schemaName);
		
		mergeUserap.addPostAction(nodeL2);
		
		actions.add(mergeUserap);
		return actions;
	}
}
