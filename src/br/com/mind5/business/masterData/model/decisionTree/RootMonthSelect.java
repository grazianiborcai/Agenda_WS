package br.com.mind5.business.masterData.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.masterData.info.MonthInfo;
import br.com.mind5.business.masterData.model.action.StdMonthSelect;
import br.com.mind5.business.masterData.model.checker.MonthCheckRead;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeReadTemplate;

public final class RootMonthSelect extends DeciTreeReadTemplate<MonthInfo> {
	
	public RootMonthSelect(DeciTreeOption<MonthInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<MonthInfo> buildDecisionCheckerHook(DeciTreeOption<MonthInfo> option) {
		List<ModelChecker<MonthInfo>> queue = new ArrayList<>();		
		ModelChecker<MonthInfo> checker;
		
		checker = new MonthCheckRead();
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<MonthInfo>> buildActionsOnPassedHook(DeciTreeOption<MonthInfo> option) {
		List<ActionStd<MonthInfo>> actions = new ArrayList<>();
		
		actions.add(new StdMonthSelect(option));
		return actions;
	}
}
