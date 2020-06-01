package br.com.mind5.business.calendarTimeStore.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.calendarTimeStore.info.CalimoreInfo;
import br.com.mind5.business.calendarTimeStore.model.action.StdCalimoreEnforceFallback;
import br.com.mind5.business.calendarTimeStore.model.action.StdCalimoreMergeStowotarch;
import br.com.mind5.business.calendarTimeStore.model.checker.CalimoreCheckStowotarch;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWriteV2;

public final class NodeCalimoreSelect extends DeciTreeTemplateWriteV2<CalimoreInfo> {
	
	public NodeCalimoreSelect(DeciTreeOption<CalimoreInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<CalimoreInfo> buildCheckerHook(DeciTreeOption<CalimoreInfo> option) {
		List<ModelCheckerV1<CalimoreInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<CalimoreInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new CalimoreCheckStowotarch(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<CalimoreInfo>> buildActionsOnPassedHook(DeciTreeOption<CalimoreInfo> option) {
		List<ActionStdV1<CalimoreInfo>> actions = new ArrayList<>();
		
		ActionStdV1<CalimoreInfo> mergeStowotarch = new StdCalimoreMergeStowotarch(option);
		
		actions.add(mergeStowotarch);
		return actions;
	}
	
	
	
	@Override protected List<ActionStdV1<CalimoreInfo>> buildActionsOnFailedHook(DeciTreeOption<CalimoreInfo> option) {
		List<ActionStdV1<CalimoreInfo>> actions = new ArrayList<>();
		
		ActionStdV1<CalimoreInfo> enforceFallback = new StdCalimoreEnforceFallback(option);
		
		actions.add(enforceFallback);
		return actions;
	}
}
