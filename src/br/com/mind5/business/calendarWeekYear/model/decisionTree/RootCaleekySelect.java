package br.com.mind5.business.calendarWeekYear.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.calendarWeekYear.info.CaleekyInfo;
import br.com.mind5.business.calendarWeekYear.model.action.StdCaleekyMergeToSelect;
import br.com.mind5.business.calendarWeekYear.model.checker.CaleekyCheckRead;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;

public final class RootCaleekySelect extends DeciTreeTemplateRead<CaleekyInfo> {
	
	public RootCaleekySelect(DeciTreeOption<CaleekyInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<CaleekyInfo> buildCheckerHook(DeciTreeOption<CaleekyInfo> option) {
		List<ModelChecker<CaleekyInfo>> queue = new ArrayList<>();		
		ModelChecker<CaleekyInfo> checker;
		ModelCheckerOption checkerOption;	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new CaleekyCheckRead(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}

		
	
	@Override protected List<ActionStd<CaleekyInfo>> buildActionsOnPassedHook(DeciTreeOption<CaleekyInfo> option) {
		List<ActionStd<CaleekyInfo>> actions = new ArrayList<>();
		
		ActionStd<CaleekyInfo> mergeToSelect = new StdCaleekyMergeToSelect(option);
		
		actions.add(mergeToSelect);
		return actions;
	}
}
