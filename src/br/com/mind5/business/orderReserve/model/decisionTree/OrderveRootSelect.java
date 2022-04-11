package br.com.mind5.business.orderReserve.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.orderReserve.info.OrderveInfo;
import br.com.mind5.business.orderReserve.model.action.OrderveVisiEnforceCancelled;
import br.com.mind5.business.orderReserve.model.action.OrderveVisiMergeToSelect;
import br.com.mind5.business.orderReserve.model.checker.OrderveCheckRead;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;

public final class OrderveRootSelect extends DeciTreeTemplateRead<OrderveInfo> {
	
	public OrderveRootSelect(DeciTreeOption<OrderveInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<OrderveInfo> buildCheckerHook(DeciTreeOption<OrderveInfo> option) {
		List<ModelChecker<OrderveInfo>> queue = new ArrayList<>();		
		ModelChecker<OrderveInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new OrderveCheckRead(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<OrderveInfo>> buildActionsOnPassedHook(DeciTreeOption<OrderveInfo> option) {
		List<ActionStd<OrderveInfo>> actions = new ArrayList<>();	
		
		ActionStd<OrderveInfo> enforceStatus = new ActionStdCommom<OrderveInfo>(option, OrderveVisiEnforceCancelled.class);
		ActionLazy<OrderveInfo> select = new ActionLazyCommom<OrderveInfo>(option, OrderveVisiMergeToSelect.class);
		
		enforceStatus.addPostAction(select);
		
		actions.add(enforceStatus);
		return actions;
	}
}
