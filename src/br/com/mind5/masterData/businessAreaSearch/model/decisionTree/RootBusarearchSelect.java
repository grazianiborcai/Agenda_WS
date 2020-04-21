package br.com.mind5.masterData.businessAreaSearch.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.masterData.businessAreaSearch.info.BusarearchInfo;
import br.com.mind5.masterData.businessAreaSearch.model.action.StdBusarearchDaoSelect;
import br.com.mind5.masterData.businessAreaSearch.model.checker.BusarearchCheckRead;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateReadV2;

public final class RootBusarearchSelect extends DeciTreeTemplateReadV2<BusarearchInfo> {
	
	public RootBusarearchSelect(DeciTreeOption<BusarearchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<BusarearchInfo> buildCheckerHook(DeciTreeOption<BusarearchInfo> option) {
		List<ModelCheckerV1<BusarearchInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<BusarearchInfo> checker;
		ModelCheckerOption checkerOption;	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new BusarearchCheckRead(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}

		
	
	@Override protected List<ActionStdV1<BusarearchInfo>> buildActionsOnPassedHook(DeciTreeOption<BusarearchInfo> option) {
		List<ActionStdV1<BusarearchInfo>> actions = new ArrayList<>();
		
		ActionStdV1<BusarearchInfo> select = new StdBusarearchDaoSelect(option);
		
		actions.add(select);
		return actions;
	}
}
