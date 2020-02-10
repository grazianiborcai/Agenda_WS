package br.com.mind5.payment.partnerMoip.customerMoip.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeWriteTemplate;
import br.com.mind5.payment.partnerMoip.customerMoip.info.CusmoipInfo;
import br.com.mind5.payment.partnerMoip.customerMoip.model.action.LazyCusmoipNodePhoneL2;
import br.com.mind5.payment.partnerMoip.customerMoip.model.action.StdCusmoipMergePhone;
import br.com.mind5.payment.partnerMoip.customerMoip.model.checker.CusmoipCheckDummy;

public final class NodeCusmoipPhoneL1 extends DeciTreeWriteTemplate<CusmoipInfo> {
	
	public NodeCusmoipPhoneL1(DeciTreeOption<CusmoipInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<CusmoipInfo> buildDecisionCheckerHook(DeciTreeOption<CusmoipInfo> option) {
		List<ModelChecker<CusmoipInfo>> queue = new ArrayList<>();		
		ModelChecker<CusmoipInfo> checker;	

		checker = new CusmoipCheckDummy();
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<CusmoipInfo>> buildActionsOnPassedHook(DeciTreeOption<CusmoipInfo> option) {
		List<ActionStd<CusmoipInfo>> actions = new ArrayList<>();
		
		ActionStd<CusmoipInfo> mergePhone = new StdCusmoipMergePhone(option);
		ActionLazy<CusmoipInfo> nodeL2 = new LazyCusmoipNodePhoneL2(option.conn, option.schemaName);
		
		mergePhone.addPostAction(nodeL2);
		
		actions.add(mergePhone);
		return actions;
	}
}
