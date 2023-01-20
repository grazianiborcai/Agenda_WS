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
import br.com.mind5.paymentPartner.partnerPagarme.customerPagarme.model.action.CustopaVisiMergeCus;
import br.com.mind5.paymentPartner.partnerPagarme.customerPagarme.model.action.CustopaVisiRootCreate;
import br.com.mind5.paymentPartner.partnerPagarme.customerPagarme.model.checker.CustopaCheckCreateFromCus;
import br.com.mind5.paymentPartner.partnerPagarme.customerPagarme.model.checker.CustopaCheckCus;

public final class CustopaRootCreateFromCus extends DeciTreeTemplateWrite<CustopaInfo> {
	
	public CustopaRootCreateFromCus(DeciTreeOption<CustopaInfo> option) {
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
		checker = new CustopaCheckCreateFromCus(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new CustopaCheckCus(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<CustopaInfo>> buildActionsOnPassedHook(DeciTreeOption<CustopaInfo> option) {
		List<ActionStd<CustopaInfo>> actions = new ArrayList<>();
		
		ActionStd<CustopaInfo> mergeCus = new ActionStdCommom<CustopaInfo>(option, CustopaVisiMergeCus.class);
		ActionLazy<CustopaInfo> create = new ActionLazyCommom<CustopaInfo>(option, CustopaVisiRootCreate.class);
		
		mergeCus.addPostAction(create);
		
		actions.add(mergeCus);
		return actions;
	}
}
