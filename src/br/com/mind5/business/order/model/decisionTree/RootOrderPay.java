package br.com.mind5.business.order.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.order.info.OrderInfo;
import br.com.mind5.business.order.model.action.LazyOrderNodePay;
import br.com.mind5.business.order.model.action.LazyOrderRootSelect;
import br.com.mind5.business.order.model.action.StdOrderMergeToUpdate;
import br.com.mind5.business.order.model.checker.OrderCheckExist;
import br.com.mind5.business.order.model.checker.OrderCheckLangu;
import br.com.mind5.business.order.model.checker.OrderCheckOwner;
import br.com.mind5.business.order.model.checker.OrderCheckWrite;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class RootOrderPay extends DeciTreeTemplateWrite<OrderInfo> {
	
	public RootOrderPay(DeciTreeOption<OrderInfo> option) {
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
		//TODO: verificar Address e Phone
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<OrderInfo>> buildActionsOnPassedHook(DeciTreeOption<OrderInfo> option) {
		List<ActionStd<OrderInfo>> actions = new ArrayList<>();
		
		ActionStd<OrderInfo> mergeToUpdate = new StdOrderMergeToUpdate(option);
		ActionLazy<OrderInfo> nodePay = new LazyOrderNodePay(option.conn, option.schemaName);		
		ActionLazy<OrderInfo> select = new LazyOrderRootSelect(option.conn, option.schemaName);	
		
		mergeToUpdate.addPostAction(nodePay);
		nodePay.addPostAction(select);
		
		actions.add(mergeToUpdate);
		return actions;
	}
}
