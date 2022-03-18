package br.com.mind5.stats.statsStoreSchedule.storeScheduleMonthAggr.model.decisionTree;

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
import br.com.mind5.stats.statsStoreSchedule.storeScheduleMonthAggr.info.StedmonagrInfo;
import br.com.mind5.stats.statsStoreSchedule.storeScheduleMonthAggr.model.action.StedmonagrVisiMergeCalonth;
import br.com.mind5.stats.statsStoreSchedule.storeScheduleMonthAggr.model.action.StedmonagrVisiMergeState;
import br.com.mind5.stats.statsStoreSchedule.storeScheduleMonthAggr.model.action.StedmonagrVisiMergeToSelect;
import br.com.mind5.stats.statsStoreSchedule.storeScheduleMonthAggr.model.checker.StedmonagrCheckLangu;
import br.com.mind5.stats.statsStoreSchedule.storeScheduleMonthAggr.model.checker.StedmonagrCheckOwner;
import br.com.mind5.stats.statsStoreSchedule.storeScheduleMonthAggr.model.checker.StedmonagrCheckRead;
import br.com.mind5.stats.statsStoreSchedule.storeScheduleMonthAggr.model.checker.StedmonagrCheckStore;


public final class StedmonagrRootSelect extends DeciTreeTemplateWrite<StedmonagrInfo> {
	
	public StedmonagrRootSelect(DeciTreeOption<StedmonagrInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<StedmonagrInfo> buildCheckerHook(DeciTreeOption<StedmonagrInfo> option) {
		List<ModelChecker<StedmonagrInfo>> queue = new ArrayList<>();
		ModelChecker<StedmonagrInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;
		checker = new StedmonagrCheckRead(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;
		checker = new StedmonagrCheckLangu(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;
		checker = new StedmonagrCheckOwner(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;
		checker = new StedmonagrCheckStore(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<StedmonagrInfo>> buildActionsOnPassedHook(DeciTreeOption<StedmonagrInfo> option) {
		List<ActionStd<StedmonagrInfo>> actions = new ArrayList<>();

		ActionStd<StedmonagrInfo> select = new ActionStdCommom<StedmonagrInfo>(option, StedmonagrVisiMergeToSelect.class);
		ActionLazy<StedmonagrInfo> mergeState = new ActionLazyCommom<StedmonagrInfo>(option.conn, option.schemaName, StedmonagrVisiMergeState.class);
		ActionLazy<StedmonagrInfo> mergeCalonth = new ActionLazyCommom<StedmonagrInfo>(option.conn, option.schemaName, StedmonagrVisiMergeCalonth.class);
		
		select.addPostAction(mergeState);
		mergeState.addPostAction(mergeCalonth);
		
		actions.add(select);
		return actions;
	}
}
