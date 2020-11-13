package br.com.mind5.business.calendarTimeEmployee.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.calendarTimeEmployee.info.CalimempInfo;
import br.com.mind5.business.calendarTimeEmployee.model.action.LazyCalimempMergeEmplarg;
import br.com.mind5.business.calendarTimeEmployee.model.action.StdCalimempEnforceFallback;
import br.com.mind5.business.calendarTimeEmployee.model.action.StdCalimempMergeEmpwotarch;
import br.com.mind5.business.calendarTimeEmployee.model.checker.CalimempCheckEmpwotarch;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class NodeCalimempSelect extends DeciTreeTemplateWrite<CalimempInfo> {
	
	public NodeCalimempSelect(DeciTreeOption<CalimempInfo> option) {
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
		
		ActionStd<CalimempInfo> mergeEmpwotarch = new StdCalimempMergeEmpwotarch(option);
		ActionLazy<CalimempInfo> mergeEmplarg = new LazyCalimempMergeEmplarg(option.conn, option.schemaName);
		
		mergeEmpwotarch.addPostAction(mergeEmplarg);
		
		actions.add(mergeEmpwotarch);
		return actions;
	}
	
	
	
	@Override protected List<ActionStd<CalimempInfo>> buildActionsOnFailedHook(DeciTreeOption<CalimempInfo> option) {
		List<ActionStd<CalimempInfo>> actions = new ArrayList<>();
		
		ActionStd<CalimempInfo> enforceFallback = new StdCalimempEnforceFallback(option);
		
		actions.add(enforceFallback);
		return actions;
	}
}
