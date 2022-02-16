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
import br.com.mind5.stats.statsStoreSchedule.storeScheduleDayAggr.model.checker.SteddagrCheckLangu;
import br.com.mind5.stats.statsStoreSchedule.storeScheduleDayAggr.model.checker.SteddagrCheckOwner;
import br.com.mind5.stats.statsStoreSchedule.storeScheduleDayAggr.model.checker.SteddagrCheckStore;
import br.com.mind5.stats.statsStoreSchedule.storeScheduleDayAggr.model.checker.SteddagrCheckWrite;


public final class RootSteddagrUpsert extends DeciTreeTemplateWrite<SteddagrInfo> {
	
	public RootSteddagrUpsert(DeciTreeOption<SteddagrInfo> option) {
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
		checker = new SteddagrCheckWrite(checkerOption);
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

		ActionStd<SteddagrInfo> nodeL1 = new NodeSteddagrUpsert(option).toAction();
		
		actions.add(nodeL1);
		return actions;
	}
}
