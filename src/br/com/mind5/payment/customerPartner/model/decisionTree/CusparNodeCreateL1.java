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
import br.com.mind5.payment.customerPartner.model.action.CusparVisiEnforceCompoundId;
import br.com.mind5.payment.customerPartner.model.action.CusparVisiRootInsert;
import br.com.mind5.payment.customerPartner.model.checker.CusparCheckIsPagarme;

public final class CusparNodeCreateL1 extends DeciTreeTemplateWrite<CusparInfo> {
	
	public CusparNodeCreateL1(DeciTreeOption<CusparInfo> option) {
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
		
		ActionStd<CusparInfo> insert = new ActionStdCommom<CusparInfo>(option, CusparVisiRootInsert.class);
		ActionLazy<CusparInfo> enforceCompoundId = new ActionLazyCommom<CusparInfo>(option, CusparVisiEnforceCompoundId.class);
		ActionLazy<CusparInfo> createCustopa = new ActionLazyCommom<CusparInfo>(option, CusparVisiCustopaCreate.class);
		ActionLazy<CusparInfo> update = new ActionLazyCommom<CusparInfo>(option, CusparVisiDaoUpdate.class);
		
		insert.addPostAction(enforceCompoundId);
		enforceCompoundId.addPostAction(createCustopa);
		createCustopa.addPostAction(update);
		
		actions.add(insert);
		return actions;
	}
	
	
	
	@Override protected List<ActionStd<CusparInfo>> buildActionsOnFailedHook(DeciTreeOption<CusparInfo> option) {
		List<ActionStd<CusparInfo>> actions = new ArrayList<>();		

		ActionStd<CusparInfo> nodeL2 = new CusparNodeCreateL2(option).toAction();	
		
		actions.add(nodeL2);		
		return actions;
	}
}
