package br.com.mind5.stats.statsStoreSchedule.storeScheduleMonthLive.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;
import br.com.mind5.stats.statsStoreSchedule.storeScheduleMonthLive.info.StedmoniveInfo;
import br.com.mind5.stats.statsStoreSchedule.storeScheduleMonthLive.model.action.LazyStedmoniveEnforceLChanged;
import br.com.mind5.stats.statsStoreSchedule.storeScheduleMonthLive.model.action.LazyStedmoniveMergeCalonth;
import br.com.mind5.stats.statsStoreSchedule.storeScheduleMonthLive.model.action.LazyStedmoniveMergeState;
import br.com.mind5.stats.statsStoreSchedule.storeScheduleMonthLive.model.action.StdStedmoniveMergeToSelect;
import br.com.mind5.stats.statsStoreSchedule.storeScheduleMonthLive.model.checker.StedmoniveCheckLangu;
import br.com.mind5.stats.statsStoreSchedule.storeScheduleMonthLive.model.checker.StedmoniveCheckOwner;
import br.com.mind5.stats.statsStoreSchedule.storeScheduleMonthLive.model.checker.StedmoniveCheckRead;
import br.com.mind5.stats.statsStoreSchedule.storeScheduleMonthLive.model.checker.StedmoniveCheckStore;


public final class RootStedmoniveSelect extends DeciTreeTemplateWrite<StedmoniveInfo> {
	
	public RootStedmoniveSelect(DeciTreeOption<StedmoniveInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<StedmoniveInfo> buildCheckerHook(DeciTreeOption<StedmoniveInfo> option) {
		List<ModelChecker<StedmoniveInfo>> queue = new ArrayList<>();		
		ModelChecker<StedmoniveInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;		
		checker = new StedmoniveCheckRead(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new StedmoniveCheckLangu(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new StedmoniveCheckOwner(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new StedmoniveCheckStore(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<StedmoniveInfo>> buildActionsOnPassedHook(DeciTreeOption<StedmoniveInfo> option) {
		List<ActionStd<StedmoniveInfo>> actions = new ArrayList<>();

		ActionStd<StedmoniveInfo> select = new StdStedmoniveMergeToSelect(option);
		ActionLazy<StedmoniveInfo> enforceLChanged = new LazyStedmoniveEnforceLChanged(option.conn, option.schemaName);
		ActionLazy<StedmoniveInfo> mergeState = new LazyStedmoniveMergeState(option.conn, option.schemaName);
		ActionLazy<StedmoniveInfo> mergeCalonth = new LazyStedmoniveMergeCalonth(option.conn, option.schemaName);		
		
		select.addPostAction(enforceLChanged);
		enforceLChanged.addPostAction(mergeState);
		mergeState.addPostAction(mergeCalonth);
		
		actions.add(select);
		return actions;
	}
}
