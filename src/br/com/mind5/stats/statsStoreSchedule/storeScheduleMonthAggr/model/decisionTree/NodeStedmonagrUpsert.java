package br.com.mind5.stats.statsStoreSchedule.storeScheduleMonthAggr.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;
import br.com.mind5.stats.statsStoreSchedule.storeScheduleMonthAggr.info.StedmonagrInfo;
import br.com.mind5.stats.statsStoreSchedule.storeScheduleMonthAggr.model.checker.StedmonagrCheckExist;


public final class NodeStedmonagrUpsert extends DeciTreeTemplateWrite<StedmonagrInfo> {
	
	public NodeStedmonagrUpsert(DeciTreeOption<StedmonagrInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<StedmonagrInfo> buildCheckerHook(DeciTreeOption<StedmonagrInfo> option) {
		List<ModelChecker<StedmonagrInfo>> queue = new ArrayList<>();		
		ModelChecker<StedmonagrInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new StedmonagrCheckExist(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<StedmonagrInfo>> buildActionsOnPassedHook(DeciTreeOption<StedmonagrInfo> option) {
		List<ActionStd<StedmonagrInfo>> actions = new ArrayList<>();

		ActionStd<StedmonagrInfo> delete = new RootStedmonagrDelete(option).toAction();
		ActionStd<StedmonagrInfo> insert = new RootStedmonagrInsert(option).toAction();
		
		actions.add(delete);
		actions.add(insert);
		
		return actions;
	}
	
	
	
	@Override protected List<ActionStd<StedmonagrInfo>> buildActionsOnFailedHook(DeciTreeOption<StedmonagrInfo> option) {
		List<ActionStd<StedmonagrInfo>> actions = new ArrayList<>();

		ActionStd<StedmonagrInfo> insert = new RootStedmonagrInsert(option).toAction();
		
		actions.add(insert);
		return actions;
	}
}
