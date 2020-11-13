package br.com.mind5.business.orderItem.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.orderItem.info.OrderemInfo;
import br.com.mind5.business.orderItem.model.action.LazyOrderemMergeOrdugePartner;
import br.com.mind5.business.orderItem.model.action.LazyOrderemNodeUpdate;
import br.com.mind5.business.orderItem.model.action.LazyOrderemSchedineRefresh;
import br.com.mind5.business.orderItem.model.action.StdOrderemMergePayordem;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.common.ModelCheckerDummy;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class NodeOrderemRefresh extends DeciTreeTemplateWrite<OrderemInfo> {
	
	public NodeOrderemRefresh(DeciTreeOption<OrderemInfo> option) {
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

		ActionStd<OrderemInfo> nodePayordem = new StdOrderemMergePayordem(option);
		ActionLazy<OrderemInfo> statusChange = new LazyOrderemMergeOrdugePartner(option.conn, option.schemaName);
		ActionLazy<OrderemInfo> nodeUpdate = new LazyOrderemNodeUpdate(option.conn, option.schemaName);
		ActionLazy<OrderemInfo> refreshSchedine = new LazyOrderemSchedineRefresh(option.conn, option.schemaName);
		
		nodePayordem.addPostAction(statusChange);
		statusChange.addPostAction(nodeUpdate);
		nodeUpdate.addPostAction(refreshSchedine);
		
		actions.add(nodePayordem);
		return actions;
	}
}
