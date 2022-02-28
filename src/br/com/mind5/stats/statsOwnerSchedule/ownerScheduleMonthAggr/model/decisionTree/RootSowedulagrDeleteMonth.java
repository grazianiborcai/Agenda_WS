package br.com.mind5.stats.statsOwnerSchedule.ownerScheduleMonthAggr.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;
import br.com.mind5.stats.statsOwnerSchedule.ownerScheduleMonthAggr.info.SowedulagrInfo;
import br.com.mind5.stats.statsOwnerSchedule.ownerScheduleMonthAggr.model.checker.SowedulagrCheckDeleteMonth;


public final class RootSowedulagrDeleteMonth extends DeciTreeTemplateWrite<SowedulagrInfo> {
	
	public RootSowedulagrDeleteMonth(DeciTreeOption<SowedulagrInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<SowedulagrInfo> buildCheckerHook(DeciTreeOption<SowedulagrInfo> option) {
		List<ModelChecker<SowedulagrInfo>> queue = new ArrayList<>();
		ModelChecker<SowedulagrInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;
		checker = new SowedulagrCheckDeleteMonth(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<SowedulagrInfo>> buildActionsOnPassedHook(DeciTreeOption<SowedulagrInfo> option) {
		List<ActionStd<SowedulagrInfo>> actions = new ArrayList<>();

		ActionStd<SowedulagrInfo> nodeL1 = new NodeSowedulagrDeleteMonth(option).toAction();
		
		actions.add(nodeL1);
		return actions;
	}
}
