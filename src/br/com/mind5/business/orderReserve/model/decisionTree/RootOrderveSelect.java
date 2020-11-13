package br.com.mind5.business.orderReserve.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.orderReserve.info.OrderveInfo;
import br.com.mind5.business.orderReserve.model.action.LazyOrderveMergeToSelect;
import br.com.mind5.business.orderReserve.model.action.StdOrderveEnforceCancelled;
import br.com.mind5.business.orderReserve.model.checker.OrderveCheckRead;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateReadV2;

public final class RootOrderveSelect extends DeciTreeTemplateReadV2<OrderveInfo> {
	
	public RootOrderveSelect(DeciTreeOption<OrderveInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<OrderveInfo> buildCheckerHook(DeciTreeOption<OrderveInfo> option) {
		List<ModelCheckerV1<OrderveInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<OrderveInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new OrderveCheckRead(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<OrderveInfo>> buildActionsOnPassedHook(DeciTreeOption<OrderveInfo> option) {
		List<ActionStdV1<OrderveInfo>> actions = new ArrayList<>();	
		
		ActionStdV1<OrderveInfo> enforceStatus = new StdOrderveEnforceCancelled(option);
		ActionLazy<OrderveInfo> select = new LazyOrderveMergeToSelect(option.conn, option.schemaName);
		
		enforceStatus.addPostAction(select);
		
		actions.add(enforceStatus);
		return actions;
	}
}
