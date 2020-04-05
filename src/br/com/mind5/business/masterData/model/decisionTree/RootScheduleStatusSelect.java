package br.com.mind5.business.masterData.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.masterData.info.ScheduleStatusInfo;
import br.com.mind5.business.masterData.model.action.StdScheduleStatusSelect;
import br.com.mind5.business.masterData.model.checker.ScheduleStatusCheckRead;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeReadTemplate;

public final class RootScheduleStatusSelect extends DeciTreeReadTemplate<ScheduleStatusInfo> {
	
	public RootScheduleStatusSelect(DeciTreeOption<ScheduleStatusInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<ScheduleStatusInfo> buildCheckerHook(DeciTreeOption<ScheduleStatusInfo> option) {
		List<ModelChecker<ScheduleStatusInfo>> queue = new ArrayList<>();		
		ModelChecker<ScheduleStatusInfo> checker;
		ModelCheckerOption checkerOption;	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new ScheduleStatusCheckRead(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}

		
	
	@Override protected List<ActionStdV1<ScheduleStatusInfo>> buildActionsOnPassedHook(DeciTreeOption<ScheduleStatusInfo> option) {
		List<ActionStdV1<ScheduleStatusInfo>> actions = new ArrayList<>();
		
		ActionStdV1<ScheduleStatusInfo> select = new StdScheduleStatusSelect(option);
		
		actions.add(select);
		return actions;
	}
}
