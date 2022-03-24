package br.com.mind5.business.order.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.order.info.OrderInfo;
import br.com.mind5.business.order.model.action.OrderVisiNodePayord;
import br.com.mind5.business.order.model.action.OrderVisiNodeRefugroupL1;
import br.com.mind5.business.order.model.action.OrderVisiEnforceCurrency;
import br.com.mind5.business.order.model.action.OrderVisiEnforceFeecat;
import br.com.mind5.business.order.model.action.OrderVisiMergeCurrency;
import br.com.mind5.business.order.model.action.OrderVisiMergeFeecat;
import br.com.mind5.business.order.model.action.OrderVisiMergeOrderatus;
import br.com.mind5.business.order.model.action.OrderVisiMergeOrderem;
import br.com.mind5.business.order.model.action.OrderVisiMergeToSelect;
import br.com.mind5.business.order.model.checker.OrderCheckLangu;
import br.com.mind5.business.order.model.checker.OrderCheckRead;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;

public final class OrderRootSelect extends DeciTreeTemplateRead<OrderInfo> {
	
	public OrderRootSelect(DeciTreeOption<OrderInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<OrderInfo> buildCheckerHook(DeciTreeOption<OrderInfo> option) {
		List<ModelChecker<OrderInfo>> queue = new ArrayList<>();		
		ModelChecker<OrderInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new OrderCheckRead(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new OrderCheckLangu(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<OrderInfo>> buildActionsOnPassedHook(DeciTreeOption<OrderInfo> option) {
		List<ActionStd<OrderInfo>> actions = new ArrayList<>();		
		
		ActionStd<OrderInfo> select = new ActionStdCommom<OrderInfo>(option, OrderVisiMergeToSelect.class);
		ActionLazy<OrderInfo> mergeItem = new ActionLazyCommom<OrderInfo>(option, OrderVisiMergeOrderem.class);
		ActionLazy<OrderInfo> enforceCurrency = new ActionLazyCommom<OrderInfo>(option, OrderVisiEnforceCurrency.class);
		ActionLazy<OrderInfo> mergeCurrency = new ActionLazyCommom<OrderInfo>(option, OrderVisiMergeCurrency.class);
		ActionLazy<OrderInfo> mergeOrderatus = new ActionLazyCommom<OrderInfo>(option, OrderVisiMergeOrderatus.class);
		ActionLazy<OrderInfo> enforceFeecat = new ActionLazyCommom<OrderInfo>(option, OrderVisiEnforceFeecat.class);
		ActionLazy<OrderInfo> mergeFeecat = new ActionLazyCommom<OrderInfo>(option, OrderVisiMergeFeecat.class);
		ActionLazy<OrderInfo> nodePayord = new ActionLazyCommom<OrderInfo>(option, OrderVisiNodePayord.class);
		ActionLazy<OrderInfo> nodeRefugroup = new ActionLazyCommom<OrderInfo>(option, OrderVisiNodeRefugroupL1.class);
		
		select.addPostAction(mergeItem);
		mergeItem.addPostAction(enforceCurrency);
		enforceCurrency.addPostAction(mergeCurrency);
		mergeCurrency.addPostAction(mergeOrderatus);
		mergeOrderatus.addPostAction(enforceFeecat);
		enforceFeecat.addPostAction(mergeFeecat);
		mergeFeecat.addPostAction(nodePayord);
		nodePayord.addPostAction(nodeRefugroup);
		
		actions.add(select);			
		return actions;
	}
}
