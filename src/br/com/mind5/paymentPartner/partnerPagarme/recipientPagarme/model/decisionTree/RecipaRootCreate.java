package br.com.mind5.paymentPartner.partnerPagarme.recipientPagarme.model.decisionTree;

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
import br.com.mind5.paymentPartner.partnerPagarme.recipientPagarme.info.RecipaInfo;
import br.com.mind5.paymentPartner.partnerPagarme.recipientPagarme.model.action.RecipaVisiCreate;
import br.com.mind5.paymentPartner.partnerPagarme.recipientPagarme.model.action.RecipaVisiEnforceType;
import br.com.mind5.paymentPartner.partnerPagarme.recipientPagarme.model.checker.RecipaCheckCreate;

public final class RecipaRootCreate extends DeciTreeTemplateWrite<RecipaInfo> {
	
	public RecipaRootCreate(DeciTreeOption<RecipaInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<RecipaInfo> buildCheckerHook(DeciTreeOption<RecipaInfo> option) {
		List<ModelChecker<RecipaInfo>> queue = new ArrayList<>();		
		ModelChecker<RecipaInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new RecipaCheckCreate(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<RecipaInfo>> buildActionsOnPassedHook(DeciTreeOption<RecipaInfo> option) {
		List<ActionStd<RecipaInfo>> actions = new ArrayList<>();
		
		ActionStd<RecipaInfo> mergeSetupar = new RecipaNodeSetuparL1(option).toAction();
		ActionLazy<RecipaInfo> enforceType = new ActionLazyCommom<RecipaInfo>(option, RecipaVisiEnforceType.class);
		ActionLazy<RecipaInfo> create = new ActionLazyCommom<RecipaInfo>(option, RecipaVisiCreate.class);
		
		mergeSetupar.addPostAction(enforceType);
		enforceType.addPostAction(create);
		
		actions.add(mergeSetupar);
		return actions;
	}
}
