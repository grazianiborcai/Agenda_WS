package br.com.mind5.business.orderItem.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.orderItem.info.OrderemInfo;
import br.com.mind5.business.orderItem.model.action.LazyOrderemNodeUpdate;
import br.com.mind5.business.orderItem.model.action.LazyOrderemRefupolEvaluate;
import br.com.mind5.business.orderItem.model.action.LazyOrderemSchedineRefresh;
import br.com.mind5.business.orderItem.model.action.StdOrderemMergeOrdugeRefunding;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.common.ModelCheckerDummy;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWriteV2;

public final class NodeOrderemRefunding extends DeciTreeTemplateWriteV2<OrderemInfo> {
	
	public NodeOrderemRefunding(DeciTreeOption<OrderemInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<OrderemInfo> buildCheckerHook(DeciTreeOption<OrderemInfo> option) {
		List<ModelCheckerV1<OrderemInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<OrderemInfo> checker;	

		checker = new ModelCheckerDummy<>();
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV2<OrderemInfo>> buildActionsOnPassedHook(DeciTreeOption<OrderemInfo> option) {
		List<ActionStdV2<OrderemInfo>> actions = new ArrayList<>();
		
		ActionStdV2<OrderemInfo> enforceStatus = new StdOrderemMergeOrdugeRefunding(option);
		ActionLazy<OrderemInfo> refupolEvaluate = new LazyOrderemRefupolEvaluate(option.conn, option.schemaName);			
		ActionLazy<OrderemInfo> update = new LazyOrderemNodeUpdate(option.conn, option.schemaName);	
		ActionLazy<OrderemInfo> schedineRefresh = new LazyOrderemSchedineRefresh(option.conn, option.schemaName);	
		
		enforceStatus.addPostAction(refupolEvaluate);
		refupolEvaluate.addPostAction(update);
		update.addPostAction(schedineRefresh);
		
		actions.add(enforceStatus);
		return actions;
	}
}
