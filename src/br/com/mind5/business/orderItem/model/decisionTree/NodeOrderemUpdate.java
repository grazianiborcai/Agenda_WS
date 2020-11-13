package br.com.mind5.business.orderItem.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.orderItem.info.OrderemInfo;
import br.com.mind5.business.orderItem.model.action.LazyOrderemEnforceLChanged;
import br.com.mind5.business.orderItem.model.action.LazyOrderemNodeSnapshot;
import br.com.mind5.business.orderItem.model.action.StdOrderemMergeUsername;
import br.com.mind5.business.orderItem.model.checker.OrderemCheckWrite;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWriteV2;

public final class NodeOrderemUpdate extends DeciTreeTemplateWriteV2<OrderemInfo> {
	
	public NodeOrderemUpdate(DeciTreeOption<OrderemInfo> option) {
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
		checker = new OrderemCheckWrite(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV2<OrderemInfo>> buildActionsOnPassedHook(DeciTreeOption<OrderemInfo> option) {
		List<ActionStdV2<OrderemInfo>> actions = new ArrayList<>();

		ActionStdV2<OrderemInfo> mergeUsername = new StdOrderemMergeUsername(option);
		ActionLazy<OrderemInfo> enforceLChanged = new LazyOrderemEnforceLChanged(option.conn, option.schemaName);
		ActionLazy<OrderemInfo> snapshot = new LazyOrderemNodeSnapshot(option.conn, option.schemaName);
		
		mergeUsername.addPostAction(enforceLChanged);
		enforceLChanged.addPostAction(snapshot);
		
		actions.add(mergeUsername);
		return actions;
	}
}
