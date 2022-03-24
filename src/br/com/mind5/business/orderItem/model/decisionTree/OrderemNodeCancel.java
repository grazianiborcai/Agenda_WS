package br.com.mind5.business.orderItem.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.orderItem.info.OrderemInfo;
import br.com.mind5.business.orderItem.model.action.OrderemVisiNodeUpdate;
import br.com.mind5.business.orderItem.model.action.OrderemVisiMergeOrdugeCancel;
import br.com.mind5.business.orderItem.model.action.OrderemVisiSchedineRefresh;
import br.com.mind5.business.orderItem.model.checker.OrderemCheckIsCancelled;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.action.commom.ActionStdSuccessCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class OrderemNodeCancel extends DeciTreeTemplateWrite<OrderemInfo> {
	
	public OrderemNodeCancel(DeciTreeOption<OrderemInfo> option) {
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
		
		ActionStd<OrderemInfo> success = new ActionStdSuccessCommom<OrderemInfo>(option);
		
		actions.add(success);
		return actions;
	}
	
	
	
	@Override protected List<ActionStd<OrderemInfo>> buildActionsOnFailedHook(DeciTreeOption<OrderemInfo> option) {
		List<ActionStd<OrderemInfo>> actions = new ArrayList<>();
		
		ActionStd<OrderemInfo> statusChange = new ActionStdCommom<OrderemInfo>(option, OrderemVisiMergeOrdugeCancel.class);
		ActionLazy<OrderemInfo> update = new ActionLazyCommom<OrderemInfo>(option, OrderemVisiNodeUpdate.class);	
		ActionLazy<OrderemInfo> refreshSchedine = new ActionLazyCommom<OrderemInfo>(option, OrderemVisiSchedineRefresh.class);			
		
		statusChange.addPostAction(update);		
		update.addPostAction(refreshSchedine);
		
		actions.add(statusChange);
		return actions;
	}
}
