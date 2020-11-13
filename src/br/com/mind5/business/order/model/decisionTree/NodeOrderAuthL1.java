package br.com.mind5.business.order.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.order.info.OrderInfo;
import br.com.mind5.business.order.model.action.LazyOrderEnforceUser;
import br.com.mind5.business.order.model.action.LazyOrderMergeUsername;
import br.com.mind5.business.order.model.action.LazyOrderNodeAuthL2;
import br.com.mind5.business.order.model.action.StdOrderEnforceKey;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.common.ModelCheckerDummy;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class NodeOrderAuthL1 extends DeciTreeTemplateWrite<OrderInfo> {
	
	public NodeOrderAuthL1(DeciTreeOption<OrderInfo> option) {
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
		
		ActionStd<OrderInfo> enforceKey = new StdOrderEnforceKey(option);
		ActionLazy<OrderInfo> mergeUsername = new LazyOrderMergeUsername(option.conn, option.schemaName);
		ActionLazy<OrderInfo> enforceUser = new LazyOrderEnforceUser(option.conn, option.schemaName);
		ActionLazy<OrderInfo> nodeL2 = new LazyOrderNodeAuthL2(option.conn, option.schemaName);
		
		enforceKey.addPostAction(mergeUsername);
		mergeUsername.addPostAction(enforceUser);
		enforceUser.addPostAction(nodeL2);
		
		actions.add(enforceKey);
		return actions;
	}
}
