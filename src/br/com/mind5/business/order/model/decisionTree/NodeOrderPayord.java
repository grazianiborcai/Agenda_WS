package br.com.mind5.business.order.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.order.info.OrderInfo;
import br.com.mind5.business.order.model.action.LazyOrderEnforceStatusMoip;
import br.com.mind5.business.order.model.action.StdOrderMergePayord;
import br.com.mind5.business.order.model.action.StdOrderSuccess;
import br.com.mind5.business.order.model.checker.OrderCheckHasPayord;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeWriteTemplate;

public final class NodeOrderPayord extends DeciTreeWriteTemplate<OrderInfo> {
	
	public NodeOrderPayord(DeciTreeOption<OrderInfo> option) {
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
		checker = new OrderCheckHasPayord(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<OrderInfo>> buildActionsOnPassedHook(DeciTreeOption<OrderInfo> option) {
		List<ActionStdV1<OrderInfo>> actions = new ArrayList<>();		

		ActionStdV1<OrderInfo> mergePayord = new StdOrderMergePayord(option);
		ActionLazyV1<OrderInfo> enforceStatus = new LazyOrderEnforceStatusMoip(option.conn, option.schemaName);
		
		mergePayord.addPostAction(enforceStatus);
		
		actions.add(mergePayord);
		return actions;
	}
	
	
	
	@Override protected List<ActionStdV1<OrderInfo>> buildActionsOnFailedHook(DeciTreeOption<OrderInfo> option) {
		List<ActionStdV1<OrderInfo>> actions = new ArrayList<>();		

		ActionStdV1<OrderInfo> success = new StdOrderSuccess(option);
		
		actions.add(success);
		return actions;
	}
}
