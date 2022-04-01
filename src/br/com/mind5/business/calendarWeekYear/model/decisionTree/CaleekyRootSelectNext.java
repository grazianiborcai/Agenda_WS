package br.com.mind5.business.calendarWeekYear.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.calendarWeekYear.info.CaleekyInfo;
import br.com.mind5.business.calendarWeekYear.model.action.CaleekyVisiRootSelect;
import br.com.mind5.business.calendarWeekYear.model.action.CaleekyVisiMergeNext;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.common.ModelCheckerDummy;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;

public final class CaleekyRootSelectNext extends DeciTreeTemplateRead<CaleekyInfo> {
	
	public CaleekyRootSelectNext(DeciTreeOption<CaleekyInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<CaleekyInfo> buildCheckerHook(DeciTreeOption<CaleekyInfo> option) {
		List<ModelChecker<CaleekyInfo>> queue = new ArrayList<>();		
		ModelChecker<CaleekyInfo> checker;

		checker = new ModelCheckerDummy<>();
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}

		
	
	@Override protected List<ActionStd<CaleekyInfo>> buildActionsOnPassedHook(DeciTreeOption<CaleekyInfo> option) {
		List<ActionStd<CaleekyInfo>> actions = new ArrayList<>();
		
		ActionStd<CaleekyInfo> selectBase = new CaleekyRootSelect(option).toAction();
		ActionLazy<CaleekyInfo> mergeNext = new ActionLazyCommom<CaleekyInfo>(option, CaleekyVisiMergeNext.class);
		ActionLazy<CaleekyInfo> selectResult = new ActionLazyCommom<CaleekyInfo>(option, CaleekyVisiRootSelect.class);
		
		selectBase.addPostAction(mergeNext);
		mergeNext.addPostAction(selectResult);
		
		actions.add(selectBase);
		return actions;
	}
}
