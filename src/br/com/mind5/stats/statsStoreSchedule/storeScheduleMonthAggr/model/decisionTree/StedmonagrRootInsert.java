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
import br.com.mind5.stats.statsStoreSchedule.storeScheduleMonthAggr.model.action.StedmonagrVisiDaoInsert;
import br.com.mind5.stats.statsStoreSchedule.storeScheduleMonthAggr.model.action.StedmonagrVisiEnforceLChanged;
import br.com.mind5.stats.statsStoreSchedule.storeScheduleMonthAggr.model.checker.StedmonagrCheckExist;
import br.com.mind5.stats.statsStoreSchedule.storeScheduleMonthAggr.model.checker.StedmonagrCheckLangu;
import br.com.mind5.stats.statsStoreSchedule.storeScheduleMonthAggr.model.checker.StedmonagrCheckOwner;
import br.com.mind5.stats.statsStoreSchedule.storeScheduleMonthAggr.model.checker.StedmonagrCheckStore;
import br.com.mind5.stats.statsStoreSchedule.storeScheduleMonthAggr.model.checker.StedmonagrCheckWrite;


public final class StedmonagrRootInsert extends DeciTreeTemplateWrite<StedmonagrInfo> {
	
	public StedmonagrRootInsert(DeciTreeOption<StedmonagrInfo> option) {
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
		checker = new StedmonagrCheckWrite(checkerOption);
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
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.NOT_FOUND;		
		checker = new StedmonagrCheckExist(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<StedmonagrInfo>> buildActionsOnPassedHook(DeciTreeOption<StedmonagrInfo> option) {
		List<ActionStd<StedmonagrInfo>> actions = new ArrayList<>();

		ActionStd<StedmonagrInfo> enforceLChanged = new ActionStdCommom<StedmonagrInfo>(option, StedmonagrVisiEnforceLChanged.class);
		ActionLazy<StedmonagrInfo> insert = new ActionLazyCommom<StedmonagrInfo>(option.conn, option.schemaName, StedmonagrVisiDaoInsert.class);
		
		enforceLChanged.addPostAction(insert);
		
		actions.add(enforceLChanged);
		return actions;
	}
}
