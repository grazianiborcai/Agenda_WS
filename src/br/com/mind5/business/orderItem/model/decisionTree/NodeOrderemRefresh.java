package br.com.mind5.business.orderItem.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.orderItem.info.OrderemInfo;
import br.com.mind5.business.orderItem.model.action.LazyOrderemMergeOrdugePartner;
import br.com.mind5.business.orderItem.model.action.LazyOrderemNodeUpdate;
import br.com.mind5.business.orderItem.model.action.LazyOrderemSchedineRefresh;
import br.com.mind5.business.orderItem.model.action.StdOrderemMergePayordem;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.common.ModelCheckerDummy;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWriteV2;

public final class NodeOrderemRefresh extends DeciTreeTemplateWriteV2<OrderemInfo> {
	
	public NodeOrderemRefresh(DeciTreeOption<OrderemInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<OrderemInfo> buildCheckerHook(DeciTreeOption<OrderemInfo> option) {
		List<ModelCheckerV1<OrderemInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<OrderemInfo> checker;
		
		checker = new ModelCheckerDummy<>();
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<OrderemInfo>> buildActionsOnPassedHook(DeciTreeOption<OrderemInfo> option) {
		List<ActionStdV1<OrderemInfo>> actions = new ArrayList<>();

		ActionStdV1<OrderemInfo> nodePayordem = new StdOrderemMergePayordem(option);
		ActionLazy<OrderemInfo> statusChange = new LazyOrderemMergeOrdugePartner(option.conn, option.schemaName);
		ActionLazy<OrderemInfo> nodeUpdate = new LazyOrderemNodeUpdate(option.conn, option.schemaName);
		ActionLazy<OrderemInfo> refreshSchedine = new LazyOrderemSchedineRefresh(option.conn, option.schemaName);
		
		nodePayordem.addPostAction(statusChange);
		statusChange.addPostAction(nodeUpdate);
		nodeUpdate.addPostAction(refreshSchedine);
		
		actions.add(nodePayordem);
		return actions;
	}
}
