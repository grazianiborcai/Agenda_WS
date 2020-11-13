package br.com.mind5.masterData.dayParting.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.masterData.dayParting.info.DaypartInfo;
import br.com.mind5.masterData.dayParting.model.action.StdDaypartDaoSelect;
import br.com.mind5.masterData.dayParting.model.checker.DaypartCheckRead;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;

public final class RootDaypartSelect extends DeciTreeTemplateRead<DaypartInfo> {
	
	public RootDaypartSelect(DeciTreeOption<DaypartInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<DaypartInfo> buildCheckerHook(DeciTreeOption<DaypartInfo> option) {
		List<ModelChecker<DaypartInfo>> queue = new ArrayList<>();		
		ModelChecker<DaypartInfo> checker;
		ModelCheckerOption checkerOption;	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new DaypartCheckRead(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}

		
	
	@Override protected List<ActionStd<DaypartInfo>> buildActionsOnPassedHook(DeciTreeOption<DaypartInfo> option) {
		List<ActionStd<DaypartInfo>> actions = new ArrayList<>();
		
		ActionStd<DaypartInfo> select = new StdDaypartDaoSelect(option);
		
		actions.add(select);
		return actions;
	}
}
