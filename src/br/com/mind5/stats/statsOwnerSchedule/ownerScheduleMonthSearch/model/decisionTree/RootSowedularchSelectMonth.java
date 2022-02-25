package br.com.mind5.stats.statsOwnerSchedule.ownerScheduleMonthSearch.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;
import br.com.mind5.stats.statsOwnerSchedule.ownerScheduleMonthSearch.info.SowedularchInfo;
import br.com.mind5.stats.statsOwnerSchedule.ownerScheduleMonthSearch.model.action.LazySowedularchRootSelect;
import br.com.mind5.stats.statsOwnerSchedule.ownerScheduleMonthSearch.model.action.StdSowedularchEnforceCalmonth;
import br.com.mind5.stats.statsOwnerSchedule.ownerScheduleMonthSearch.model.checker.SowedularchCheckReadMonth;


public final class RootSowedularchSelectMonth extends DeciTreeTemplateWrite<SowedularchInfo> {
	
	public RootSowedularchSelectMonth(DeciTreeOption<SowedularchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<SowedularchInfo> buildCheckerHook(DeciTreeOption<SowedularchInfo> option) {
		List<ModelChecker<SowedularchInfo>> queue = new ArrayList<>();
		ModelChecker<SowedularchInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;
		checker = new SowedularchCheckReadMonth(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<SowedularchInfo>> buildActionsOnPassedHook(DeciTreeOption<SowedularchInfo> option) {
		List<ActionStd<SowedularchInfo>> actions = new ArrayList<>();

		ActionStd<SowedularchInfo> enforceCalmonth = new StdSowedularchEnforceCalmonth(option);
		ActionLazy<SowedularchInfo> select = new LazySowedularchRootSelect(option.conn, option.schemaName);
		
		enforceCalmonth.addPostAction(select);
		
		actions.add(enforceCalmonth);
		return actions;
	}
}
