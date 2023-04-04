package br.com.mind5.paymentPartner.partnerPagarme.orderSplitPagarme.model.decisionTree;

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
import br.com.mind5.paymentPartner.partnerPagarme.orderSplitPagarme.info.SplitapaInfo;
import br.com.mind5.paymentPartner.partnerPagarme.orderSplitPagarme.model.action.SplitapaVisiEnforceCode;
import br.com.mind5.paymentPartner.partnerPagarme.orderSplitPagarme.model.action.SplitapaVisiEnforceCredidCard;
import br.com.mind5.paymentPartner.partnerPagarme.orderSplitPagarme.model.action.SplitapaVisiEnforceCustomerId;
import br.com.mind5.paymentPartner.partnerPagarme.orderSplitPagarme.model.action.SplitapaVisiEnforceItems;
import br.com.mind5.paymentPartner.partnerPagarme.orderSplitPagarme.model.action.SplitapaVisiEnforceSplit;
import br.com.mind5.paymentPartner.partnerPagarme.orderSplitPagarme.model.action.SplitapaVisiMergePayord;
import br.com.mind5.paymentPartner.partnerPagarme.orderSplitPagarme.model.action.SplitapaVisiNodeCreate;
import br.com.mind5.paymentPartner.partnerPagarme.orderSplitPagarme.model.checker.SplitapaCheckCreate;
import br.com.mind5.paymentPartner.partnerPagarme.orderSplitPagarme.model.checker.SplitapaCheckPayord;

public final class SplitapaRootCreate extends DeciTreeTemplateWrite<SplitapaInfo> {
	
	public SplitapaRootCreate(DeciTreeOption<SplitapaInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<SplitapaInfo> buildCheckerHook(DeciTreeOption<SplitapaInfo> option) {
		List<ModelChecker<SplitapaInfo>> queue = new ArrayList<>();		
		ModelChecker<SplitapaInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new SplitapaCheckCreate(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new SplitapaCheckPayord(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<SplitapaInfo>> buildActionsOnPassedHook(DeciTreeOption<SplitapaInfo> option) {
		List<ActionStd<SplitapaInfo>> actions = new ArrayList<>();
		
		ActionStd<SplitapaInfo>  nodeSetupar 		 = new SplitapaNodeSetuparL1(option).toAction();
		ActionLazy<SplitapaInfo> mergePayord 		 = new ActionLazyCommom<SplitapaInfo>(option, SplitapaVisiMergePayord.class);
		ActionLazy<SplitapaInfo> enforceCustomerId = new ActionLazyCommom<SplitapaInfo>(option, SplitapaVisiEnforceCode.class);
		ActionLazy<SplitapaInfo> enforceCode 		 = new ActionLazyCommom<SplitapaInfo>(option, SplitapaVisiEnforceCustomerId.class);
		ActionLazy<SplitapaInfo> enforceItems 	 = new ActionLazyCommom<SplitapaInfo>(option, SplitapaVisiEnforceItems.class);
		ActionLazy<SplitapaInfo> enforceCredidCard = new ActionLazyCommom<SplitapaInfo>(option, SplitapaVisiEnforceCredidCard.class);
		ActionLazy<SplitapaInfo> enforceSplit 	 = new ActionLazyCommom<SplitapaInfo>(option, SplitapaVisiEnforceSplit.class);
		ActionLazy<SplitapaInfo> nodeL1 			 = new ActionLazyCommom<SplitapaInfo>(option, SplitapaVisiNodeCreate.class);
		
		nodeSetupar.addPostAction(mergePayord);
		mergePayord.addPostAction(enforceCustomerId);
		enforceCustomerId.addPostAction(enforceCode);
		enforceCode.addPostAction(enforceItems);
		enforceItems.addPostAction(enforceCredidCard);
		enforceCredidCard.addPostAction(enforceSplit);
		enforceSplit.addPostAction(nodeL1);
		
		actions.add(nodeSetupar);
		return actions;
	}
}
