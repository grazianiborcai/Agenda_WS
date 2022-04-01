package br.com.mind5.business.calendarTimeStore.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.calendarTimeStore.info.CalimoreInfo;
import br.com.mind5.business.calendarTimeStore.model.action.CalimoreVisiEnforceFallback;
import br.com.mind5.business.calendarTimeStore.model.action.CalimoreVisiMergeStolarg;
import br.com.mind5.business.calendarTimeStore.model.action.CalimoreVisiMergeStowotarch;
import br.com.mind5.business.calendarTimeStore.model.checker.CalimoreCheckStowotarch;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class CalimoreNodeSelect extends DeciTreeTemplateWrite<CalimoreInfo> {
	
	public CalimoreNodeSelect(DeciTreeOption<CalimoreInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<CalimoreInfo> buildCheckerHook(DeciTreeOption<CalimoreInfo> option) {
		List<ModelChecker<CalimoreInfo>> queue = new ArrayList<>();		
		ModelChecker<CalimoreInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new CalimoreCheckStowotarch(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<CalimoreInfo>> buildActionsOnPassedHook(DeciTreeOption<CalimoreInfo> option) {
		List<ActionStd<CalimoreInfo>> actions = new ArrayList<>();
		
		ActionStd<CalimoreInfo> mergeStowotarch = new ActionStdCommom<CalimoreInfo>(option, CalimoreVisiMergeStowotarch.class);
		ActionLazy<CalimoreInfo> mergeStolarg = new ActionLazyCommom<CalimoreInfo>(option, CalimoreVisiMergeStolarg.class);
		
		mergeStowotarch.addPostAction(mergeStolarg);
		
		actions.add(mergeStowotarch);
		return actions;
	}
	
	
	
	@Override protected List<ActionStd<CalimoreInfo>> buildActionsOnFailedHook(DeciTreeOption<CalimoreInfo> option) {
		List<ActionStd<CalimoreInfo>> actions = new ArrayList<>();
		
		ActionStd<CalimoreInfo> enforceFallback = new ActionStdCommom<CalimoreInfo>(option, CalimoreVisiEnforceFallback.class);
		
		actions.add(enforceFallback);
		return actions;
	}
}
