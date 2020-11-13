package br.com.mind5.business.orderItem.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.orderItem.info.OrderemInfo;
import br.com.mind5.business.orderItem.model.action.LazyOrderemNodeUpdate;
import br.com.mind5.business.orderItem.model.action.LazyOrderemSchedineRefresh;
import br.com.mind5.business.orderItem.model.action.StdOrderemMergeOrdugeCancel;
import br.com.mind5.business.orderItem.model.action.StdOrderemSuccess;
import br.com.mind5.business.orderItem.model.checker.OrderemCheckIsCancelled;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class NodeOrderemCancel extends DeciTreeTemplateWrite<OrderemInfo> {
	
	public NodeOrderemCancel(DeciTreeOption<OrderemInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<OrderemInfo> buildCheckerHook(DeciTreeOption<OrderemInfo> option) {
		List<ModelChecker<OrderemInfo>> queue = new ArrayList<>();		
		ModelChecker<OrderemInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new OrderemCheckIsCancelled(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<OrderemInfo>> buildActionsOnPassedHook(DeciTreeOption<OrderemInfo> option) {
		List<ActionStd<OrderemInfo>> actions = new ArrayList<>();
		
		ActionStd<OrderemInfo> success = new StdOrderemSuccess(option);
		
		actions.add(success);
		return actions;
	}
	
	
	
	@Override protected List<ActionStd<OrderemInfo>> buildActionsOnFailedHook(DeciTreeOption<OrderemInfo> option) {
		List<ActionStd<OrderemInfo>> actions = new ArrayList<>();
		
		ActionStd<OrderemInfo> statusChange = new StdOrderemMergeOrdugeCancel(option);
		ActionLazy<OrderemInfo> update = new LazyOrderemNodeUpdate(option.conn, option.schemaName);	
		ActionLazy<OrderemInfo> refreshSchedine = new LazyOrderemSchedineRefresh(option.conn, option.schemaName);			
		
		statusChange.addPostAction(update);		
		update.addPostAction(refreshSchedine);
		
		actions.add(statusChange);
		return actions;
	}
}
