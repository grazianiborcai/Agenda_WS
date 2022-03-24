package br.com.mind5.business.orderItem.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.orderItem.info.OrderemInfo;
import br.com.mind5.business.orderItem.model.action.OrderemVisiNodeUpdate;
import br.com.mind5.business.orderItem.model.action.OrderemVisiMergeOrdugeRefunding;
import br.com.mind5.business.orderItem.model.action.OrderemVisiRefupolEvaluate;
import br.com.mind5.business.orderItem.model.action.OrderemVisiSchedineRefresh;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.common.ModelCheckerDummy;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class OrderemNodeRefunding extends DeciTreeTemplateWrite<OrderemInfo> {
	
	public OrderemNodeRefunding(DeciTreeOption<OrderemInfo> option) {
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
		
		ActionStd<OrderemInfo> enforceStatus = new ActionStdCommom<OrderemInfo>(option, OrderemVisiMergeOrdugeRefunding.class);
		ActionLazy<OrderemInfo> refupolEvaluate = new ActionLazyCommom<OrderemInfo>(option, OrderemVisiRefupolEvaluate.class);			
		ActionLazy<OrderemInfo> update = new ActionLazyCommom<OrderemInfo>(option, OrderemVisiNodeUpdate.class);	
		ActionLazy<OrderemInfo> schedineRefresh = new ActionLazyCommom<OrderemInfo>(option, OrderemVisiSchedineRefresh.class);	
		
		enforceStatus.addPostAction(refupolEvaluate);
		refupolEvaluate.addPostAction(update);
		update.addPostAction(schedineRefresh);
		
		actions.add(enforceStatus);
		return actions;
	}
}
