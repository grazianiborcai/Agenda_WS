package br.com.mind5.masterData.timezoneSearch.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.masterData.timezoneSearch.info.TimezonarchInfo;
import br.com.mind5.masterData.timezoneSearch.model.action.StdTimezonarchDaoSelect;
import br.com.mind5.masterData.timezoneSearch.model.checker.TimezonarchCheckRead;
import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateReadV2;

public final class RootTimezonarchSelect extends DeciTreeTemplateReadV2<TimezonarchInfo> {
	
	public RootTimezonarchSelect(DeciTreeOption<TimezonarchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<TimezonarchInfo> buildCheckerHook(DeciTreeOption<TimezonarchInfo> option) {
		List<ModelCheckerV1<TimezonarchInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<TimezonarchInfo> checker;
		ModelCheckerOption checkerOption;	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new TimezonarchCheckRead(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}

		
	
	@Override protected List<ActionStdV2<TimezonarchInfo>> buildActionsOnPassedHook(DeciTreeOption<TimezonarchInfo> option) {
		List<ActionStdV2<TimezonarchInfo>> actions = new ArrayList<>();
		
		ActionStdV2<TimezonarchInfo> select = new StdTimezonarchDaoSelect(option);
		
		actions.add(select);
		return actions;
	}
}
