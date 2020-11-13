package br.com.mind5.business.order.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.order.info.OrderInfo;
import br.com.mind5.business.order.model.action.StdOrderCusInsert;
import br.com.mind5.business.order.model.action.StdOrderMergeCusarch;
import br.com.mind5.business.order.model.checker.OrderCheckCusarch;
import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWriteV2;

public final class NodeOrderCusL2 extends DeciTreeTemplateWriteV2<OrderInfo> {
	
	public NodeOrderCusL2(DeciTreeOption<OrderInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<OrderInfo> buildCheckerHook(DeciTreeOption<OrderInfo> option) {
		List<ModelCheckerV1<OrderInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<OrderInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new OrderCheckCusarch(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV2<OrderInfo>> buildActionsOnPassedHook(DeciTreeOption<OrderInfo> option) {
		List<ActionStdV2<OrderInfo>> actions = new ArrayList<>();

		ActionStdV2<OrderInfo> mergeCusarch = new StdOrderMergeCusarch(option);
		
		actions.add(mergeCusarch);
		return actions;
	}
	
	
	
	@Override protected List<ActionStdV2<OrderInfo>> buildActionsOnFailedHook(DeciTreeOption<OrderInfo> option) {
		List<ActionStdV2<OrderInfo>> actions = new ArrayList<>();

		ActionStdV2<OrderInfo> insertCus = new StdOrderCusInsert(option);
		
		actions.add(insertCus);
		return actions;
	}
}
