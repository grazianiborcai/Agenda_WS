package br.com.mind5.stats.statsStoreSchedule.storeScheduleDayAggr.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;
import br.com.mind5.stats.statsStoreSchedule.storeScheduleDayAggr.info.SteddagrInfo;
import br.com.mind5.stats.statsStoreSchedule.storeScheduleDayAggr.model.action.LazySteddagrEnforceHasData;
import br.com.mind5.stats.statsStoreSchedule.storeScheduleDayAggr.model.action.LazySteddagrMergeCalate;
import br.com.mind5.stats.statsStoreSchedule.storeScheduleDayAggr.model.action.LazySteddagrMergeState;
import br.com.mind5.stats.statsStoreSchedule.storeScheduleDayAggr.model.action.StdSteddagrMergeToSelect;
import br.com.mind5.stats.statsStoreSchedule.storeScheduleDayAggr.model.checker.SteddagrCheckLangu;
import br.com.mind5.stats.statsStoreSchedule.storeScheduleDayAggr.model.checker.SteddagrCheckOwner;
import br.com.mind5.stats.statsStoreSchedule.storeScheduleDayAggr.model.checker.SteddagrCheckRead;
import br.com.mind5.stats.statsStoreSchedule.storeScheduleDayAggr.model.checker.SteddagrCheckStore;


public final class RootSteddagrSelect extends DeciTreeTemplateWrite<SteddagrInfo> {
	
	public RootSteddagrSelect(DeciTreeOption<SteddagrInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<SteddagrInfo> buildCheckerHook(DeciTreeOption<SteddagrInfo> option) {
		List<ModelChecker<SteddagrInfo>> queue = new ArrayList<>();		
		ModelChecker<SteddagrInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;		
		checker = new SteddagrCheckRead(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new SteddagrCheckLangu(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new SteddagrCheckOwner(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new SteddagrCheckStore(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<SteddagrInfo>> buildActionsOnPassedHook(DeciTreeOption<SteddagrInfo> option) {
		List<ActionStd<SteddagrInfo>> actions = new ArrayList<>();

		ActionStd<SteddagrInfo> select = new StdSteddagrMergeToSelect(option);
		ActionLazy<SteddagrInfo> enforceHasData = new LazySteddagrEnforceHasData(option.conn, option.schemaName);
		ActionLazy<SteddagrInfo> mergeState = new LazySteddagrMergeState(option.conn, option.schemaName);
		ActionLazy<SteddagrInfo> mergeCalate = new LazySteddagrMergeCalate(option.conn, option.schemaName);		
		
		select.addPostAction(enforceHasData);
		enforceHasData.addPostAction(mergeState);
		mergeState.addPostAction(mergeCalate);
		
		actions.add(select);
		return actions;
	}
}
