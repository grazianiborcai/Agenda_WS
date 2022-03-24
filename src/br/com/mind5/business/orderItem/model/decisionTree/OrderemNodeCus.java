package br.com.mind5.business.orderItem.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.orderItem.info.OrderemInfo;
import br.com.mind5.business.orderItem.model.action.OrderemVisiCusInsert;
import br.com.mind5.business.orderItem.model.action.OrderemVisiDaoUpdate;
import br.com.mind5.business.orderItem.model.action.OrderemVisiMergeCusarch;
import br.com.mind5.business.orderItem.model.checker.OrderemCheckCusarch;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class OrderemNodeCus extends DeciTreeTemplateWrite<OrderemInfo> {
	
	public OrderemNodeCus(DeciTreeOption<OrderemInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<OrderemInfo> buildCheckerHook(DeciTreeOption<OrderemInfo> option) {
		List<ModelChecker<OrderemInfo>> queue = new ArrayList<>();		
		ModelChecker<OrderemInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new OrderemCheckCusarch(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<OrderemInfo>> buildActionsOnPassedHook(DeciTreeOption<OrderemInfo> option) {
		List<ActionStd<OrderemInfo>> actions = new ArrayList<>();

		ActionStd<OrderemInfo> mergeCusarch = new ActionStdCommom<OrderemInfo>(option, OrderemVisiMergeCusarch.class);
		ActionLazy<OrderemInfo> update = new ActionLazyCommom<OrderemInfo>(option, OrderemVisiDaoUpdate.class);
		
		mergeCusarch.addPostAction(update);
		
		actions.add(mergeCusarch);
		return actions;
	}
	
	
	
	@Override protected List<ActionStd<OrderemInfo>> buildActionsOnFailedHook(DeciTreeOption<OrderemInfo> option) {
		List<ActionStd<OrderemInfo>> actions = new ArrayList<>();

		ActionStd<OrderemInfo> insertCus = new ActionStdCommom<OrderemInfo>(option, OrderemVisiCusInsert.class);
		ActionLazy<OrderemInfo> update = new ActionLazyCommom<OrderemInfo>(option, OrderemVisiDaoUpdate.class);
		
		insertCus.addPostAction(update);
		
		actions.add(insertCus);
		return actions;
	}
}
