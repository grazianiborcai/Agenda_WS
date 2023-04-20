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
import br.com.mind5.paymentPartner.partnerPagarme.customerPagarme.model.action.CustopaVisiMergeCuspar;
import br.com.mind5.paymentPartner.partnerPagarme.customerPagarme.model.action.CustopaVisiMergeUser;
import br.com.mind5.paymentPartner.partnerPagarme.customerPagarme.model.action.CustopaVisiRootCreate;
import br.com.mind5.paymentPartner.partnerPagarme.customerPagarme.model.checker.CustopaCheckCreateFromCuspar;
import br.com.mind5.paymentPartner.partnerPagarme.customerPagarme.model.checker.CustopaCheckCuspar;

public final class CustopaRootCreateFromCuspar extends DeciTreeTemplateWrite<CustopaInfo> {
	
	public CustopaRootCreateFromCuspar(DeciTreeOption<CustopaInfo> option) {
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
		checker = new CustopaCheckCreateFromCuspar(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new CustopaCheckCuspar(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<CustopaInfo>> buildActionsOnPassedHook(DeciTreeOption<CustopaInfo> option) {
		List<ActionStd<CustopaInfo>> actions = new ArrayList<>();
		
		ActionStd <CustopaInfo> mergeCuspar = new ActionStdCommom <CustopaInfo>(option, CustopaVisiMergeCuspar.class);
		ActionLazy<CustopaInfo> mergeUser   = new ActionLazyCommom<CustopaInfo>(option, CustopaVisiMergeUser.class);
		ActionLazy<CustopaInfo> create      = new ActionLazyCommom<CustopaInfo>(option, CustopaVisiRootCreate.class);
		
		mergeCuspar.addPostAction(mergeUser);
		mergeUser.addPostAction(create);
		
		actions.add(mergeCuspar);
		return actions;
	}
}
