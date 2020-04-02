package br.com.mind5.business.order.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.order.info.OrderInfo;
import br.com.mind5.business.order.model.action.LazyOrderNodeCancelL1;
import br.com.mind5.business.order.model.action.LazyOrderRefreshSchedine;
import br.com.mind5.business.order.model.action.LazyOrderRootSelect;
import br.com.mind5.business.order.model.action.StdOrderMergeToSelect;
import br.com.mind5.business.order.model.checker.OrderCheckExist;
import br.com.mind5.business.order.model.checker.OrderCheckLangu;
import br.com.mind5.business.order.model.checker.OrderCheckOwner;
import br.com.mind5.business.order.model.checker.OrderCheckWrite;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeWriteTemplate;

public final class RootOrderCancel extends DeciTreeWriteTemplate<OrderInfo> {
	
	public RootOrderCancel(DeciTreeOption<OrderInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<OrderInfo> buildDecisionCheckerHook(DeciTreeOption<OrderInfo> option) {
		List<ModelChecker<OrderInfo>> queue = new ArrayList<>();		
		ModelChecker<OrderInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new OrderCheckWrite(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new OrderCheckLangu(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new OrderCheckOwner(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new OrderCheckExist(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<OrderInfo>> buildActionsOnPassedHook(DeciTreeOption<OrderInfo> option) {
		List<ActionStdV1<OrderInfo>> actions = new ArrayList<>();
		
		ActionStdV1<OrderInfo> select = new StdOrderMergeToSelect(option);
		ActionLazyV1<OrderInfo> nodeCancel = new LazyOrderNodeCancelL1(option.conn, option.schemaName);
		ActionLazyV1<OrderInfo> refreshSchedine = new LazyOrderRefreshSchedine(option.conn, option.schemaName);
		ActionLazyV1<OrderInfo> rootSelect = new LazyOrderRootSelect(option.conn, option.schemaName);		
		
		select.addPostAction(nodeCancel);		
		nodeCancel.addPostAction(refreshSchedine);
		refreshSchedine.addPostAction(rootSelect);
		
		actions.add(select);
		return actions;
	}
}
