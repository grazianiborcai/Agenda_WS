package br.com.mind5.paymentPartner.partnerPagarme.orderSplitPagarme.model.decisionTree;

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
import br.com.mind5.paymentPartner.partnerPagarme.orderSplitPagarme.info.SplitapaInfo;
import br.com.mind5.paymentPartner.partnerPagarme.orderSplitPagarme.model.action.SplitapaVisiEnforceAuthorization;
import br.com.mind5.paymentPartner.partnerPagarme.orderSplitPagarme.model.action.SplitapaVisiMergeSetupar;
import br.com.mind5.paymentPartner.partnerPagarme.orderSplitPagarme.model.checker.SplitapaCheckSetupar;

public final class SplitapaNodeSetuparL2 extends DeciTreeTemplateWrite<SplitapaInfo> {
	
	public SplitapaNodeSetuparL2(DeciTreeOption<SplitapaInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<SplitapaInfo> buildCheckerHook(DeciTreeOption<SplitapaInfo> option) {
		List<ModelChecker<SplitapaInfo>> queue = new ArrayList<>();		
		ModelChecker<SplitapaInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new SplitapaCheckSetupar(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<SplitapaInfo>> buildActionsOnPassedHook(DeciTreeOption<SplitapaInfo> option) {
		List<ActionStd<SplitapaInfo>> actions = new ArrayList<>();
		
		ActionStd<SplitapaInfo> mergeSetupar = new ActionStdCommom<SplitapaInfo>(option, SplitapaVisiMergeSetupar.class);
		ActionLazy<SplitapaInfo> enforceAuthorization = new ActionLazyCommom<SplitapaInfo>(option, SplitapaVisiEnforceAuthorization.class);
		
		mergeSetupar.addPostAction(enforceAuthorization);
		
		actions.add(mergeSetupar);
		return actions;
	}
}
