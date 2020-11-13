package br.com.mind5.business.calendarWeekYear.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.calendarWeekYear.info.CaleekyInfo;
import br.com.mind5.business.calendarWeekYear.model.action.LazyCaleekyMergePrevious;
import br.com.mind5.business.calendarWeekYear.model.action.LazyCaleekyRootSelect;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.common.ModelCheckerDummy;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;

public final class RootCaleekySelectPrevious extends DeciTreeTemplateRead<CaleekyInfo> {
	
	public RootCaleekySelectPrevious(DeciTreeOption<CaleekyInfo> option) {
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
		
		ActionStd<CaleekyInfo> selectBase = new RootCaleekySelect(option).toAction();
		ActionLazy<CaleekyInfo> mergePrevious = new LazyCaleekyMergePrevious(option.conn, option.schemaName);
		ActionLazy<CaleekyInfo> selectResult = new LazyCaleekyRootSelect(option.conn, option.schemaName);
		
		selectBase.addPostAction(mergePrevious);
		mergePrevious.addPostAction(selectResult);
		
		actions.add(selectBase);
		return actions;
	}
}
