package br.com.mind5.business.orderItem.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.orderItem.info.OrderemInfo;
import br.com.mind5.business.orderItem.model.action.LazyOrderemEnforceWeekday;
import br.com.mind5.business.orderItem.model.action.LazyOrderemMergeEmplis;
import br.com.mind5.business.orderItem.model.action.LazyOrderemMergeMatore;
import br.com.mind5.business.orderItem.model.action.LazyOrderemMergeRefugroup;
import br.com.mind5.business.orderItem.model.action.LazyOrderemMergeWeekday;
import br.com.mind5.business.orderItem.model.action.StdOrderemMergeStolis;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.common.ModelCheckerDummy;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class NodeOrderemSelectService extends DeciTreeTemplateWrite<OrderemInfo> {
	
	public NodeOrderemSelectService(DeciTreeOption<OrderemInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<OrderemInfo> buildCheckerHook(DeciTreeOption<OrderemInfo> option) {
		List<ModelChecker<OrderemInfo>> queue = new ArrayList<>();		
		ModelChecker<OrderemInfo> checker;
		
		checker = new ModelCheckerDummy<>();
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<OrderemInfo>> buildActionsOnPassedHook(DeciTreeOption<OrderemInfo> option) {
		List<ActionStd<OrderemInfo>> actions = new ArrayList<>();
		
		ActionStd<OrderemInfo> mergeStolis = new StdOrderemMergeStolis(option);
		ActionLazy<OrderemInfo> mergeEmplis = new LazyOrderemMergeEmplis(option.conn, option.schemaName);
		ActionLazy<OrderemInfo> enforceWeekday = new LazyOrderemEnforceWeekday(option.conn, option.schemaName);
		ActionLazy<OrderemInfo> mergeWeekday = new LazyOrderemMergeWeekday(option.conn, option.schemaName);
		ActionLazy<OrderemInfo> mergeMatore = new LazyOrderemMergeMatore(option.conn, option.schemaName);
		ActionLazy<OrderemInfo> mergeRefugroup = new LazyOrderemMergeRefugroup(option.conn, option.schemaName);
		
		mergeStolis.addPostAction(mergeEmplis);
		mergeEmplis.addPostAction(enforceWeekday);
		enforceWeekday.addPostAction(mergeWeekday);
		mergeWeekday.addPostAction(mergeMatore);
		mergeMatore.addPostAction(mergeRefugroup);
		
		actions.add(mergeStolis);
		return actions;
	}
}
