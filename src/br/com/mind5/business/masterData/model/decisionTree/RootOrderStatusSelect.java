package br.com.mind5.business.masterData.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.masterData.info.OrderStatusInfo;
import br.com.mind5.business.masterData.model.action.StdOrderStatusSelect;
import br.com.mind5.business.masterData.model.checker.OrderStatusCheckRead;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeReadTemplate;

public final class RootOrderStatusSelect extends DeciTreeReadTemplate<OrderStatusInfo> {
	
	public RootOrderStatusSelect(DeciTreeOption<OrderStatusInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<OrderStatusInfo> buildDecisionCheckerHook(DeciTreeOption<OrderStatusInfo> option) {
		List<ModelChecker<OrderStatusInfo>> queue = new ArrayList<>();		
		ModelChecker<OrderStatusInfo> checker;
		ModelCheckerOption checkerOption;	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new OrderStatusCheckRead(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}

		
	
	@Override protected List<ActionStdV1<OrderStatusInfo>> buildActionsOnPassedHook(DeciTreeOption<OrderStatusInfo> option) {
		List<ActionStdV1<OrderStatusInfo>> actions = new ArrayList<>();
		
		ActionStdV1<OrderStatusInfo> select = new StdOrderStatusSelect(option);
		
		actions.add(select);
		return actions;
	}
}
