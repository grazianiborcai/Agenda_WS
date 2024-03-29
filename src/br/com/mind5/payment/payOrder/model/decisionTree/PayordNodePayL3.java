package br.com.mind5.payment.payOrder.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.common.ModelCheckerDummy;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;
import br.com.mind5.payment.payOrder.info.PayordInfo;
import br.com.mind5.payment.payOrder.model.action.PayordVisiDaoUpdate;
import br.com.mind5.payment.payOrder.model.action.PayordVisiEnforceUpperCase;
import br.com.mind5.payment.payOrder.model.action.PayordVisiOrderRefresh;
import br.com.mind5.payment.payOrder.model.action.PayordVisiPayordemUpdate;

public final class PayordNodePayL3 extends DeciTreeTemplateWrite<PayordInfo> {
	
	public PayordNodePayL3(DeciTreeOption<PayordInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<PayordInfo> buildCheckerHook(DeciTreeOption<PayordInfo> option) {
		List<ModelChecker<PayordInfo>> queue = new ArrayList<>();		
		ModelChecker<PayordInfo> checker;	

		checker = new ModelCheckerDummy<>();
		queue.add(checker);

		return new ModelCheckerHelperQueue<>(queue);
	}
	
	

	@Override protected List<ActionStd<PayordInfo>> buildActionsOnPassedHook(DeciTreeOption<PayordInfo> option) {
		List<ActionStd<PayordInfo>> actions = new ArrayList<>();		
	
		ActionStd <PayordInfo> enforceUpperCase = new ActionStdCommom<PayordInfo> (option, PayordVisiEnforceUpperCase.class);
		ActionLazy<PayordInfo> updatePayord     = new ActionLazyCommom<PayordInfo>(option, PayordVisiDaoUpdate.class);
		ActionLazy<PayordInfo> updatePayordem   = new ActionLazyCommom<PayordInfo>(option, PayordVisiPayordemUpdate.class);
		ActionLazy<PayordInfo> orderRefresh     = new ActionLazyCommom<PayordInfo>(option, PayordVisiOrderRefresh.class);
		
		enforceUpperCase.addPostAction(updatePayord);
		updatePayord.addPostAction(updatePayordem);
		updatePayordem.addPostAction(orderRefresh);
		
		actions.add(enforceUpperCase);		
		return actions;
	}
}
