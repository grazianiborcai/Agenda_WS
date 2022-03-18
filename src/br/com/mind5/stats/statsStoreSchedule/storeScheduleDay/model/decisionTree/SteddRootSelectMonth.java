package br.com.mind5.stats.statsStoreSchedule.storeScheduleDay.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;
import br.com.mind5.stats.statsStoreSchedule.storeScheduleDay.info.SteddInfo;
import br.com.mind5.stats.statsStoreSchedule.storeScheduleDay.model.action.SteddVisiRootSelect;
import br.com.mind5.stats.statsStoreSchedule.storeScheduleDay.model.action.SteddVisiEnforceYearMonth;
import br.com.mind5.stats.statsStoreSchedule.storeScheduleDay.model.action.SteddVisiMergeCalateMonth;
import br.com.mind5.stats.statsStoreSchedule.storeScheduleDay.model.checker.SteddCheckReadMonth;


public final class SteddRootSelectMonth extends DeciTreeTemplateWrite<SteddInfo> {
	
	public SteddRootSelectMonth(DeciTreeOption<SteddInfo> option) {
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


		ActionStd<SteddInfo> enforceYearMonth = new ActionStdCommom<SteddInfo>(option, SteddVisiEnforceYearMonth.class);
		ActionLazy<SteddInfo> mergeCalateMonth = new ActionLazyCommom<SteddInfo>(option.conn, option.schemaName, SteddVisiMergeCalateMonth.class);
		ActionLazy<SteddInfo> select = new ActionLazyCommom<SteddInfo>(option.conn, option.schemaName, SteddVisiRootSelect.class);	
		
		enforceYearMonth.addPostAction(mergeCalateMonth);
		mergeCalateMonth.addPostAction(select);
		
		actions.add(enforceYearMonth);
		return actions;
	}
}
