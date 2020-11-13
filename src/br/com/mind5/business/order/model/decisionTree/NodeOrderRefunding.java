package br.com.mind5.business.order.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.order.info.OrderInfo;
import br.com.mind5.business.order.model.action.LazyOrderMergeOrderem;
import br.com.mind5.business.order.model.action.LazyOrderNodeUpdate;
import br.com.mind5.business.order.model.action.StdOrderMergeOrdugeRefunding;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.common.ModelCheckerDummy;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class NodeOrderRefunding extends DeciTreeTemplateWrite<OrderInfo> {
	
	public NodeOrderRefunding(DeciTreeOption<OrderInfo> option) {
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
		
		ActionStd<OrderInfo> enforceStatus = new StdOrderMergeOrdugeRefunding(option);
		ActionLazy<OrderInfo> update = new LazyOrderNodeUpdate(option.conn, option.schemaName);
		ActionLazy<OrderInfo> mergeOrderem = new LazyOrderMergeOrderem(option.conn, option.schemaName);
		
		enforceStatus.addPostAction(update);
		update.addPostAction(mergeOrderem);
		
		actions.add(enforceStatus);
		return actions;
	}
}
