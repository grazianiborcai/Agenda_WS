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
import br.com.mind5.payment.payOrder.model.action.PayordVisiEnforceCreatedOn;
import br.com.mind5.payment.payOrder.model.action.PayordVisiEnforceLChanged;
import br.com.mind5.payment.payOrder.model.action.PayordVisiMergeUsername;

public final class PayordNodeUser extends DeciTreeTemplateWrite<PayordInfo> {
	
	public PayordNodeUser(DeciTreeOption<PayordInfo> option) {
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

		ActionStd <PayordInfo> enforceCreatedOn = new ActionStdCommom <PayordInfo>(option, PayordVisiEnforceCreatedOn.class);	
		ActionLazy<PayordInfo> enforceLChanged  = new ActionLazyCommom<PayordInfo>(option, PayordVisiEnforceLChanged.class);
		ActionLazy<PayordInfo> mergeUsername    = new ActionLazyCommom<PayordInfo>(option, PayordVisiMergeUsername.class);
		
		enforceCreatedOn.addPostAction(enforceLChanged);
		enforceLChanged.addPostAction(mergeUsername);
		
		actions.add(enforceCreatedOn);		
		return actions;
	}
}
