package br.com.mind5.business.order.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.order.info.OrderInfo;
import br.com.mind5.business.order.model.action.OrderVisiEnforceKey;
import br.com.mind5.business.order.model.action.OrderVisiEnforceUser;
import br.com.mind5.business.order.model.action.OrderVisiMergeUsername;
import br.com.mind5.business.order.model.action.OrderVisiNodeAuthL2;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.common.ModelCheckerDummy;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class OrderNodeAuthL1 extends DeciTreeTemplateWrite<OrderInfo> {
	
	public OrderNodeAuthL1(DeciTreeOption<OrderInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<OrderInfo> buildCheckerHook(DeciTreeOption<OrderInfo> option) {
		List<ModelChecker<OrderInfo>> queue = new ArrayList<>();		
		ModelChecker<OrderInfo> checker;	

		checker = new ModelCheckerDummy<>();
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<OrderInfo>> buildActionsOnPassedHook(DeciTreeOption<OrderInfo> option) {
		List<ActionStd<OrderInfo>> actions = new ArrayList<>();
		
		ActionStd <OrderInfo> enforceKey    = new ActionStdCommom <OrderInfo>(option, OrderVisiEnforceKey.class);
		ActionLazy<OrderInfo> mergeUsername = new ActionLazyCommom<OrderInfo>(option, OrderVisiMergeUsername.class);
		ActionLazy<OrderInfo> enforceUser   = new ActionLazyCommom<OrderInfo>(option, OrderVisiEnforceUser.class);
		ActionLazy<OrderInfo> nodeL2        = new ActionLazyCommom<OrderInfo>(option, OrderVisiNodeAuthL2.class);
		
		enforceKey.addPostAction(mergeUsername);
		mergeUsername.addPostAction(enforceUser);
		enforceUser.addPostAction(nodeL2);
		
		actions.add(enforceKey);
		return actions;
	}
}
