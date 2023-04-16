package br.com.mind5.payment.payOrder.model.decisionTree;

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
import br.com.mind5.payment.payOrder.info.PayordInfo;
import br.com.mind5.payment.payOrder.model.action.PayordVisiNodeRefreshL2;
import br.com.mind5.payment.payOrder.model.action.PayordVisiOrdapaRead;
import br.com.mind5.payment.payOrder.model.checker.PayordCheckIsPagarme;

public final class PayordNodeRefreshL1 extends DeciTreeTemplateWrite<PayordInfo> {
	
	public PayordNodeRefreshL1(DeciTreeOption<PayordInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<PayordInfo> buildCheckerHook(DeciTreeOption<PayordInfo> option) {
		List<ModelChecker<PayordInfo>> queue = new ArrayList<>();		
		ModelChecker<PayordInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new PayordCheckIsPagarme(checkerOption);
		queue.add(checker);

		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<PayordInfo>> buildActionsOnPassedHook(DeciTreeOption<PayordInfo> option) {
		List<ActionStd<PayordInfo>> actions = new ArrayList<>();		
	
		ActionStd <PayordInfo> ordapaRead = new ActionStdCommom <PayordInfo>(option, PayordVisiOrdapaRead.class);
		ActionLazy<PayordInfo> nodeL2     = new ActionLazyCommom<PayordInfo>(option, PayordVisiNodeRefreshL2.class);
		
		ordapaRead.addPostAction(nodeL2);
		
		actions.add(ordapaRead);		
		return actions;
	}
}
