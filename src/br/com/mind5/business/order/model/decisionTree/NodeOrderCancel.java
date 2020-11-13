package br.com.mind5.business.order.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.order.info.OrderInfo;
import br.com.mind5.business.order.model.action.LazyOrderMergeOrderem;
import br.com.mind5.business.order.model.action.LazyOrderNodeUpdate;
import br.com.mind5.business.order.model.action.LazyOrderOrderemCancel;
import br.com.mind5.business.order.model.action.StdOrderMargeOrdugeCancel;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.common.ModelCheckerDummy;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWriteV2;

public final class NodeOrderCancel extends DeciTreeTemplateWriteV2<OrderInfo> {
	
	public NodeOrderCancel(DeciTreeOption<OrderInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<OrderInfo> buildCheckerHook(DeciTreeOption<OrderInfo> option) {
		List<ModelCheckerV1<OrderInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<OrderInfo> checker;	

		checker = new ModelCheckerDummy<>();
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV2<OrderInfo>> buildActionsOnPassedHook(DeciTreeOption<OrderInfo> option) {
		List<ActionStdV2<OrderInfo>> actions = new ArrayList<>();
		
		ActionStdV2<OrderInfo> statusChange = new StdOrderMargeOrdugeCancel(option);
		ActionLazy<OrderInfo> update = new LazyOrderNodeUpdate(option.conn, option.schemaName);
		ActionLazy<OrderInfo> mergeOrderem = new LazyOrderMergeOrderem(option.conn, option.schemaName);
		ActionLazy<OrderInfo> orderemCancel = new LazyOrderOrderemCancel(option.conn, option.schemaName);
		
		statusChange.addPostAction(update);
		update.addPostAction(mergeOrderem);
		mergeOrderem.addPostAction(orderemCancel);
		
		actions.add(statusChange);
		return actions;
	}
}
