package br.com.mind5.masterData.orderStatusSearch.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.masterData.orderStatusSearch.info.OrderatarchInfo;
import br.com.mind5.masterData.orderStatusSearch.model.action.StdOrderatarchDaoSelect;
import br.com.mind5.masterData.orderStatusSearch.model.checker.OrderatarchCheckRead;
import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateReadV2;

public final class RootOrderatarchSelect extends DeciTreeTemplateReadV2<OrderatarchInfo> {
	
	public RootOrderatarchSelect(DeciTreeOption<OrderatarchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<OrderatarchInfo> buildCheckerHook(DeciTreeOption<OrderatarchInfo> option) {
		List<ModelCheckerV1<OrderatarchInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<OrderatarchInfo> checker;
		ModelCheckerOption checkerOption;	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new OrderatarchCheckRead(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}

		
	
	@Override protected List<ActionStdV2<OrderatarchInfo>> buildActionsOnPassedHook(DeciTreeOption<OrderatarchInfo> option) {
		List<ActionStdV2<OrderatarchInfo>> actions = new ArrayList<>();
		
		ActionStdV2<OrderatarchInfo> select = new StdOrderatarchDaoSelect(option);
		
		actions.add(select);
		return actions;
	}
}
