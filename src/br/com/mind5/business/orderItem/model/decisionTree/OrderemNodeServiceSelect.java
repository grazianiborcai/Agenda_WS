package br.com.mind5.business.orderItem.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.orderItem.info.OrderemInfo;
import br.com.mind5.business.orderItem.model.action.OrderemVisiEnforceWeekday;
import br.com.mind5.business.orderItem.model.action.OrderemVisiMergeEmplres;
import br.com.mind5.business.orderItem.model.action.OrderemVisiMergeMatore;
import br.com.mind5.business.orderItem.model.action.OrderemVisiMergeRefugroup;
import br.com.mind5.business.orderItem.model.action.OrderemVisiMergeStolis;
import br.com.mind5.business.orderItem.model.action.OrderemVisiMergeWeekday;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.common.ModelCheckerDummy;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class OrderemNodeServiceSelect extends DeciTreeTemplateWrite<OrderemInfo> {
	
	public OrderemNodeServiceSelect(DeciTreeOption<OrderemInfo> option) {
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
		
		ActionStd<OrderemInfo> mergeStolis = new ActionStdCommom<OrderemInfo>(option, OrderemVisiMergeStolis.class);
		ActionLazy<OrderemInfo> mergeEmplres = new ActionLazyCommom<OrderemInfo>(option, OrderemVisiMergeEmplres.class);
		ActionLazy<OrderemInfo> enforceWeekday = new ActionLazyCommom<OrderemInfo>(option, OrderemVisiEnforceWeekday.class);
		ActionLazy<OrderemInfo> mergeWeekday = new ActionLazyCommom<OrderemInfo>(option, OrderemVisiMergeWeekday.class);
		ActionLazy<OrderemInfo> mergeMatore = new ActionLazyCommom<OrderemInfo>(option, OrderemVisiMergeMatore.class);
		ActionLazy<OrderemInfo> mergeRefugroup = new ActionLazyCommom<OrderemInfo>(option, OrderemVisiMergeRefugroup.class);
		
		mergeStolis.addPostAction(mergeEmplres);
		mergeEmplres.addPostAction(enforceWeekday);
		enforceWeekday.addPostAction(mergeWeekday);
		mergeWeekday.addPostAction(mergeMatore);
		mergeMatore.addPostAction(mergeRefugroup);
		
		actions.add(mergeStolis);
		return actions;
	}
}
