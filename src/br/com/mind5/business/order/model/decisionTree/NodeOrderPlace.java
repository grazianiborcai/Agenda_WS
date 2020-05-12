package br.com.mind5.business.order.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.order.info.OrderInfo;
import br.com.mind5.business.order.model.action.LazyOrderMergeOrderem;
import br.com.mind5.business.order.model.action.LazyOrderNodeUpdate;
import br.com.mind5.business.order.model.action.LazyOrderOrderemPlace;
import br.com.mind5.business.order.model.action.StdOrderMergeOrdugePlace;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.common.ModelCheckerDummy;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWriteV2;

public final class NodeOrderPlace extends DeciTreeTemplateWriteV2<OrderInfo> {
	
	public NodeOrderPlace(DeciTreeOption<OrderInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<OrderInfo> buildCheckerHook(DeciTreeOption<OrderInfo> option) {
		List<ModelCheckerV1<OrderInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<OrderInfo> checker;	

		checker = new ModelCheckerDummy<>();
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<OrderInfo>> buildActionsOnPassedHook(DeciTreeOption<OrderInfo> option) {
		List<ActionStdV1<OrderInfo>> actions = new ArrayList<>();
		
		ActionStdV1<OrderInfo> enforceStatus = new StdOrderMergeOrdugePlace(option);
		ActionLazyV1<OrderInfo> update = new LazyOrderNodeUpdate(option.conn, option.schemaName);
		ActionLazyV1<OrderInfo> mergeOrderem = new LazyOrderMergeOrderem(option.conn, option.schemaName);
		ActionLazyV1<OrderInfo> placeOrderem = new LazyOrderOrderemPlace(option.conn, option.schemaName);
		
		enforceStatus.addPostAction(update);
		update.addPostAction(mergeOrderem);
		mergeOrderem.addPostAction(placeOrderem);
		
		actions.add(enforceStatus);
		return actions;
	}
}
