package br.com.mind5.stats.statsStoreSchedule.storeScheduleDay.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;
import br.com.mind5.stats.statsStoreSchedule.storeScheduleDay.info.SteddInfo;
import br.com.mind5.stats.statsStoreSchedule.storeScheduleDay.model.action.StdSteddEnforceZerofy;
import br.com.mind5.stats.statsStoreSchedule.storeScheduleDay.model.action.StdSteddSuccess;
import br.com.mind5.stats.statsStoreSchedule.storeScheduleDay.model.checker.SteddCheckHasData;


public final class NodeSteddZerofy extends DeciTreeTemplateWrite<SteddInfo> {
	
	public NodeSteddZerofy(DeciTreeOption<SteddInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<SteddInfo> buildCheckerHook(DeciTreeOption<SteddInfo> option) {
		List<ModelChecker<SteddInfo>> queue = new ArrayList<>();		
		ModelChecker<SteddInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;		
		checker = new SteddCheckHasData(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<SteddInfo>> buildActionsOnPassedHook(DeciTreeOption<SteddInfo> option) {
		List<ActionStd<SteddInfo>> actions = new ArrayList<>();

		ActionStd<SteddInfo> success = new StdSteddSuccess(option);
		
		actions.add(success);
		return actions;
	}
	
	
	
	@Override protected List<ActionStd<SteddInfo>> buildActionsOnFailedHook(DeciTreeOption<SteddInfo> option) {
		List<ActionStd<SteddInfo>> actions = new ArrayList<>();

		ActionStd<SteddInfo> zerofy = new StdSteddEnforceZerofy(option);
		
		actions.add(zerofy);
		return actions;
	}
}
