package br.com.mind5.business.calendarDate.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.calendarDate.info.CalateInfo;
import br.com.mind5.business.calendarDate.model.action.CalateVisiRootSelect;
import br.com.mind5.business.calendarDate.model.action.CalateVisiEnforceNext;
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

public final class CalateRootSelectNext extends DeciTreeTemplateRead<CalateInfo> {
	
	public CalateRootSelectNext(DeciTreeOption<CalateInfo> option) {
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
		
		ActionStd<CalateInfo> enforceNext = new ActionStdCommom<CalateInfo>(option, CalateVisiEnforceNext.class);
		ActionLazy<CalateInfo> select = new ActionLazyCommom<CalateInfo>(option, CalateVisiRootSelect.class);
		
		enforceNext.addPostAction(select);
		
		actions.add(enforceNext);
		return actions;
	}
}
