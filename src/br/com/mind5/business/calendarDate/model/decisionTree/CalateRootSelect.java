package br.com.mind5.business.calendarDate.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.calendarDate.info.CalateInfo;
import br.com.mind5.business.calendarDate.model.action.CalateVisiEnforceCalmonth;
import br.com.mind5.business.calendarDate.model.action.CalateVisiMergeMonth;
import br.com.mind5.business.calendarDate.model.action.CalateVisiMergeMooncal;
import br.com.mind5.business.calendarDate.model.action.CalateVisiMergeToSelect;
import br.com.mind5.business.calendarDate.model.action.CalateVisiMergeWeekday;
import br.com.mind5.business.calendarDate.model.checker.CalateCheckRead;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;

public final class CalateRootSelect extends DeciTreeTemplateRead<CalateInfo> {
	
	public CalateRootSelect(DeciTreeOption<CalateInfo> option) {
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
		
		ActionStd<CalateInfo> mergeToSelect = new ActionStdCommom<CalateInfo>(option, CalateVisiMergeToSelect.class);
		ActionLazy<CalateInfo> mergeWeekday = new ActionLazyCommom<CalateInfo>(option, CalateVisiMergeWeekday.class);
		ActionLazy<CalateInfo> mergeMonth = new ActionLazyCommom<CalateInfo>(option, CalateVisiMergeMonth.class);
		ActionLazy<CalateInfo> mergeMooncal = new ActionLazyCommom<CalateInfo>(option, CalateVisiMergeMooncal.class);
		ActionLazy<CalateInfo> enforceCalmonth = new ActionLazyCommom<CalateInfo>(option, CalateVisiEnforceCalmonth.class);
		
		mergeToSelect.addPostAction(mergeWeekday);
		mergeWeekday.addPostAction(mergeMonth);
		mergeMonth.addPostAction(mergeMooncal);
		mergeMooncal.addPostAction(enforceCalmonth);
		
		actions.add(mergeToSelect);
		return actions;
	}
}
