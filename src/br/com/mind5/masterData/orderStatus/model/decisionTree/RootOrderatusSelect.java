package br.com.mind5.masterData.orderStatus.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.masterData.orderStatus.info.OrderatusInfo;
import br.com.mind5.masterData.orderStatus.model.action.StdOrderatusDaoSelect;
import br.com.mind5.masterData.orderStatus.model.checker.OrderatusCheckRead;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateReadV2;

public final class RootOrderatusSelect extends DeciTreeTemplateReadV2<OrderatusInfo> {
	
	public RootOrderatusSelect(DeciTreeOption<OrderatusInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<OrderatusInfo> buildCheckerHook(DeciTreeOption<OrderatusInfo> option) {
		List<ModelCheckerV1<OrderatusInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<OrderatusInfo> checker;
		ModelCheckerOption checkerOption;	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new OrderatusCheckRead(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}

		
	
	@Override protected List<ActionStdV1<OrderatusInfo>> buildActionsOnPassedHook(DeciTreeOption<OrderatusInfo> option) {
		List<ActionStdV1<OrderatusInfo>> actions = new ArrayList<>();
		
		ActionStdV1<OrderatusInfo> select = new StdOrderatusDaoSelect(option);
		
		actions.add(select);
		return actions;
	}
}
