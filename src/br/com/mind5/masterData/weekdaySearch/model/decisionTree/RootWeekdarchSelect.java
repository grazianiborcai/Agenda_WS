package br.com.mind5.masterData.weekdaySearch.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.masterData.weekdaySearch.info.WeekdarchInfo;
import br.com.mind5.masterData.weekdaySearch.model.action.StdWeekdarchDaoSelect;
import br.com.mind5.masterData.weekdaySearch.model.checker.WeekdarchCheckRead;
import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateReadV2;

public final class RootWeekdarchSelect extends DeciTreeTemplateReadV2<WeekdarchInfo> {
	
	public RootWeekdarchSelect(DeciTreeOption<WeekdarchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<WeekdarchInfo> buildCheckerHook(DeciTreeOption<WeekdarchInfo> option) {
		List<ModelCheckerV1<WeekdarchInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<WeekdarchInfo> checker;
		ModelCheckerOption checkerOption;	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new WeekdarchCheckRead(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}

		
	
	@Override protected List<ActionStdV2<WeekdarchInfo>> buildActionsOnPassedHook(DeciTreeOption<WeekdarchInfo> option) {
		List<ActionStdV2<WeekdarchInfo>> actions = new ArrayList<>();
		
		ActionStdV2<WeekdarchInfo> select = new StdWeekdarchDaoSelect(option);
		
		actions.add(select);
		return actions;
	}
}
