package br.com.mind5.paymentPartner.partnerPagarme.orderPagarme.model.decisionTree;

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
import br.com.mind5.paymentPartner.partnerPagarme.orderPagarme.info.OrdapaInfo;
import br.com.mind5.paymentPartner.partnerPagarme.orderPagarme.model.action.OrdapaVisiCancel;
import br.com.mind5.paymentPartner.partnerPagarme.orderPagarme.model.action.OrdapaVisiEnforceResponseCancel;
import br.com.mind5.paymentPartner.partnerPagarme.orderPagarme.model.checker.OrdapaCheckHasChargeId;
import br.com.mind5.paymentPartner.partnerPagarme.orderPagarme.model.checker.OrdapaCheckHasCard;

public final class OrdapaNodeCancel extends DeciTreeTemplateWrite<OrdapaInfo> {
	
	public OrdapaNodeCancel(DeciTreeOption<OrdapaInfo> option) {
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
		checker = new OrdapaCheckHasChargeId(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new OrdapaCheckHasCard(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<OrdapaInfo>> buildActionsOnPassedHook(DeciTreeOption<OrdapaInfo> option) {
		List<ActionStd<OrdapaInfo>> actions = new ArrayList<>();
		
		ActionStd<OrdapaInfo>  cancel                = new ActionStdCommom <OrdapaInfo>(option, OrdapaVisiCancel.class);
		ActionLazy<OrdapaInfo> enforceResponseCancel = new ActionLazyCommom<OrdapaInfo>(option, OrdapaVisiEnforceResponseCancel.class);
		
		cancel.addPostAction(enforceResponseCancel);
		
		actions.add(cancel);
		return actions;
	}
}
