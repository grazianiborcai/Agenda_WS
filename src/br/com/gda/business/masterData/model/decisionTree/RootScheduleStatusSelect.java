package br.com.gda.business.masterData.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.masterData.info.ScheduleStatusInfo;
import br.com.gda.business.masterData.model.action.StdScheduleStatusSelect;
import br.com.gda.business.masterData.model.checker.ScheduleStatusCheckRead;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciTreeReadTemplate;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class RootScheduleStatusSelect extends DeciTreeReadTemplate<ScheduleStatusInfo> {
	
	public RootScheduleStatusSelect(DeciTreeOption<ScheduleStatusInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<ScheduleStatusInfo> buildDecisionCheckerHook(DeciTreeOption<ScheduleStatusInfo> option) {
		List<ModelChecker<ScheduleStatusInfo>> queue = new ArrayList<>();		
		ModelChecker<ScheduleStatusInfo> checker;
		
		checker = new ScheduleStatusCheckRead();
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}

		
	
	@Override protected List<ActionStd<ScheduleStatusInfo>> buildActionsOnPassedHook(DeciTreeOption<ScheduleStatusInfo> option) {
		List<ActionStd<ScheduleStatusInfo>> actions = new ArrayList<>();
		
		actions.add(new StdScheduleStatusSelect(option));
		return actions;
	}
}
