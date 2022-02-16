package br.com.mind5.stats.statsStoreSchedule.storeScheduleDayAggr.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;
import br.com.mind5.stats.statsStoreSchedule.storeScheduleDayAggr.info.SteddagrInfo;
import br.com.mind5.stats.statsStoreSchedule.storeScheduleDayAggr.model.checker.SteddagrCheckExist;


public final class NodeSteddagrUpsert extends DeciTreeTemplateWrite<SteddagrInfo> {
	
	public NodeSteddagrUpsert(DeciTreeOption<SteddagrInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<SteddagrInfo> buildCheckerHook(DeciTreeOption<SteddagrInfo> option) {
		List<ModelChecker<SteddagrInfo>> queue = new ArrayList<>();		
		ModelChecker<SteddagrInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new SteddagrCheckExist(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<SteddagrInfo>> buildActionsOnPassedHook(DeciTreeOption<SteddagrInfo> option) {
		List<ActionStd<SteddagrInfo>> actions = new ArrayList<>();

		ActionStd<SteddagrInfo> delete = new RootSteddagrDelete(option).toAction();
		ActionStd<SteddagrInfo> insert = new RootSteddagrInsert(option).toAction();
		
		actions.add(delete);
		actions.add(insert);
		
		return actions;
	}
	
	
	
	@Override protected List<ActionStd<SteddagrInfo>> buildActionsOnFailedHook(DeciTreeOption<SteddagrInfo> option) {
		List<ActionStd<SteddagrInfo>> actions = new ArrayList<>();

		ActionStd<SteddagrInfo> insert = new RootSteddagrInsert(option).toAction();
		
		actions.add(insert);
		return actions;
	}
}
