package br.com.mind5.paymentPartner.partnerPagarme.recipientPagarme.model.decisionTree;

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
import br.com.mind5.paymentPartner.partnerPagarme.recipientPagarme.info.RecipaInfo;
import br.com.mind5.paymentPartner.partnerPagarme.recipientPagarme.model.action.RecipaVisiEnforcePaypar;
import br.com.mind5.paymentPartner.partnerPagarme.recipientPagarme.model.action.RecipaVisiNodeSetuparL2;

public final class RecipaNodeSetuparL1 extends DeciTreeTemplateWrite<RecipaInfo> {
	
	public RecipaNodeSetuparL1(DeciTreeOption<RecipaInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<RecipaInfo> buildCheckerHook(DeciTreeOption<RecipaInfo> option) {
		List<ModelChecker<RecipaInfo>> queue = new ArrayList<>();		
		ModelChecker<RecipaInfo> checker;	

		checker = new ModelCheckerDummy<>();
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<RecipaInfo>> buildActionsOnPassedHook(DeciTreeOption<RecipaInfo> option) {
		List<ActionStd<RecipaInfo>> actions = new ArrayList<>();
		
		ActionStd<RecipaInfo> enforcePaypar = new ActionStdCommom<RecipaInfo>(option, RecipaVisiEnforcePaypar.class);
		ActionLazy<RecipaInfo> nodeL2 = new ActionLazyCommom<RecipaInfo>(option, RecipaVisiNodeSetuparL2.class);
		
		enforcePaypar.addPostAction(nodeL2);
		
		actions.add(enforcePaypar);
		return actions;
	}
}
