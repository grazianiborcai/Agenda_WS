package br.com.mind5.paymentPartner.partnerPagarme.orderPagarme.model.decisionTree;

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
import br.com.mind5.paymentPartner.partnerPagarme.orderPagarme.info.OrdapaInfo;
import br.com.mind5.paymentPartner.partnerPagarme.orderPagarme.model.action.OrdapaVisiEnforceCode;
import br.com.mind5.paymentPartner.partnerPagarme.orderPagarme.model.action.OrdapaVisiEnforceCustomerId;
import br.com.mind5.paymentPartner.partnerPagarme.orderPagarme.model.action.OrdapaVisiEnforceItems;
import br.com.mind5.paymentPartner.partnerPagarme.orderPagarme.model.action.OrdapaVisiEnforcePayments;
import br.com.mind5.paymentPartner.partnerPagarme.orderPagarme.model.action.OrdapaVisiMergePayord;
import br.com.mind5.paymentPartner.partnerPagarme.orderPagarme.model.action.OrdapaVisiNodeCreate;
import br.com.mind5.paymentPartner.partnerPagarme.orderPagarme.model.checker.OrdapaCheckCreate;
import br.com.mind5.paymentPartner.partnerPagarme.orderPagarme.model.checker.OrdapaCheckPayord;
import br.com.mind5.paymentPartner.partnerPagarme.orderPagarme.model.checker.OrdapaCheckPayordem;

public final class OrdapaRootCreate extends DeciTreeTemplateWrite<OrdapaInfo> {
	
	public OrdapaRootCreate(DeciTreeOption<OrdapaInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<OrdapaInfo> buildCheckerHook(DeciTreeOption<OrdapaInfo> option) {
		List<ModelChecker<OrdapaInfo>> queue = new ArrayList<>();		
		ModelChecker<OrdapaInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new OrdapaCheckCreate(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new OrdapaCheckPayord(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new OrdapaCheckPayordem(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<OrdapaInfo>> buildActionsOnPassedHook(DeciTreeOption<OrdapaInfo> option) {
		List<ActionStd<OrdapaInfo>> actions = new ArrayList<>();
		
		ActionStd<OrdapaInfo>  nodeSetupar 	   = new OrdapaNodeSetuparL1(option).toAction();
		ActionLazy<OrdapaInfo> mergePayord     = new ActionLazyCommom<OrdapaInfo>(option, OrdapaVisiMergePayord.class);
		ActionLazy<OrdapaInfo> enforceCode 	   = new ActionLazyCommom<OrdapaInfo>(option, OrdapaVisiEnforceCode.class);
		ActionLazy<OrdapaInfo> enforceCustomer = new ActionLazyCommom<OrdapaInfo>(option, OrdapaVisiEnforceCustomerId.class);
		ActionLazy<OrdapaInfo> enforceItems    = new ActionLazyCommom<OrdapaInfo>(option, OrdapaVisiEnforceItems.class);
		ActionLazy<OrdapaInfo> enforcePayments = new ActionLazyCommom<OrdapaInfo>(option, OrdapaVisiEnforcePayments.class);
		ActionLazy<OrdapaInfo> nodeL1 		   = new ActionLazyCommom<OrdapaInfo>(option, OrdapaVisiNodeCreate.class);
		
		nodeSetupar.addPostAction(mergePayord);
		mergePayord.addPostAction(enforceCode);
		enforceCode.addPostAction(enforceCustomer);
		enforceCustomer.addPostAction(enforceItems);
		enforceItems.addPostAction(enforcePayments);
		enforcePayments.addPostAction(nodeL1);
		
		actions.add(nodeSetupar);
		return actions;
	}
}
