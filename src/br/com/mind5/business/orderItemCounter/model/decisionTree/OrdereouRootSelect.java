package br.com.mind5.business.orderItemCounter.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.orderItemCounter.info.OrdereouInfo;
import br.com.mind5.business.orderItemCounter.model.checker.OrdereouCheckLangu;
import br.com.mind5.business.orderItemCounter.model.checker.OrdereouCheckOwner;
import br.com.mind5.business.orderItemCounter.model.checker.OrdereouCheckRead;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;

public final class OrdereouRootSelect extends DeciTreeTemplateRead<OrdereouInfo> {
	
	public OrdereouRootSelect(DeciTreeOption<OrdereouInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<OrdereouInfo> buildCheckerHook(DeciTreeOption<OrdereouInfo> option) {
		List<ModelChecker<OrdereouInfo>> queue = new ArrayList<>();		
		ModelChecker<OrdereouInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new OrdereouCheckRead(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new OrdereouCheckLangu(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new OrdereouCheckOwner(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<OrdereouInfo>> buildActionsOnPassedHook(DeciTreeOption<OrdereouInfo> option) {
		List<ActionStd<OrdereouInfo>> actions = new ArrayList<>();		
		
		ActionStd<OrdereouInfo> nodeL1 = new OrdereouNodeSelect(option).toAction();
		
		actions.add(nodeL1);	
		return actions;
	}
}
