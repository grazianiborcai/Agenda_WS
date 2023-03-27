package br.com.mind5.paymentPartner.partnerPagarme.customerPagarme.model.decisionTree;

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
import br.com.mind5.paymentPartner.partnerPagarme.customerPagarme.info.CustopaInfo;
import br.com.mind5.paymentPartner.partnerPagarme.customerPagarme.model.action.CustopaVisiEnforcePaypar;
import br.com.mind5.paymentPartner.partnerPagarme.customerPagarme.model.action.CustopaVisiNodeSetuparL2;

public final class CustopaNodeSetuparL1 extends DeciTreeTemplateWrite<CustopaInfo> {
	
	public CustopaNodeSetuparL1(DeciTreeOption<CustopaInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<CustopaInfo> buildCheckerHook(DeciTreeOption<CustopaInfo> option) {
		List<ModelChecker<CustopaInfo>> queue = new ArrayList<>();		
		ModelChecker<CustopaInfo> checker;	

		checker = new ModelCheckerDummy<>();
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<CustopaInfo>> buildActionsOnPassedHook(DeciTreeOption<CustopaInfo> option) {
		List<ActionStd<CustopaInfo>> actions = new ArrayList<>();
		
		ActionStd <CustopaInfo> enforcePaypar = new ActionStdCommom <CustopaInfo>(option, CustopaVisiEnforcePaypar.class);
		ActionLazy<CustopaInfo> nodeL2        = new ActionLazyCommom<CustopaInfo>(option, CustopaVisiNodeSetuparL2.class);
		
		enforcePaypar.addPostAction(nodeL2);
		
		actions.add(enforcePaypar);
		return actions;
	}
}
