package br.com.gda.business.orderReserve.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.orderReserve.info.OrderveInfo;
import br.com.gda.business.orderReserve.model.action.LazyOrderveSelect;
import br.com.gda.business.orderReserve.model.action.StdOrderveEnforceCancelled;
import br.com.gda.business.orderReserve.model.checker.OrderveCheckRead;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.model.decisionTree.DeciTreeReadTemplate;

public final class RootOrderveSelect extends DeciTreeReadTemplate<OrderveInfo> {
	
	public RootOrderveSelect(DeciTreeOption<OrderveInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<OrderveInfo> buildDecisionCheckerHook(DeciTreeOption<OrderveInfo> option) {
		List<ModelChecker<OrderveInfo>> queue = new ArrayList<>();		
		ModelChecker<OrderveInfo> checker;	
		
		checker = new OrderveCheckRead();
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<OrderveInfo>> buildActionsOnPassedHook(DeciTreeOption<OrderveInfo> option) {
		List<ActionStd<OrderveInfo>> actions = new ArrayList<>();	
		
		ActionStd<OrderveInfo> enforceStatus = new StdOrderveEnforceCancelled(option);
		ActionLazy<OrderveInfo> select = new LazyOrderveSelect(option.conn, option.schemaName);
		
		enforceStatus.addPostAction(select);
		
		actions.add(enforceStatus);
		return actions;
	}
}
