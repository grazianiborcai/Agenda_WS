package br.com.mind5.business.order.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.order.info.OrderInfo;
import br.com.mind5.business.order.model.action.LazyOrderNodeUpdate;
import br.com.mind5.business.order.model.action.LazyOrderRefreshSchedine;
import br.com.mind5.business.order.model.checker.OrderCheckDummy;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeWriteTemplate;

public final class NodeOrderRefresh extends DeciTreeWriteTemplate<OrderInfo> {
	
	public NodeOrderRefresh(DeciTreeOption<OrderInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<OrderInfo> buildDecisionCheckerHook(DeciTreeOption<OrderInfo> option) {
		List<ModelChecker<OrderInfo>> queue = new ArrayList<>();		
		ModelChecker<OrderInfo> checker;
		
		checker = new OrderCheckDummy();
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<OrderInfo>> buildActionsOnPassedHook(DeciTreeOption<OrderInfo> option) {
		List<ActionStdV1<OrderInfo>> actions = new ArrayList<>();

		ActionStdV1<OrderInfo> nodePayord = new NodeOrderPayord(option).toAction();
		ActionLazyV1<OrderInfo> nodeUpdate = new LazyOrderNodeUpdate(option.conn, option.schemaName);
		ActionLazyV1<OrderInfo> refreshSchedine = new LazyOrderRefreshSchedine(option.conn, option.schemaName);
		
		nodePayord.addPostAction(nodeUpdate);
		nodeUpdate.addPostAction(refreshSchedine);
		
		actions.add(nodePayord);
		return actions;
	}
}
