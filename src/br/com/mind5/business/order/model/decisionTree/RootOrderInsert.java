package br.com.mind5.business.order.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.order.info.OrderInfo;
import br.com.mind5.business.order.model.action.LazyOrderInsertSchedine;
import br.com.mind5.business.order.model.action.LazyOrderNodeOrderem;
import br.com.mind5.business.order.model.action.LazyOrderNodeSnapshot;
import br.com.mind5.business.order.model.checker.OrderCheckCurrency;
import br.com.mind5.business.order.model.checker.OrderCheckInsert;
import br.com.mind5.business.order.model.checker.OrderCheckLangu;
import br.com.mind5.business.order.model.checker.OrderCheckOwner;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeWriteTemplate;

public final class RootOrderInsert extends DeciTreeWriteTemplate<OrderInfo> {
	
	public RootOrderInsert(DeciTreeOption<OrderInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<OrderInfo> buildDecisionCheckerHook(DeciTreeOption<OrderInfo> option) {
		final boolean EXIST_ON_DB = true;
		
		List<ModelChecker<OrderInfo>> queue = new ArrayList<>();		
		ModelChecker<OrderInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checker = new OrderCheckInsert();
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;	
		checker = new OrderCheckLangu(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;	
		checker = new OrderCheckOwner(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;	
		checker = new OrderCheckCurrency(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<OrderInfo>> buildActionsOnPassedHook(DeciTreeOption<OrderInfo> option) {
		List<ActionStd<OrderInfo>> actions = new ArrayList<>();

		ActionStd<OrderInfo> insertOrder = new NodeOrderInsert(option).toAction();
		ActionLazy<OrderInfo> insertOrderem = new LazyOrderNodeOrderem(option.conn, option.schemaName);
		ActionLazy<OrderInfo> snapshot = new LazyOrderNodeSnapshot(option.conn, option.schemaName);
		ActionLazy<OrderInfo> insertSchedine = new LazyOrderInsertSchedine(option.conn, option.schemaName);	
		
		insertOrder.addPostAction(insertOrderem);
		insertOrderem.addPostAction(snapshot);
		snapshot.addPostAction(insertSchedine);
		
		actions.add(insertOrder);
		return actions;
	}
}
