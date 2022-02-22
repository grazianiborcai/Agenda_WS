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
import br.com.mind5.stats.statsStoreSchedule.storeScheduleDay.model.action.LazySteddMergeStolis;
import br.com.mind5.stats.statsStoreSchedule.storeScheduleDay.model.action.LazySteddSteddagrUpsert;
import br.com.mind5.stats.statsStoreSchedule.storeScheduleDay.model.action.StdSteddEnforceZerofy;
import br.com.mind5.stats.statsStoreSchedule.storeScheduleDay.model.action.StdSteddMergeSteddive;
import br.com.mind5.stats.statsStoreSchedule.storeScheduleDay.model.checker.SteddCheckSteddive;


public final class NodeSteddUpsert extends DeciTreeTemplateWrite<SteddInfo> {
	
	public NodeSteddUpsert(DeciTreeOption<SteddInfo> option) {
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

		ActionStd<SteddInfo> mergeSteddive = new StdSteddMergeSteddive(option);
		ActionLazy<SteddInfo> upsertSteddagr = new LazySteddSteddagrUpsert(option.conn, option.schemaName);
		
		mergeSteddive.addPostAction(upsertSteddagr);
		
		
		actions.add(mergeSteddive);
		return actions;
	}
	
	
	
	@Override protected List<ActionStd<SteddInfo>> buildActionsOnFailedHook(DeciTreeOption<SteddInfo> option) {
		List<ActionStd<SteddInfo>> actions = new ArrayList<>();

		ActionStd<SteddInfo> zerofy = new StdSteddEnforceZerofy(option);
		ActionLazy<SteddInfo> mergeStolis = new LazySteddMergeStolis(option.conn, option.schemaName);
		ActionLazy<SteddInfo> upsertSteddagr = new LazySteddSteddagrUpsert(option.conn, option.schemaName);
		
		zerofy.addPostAction(mergeStolis);
		mergeStolis.addPostAction(upsertSteddagr);
		
		
		actions.add(zerofy);
		return actions;
	}
}
