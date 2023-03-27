package br.com.mind5.paymentPartner.partnerPagarme.creditCardPagarme.model.decisionTree;

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
import br.com.mind5.paymentPartner.partnerPagarme.creditCardPagarme.info.CrecapaInfo;
import br.com.mind5.paymentPartner.partnerPagarme.creditCardPagarme.model.action.CrecapaVisiEnforcePaypar;
import br.com.mind5.paymentPartner.partnerPagarme.creditCardPagarme.model.action.CrecapaVisiNodeSetuparL2;

public final class CrecapaNodeSetuparL1 extends DeciTreeTemplateWrite<CrecapaInfo> {
	
	public CrecapaNodeSetuparL1(DeciTreeOption<CrecapaInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<CrecapaInfo> buildCheckerHook(DeciTreeOption<CrecapaInfo> option) {
		List<ModelChecker<CrecapaInfo>> queue = new ArrayList<>();		
		ModelChecker<CrecapaInfo> checker;	

		checker = new ModelCheckerDummy<>();
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<CrecapaInfo>> buildActionsOnPassedHook(DeciTreeOption<CrecapaInfo> option) {
		List<ActionStd<CrecapaInfo>> actions = new ArrayList<>();
		
		ActionStd <CrecapaInfo> enforcePaypar = new ActionStdCommom <CrecapaInfo>(option, CrecapaVisiEnforcePaypar.class);
		ActionLazy<CrecapaInfo> nodeL2        = new ActionLazyCommom<CrecapaInfo>(option, CrecapaVisiNodeSetuparL2.class);
		
		enforcePaypar.addPostAction(nodeL2);
		
		actions.add(enforcePaypar);
		return actions;
	}
}
