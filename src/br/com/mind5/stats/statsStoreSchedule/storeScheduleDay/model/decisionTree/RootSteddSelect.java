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
import br.com.mind5.stats.statsStoreSchedule.storeScheduleDay.model.checker.SteddCheckRead;


public final class RootSteddSelect extends DeciTreeTemplateWrite<SteddInfo> {
	
	public RootSteddSelect(DeciTreeOption<SteddInfo> option) {
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
		checker = new SteddCheckRead(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<SteddInfo>> buildActionsOnPassedHook(DeciTreeOption<SteddInfo> option) {
		List<ActionStd<SteddInfo>> actions = new ArrayList<>();

		ActionStd<SteddInfo> nodeL1 = new NodeSteddSelectL1(option).toAction();
		
		actions.add(nodeL1);
		return actions;
	}
}
