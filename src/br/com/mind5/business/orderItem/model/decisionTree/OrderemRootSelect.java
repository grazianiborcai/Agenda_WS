package br.com.mind5.business.orderItem.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.orderItem.info.OrderemInfo;
import br.com.mind5.business.orderItem.model.action.OrderemVisiMergeMatlis;
import br.com.mind5.business.orderItem.model.action.OrderemVisiMergeToSelect;
import br.com.mind5.business.orderItem.model.action.OrderemVisiNodeSelect;
import br.com.mind5.business.orderItem.model.checker.OrderemCheckRead;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class OrderemRootSelect extends DeciTreeTemplateWrite<OrderemInfo> {
	
	public OrderemRootSelect(DeciTreeOption<OrderemInfo> option) {
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
		checker = new OrderemCheckRead(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<OrderemInfo>> buildActionsOnPassedHook(DeciTreeOption<OrderemInfo> option) {
		List<ActionStd<OrderemInfo>> actions = new ArrayList<>();
		
		ActionStd<OrderemInfo>  select      = new ActionStdCommom<OrderemInfo> (option, OrderemVisiMergeToSelect.class);
		ActionLazy<OrderemInfo> mergeMatlis = new ActionLazyCommom<OrderemInfo>(option, OrderemVisiMergeMatlis.class);
		ActionLazy<OrderemInfo> nodeSelect  = new ActionLazyCommom<OrderemInfo>(option, OrderemVisiNodeSelect.class);		
		
		select.addPostAction(mergeMatlis);
		mergeMatlis.addPostAction(nodeSelect);
		
		actions.add(select);
		return actions;
	}
}
