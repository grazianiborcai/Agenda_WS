package br.com.mind5.business.orderItem.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.orderItem.info.OrderemInfo;
import br.com.mind5.business.orderItem.model.action.LazyOrderemUpdate;
import br.com.mind5.business.orderItem.model.action.StdOrderemInsertOrdemrap;
import br.com.mind5.business.orderItem.model.checker.OrderemCheckDummy;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeWriteTemplate;

public final class NodeOrderemSnapshot extends DeciTreeWriteTemplate<OrderemInfo> {
	
	public NodeOrderemSnapshot(DeciTreeOption<OrderemInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<OrderemInfo> buildDecisionCheckerHook(DeciTreeOption<OrderemInfo> option) {
		List<ModelChecker<OrderemInfo>> queue = new ArrayList<>();		
		ModelChecker<OrderemInfo> checker;	

		checker = new OrderemCheckDummy();
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<OrderemInfo>> buildActionsOnPassedHook(DeciTreeOption<OrderemInfo> option) {
		List<ActionStdV1<OrderemInfo>> actions = new ArrayList<>();
		
		ActionStdV1<OrderemInfo> insertOrdemrap = new StdOrderemInsertOrdemrap(option);
		ActionLazyV1<OrderemInfo> update = new LazyOrderemUpdate(option.conn, option.schemaName);
		
		insertOrdemrap.addPostAction(update);
		
		actions.add(insertOrdemrap);
		return actions;
	}
}
