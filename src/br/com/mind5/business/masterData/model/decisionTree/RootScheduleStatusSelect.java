package br.com.mind5.business.masterData.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.masterData.info.ScheduleStatusInfo;
import br.com.mind5.business.masterData.model.action.StdScheduleStatusSelect;
import br.com.mind5.business.masterData.model.checker.ScheduleStatusCheckRead;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;

public final class RootScheduleStatusSelect extends DeciTreeTemplateRead<ScheduleStatusInfo> {
	
	public RootScheduleStatusSelect(DeciTreeOption<ScheduleStatusInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<ScheduleStatusInfo> buildCheckerHook(DeciTreeOption<ScheduleStatusInfo> option) {
		List<ModelCheckerV1<ScheduleStatusInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<ScheduleStatusInfo> checker;
		ModelCheckerOption checkerOption;	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new ScheduleStatusCheckRead(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}

		
	
	@Override protected List<ActionStdV1<ScheduleStatusInfo>> buildActionsOnPassedHook(DeciTreeOption<ScheduleStatusInfo> option) {
		List<ActionStdV1<ScheduleStatusInfo>> actions = new ArrayList<>();
		
		ActionStdV1<ScheduleStatusInfo> select = new StdScheduleStatusSelect(option);
		
		actions.add(select);
		return actions;
	}
}
