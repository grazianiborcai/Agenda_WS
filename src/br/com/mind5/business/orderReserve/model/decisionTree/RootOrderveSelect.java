package br.com.mind5.business.orderReserve.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.orderReserve.info.OrderveInfo;
import br.com.mind5.business.orderReserve.model.action.LazyOrderveMergeToSelect;
import br.com.mind5.business.orderReserve.model.action.StdOrderveEnforceCancelled;
import br.com.mind5.business.orderReserve.model.checker.OrderveCheckRead;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeReadTemplate;

public final class RootOrderveSelect extends DeciTreeReadTemplate<OrderveInfo> {
	
	public RootOrderveSelect(DeciTreeOption<OrderveInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<OrderveInfo> buildCheckerHook(DeciTreeOption<OrderveInfo> option) {
		List<ModelChecker<OrderveInfo>> queue = new ArrayList<>();		
		ModelChecker<OrderveInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new OrderveCheckRead(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<OrderveInfo>> buildActionsOnPassedHook(DeciTreeOption<OrderveInfo> option) {
		List<ActionStdV1<OrderveInfo>> actions = new ArrayList<>();	
		
		ActionStdV1<OrderveInfo> enforceStatus = new StdOrderveEnforceCancelled(option);
		ActionLazyV1<OrderveInfo> select = new LazyOrderveMergeToSelect(option.conn, option.schemaName);
		
		enforceStatus.addPostAction(select);
		
		actions.add(enforceStatus);
		return actions;
	}
}
