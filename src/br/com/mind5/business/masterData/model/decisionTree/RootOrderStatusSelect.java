package br.com.mind5.business.masterData.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.masterData.info.OrderStatusInfo;
import br.com.mind5.business.masterData.model.action.StdOrderStatusSelect;
import br.com.mind5.business.masterData.model.checker.OrderStatusCheckRead;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateReadV1;

public final class RootOrderStatusSelect extends DeciTreeTemplateReadV1<OrderStatusInfo> {
	
	public RootOrderStatusSelect(DeciTreeOption<OrderStatusInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<OrderStatusInfo> buildCheckerHook(DeciTreeOption<OrderStatusInfo> option) {
		List<ModelCheckerV1<OrderStatusInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<OrderStatusInfo> checker;
		ModelCheckerOption checkerOption;	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new OrderStatusCheckRead(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}

		
	
	@Override protected List<ActionStdV1<OrderStatusInfo>> buildActionsOnPassedHook(DeciTreeOption<OrderStatusInfo> option) {
		List<ActionStdV1<OrderStatusInfo>> actions = new ArrayList<>();
		
		ActionStdV1<OrderStatusInfo> select = new StdOrderStatusSelect(option);
		
		actions.add(select);
		return actions;
	}
}
