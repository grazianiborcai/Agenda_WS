package br.com.mind5.business.order.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.order.info.OrderInfo;
import br.com.mind5.business.order.model.action.StdOrderMergeRefugroup;
import br.com.mind5.business.order.model.action.StdOrderMergeRefupown;
import br.com.mind5.business.order.model.checker.OrderCheckHasRefugroup;
import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWriteV2;

public final class NodeOrderRefugroupL1 extends DeciTreeTemplateWriteV2<OrderInfo> {
	
	public NodeOrderRefugroupL1(DeciTreeOption<OrderInfo> option) {
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
		checker = new OrderCheckHasRefugroup(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV2<OrderInfo>> buildActionsOnPassedHook(DeciTreeOption<OrderInfo> option) {
		List<ActionStdV2<OrderInfo>> actions = new ArrayList<>();		

		ActionStdV2<OrderInfo> mergeRefugroup = new StdOrderMergeRefugroup(option);
		
		actions.add(mergeRefugroup);
		return actions;
	}
	
	
	
	@Override protected List<ActionStdV2<OrderInfo>> buildActionsOnFailedHook(DeciTreeOption<OrderInfo> option) {
		List<ActionStdV2<OrderInfo>> actions = new ArrayList<>();		

		ActionStdV2<OrderInfo> mergeRefupown = new StdOrderMergeRefupown(option);
		
		actions.add(mergeRefupown);
		return actions;
	}
}
