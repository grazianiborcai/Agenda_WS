package br.com.mind5.masterData.weekdaySearch.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.masterData.weekdaySearch.info.WeekdarchInfo;
import br.com.mind5.masterData.weekdaySearch.model.action.StdWeekdarchDaoSelect;
import br.com.mind5.masterData.weekdaySearch.model.checker.WeekdarchCheckRead;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;

public final class RootWeekdarchSelect extends DeciTreeTemplateRead<WeekdarchInfo> {
	
	public RootWeekdarchSelect(DeciTreeOption<WeekdarchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<WeekdarchInfo> buildCheckerHook(DeciTreeOption<WeekdarchInfo> option) {
		List<ModelChecker<WeekdarchInfo>> queue = new ArrayList<>();		
		ModelChecker<WeekdarchInfo> checker;
		ModelCheckerOption checkerOption;	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new WeekdarchCheckRead(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}

		
	
	@Override protected List<ActionStd<WeekdarchInfo>> buildActionsOnPassedHook(DeciTreeOption<WeekdarchInfo> option) {
		List<ActionStd<WeekdarchInfo>> actions = new ArrayList<>();
		
		ActionStd<WeekdarchInfo> select = new StdWeekdarchDaoSelect(option);
		
		actions.add(select);
		return actions;
	}
}
