package br.com.mind5.business.masterData.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.masterData.info.WeekdayInfo;
import br.com.mind5.business.masterData.model.action.StdWeekdaySelect;
import br.com.mind5.business.masterData.model.checker.WeekdayCheckRead;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeReadTemplate;

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
