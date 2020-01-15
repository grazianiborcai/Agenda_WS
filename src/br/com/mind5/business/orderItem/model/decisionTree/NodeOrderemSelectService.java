package br.com.mind5.business.orderItem.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.orderItem.info.OrderemInfo;
import br.com.mind5.business.orderItem.model.action.LazyOrderemEnforceWeekday;
import br.com.mind5.business.orderItem.model.action.LazyOrderemMergeEmplis;
import br.com.mind5.business.orderItem.model.action.LazyOrderemMergeMatore;
import br.com.mind5.business.orderItem.model.action.LazyOrderemMergeWeekday;
import br.com.mind5.business.orderItem.model.action.StdOrderemMergeStolis;
import br.com.mind5.business.orderItem.model.checker.OrderemCheckDummy;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeWriteTemplate;

public final class NodeOrderemSelectService extends DeciTreeWriteTemplate<OrderemInfo> {
	
	public NodeOrderemSelectService(DeciTreeOption<OrderemInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<OrderemInfo> buildDecisionCheckerHook(DeciTreeOption<OrderemInfo> option) {
		List<ModelChecker<OrderemInfo>> queue = new ArrayList<>();		
		ModelChecker<OrderemInfo> checker;
		
		checker = new OrderemCheckDummy();
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<OrderemInfo>> buildActionsOnPassedHook(DeciTreeOption<OrderemInfo> option) {
		List<ActionStd<OrderemInfo>> actions = new ArrayList<>();
		
		ActionStd<OrderemInfo> mergeStolis = new StdOrderemMergeStolis(option);
		ActionLazy<OrderemInfo> mergeEmplis = new LazyOrderemMergeEmplis(option.conn, option.schemaName);
		ActionLazy<OrderemInfo> enforceWeekday = new LazyOrderemEnforceWeekday(option.conn, option.schemaName);
		ActionLazy<OrderemInfo> mergeWeekday = new LazyOrderemMergeWeekday(option.conn, option.schemaName);
		ActionLazy<OrderemInfo> mergeMatore = new LazyOrderemMergeMatore(option.conn, option.schemaName);
		
		mergeStolis.addPostAction(mergeEmplis);
		mergeEmplis.addPostAction(enforceWeekday);
		enforceWeekday.addPostAction(mergeWeekday);
		mergeWeekday.addPostAction(mergeMatore);
		
		actions.add(mergeStolis);
		return actions;
	}
}
