package br.com.mind5.stats.statsStoreSchedule.storeScheduleMonth.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;
import br.com.mind5.stats.statsStoreSchedule.storeScheduleMonth.info.StedmonInfo;
import br.com.mind5.stats.statsStoreSchedule.storeScheduleMonth.model.checker.StedmonCheckRead;


public final class StedmonRootSelect extends DeciTreeTemplateWrite<StedmonInfo> {
	
	public StedmonRootSelect(DeciTreeOption<StedmonInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<StedmonInfo> buildCheckerHook(DeciTreeOption<StedmonInfo> option) {
		List<ModelChecker<StedmonInfo>> queue = new ArrayList<>();		
		ModelChecker<StedmonInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;		
		checker = new StedmonCheckRead(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<StedmonInfo>> buildActionsOnPassedHook(DeciTreeOption<StedmonInfo> option) {
		List<ActionStd<StedmonInfo>> actions = new ArrayList<>();

		ActionStd<StedmonInfo> nodeL1 = new StedmonNodeSelectL1(option).toAction();
		
		actions.add(nodeL1);
		return actions;
	}
}
