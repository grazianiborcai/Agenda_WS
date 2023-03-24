package br.com.mind5.payment.customerPartner.model.decisionTree;

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
import br.com.mind5.payment.customerPartner.info.CusparInfo;
import br.com.mind5.payment.customerPartner.model.action.CusparVisiCustopaCreate;
import br.com.mind5.payment.customerPartner.model.action.CusparVisiDaoUpdate;
import br.com.mind5.payment.customerPartner.model.checker.CusparCheckIsPagarme;

public final class CusparNodeUpdateL1 extends DeciTreeTemplateWrite<CusparInfo> {
	
	public CusparNodeUpdateL1(DeciTreeOption<CusparInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<CusparInfo> buildCheckerHook(DeciTreeOption<CusparInfo> option) {		
		List<ModelChecker<CusparInfo>> queue = new ArrayList<>();		
		ModelChecker<CusparInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new CusparCheckIsPagarme(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<CusparInfo>> buildActionsOnPassedHook(DeciTreeOption<CusparInfo> option) {
		List<ActionStd<CusparInfo>> actions = new ArrayList<>();
		
		ActionStd <CusparInfo> createCustopa = new ActionStdCommom <CusparInfo>(option, CusparVisiCustopaCreate.class);
		ActionLazy<CusparInfo> update        = new ActionLazyCommom<CusparInfo>(option, CusparVisiDaoUpdate.class);
		
		createCustopa.addPostAction(update);
		
		actions.add(createCustopa);
		return actions;
	}
	
	
	
	@Override protected List<ActionStd<CusparInfo>> buildActionsOnFailedHook(DeciTreeOption<CusparInfo> option) {
		List<ActionStd<CusparInfo>> actions = new ArrayList<>();		

		ActionStd<CusparInfo> nodeL2 = new CusparNodeCreateL2(option).toAction();	
		
		actions.add(nodeL2);		
		return actions;
	}
}
