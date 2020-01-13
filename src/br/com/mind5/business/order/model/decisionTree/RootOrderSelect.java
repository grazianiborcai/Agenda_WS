package br.com.mind5.business.order.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.order.info.OrderInfo;
import br.com.mind5.business.order.model.action.LazyOrderEnforceCurrency;
import br.com.mind5.business.order.model.action.LazyOrderEnforceFeeCateg;
import br.com.mind5.business.order.model.action.LazyOrderMergeCurrency;
import br.com.mind5.business.order.model.action.LazyOrderMergeFeeCateg;
import br.com.mind5.business.order.model.action.LazyOrderMergeOrderStatus;
import br.com.mind5.business.order.model.action.LazyOrderMergeOrderem;
import br.com.mind5.business.order.model.action.LazyOrderNodePayord;
import br.com.mind5.business.order.model.action.StdOrderMergeToSelect;
import br.com.mind5.business.order.model.checker.OrderCheckLangu;
import br.com.mind5.business.order.model.checker.OrderCheckRead;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeReadTemplate;

public final class RootOrderSelect extends DeciTreeReadTemplate<OrderInfo> {
	
	public RootOrderSelect(DeciTreeOption<OrderInfo> option) {
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
		checker = new OrderCheckRead(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new OrderCheckLangu(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<OrderInfo>> buildActionsOnPassedHook(DeciTreeOption<OrderInfo> option) {
		List<ActionStd<OrderInfo>> actions = new ArrayList<>();		
		
		ActionStd<OrderInfo> select = new StdOrderMergeToSelect(option);
		ActionLazy<OrderInfo> mergeItem = new LazyOrderMergeOrderem(option.conn, option.schemaName);
		ActionLazy<OrderInfo> enforceCurrency = new LazyOrderEnforceCurrency(option.conn, option.schemaName);
		ActionLazy<OrderInfo> mergeCurrency = new LazyOrderMergeCurrency(option.conn, option.schemaName);
		ActionLazy<OrderInfo> mergeOrderStatus = new LazyOrderMergeOrderStatus(option.conn, option.schemaName);
		ActionLazy<OrderInfo> enforceFeeCateg = new LazyOrderEnforceFeeCateg(option.conn, option.schemaName);
		ActionLazy<OrderInfo> mergeFeeCateg = new LazyOrderMergeFeeCateg(option.conn, option.schemaName);
		ActionLazy<OrderInfo> nodePayord = new LazyOrderNodePayord(option.conn, option.schemaName);
		
		select.addPostAction(mergeItem);
		mergeItem.addPostAction(enforceCurrency);
		enforceCurrency.addPostAction(mergeCurrency);
		mergeCurrency.addPostAction(mergeOrderStatus);
		mergeOrderStatus.addPostAction(enforceFeeCateg);
		enforceFeeCateg.addPostAction(mergeFeeCateg);
		mergeFeeCateg.addPostAction(nodePayord);
		
		actions.add(select);			
		return actions;
	}
}
