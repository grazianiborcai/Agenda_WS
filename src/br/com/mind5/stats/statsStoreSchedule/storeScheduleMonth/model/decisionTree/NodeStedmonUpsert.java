package br.com.mind5.stats.statsStoreSchedule.storeScheduleMonth.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;
import br.com.mind5.stats.statsStoreSchedule.storeScheduleMonth.info.StedmonInfo;
import br.com.mind5.stats.statsStoreSchedule.storeScheduleMonth.model.action.LazyStedmonMergeStolis;
import br.com.mind5.stats.statsStoreSchedule.storeScheduleMonth.model.action.LazyStedmonStedmonagrUpsert;
import br.com.mind5.stats.statsStoreSchedule.storeScheduleMonth.model.action.StdStedmonEnforceZerofy;
import br.com.mind5.stats.statsStoreSchedule.storeScheduleMonth.model.action.StdStedmonMergeSteddive;
import br.com.mind5.stats.statsStoreSchedule.storeScheduleMonth.model.checker.StedmonCheckStedmonive;


public final class NodeStedmonUpsert extends DeciTreeTemplateWrite<StedmonInfo> {
	
	public NodeStedmonUpsert(DeciTreeOption<StedmonInfo> option) {
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

		ActionStd<StedmonInfo> mergeSteddive = new StdStedmonMergeSteddive(option);
		ActionLazy<StedmonInfo> upsertSteddagr = new LazyStedmonStedmonagrUpsert(option.conn, option.schemaName);
		
		mergeSteddive.addPostAction(upsertSteddagr);
		
		
		actions.add(mergeSteddive);
		return actions;
	}
	
	
	
	@Override protected List<ActionStd<StedmonInfo>> buildActionsOnFailedHook(DeciTreeOption<StedmonInfo> option) {
		List<ActionStd<StedmonInfo>> actions = new ArrayList<>();

		ActionStd<StedmonInfo> zerofy = new StdStedmonEnforceZerofy(option);
		ActionLazy<StedmonInfo> mergeStolis = new LazyStedmonMergeStolis(option.conn, option.schemaName);
		ActionLazy<StedmonInfo> upsertSteddagr = new LazyStedmonStedmonagrUpsert(option.conn, option.schemaName);
		
		zerofy.addPostAction(mergeStolis);
		mergeStolis.addPostAction(upsertSteddagr);
		
		
		actions.add(zerofy);
		return actions;
	}
}
