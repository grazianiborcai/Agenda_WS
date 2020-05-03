package br.com.mind5.business.order.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.order.info.OrderInfo;
import br.com.mind5.business.order.model.action.LazyOrderEnforceCurrency;
import br.com.mind5.business.order.model.action.LazyOrderEnforceFeecat;
import br.com.mind5.business.order.model.action.LazyOrderMergeCurrency;
import br.com.mind5.business.order.model.action.LazyOrderMergeFeecat;
import br.com.mind5.business.order.model.action.LazyOrderMergeOrderatus;
import br.com.mind5.business.order.model.action.LazyOrderMergeOrderem;
import br.com.mind5.business.order.model.action.LazyOrderNodePayord;
import br.com.mind5.business.order.model.action.StdOrderMergeToSelect;
import br.com.mind5.business.order.model.checker.OrderCheckLangu;
import br.com.mind5.business.order.model.checker.OrderCheckRead;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateReadV2;

public final class RootOrderSelect extends DeciTreeTemplateReadV2<OrderInfo> {
	
	public RootOrderSelect(DeciTreeOption<OrderInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<OrderInfo> buildCheckerHook(DeciTreeOption<OrderInfo> option) {
		List<ModelCheckerV1<OrderInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<OrderInfo> checker;	
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
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<OrderInfo>> buildActionsOnPassedHook(DeciTreeOption<OrderInfo> option) {
		List<ActionStdV1<OrderInfo>> actions = new ArrayList<>();		
		
		ActionStdV1<OrderInfo> select = new StdOrderMergeToSelect(option);
		ActionLazyV1<OrderInfo> mergeItem = new LazyOrderMergeOrderem(option.conn, option.schemaName);
		ActionLazyV1<OrderInfo> enforceCurrency = new LazyOrderEnforceCurrency(option.conn, option.schemaName);
		ActionLazyV1<OrderInfo> mergeCurrency = new LazyOrderMergeCurrency(option.conn, option.schemaName);
		ActionLazyV1<OrderInfo> mergeOrderatus = new LazyOrderMergeOrderatus(option.conn, option.schemaName);
		ActionLazyV1<OrderInfo> enforceFeecat = new LazyOrderEnforceFeecat(option.conn, option.schemaName);
		ActionLazyV1<OrderInfo> mergeFeecat = new LazyOrderMergeFeecat(option.conn, option.schemaName);
		ActionLazyV1<OrderInfo> nodePayord = new LazyOrderNodePayord(option.conn, option.schemaName);
		
		select.addPostAction(mergeItem);
		mergeItem.addPostAction(enforceCurrency);
		enforceCurrency.addPostAction(mergeCurrency);
		mergeCurrency.addPostAction(mergeOrderatus);
		mergeOrderatus.addPostAction(enforceFeecat);
		enforceFeecat.addPostAction(mergeFeecat);
		mergeFeecat.addPostAction(nodePayord);
		
		actions.add(select);			
		return actions;
	}
}
