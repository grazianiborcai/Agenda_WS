package br.com.mind5.paymentPartner.partnerMoip.multiPayMoip.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.common.ModelCheckerDummy;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;
import br.com.mind5.paymentPartner.partnerMoip.multiPayMoip.info.PaymoipInfo;
import br.com.mind5.paymentPartner.partnerMoip.multiPayMoip.model.action.PaymoipVisiNodeSysparL2;
import br.com.mind5.paymentPartner.partnerMoip.multiPayMoip.model.action.PaymoipVisiMergeSyspar;

public final class PaymoipNodeSysparL1 extends DeciTreeTemplateWrite<PaymoipInfo> {
	
	public PaymoipNodeSysparL1(DeciTreeOption<PaymoipInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<PaymoipInfo> buildCheckerHook(DeciTreeOption<PaymoipInfo> option) {	
		List<ModelChecker<PaymoipInfo>> queue = new ArrayList<>();		
		ModelChecker<PaymoipInfo> checker;

		checker = new ModelCheckerDummy<>();
		queue.add(checker);

		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<PaymoipInfo>> buildActionsOnPassedHook(DeciTreeOption<PaymoipInfo> option) {
		List<ActionStd<PaymoipInfo>> actions = new ArrayList<>();	
		
		ActionStd<PaymoipInfo> mergeSyspar = new ActionStdCommom<PaymoipInfo>(option, PaymoipVisiMergeSyspar.class);
		ActionLazy<PaymoipInfo> nodeL2 = new ActionLazyCommom<PaymoipInfo>(option, PaymoipVisiNodeSysparL2.class);
		
		mergeSyspar.addPostAction(nodeL2);
		
		actions.add(mergeSyspar);		
		return actions;
	}
}
