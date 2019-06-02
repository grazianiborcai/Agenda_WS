package br.com.gda.business.order.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.order.info.OrderInfo;
import br.com.gda.business.order.model.action.LazyOrderInsertOrderem;
import br.com.gda.business.order.model.action.StdOrderEnforceOrderemKey;
import br.com.gda.business.order.model.checker.OrderCheckInsert;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.model.decisionTree.DeciTreeWriteTemplate;

public final class NodeOrderOrderem extends DeciTreeWriteTemplate<OrderInfo> {
	
	public NodeOrderOrderem(DeciTreeOption<OrderInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<OrderInfo> buildDecisionCheckerHook(DeciTreeOption<OrderInfo> option) {
		List<ModelChecker<OrderInfo>> queue = new ArrayList<>();		
		ModelChecker<OrderInfo> checker;	
		
		checker = new OrderCheckInsert();
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<OrderInfo>> buildActionsOnPassedHook(DeciTreeOption<OrderInfo> option) {
		List<ActionStd<OrderInfo>> actions = new ArrayList<>();		

		ActionStd<OrderInfo> enforceOrderemKey = new StdOrderEnforceOrderemKey(option);
		ActionLazy<OrderInfo> insertOrderem = new LazyOrderInsertOrderem(option.conn, option.schemaName);
		
		enforceOrderemKey.addPostAction(insertOrderem);
		
		actions.add(enforceOrderemKey);
		return actions;
	}
}
