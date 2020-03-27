package br.com.mind5.business.masterData.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.masterData.info.DaypartInfo;
import br.com.mind5.business.masterData.model.action.StdDaypartSelect;
import br.com.mind5.business.masterData.model.checker.DaypartCheckRead;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeReadTemplate;

public final class RootDaypartSelect extends DeciTreeReadTemplate<DaypartInfo> {
	
	public RootDaypartSelect(DeciTreeOption<DaypartInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<DaypartInfo> buildDecisionCheckerHook(DeciTreeOption<DaypartInfo> option) {
		List<ModelChecker<DaypartInfo>> queue = new ArrayList<>();		
		ModelChecker<DaypartInfo> checker;
		ModelCheckerOption checkerOption;	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new DaypartCheckRead(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}

		
	
	@Override protected List<ActionStd<DaypartInfo>> buildActionsOnPassedHook(DeciTreeOption<DaypartInfo> option) {
		List<ActionStd<DaypartInfo>> actions = new ArrayList<>();
		
		ActionStd<DaypartInfo> select = new StdDaypartSelect(option);
		
		actions.add(select);
		return actions;
	}
}
