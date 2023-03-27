package br.com.mind5.paymentPartner.partnerPagarme.customerPagarme.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;
import br.com.mind5.paymentPartner.partnerPagarme.customerPagarme.info.CustopaInfo;
import br.com.mind5.paymentPartner.partnerPagarme.customerPagarme.model.action.CustopaVisiEnforceAuthorization;
import br.com.mind5.paymentPartner.partnerPagarme.customerPagarme.model.action.CustopaVisiMergeSetupar;
import br.com.mind5.paymentPartner.partnerPagarme.customerPagarme.model.checker.CustopaCheckSetupar;

public final class CustopaNodeSetuparL2 extends DeciTreeTemplateWrite<CustopaInfo> {
	
	public CustopaNodeSetuparL2(DeciTreeOption<CustopaInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<CustopaInfo> buildCheckerHook(DeciTreeOption<CustopaInfo> option) {
		List<ModelChecker<CustopaInfo>> queue = new ArrayList<>();		
		ModelChecker<CustopaInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new CustopaCheckSetupar(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<CustopaInfo>> buildActionsOnPassedHook(DeciTreeOption<CustopaInfo> option) {
		List<ActionStd<CustopaInfo>> actions = new ArrayList<>();
		
		ActionStd <CustopaInfo> mergeSetupar         = new ActionStdCommom <CustopaInfo>(option, CustopaVisiMergeSetupar.class);
		ActionLazy<CustopaInfo> enforceAuthorization = new ActionLazyCommom<CustopaInfo>(option, CustopaVisiEnforceAuthorization.class);
		
		mergeSetupar.addPostAction(enforceAuthorization);
		
		actions.add(mergeSetupar);
		return actions;
	}
}
