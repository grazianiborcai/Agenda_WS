package br.com.mind5.business.calendarTimeEmployee.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.calendarTimeEmployee.info.CalimempInfo;
import br.com.mind5.business.calendarTimeEmployee.model.action.CalimempVisiEnforceFallback;
import br.com.mind5.business.calendarTimeEmployee.model.action.CalimempVisiMergeEmplarg;
import br.com.mind5.business.calendarTimeEmployee.model.action.CalimempVisiMergeEmpwotarch;
import br.com.mind5.business.calendarTimeEmployee.model.checker.CalimempCheckEmpwotarch;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class CalimempNodeSelect extends DeciTreeTemplateWrite<CalimempInfo> {
	
	public CalimempNodeSelect(DeciTreeOption<CalimempInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<CalimempInfo> buildCheckerHook(DeciTreeOption<CalimempInfo> option) {
		List<ModelChecker<CalimempInfo>> queue = new ArrayList<>();		
		ModelChecker<CalimempInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new CalimempCheckEmpwotarch(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<CalimempInfo>> buildActionsOnPassedHook(DeciTreeOption<CalimempInfo> option) {
		List<ActionStd<CalimempInfo>> actions = new ArrayList<>();
		
		ActionStd<CalimempInfo> mergeEmpwotarch = new ActionStdCommom<CalimempInfo>(option, CalimempVisiMergeEmpwotarch.class);
		ActionLazy<CalimempInfo> mergeEmplarg = new ActionLazyCommom<CalimempInfo>(option, CalimempVisiMergeEmplarg.class);
		
		mergeEmpwotarch.addPostAction(mergeEmplarg);
		
		actions.add(mergeEmpwotarch);
		return actions;
	}
	
	
	
	@Override protected List<ActionStd<CalimempInfo>> buildActionsOnFailedHook(DeciTreeOption<CalimempInfo> option) {
		List<ActionStd<CalimempInfo>> actions = new ArrayList<>();
		
		ActionStd<CalimempInfo> enforceFallback = new ActionStdCommom<CalimempInfo>(option, CalimempVisiEnforceFallback.class);
		
		actions.add(enforceFallback);
		return actions;
	}
}
