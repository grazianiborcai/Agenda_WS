package br.com.mind5.paymentPartner.partnerPagarme.customerPagarme.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;
import br.com.mind5.paymentPartner.partnerPagarme.customerPagarme.info.CustopaInfo;
import br.com.mind5.paymentPartner.partnerPagarme.customerPagarme.model.action.CustopaVisiCreate;
import br.com.mind5.paymentPartner.partnerPagarme.customerPagarme.model.action.CustopaVisiEnforceResponseAttr;
import br.com.mind5.paymentPartner.partnerPagarme.customerPagarme.model.checker.CustopaCheckCreate;

public final class CustopaRootCreate extends DeciTreeTemplateWrite<CustopaInfo> {
	
	public CustopaRootCreate(DeciTreeOption<CustopaInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<CustopaInfo> buildCheckerHook(DeciTreeOption<CustopaInfo> option) {
		List<ModelChecker<CustopaInfo>> queue = new ArrayList<>();		
		ModelChecker<CustopaInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new CustopaCheckCreate(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<CustopaInfo>> buildActionsOnPassedHook(DeciTreeOption<CustopaInfo> option) {
		List<ActionStd<CustopaInfo>> actions = new ArrayList<>();
		
		ActionStd <CustopaInfo> mergeSetupar        = new CustopaNodeSetuparL1(option).toAction();
		ActionLazy<CustopaInfo> create              = new ActionLazyCommom<CustopaInfo>(option, CustopaVisiCreate.class);
		ActionLazy<CustopaInfo> enforceResponseAttr = new ActionLazyCommom<CustopaInfo>(option, CustopaVisiEnforceResponseAttr.class);
		
		mergeSetupar.addPostAction(create);
		create.addPostAction(enforceResponseAttr);
		
		actions.add(mergeSetupar);
		return actions;
	}
}
