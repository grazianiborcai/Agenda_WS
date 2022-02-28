package br.com.mind5.stats.statsOwnerSchedule.ownerScheduleMonthAggr.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.common.ModelCheckerDummy;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;
import br.com.mind5.stats.statsOwnerSchedule.ownerScheduleMonthAggr.info.SowedulagrInfo;
import br.com.mind5.stats.statsOwnerSchedule.ownerScheduleMonthAggr.model.action.LazySowedulagrRootSelect;
import br.com.mind5.stats.statsOwnerSchedule.ownerScheduleMonthAggr.model.action.StdSowedulagrMergeSowedularchMonth;


public final class RootSowedulagrSelectMonth extends DeciTreeTemplateWrite<SowedulagrInfo> {
	
	public RootSowedulagrSelectMonth(DeciTreeOption<SowedulagrInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<SowedulagrInfo> buildCheckerHook(DeciTreeOption<SowedulagrInfo> option) {
		List<ModelChecker<SowedulagrInfo>> queue = new ArrayList<>();
		ModelChecker<SowedulagrInfo> checker;

		checker = new ModelCheckerDummy<SowedulagrInfo>();
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<SowedulagrInfo>> buildActionsOnPassedHook(DeciTreeOption<SowedulagrInfo> option) {
		List<ActionStd<SowedulagrInfo>> actions = new ArrayList<>();

		ActionStd<SowedulagrInfo> mergeSowedularchMonth = new StdSowedulagrMergeSowedularchMonth(option);
		ActionLazy<SowedulagrInfo> select = new LazySowedulagrRootSelect(option.conn, option.schemaName);
		
		mergeSowedularchMonth.addPostAction(select);
		
		actions.add(mergeSowedularchMonth);
		return actions;
	}
}
