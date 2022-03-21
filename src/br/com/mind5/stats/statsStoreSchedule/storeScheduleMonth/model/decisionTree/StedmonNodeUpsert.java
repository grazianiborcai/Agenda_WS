package br.com.mind5.stats.statsStoreSchedule.storeScheduleMonth.model.decisionTree;

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
import br.com.mind5.stats.statsStoreSchedule.storeScheduleMonth.info.StedmonInfo;
import br.com.mind5.stats.statsStoreSchedule.storeScheduleMonth.model.action.StedmonVisiEnforceZerofy;
import br.com.mind5.stats.statsStoreSchedule.storeScheduleMonth.model.action.StedmonVisiMergeStedmonive;
import br.com.mind5.stats.statsStoreSchedule.storeScheduleMonth.model.action.StedmonVisiMergeStolis;
import br.com.mind5.stats.statsStoreSchedule.storeScheduleMonth.model.action.StedmonVisiStedmonagrUpsert;
import br.com.mind5.stats.statsStoreSchedule.storeScheduleMonth.model.checker.StedmonCheckStedmonive;


public final class StedmonNodeUpsert extends DeciTreeTemplateWrite<StedmonInfo> {
	
	public StedmonNodeUpsert(DeciTreeOption<StedmonInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<StedmonInfo> buildCheckerHook(DeciTreeOption<StedmonInfo> option) {
		List<ModelChecker<StedmonInfo>> queue = new ArrayList<>();		
		ModelChecker<StedmonInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new StedmonCheckStedmonive(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<StedmonInfo>> buildActionsOnPassedHook(DeciTreeOption<StedmonInfo> option) {
		List<ActionStd<StedmonInfo>> actions = new ArrayList<>();

		ActionStd<StedmonInfo> mergeStedmonive = new ActionStdCommom<StedmonInfo>(option, StedmonVisiMergeStedmonive.class);
		ActionLazy<StedmonInfo> upsertStedmonagr = new ActionLazyCommom<StedmonInfo>(option, StedmonVisiStedmonagrUpsert.class);
		
		mergeStedmonive.addPostAction(upsertStedmonagr);
		
		
		actions.add(mergeStedmonive);
		return actions;
	}
	
	
	
	@Override protected List<ActionStd<StedmonInfo>> buildActionsOnFailedHook(DeciTreeOption<StedmonInfo> option) {
		List<ActionStd<StedmonInfo>> actions = new ArrayList<>();

		ActionStd<StedmonInfo> zerofy = new ActionStdCommom<StedmonInfo>(option, StedmonVisiEnforceZerofy.class);
		ActionLazy<StedmonInfo> mergeStolis = new ActionLazyCommom<StedmonInfo>(option, StedmonVisiMergeStolis.class);
		ActionLazy<StedmonInfo> upsertStedmonagr = new ActionLazyCommom<StedmonInfo>(option, StedmonVisiStedmonagrUpsert.class);
		
		zerofy.addPostAction(mergeStolis);
		mergeStolis.addPostAction(upsertStedmonagr);
		
		
		actions.add(zerofy);
		return actions;
	}
}
