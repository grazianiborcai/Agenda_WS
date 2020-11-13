package br.com.mind5.business.orderItem.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.orderItem.info.OrderemInfo;
import br.com.mind5.business.orderItem.model.action.LazyOrderemNodeUpdate;
import br.com.mind5.business.orderItem.model.action.LazyOrderemSchedineRefresh;
import br.com.mind5.business.orderItem.model.action.StdOrderemMergeOrdugeCancel;
import br.com.mind5.business.orderItem.model.action.StdOrderemSuccess;
import br.com.mind5.business.orderItem.model.checker.OrderemCheckIsCancelled;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWriteV2;

public final class NodeOrderemCancel extends DeciTreeTemplateWriteV2<OrderemInfo> {
	
	public NodeOrderemCancel(DeciTreeOption<OrderemInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<OrderemInfo> buildCheckerHook(DeciTreeOption<OrderemInfo> option) {
		List<ModelCheckerV1<OrderemInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<OrderemInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new OrderemCheckIsCancelled(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<OrderemInfo>> buildActionsOnPassedHook(DeciTreeOption<OrderemInfo> option) {
		List<ActionStdV1<OrderemInfo>> actions = new ArrayList<>();
		
		ActionStdV1<OrderemInfo> success = new StdOrderemSuccess(option);
		
		actions.add(success);
		return actions;
	}
	
	
	
	@Override protected List<ActionStdV1<OrderemInfo>> buildActionsOnFailedHook(DeciTreeOption<OrderemInfo> option) {
		List<ActionStdV1<OrderemInfo>> actions = new ArrayList<>();
		
		ActionStdV1<OrderemInfo> statusChange = new StdOrderemMergeOrdugeCancel(option);
		ActionLazy<OrderemInfo> update = new LazyOrderemNodeUpdate(option.conn, option.schemaName);	
		ActionLazy<OrderemInfo> refreshSchedine = new LazyOrderemSchedineRefresh(option.conn, option.schemaName);			
		
		statusChange.addPostAction(update);		
		update.addPostAction(refreshSchedine);
		
		actions.add(statusChange);
		return actions;
	}
}
