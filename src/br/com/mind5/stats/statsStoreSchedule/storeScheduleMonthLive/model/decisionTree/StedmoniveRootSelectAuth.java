package br.com.mind5.stats.statsStoreSchedule.storeScheduleMonthLive.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;
import br.com.mind5.stats.statsStoreSchedule.storeScheduleMonthLive.info.StedmoniveInfo;
import br.com.mind5.stats.statsStoreSchedule.storeScheduleMonthLive.model.action.StedmoniveVisiRootSelect;
import br.com.mind5.stats.statsStoreSchedule.storeScheduleMonthLive.model.checker.StedmoniveCheckLangu;
import br.com.mind5.stats.statsStoreSchedule.storeScheduleMonthLive.model.checker.StedmoniveCheckOwner;
import br.com.mind5.stats.statsStoreSchedule.storeScheduleMonthLive.model.checker.StedmoniveCheckRead;
import br.com.mind5.stats.statsStoreSchedule.storeScheduleMonthLive.model.checker.StedmoniveCheckStore;


public final class StedmoniveRootSelectAuth extends DeciTreeTemplateWrite<StedmoniveInfo> {
	
	public StedmoniveRootSelectAuth(DeciTreeOption<StedmoniveInfo> option) {
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

		ActionStd<StedmoniveInfo> auth = new StedmoniveNodeAuthL1(option).toAction();
		ActionLazy<StedmoniveInfo> select = new ActionLazyCommom<StedmoniveInfo>(option, StedmoniveVisiRootSelect.class);
		
		auth.addPostAction(select);
		
		actions.add(auth);
		return actions;
	}
}
