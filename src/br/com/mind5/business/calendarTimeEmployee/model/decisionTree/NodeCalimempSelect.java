package br.com.mind5.business.calendarTimeEmployee.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.calendarTimeEmployee.info.CalimempInfo;
import br.com.mind5.business.calendarTimeEmployee.model.action.LazyCalimempMergeEmplarg;
import br.com.mind5.business.calendarTimeEmployee.model.action.StdCalimempEnforceFallback;
import br.com.mind5.business.calendarTimeEmployee.model.action.StdCalimempMergeEmpwotarch;
import br.com.mind5.business.calendarTimeEmployee.model.checker.CalimempCheckEmpwotarch;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWriteV2;

public final class NodeCalimempSelect extends DeciTreeTemplateWriteV2<CalimempInfo> {
	
	public NodeCalimempSelect(DeciTreeOption<CalimempInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<CalimempInfo> buildCheckerHook(DeciTreeOption<CalimempInfo> option) {
		List<ModelCheckerV1<CalimempInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<CalimempInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new CalimempCheckEmpwotarch(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<CalimempInfo>> buildActionsOnPassedHook(DeciTreeOption<CalimempInfo> option) {
		List<ActionStdV1<CalimempInfo>> actions = new ArrayList<>();
		
		ActionStdV1<CalimempInfo> mergeEmpwotarch = new StdCalimempMergeEmpwotarch(option);
		ActionLazy<CalimempInfo> mergeEmplarg = new LazyCalimempMergeEmplarg(option.conn, option.schemaName);
		
		mergeEmpwotarch.addPostAction(mergeEmplarg);
		
		actions.add(mergeEmpwotarch);
		return actions;
	}
	
	
	
	@Override protected List<ActionStdV1<CalimempInfo>> buildActionsOnFailedHook(DeciTreeOption<CalimempInfo> option) {
		List<ActionStdV1<CalimempInfo>> actions = new ArrayList<>();
		
		ActionStdV1<CalimempInfo> enforceFallback = new StdCalimempEnforceFallback(option);
		
		actions.add(enforceFallback);
		return actions;
	}
}
