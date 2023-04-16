package br.com.mind5.business.order.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.order.info.OrderInfo;
import br.com.mind5.business.order.model.action.OrderVisiMergeOrderem;
import br.com.mind5.business.order.model.action.OrderVisiNodeUpdate;
import br.com.mind5.business.order.model.action.OrderVisiOrderemCancel;
import br.com.mind5.business.order.model.action.OrderVisiRefuRefund;
import br.com.mind5.business.order.model.checker.OrderCheckHasPayord;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class OrderNodeCancel extends DeciTreeTemplateWrite<OrderInfo> {
	
	public OrderNodeCancel(DeciTreeOption<OrderInfo> option) {
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
		checker = new OrderCheckHasPayord(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<OrderInfo>> buildActionsOnPassedHook(DeciTreeOption<OrderInfo> option) {
		List<ActionStd<OrderInfo>> actions = new ArrayList<>();
		
		ActionStd <OrderInfo> refund = new ActionStdCommom <OrderInfo>(option, OrderVisiRefuRefund.class);
		
		actions.add(refund);
		return actions;
	}
	
	
	
	@Override protected List<ActionStd<OrderInfo>> buildActionsOnFailedHook(DeciTreeOption<OrderInfo> option) {
		List<ActionStd<OrderInfo>> actions = new ArrayList<>();
		
		ActionStd <OrderInfo> update        = new ActionStdCommom <OrderInfo>(option, OrderVisiNodeUpdate.class);
		ActionLazy<OrderInfo> mergeOrderem  = new ActionLazyCommom<OrderInfo>(option, OrderVisiMergeOrderem.class);
		ActionLazy<OrderInfo> orderemCancel = new ActionLazyCommom<OrderInfo>(option, OrderVisiOrderemCancel.class);
		
		update.addPostAction(mergeOrderem);
		mergeOrderem.addPostAction(orderemCancel);
		
		actions.add(update);
		return actions;
	}
}
