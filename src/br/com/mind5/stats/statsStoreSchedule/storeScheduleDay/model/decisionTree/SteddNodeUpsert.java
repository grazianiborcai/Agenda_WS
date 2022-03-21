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
import br.com.mind5.stats.statsStoreSchedule.storeScheduleDay.model.action.SteddVisiEnforceZerofy;
import br.com.mind5.stats.statsStoreSchedule.storeScheduleDay.model.action.SteddVisiMergeSteddive;
import br.com.mind5.stats.statsStoreSchedule.storeScheduleDay.model.action.SteddVisiMergeStolis;
import br.com.mind5.stats.statsStoreSchedule.storeScheduleDay.model.action.SteddVisiSteddagrUpsert;
import br.com.mind5.stats.statsStoreSchedule.storeScheduleDay.model.checker.SteddCheckSteddive;


public final class SteddNodeUpsert extends DeciTreeTemplateWrite<SteddInfo> {
	
	public SteddNodeUpsert(DeciTreeOption<SteddInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<SteddInfo> buildCheckerHook(DeciTreeOption<SteddInfo> option) {
		List<ModelChecker<SteddInfo>> queue = new ArrayList<>();		
		ModelChecker<SteddInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new SteddCheckSteddive(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<SteddInfo>> buildActionsOnPassedHook(DeciTreeOption<SteddInfo> option) {
		List<ActionStd<SteddInfo>> actions = new ArrayList<>();

		ActionStd<SteddInfo> mergeSteddive = new ActionStdCommom<SteddInfo>(option, SteddVisiMergeSteddive.class);
		ActionLazy<SteddInfo> upsertSteddagr = new ActionLazyCommom<SteddInfo>(option, SteddVisiSteddagrUpsert.class);
		
		mergeSteddive.addPostAction(upsertSteddagr);
		
		
		actions.add(mergeSteddive);
		return actions;
	}
	
	
	
	@Override protected List<ActionStd<SteddInfo>> buildActionsOnFailedHook(DeciTreeOption<SteddInfo> option) {
		List<ActionStd<SteddInfo>> actions = new ArrayList<>();

		ActionStd<SteddInfo> zerofy = new ActionStdCommom<SteddInfo>(option, SteddVisiEnforceZerofy.class);
		ActionLazy<SteddInfo> mergeStolis = new ActionLazyCommom<SteddInfo>(option, SteddVisiMergeStolis.class);
		ActionLazy<SteddInfo> upsertSteddagr = new ActionLazyCommom<SteddInfo>(option, SteddVisiSteddagrUpsert.class);
		
		zerofy.addPostAction(mergeStolis);
		mergeStolis.addPostAction(upsertSteddagr);
		
		
		actions.add(zerofy);
		return actions;
	}
}
