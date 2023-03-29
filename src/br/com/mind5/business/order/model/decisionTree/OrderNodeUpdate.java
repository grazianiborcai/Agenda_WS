package br.com.mind5.business.order.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.order.info.OrderInfo;
import br.com.mind5.business.order.model.action.OrderVisiEnforceLChanged;
import br.com.mind5.business.order.model.action.OrderVisiMergeUsername;
import br.com.mind5.business.order.model.action.OrderVisiNodeSnapshot;
import br.com.mind5.business.order.model.checker.OrderCheckUpdate;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class OrderNodeUpdate extends DeciTreeTemplateWrite<OrderInfo> {
	
	public OrderNodeUpdate(DeciTreeOption<OrderInfo> option) {
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
		checker = new OrderCheckUpdate(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<OrderInfo>> buildActionsOnPassedHook(DeciTreeOption<OrderInfo> option) {
		List<ActionStd<OrderInfo>> actions = new ArrayList<>();

		ActionStd <OrderInfo> mergeUsername   = new ActionStdCommom <OrderInfo>(option, OrderVisiMergeUsername.class);
		ActionLazy<OrderInfo> enforceLChanged = new ActionLazyCommom<OrderInfo>(option, OrderVisiEnforceLChanged.class);
		ActionLazy<OrderInfo> snapshot        = new ActionLazyCommom<OrderInfo>(option, OrderVisiNodeSnapshot.class);
		
		mergeUsername.addPostAction(enforceLChanged);
		enforceLChanged.addPostAction(snapshot);
		
		actions.add(mergeUsername);
		return actions;
	}
}
