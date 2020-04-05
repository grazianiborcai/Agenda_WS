package br.com.mind5.business.order.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.order.info.OrderInfo;
import br.com.mind5.business.order.model.action.LazyOrderEnforceUser;
import br.com.mind5.business.order.model.action.LazyOrderMergeUsername;
import br.com.mind5.business.order.model.action.LazyOrderNodeAuthL2;
import br.com.mind5.business.order.model.action.StdOrderEnforceKey;
import br.com.mind5.business.order.model.checker.OrderCheckDummy;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeWriteTemplate;

public final class NodeOrderAuthL1 extends DeciTreeWriteTemplate<OrderInfo> {
	
	public NodeOrderAuthL1(DeciTreeOption<OrderInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<OrderInfo> buildCheckerHook(DeciTreeOption<OrderInfo> option) {
		List<ModelChecker<OrderInfo>> queue = new ArrayList<>();		
		ModelChecker<OrderInfo> checker;	

		checker = new OrderCheckDummy();
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<OrderInfo>> buildActionsOnPassedHook(DeciTreeOption<OrderInfo> option) {
		List<ActionStdV1<OrderInfo>> actions = new ArrayList<>();
		
		ActionStdV1<OrderInfo> enforceKey = new StdOrderEnforceKey(option);
		ActionLazyV1<OrderInfo> mergeUsername = new LazyOrderMergeUsername(option.conn, option.schemaName);
		ActionLazyV1<OrderInfo> enforceUser = new LazyOrderEnforceUser(option.conn, option.schemaName);
		ActionLazyV1<OrderInfo> nodeL2 = new LazyOrderNodeAuthL2(option.conn, option.schemaName);
		
		enforceKey.addPostAction(mergeUsername);
		mergeUsername.addPostAction(enforceUser);
		enforceUser.addPostAction(nodeL2);
		
		actions.add(enforceKey);
		return actions;
	}
}
