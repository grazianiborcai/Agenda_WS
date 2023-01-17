package br.com.mind5.paymentPartner.partnerPagarme.recipientPagarme.model.decisionTree;

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
import br.com.mind5.paymentPartner.partnerPagarme.recipientPagarme.info.RecipaInfo;
import br.com.mind5.paymentPartner.partnerPagarme.recipientPagarme.model.action.RecipaVisiEnforceAuthorization;
import br.com.mind5.paymentPartner.partnerPagarme.recipientPagarme.model.action.RecipaVisiMergeSetupar;
import br.com.mind5.paymentPartner.partnerPagarme.recipientPagarme.model.checker.RecipaCheckSetupar;

public final class RecipaNodeSetuparL2 extends DeciTreeTemplateWrite<RecipaInfo> {
	
	public RecipaNodeSetuparL2(DeciTreeOption<RecipaInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<RecipaInfo> buildCheckerHook(DeciTreeOption<RecipaInfo> option) {
		List<ModelChecker<RecipaInfo>> queue = new ArrayList<>();		
		ModelChecker<RecipaInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new RecipaCheckSetupar(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<RecipaInfo>> buildActionsOnPassedHook(DeciTreeOption<RecipaInfo> option) {
		List<ActionStd<RecipaInfo>> actions = new ArrayList<>();
		
		ActionStd<RecipaInfo> mergeSetupar = new ActionStdCommom<RecipaInfo>(option, RecipaVisiMergeSetupar.class);
		ActionLazy<RecipaInfo> enforceAuthorization = new ActionLazyCommom<RecipaInfo>(option, RecipaVisiEnforceAuthorization.class);
		
		mergeSetupar.addPostAction(enforceAuthorization);
		
		actions.add(mergeSetupar);
		return actions;
	}
}
