package br.com.mind5.masterData.orderStatus.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.masterData.orderStatus.info.OrderatusInfo;
import br.com.mind5.masterData.orderStatus.model.action.OrderatusVisiDaoSelect;
import br.com.mind5.masterData.orderStatus.model.checker.OrderatusCheckRead;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;

public final class OrderatusRootSelect extends DeciTreeTemplateRead<OrderatusInfo> {
	
	public OrderatusRootSelect(DeciTreeOption<OrderatusInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<OrderatusInfo> buildCheckerHook(DeciTreeOption<OrderatusInfo> option) {
		List<ModelChecker<OrderatusInfo>> queue = new ArrayList<>();		
		ModelChecker<OrderatusInfo> checker;
		ModelCheckerOption checkerOption;	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new OrderatusCheckRead(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}

		
	
	@Override protected List<ActionStd<OrderatusInfo>> buildActionsOnPassedHook(DeciTreeOption<OrderatusInfo> option) {
		List<ActionStd<OrderatusInfo>> actions = new ArrayList<>();
		
		ActionStd<OrderatusInfo> select = new ActionStdCommom<OrderatusInfo>(option, OrderatusVisiDaoSelect.class);
		
		actions.add(select);
		return actions;
	}
}
