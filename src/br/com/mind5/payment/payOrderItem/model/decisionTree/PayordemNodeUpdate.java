package br.com.mind5.payment.payOrderItem.model.decisionTree;

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
import br.com.mind5.payment.payOrderItem.info.PayordemInfo;
import br.com.mind5.payment.payOrderItem.model.action.PayordemVisiNodeRefresh;
import br.com.mind5.payment.payOrderItem.model.action.PayordemVisiDaoUpdate;
import br.com.mind5.payment.payOrderItem.model.action.PayordemVisiEnforceLChanged;

public final class PayordemNodeUpdate extends DeciTreeTemplateWrite<PayordemInfo> {
	
	public PayordemNodeUpdate(DeciTreeOption<PayordemInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<PayordemInfo> buildCheckerHook(DeciTreeOption<PayordemInfo> option) {
		List<ModelChecker<PayordemInfo>> queue = new ArrayList<>();		
		ModelChecker<PayordemInfo> checker;	

		checker = new ModelCheckerDummy<>();
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<PayordemInfo>> buildActionsOnPassedHook(DeciTreeOption<PayordemInfo> option) {
		List<ActionStd<PayordemInfo>> actions = new ArrayList<>();
		
		ActionStd<PayordemInfo> enforceLChanged = new ActionStdCommom<PayordemInfo>(option, PayordemVisiEnforceLChanged.class);
		ActionLazy<PayordemInfo> update = new ActionLazyCommom<PayordemInfo>(option, PayordemVisiDaoUpdate.class);
		ActionLazy<PayordemInfo> refresh = new ActionLazyCommom<PayordemInfo>(option, PayordemVisiNodeRefresh.class);
		
		enforceLChanged.addPostAction(update);
		update.addPostAction(refresh);
		
		actions.add(enforceLChanged);
		return actions;
	}
}
