package br.com.mind5.paymentPartner.partnerPagarme.orderSplitPagarme.model.decisionTree;

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
import br.com.mind5.paymentPartner.partnerPagarme.orderSplitPagarme.info.SplitapaInfo;
import br.com.mind5.paymentPartner.partnerPagarme.orderSplitPagarme.model.action.SplitapaVisiEnforcePaypar;
import br.com.mind5.paymentPartner.partnerPagarme.orderSplitPagarme.model.action.SplitapaVisiNodeSetuparL2;

public final class SplitapaNodeSetuparL1 extends DeciTreeTemplateWrite<SplitapaInfo> {
	
	public SplitapaNodeSetuparL1(DeciTreeOption<SplitapaInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<SplitapaInfo> buildCheckerHook(DeciTreeOption<SplitapaInfo> option) {
		List<ModelChecker<SplitapaInfo>> queue = new ArrayList<>();		
		ModelChecker<SplitapaInfo> checker;	

		checker = new ModelCheckerDummy<>();
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<SplitapaInfo>> buildActionsOnPassedHook(DeciTreeOption<SplitapaInfo> option) {
		List<ActionStd<SplitapaInfo>> actions = new ArrayList<>();
		
		ActionStd<SplitapaInfo> enforcePaypar = new ActionStdCommom<SplitapaInfo>(option, SplitapaVisiEnforcePaypar.class);
		ActionLazy<SplitapaInfo> nodeL2 = new ActionLazyCommom<SplitapaInfo>(option, SplitapaVisiNodeSetuparL2.class);
		
		enforcePaypar.addPostAction(nodeL2);
		
		actions.add(enforcePaypar);
		return actions;
	}
}
