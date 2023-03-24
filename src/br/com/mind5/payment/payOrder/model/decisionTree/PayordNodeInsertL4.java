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
import br.com.mind5.payment.payOrder.model.action.PayordVisiDaoInsert;
import br.com.mind5.payment.payOrder.model.action.PayordVisiEnforceFee;
import br.com.mind5.payment.payOrder.model.action.PayordVisiEnforceItem;
import br.com.mind5.payment.payOrder.model.action.PayordVisiPayordemInsert;

public final class PayordNodeInsertL4 extends DeciTreeTemplateWrite<PayordInfo> {
	
	public PayordNodeInsertL4(DeciTreeOption<PayordInfo> option) {
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
		
		ActionStd <PayordInfo> insertPayord   = new ActionStdCommom <PayordInfo>(option, PayordVisiDaoInsert.class);
		ActionLazy<PayordInfo> enforceFee     = new ActionLazyCommom<PayordInfo>(option, PayordVisiEnforceFee.class);
		ActionLazy<PayordInfo> enforceItem    = new ActionLazyCommom<PayordInfo>(option, PayordVisiEnforceItem.class);
		ActionLazy<PayordInfo> insertPayordem = new ActionLazyCommom<PayordInfo>(option, PayordVisiPayordemInsert.class);
		
		insertPayord.addPostAction(enforceFee);
		enforceFee.addPostAction(enforceItem);
		enforceItem.addPostAction(insertPayordem);
		
		actions.add(insertPayord);		
		return actions;
	}
}
