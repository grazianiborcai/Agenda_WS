package br.com.gda.business.orderItem.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.orderItem.info.OrderemInfo;
import br.com.gda.business.orderItem.model.action.LazyOrderemUpdate;
import br.com.gda.business.orderItem.model.action.StdOrderemInsertOrdemrap;
import br.com.gda.business.orderItem.model.checker.OrderemCheckWrite;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.model.decisionTree.DeciTreeWriteTemplate;

public final class NodeOrderemSnapshot extends DeciTreeWriteTemplate<OrderemInfo> {
	
	public NodeOrderemSnapshot(DeciTreeOption<OrderemInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<OrderemInfo> buildDecisionCheckerHook(DeciTreeOption<OrderemInfo> option) {
		List<ModelChecker<OrderemInfo>> queue = new ArrayList<>();		
		ModelChecker<OrderemInfo> checker;	
		
		checker = new OrderemCheckWrite();
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<OrderemInfo>> buildActionsOnPassedHook(DeciTreeOption<OrderemInfo> option) {
		List<ActionStd<OrderemInfo>> actions = new ArrayList<>();
		
		ActionStd<OrderemInfo> insertOrdemrap = new StdOrderemInsertOrdemrap(option);
		ActionLazy<OrderemInfo> update = new LazyOrderemUpdate(option.conn, option.schemaName);
		
		insertOrdemrap.addPostAction(update);
		
		actions.add(insertOrdemrap);
		return actions;
	}
}
