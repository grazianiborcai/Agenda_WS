package br.com.mind5.stats.statsStoreSchedule.storeScheduleDay.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;
import br.com.mind5.stats.statsStoreSchedule.storeScheduleDay.info.SteddInfo;
import br.com.mind5.stats.statsStoreSchedule.storeScheduleDay.model.action.LazySteddMergeCalateMonth;
import br.com.mind5.stats.statsStoreSchedule.storeScheduleDay.model.action.LazySteddNodeSelectMonth;
import br.com.mind5.stats.statsStoreSchedule.storeScheduleDay.model.action.LazySteddNodeZerofy;
import br.com.mind5.stats.statsStoreSchedule.storeScheduleDay.model.action.StdSteddEnforceYearMonth;
import br.com.mind5.stats.statsStoreSchedule.storeScheduleDay.model.checker.SteddCheckReadMonth;


public final class RootSteddSelectMonth extends DeciTreeTemplateWrite<SteddInfo> {
	
	public RootSteddSelectMonth(DeciTreeOption<SteddInfo> option) {
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
		checker = new SteddCheckReadMonth(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<SteddInfo>> buildActionsOnPassedHook(DeciTreeOption<SteddInfo> option) {
		List<ActionStd<SteddInfo>> actions = new ArrayList<>();


		ActionStd<SteddInfo> enforceYearMonth = new StdSteddEnforceYearMonth(option);
		ActionLazy<SteddInfo> mergeCalateMonth = new LazySteddMergeCalateMonth(option.conn, option.schemaName);
		ActionLazy<SteddInfo> nodeL1 = new LazySteddNodeSelectMonth(option.conn, option.schemaName);
		ActionLazy<SteddInfo> zerofy = new LazySteddNodeZerofy(option.conn, option.schemaName);		
		
		enforceYearMonth.addPostAction(mergeCalateMonth);
		mergeCalateMonth.addPostAction(nodeL1);
		nodeL1.addPostAction(zerofy);
		
		actions.add(enforceYearMonth);
		return actions;
	}
}
