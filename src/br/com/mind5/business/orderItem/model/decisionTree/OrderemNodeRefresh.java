package br.com.mind5.business.orderItem.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.orderItem.info.OrderemInfo;
import br.com.mind5.business.orderItem.model.action.OrderemVisiNodeUpdate;
import br.com.mind5.business.orderItem.model.action.OrderemVisiMergeOrdugePartner;
import br.com.mind5.business.orderItem.model.action.OrderemVisiMergePayordem;
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

public final class OrderemNodeRefresh extends DeciTreeTemplateWrite<OrderemInfo> {
	
	public OrderemNodeRefresh(DeciTreeOption<OrderemInfo> option) {
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

		ActionStd<OrderemInfo> nodePayordem = new ActionStdCommom<OrderemInfo>(option, OrderemVisiMergePayordem.class);
		ActionLazy<OrderemInfo> statusChange = new ActionLazyCommom<OrderemInfo>(option, OrderemVisiMergeOrdugePartner.class);
		ActionLazy<OrderemInfo> nodeUpdate = new ActionLazyCommom<OrderemInfo>(option, OrderemVisiNodeUpdate.class);
		ActionLazy<OrderemInfo> refreshSchedine = new ActionLazyCommom<OrderemInfo>(option, OrderemVisiSchedineRefresh.class);
		
		nodePayordem.addPostAction(statusChange);
		statusChange.addPostAction(nodeUpdate);
		nodeUpdate.addPostAction(refreshSchedine);
		
		actions.add(nodePayordem);
		return actions;
	}
}
