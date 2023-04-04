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
import br.com.mind5.paymentPartner.partnerPagarme.orderSplitPagarme.model.action.SplitapaVisiCreate;
import br.com.mind5.paymentPartner.partnerPagarme.orderSplitPagarme.model.action.SplitapaVisiEnforceResponseCreate;
import br.com.mind5.paymentPartner.partnerPagarme.orderSplitPagarme.model.checker.SplitapaCheckHasCustomer;
import br.com.mind5.paymentPartner.partnerPagarme.orderSplitPagarme.model.checker.SplitapaCheckHasItems;
import br.com.mind5.paymentPartner.partnerPagarme.orderSplitPagarme.model.checker.SplitapaCheckHasPayments;
import br.com.mind5.paymentPartner.partnerPagarme.orderSplitPagarme.model.checker.SplitapaCheckHasSplit;

public final class SplitapaNodeCreate extends DeciTreeTemplateWrite<SplitapaInfo> {
	
	public SplitapaNodeCreate(DeciTreeOption<SplitapaInfo> option) {
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
		checker = new SplitapaCheckHasCustomer(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new SplitapaCheckHasItems(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new SplitapaCheckHasPayments(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new SplitapaCheckHasSplit(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<SplitapaInfo>> buildActionsOnPassedHook(DeciTreeOption<SplitapaInfo> option) {
		List<ActionStd<SplitapaInfo>> actions = new ArrayList<>();
		
		ActionStd <SplitapaInfo> create                = new ActionStdCommom<SplitapaInfo> (option, SplitapaVisiCreate.class);
		ActionLazy<SplitapaInfo> enforceResponseCreate = new ActionLazyCommom<SplitapaInfo>(option, SplitapaVisiEnforceResponseCreate.class);
		
		create.addPostAction(enforceResponseCreate);
		
		actions.add(create);
		return actions;
	}
}
