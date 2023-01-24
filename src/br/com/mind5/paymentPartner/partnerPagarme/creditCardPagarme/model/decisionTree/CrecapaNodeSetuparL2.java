package br.com.mind5.paymentPartner.partnerPagarme.creditCardPagarme.model.decisionTree;

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
import br.com.mind5.paymentPartner.partnerPagarme.creditCardPagarme.info.CrecapaInfo;
import br.com.mind5.paymentPartner.partnerPagarme.creditCardPagarme.model.action.CrecapaVisiEnforceAuthorization;
import br.com.mind5.paymentPartner.partnerPagarme.creditCardPagarme.model.action.CrecapaVisiMergeSetupar;
import br.com.mind5.paymentPartner.partnerPagarme.creditCardPagarme.model.checker.CrecapaCheckSetupar;

public final class CrecapaNodeSetuparL2 extends DeciTreeTemplateWrite<CrecapaInfo> {
	
	public CrecapaNodeSetuparL2(DeciTreeOption<CrecapaInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<CrecapaInfo> buildCheckerHook(DeciTreeOption<CrecapaInfo> option) {
		List<ModelChecker<CrecapaInfo>> queue = new ArrayList<>();		
		ModelChecker<CrecapaInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new CrecapaCheckSetupar(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<CrecapaInfo>> buildActionsOnPassedHook(DeciTreeOption<CrecapaInfo> option) {
		List<ActionStd<CrecapaInfo>> actions = new ArrayList<>();
		
		ActionStd<CrecapaInfo> mergeSetupar = new ActionStdCommom<CrecapaInfo>(option, CrecapaVisiMergeSetupar.class);
		ActionLazy<CrecapaInfo> enforceAuthorization = new ActionLazyCommom<CrecapaInfo>(option, CrecapaVisiEnforceAuthorization.class);
		
		mergeSetupar.addPostAction(enforceAuthorization);
		
		actions.add(mergeSetupar);
		return actions;
	}
}
