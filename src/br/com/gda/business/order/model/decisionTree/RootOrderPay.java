package br.com.gda.business.order.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.order.info.OrderInfo;
import br.com.gda.business.order.model.checker.OrderCheckLangu;
import br.com.gda.business.order.model.checker.OrderCheckOwner;
import br.com.gda.business.order.model.checker.OrderCheckWrite;
import br.com.gda.business.order.model.action.LazyOrderNodePay;
import br.com.gda.business.order.model.action.LazyOrderRootSelect;
import br.com.gda.business.order.model.action.StdOrderMergeToUpdate;
import br.com.gda.business.order.model.checker.OrderCheckExist;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.model.decisionTree.DeciTreeWriteTemplate;

public final class RootOrderPay extends DeciTreeWriteTemplate<OrderInfo> {
	
	public RootOrderPay(DeciTreeOption<OrderInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<OrderInfo> buildDecisionCheckerHook(DeciTreeOption<OrderInfo> option) {
		final boolean EXIST_ON_DB = true;
		
		List<ModelChecker<OrderInfo>> queue = new ArrayList<>();		
		ModelChecker<OrderInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checker = new OrderCheckWrite();
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
		checker = new OrderCheckExist(checkerOption);
		queue.add(checker);
		//TODO: verificar Address e Phone
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<OrderInfo>> buildActionsOnPassedHook(DeciTreeOption<OrderInfo> option) {
		List<ActionStd<OrderInfo>> actions = new ArrayList<>();
		
		ActionStd<OrderInfo> select = new StdOrderMergeToUpdate(option);
		ActionLazy<OrderInfo> nodePay = new LazyOrderNodePay(option.conn, option.schemaName);		
		ActionLazy<OrderInfo> rootSelect = new LazyOrderRootSelect(option.conn, option.schemaName);	
		
		select.addPostAction(nodePay);
		nodePay.addPostAction(rootSelect);
		
		actions.add(select);
		return actions;
	}
}
