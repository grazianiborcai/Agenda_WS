package br.com.mind5.business.calendarDate.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.calendarDate.info.CalateInfo;
import br.com.mind5.business.calendarDate.model.action.LazyCalateEnforceCalmonth;
import br.com.mind5.business.calendarDate.model.action.LazyCalateMergeMonth;
import br.com.mind5.business.calendarDate.model.action.LazyCalateMergeMooncal;
import br.com.mind5.business.calendarDate.model.action.LazyCalateMergeWeekday;
import br.com.mind5.business.calendarDate.model.action.StdCalateMergeToSelect;
import br.com.mind5.business.calendarDate.model.checker.CalateCheckRead;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;

public final class RootCalateSelect extends DeciTreeTemplateRead<CalateInfo> {
	
	public RootCalateSelect(DeciTreeOption<CalateInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<CalateInfo> buildCheckerHook(DeciTreeOption<CalateInfo> option) {
		List<ModelChecker<CalateInfo>> queue = new ArrayList<>();
		ModelChecker<CalateInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;
		checker = new CalateCheckRead(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}

		
	
	@Override protected List<ActionStd<CalateInfo>> buildActionsOnPassedHook(DeciTreeOption<CalateInfo> option) {
		List<ActionStd<CalateInfo>> actions = new ArrayList<>();
		
		ActionStd<CalateInfo> mergeToSelect = new StdCalateMergeToSelect(option);
		ActionLazy<CalateInfo> mergeWeekday = new LazyCalateMergeWeekday(option.conn, option.schemaName);
		ActionLazy<CalateInfo> mergeMonth = new LazyCalateMergeMonth(option.conn, option.schemaName);
		ActionLazy<CalateInfo> mergeMooncal = new LazyCalateMergeMooncal(option.conn, option.schemaName);
		ActionLazy<CalateInfo> enforceCalmonth = new LazyCalateEnforceCalmonth(option.conn, option.schemaName);
		
		mergeToSelect.addPostAction(mergeWeekday);
		mergeWeekday.addPostAction(mergeMonth);
		mergeMonth.addPostAction(mergeMooncal);
		mergeMooncal.addPostAction(enforceCalmonth);
		
		actions.add(mergeToSelect);
		return actions;
	}
}
