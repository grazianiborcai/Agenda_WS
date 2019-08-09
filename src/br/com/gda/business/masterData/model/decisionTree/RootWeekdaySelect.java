package br.com.gda.business.masterData.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.masterData.info.WeekdayInfo;
import br.com.gda.business.masterData.model.action.StdWeekdaySelect;
import br.com.gda.business.masterData.model.checker.WeekdayCheckRead;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciTreeReadTemplate;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class RootWeekdaySelect extends DeciTreeReadTemplate<WeekdayInfo> {
	
	public RootWeekdaySelect(DeciTreeOption<WeekdayInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<WeekdayInfo> buildDecisionCheckerHook(DeciTreeOption<WeekdayInfo> option) {
		List<ModelChecker<WeekdayInfo>> queue = new ArrayList<>();		
		ModelChecker<WeekdayInfo> checker;
		
		checker = new WeekdayCheckRead();
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}

		
	
	@Override protected List<ActionStd<WeekdayInfo>> buildActionsOnPassedHook(DeciTreeOption<WeekdayInfo> option) {
		List<ActionStd<WeekdayInfo>> actions = new ArrayList<>();
		
		actions.add(new StdWeekdaySelect(option));
		return actions;
	}
}
