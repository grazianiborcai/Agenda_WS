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
import br.com.mind5.payment.payOrder.model.action.PayordVisiCusparRefresh;
import br.com.mind5.payment.payOrder.model.action.PayordVisiNodePayL3;
import br.com.mind5.payment.payOrder.model.action.PayordVisiOrdapaPay;
import br.com.mind5.payment.payOrder.model.checker.PayordCheckIsPagarme;

public final class PayordNodePayL2 extends DeciTreeTemplateWrite<PayordInfo> {
	
	public PayordNodePayL2(DeciTreeOption<PayordInfo> option) {
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
	
		ActionStd <PayordInfo> cusparRefresh = new ActionStdCommom <PayordInfo>(option, PayordVisiCusparRefresh.class);
		ActionLazy<PayordInfo> ordapaPay     = new ActionLazyCommom<PayordInfo>(option, PayordVisiOrdapaPay.class);
		ActionLazy<PayordInfo> nodeL3        = new ActionLazyCommom<PayordInfo>(option, PayordVisiNodePayL3.class);
		
		cusparRefresh.addPostAction(ordapaPay);
		ordapaPay.addPostAction(nodeL3);
		
		actions.add(cusparRefresh);		
		return actions;
	}
}
