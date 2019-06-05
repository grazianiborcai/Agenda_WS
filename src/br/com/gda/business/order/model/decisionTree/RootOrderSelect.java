package br.com.gda.business.order.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.order.info.OrderInfo;
import br.com.gda.business.order.model.action.LazyOrderEnforceCurrency;
import br.com.gda.business.order.model.action.LazyOrderMergeOrderem;
import br.com.gda.business.order.model.action.LazyOrderMergeCurrency;
import br.com.gda.business.order.model.action.LazyOrderMergeOrderStatus;
import br.com.gda.business.order.model.action.LazyOrderMergeToSelect;
import br.com.gda.business.order.model.action.StdOrderMergeUsername;
import br.com.gda.business.order.model.checker.OrderCheckLangu;
import br.com.gda.business.order.model.checker.OrderCheckRead;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.model.decisionTree.DeciTreeReadTemplate;

public final class RootOrderSelect extends DeciTreeReadTemplate<OrderInfo> {
	
	public RootOrderSelect(DeciTreeOption<OrderInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<OrderInfo> buildDecisionCheckerHook(DeciTreeOption<OrderInfo> option) {
		final boolean EXIST_ON_DB = true;
		
		List<ModelChecker<OrderInfo>> queue = new ArrayList<>();		
		ModelChecker<OrderInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checker = new OrderCheckRead();
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;	
		checker = new OrderCheckLangu(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<OrderInfo>> buildActionsOnPassedHook(DeciTreeOption<OrderInfo> option) {
		List<ActionStd<OrderInfo>> actions = new ArrayList<>();		
		
		ActionStd<OrderInfo> mergeUser = new StdOrderMergeUsername(option);
		ActionLazy<OrderInfo> select = new LazyOrderMergeToSelect(option.conn, option.schemaName);
		ActionLazy<OrderInfo> mergeItem = new LazyOrderMergeOrderem(option.conn, option.schemaName);
		ActionLazy<OrderInfo> enforceCurrency = new LazyOrderEnforceCurrency(option.conn, option.schemaName);
		ActionLazy<OrderInfo> mergeCurrency = new LazyOrderMergeCurrency(option.conn, option.schemaName);
		ActionLazy<OrderInfo> mergeOrderStatus = new LazyOrderMergeOrderStatus(option.conn, option.schemaName);
		
		mergeUser.addPostAction(select);
		select.addPostAction(mergeItem);
		mergeItem.addPostAction(enforceCurrency);
		enforceCurrency.addPostAction(mergeCurrency);
		mergeCurrency.addPostAction(mergeOrderStatus);
		
		actions.add(mergeUser);			
		return actions;
	}
}
