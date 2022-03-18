package br.com.mind5.stats.statsStoreSchedule.storeScheduleDayLive.model.decisionTree;

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
import br.com.mind5.stats.statsStoreSchedule.storeScheduleDayLive.info.SteddiveInfo;
import br.com.mind5.stats.statsStoreSchedule.storeScheduleDayLive.model.action.SteddiveVisiEnforceLChanged;
import br.com.mind5.stats.statsStoreSchedule.storeScheduleDayLive.model.action.SteddiveVisiMergeCalate;
import br.com.mind5.stats.statsStoreSchedule.storeScheduleDayLive.model.action.SteddiveVisiMergeState;
import br.com.mind5.stats.statsStoreSchedule.storeScheduleDayLive.model.action.SteddiveVisiMergeToSelect;
import br.com.mind5.stats.statsStoreSchedule.storeScheduleDayLive.model.checker.SteddiveCheckLangu;
import br.com.mind5.stats.statsStoreSchedule.storeScheduleDayLive.model.checker.SteddiveCheckOwner;
import br.com.mind5.stats.statsStoreSchedule.storeScheduleDayLive.model.checker.SteddiveCheckRead;
import br.com.mind5.stats.statsStoreSchedule.storeScheduleDayLive.model.checker.SteddiveCheckStore;


public final class SteddiveRootSelect extends DeciTreeTemplateWrite<SteddiveInfo> {
	
	public SteddiveRootSelect(DeciTreeOption<SteddiveInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<SteddiveInfo> buildCheckerHook(DeciTreeOption<SteddiveInfo> option) {
		List<ModelChecker<SteddiveInfo>> queue = new ArrayList<>();		
		ModelChecker<SteddiveInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;		
		checker = new SteddiveCheckRead(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new SteddiveCheckLangu(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new SteddiveCheckOwner(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new SteddiveCheckStore(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<SteddiveInfo>> buildActionsOnPassedHook(DeciTreeOption<SteddiveInfo> option) {
		List<ActionStd<SteddiveInfo>> actions = new ArrayList<>();

		ActionStd<SteddiveInfo> select = new ActionStdCommom<SteddiveInfo>(option, SteddiveVisiMergeToSelect.class);
		ActionLazy<SteddiveInfo> enforceLChanged = new ActionLazyCommom<SteddiveInfo>(option.conn, option.schemaName, SteddiveVisiEnforceLChanged.class);
		ActionLazy<SteddiveInfo> mergeState = new ActionLazyCommom<SteddiveInfo>(option.conn, option.schemaName, SteddiveVisiMergeState.class);
		ActionLazy<SteddiveInfo> mergeCalate = new ActionLazyCommom<SteddiveInfo>(option.conn, option.schemaName, SteddiveVisiMergeCalate.class);		
		
		select.addPostAction(enforceLChanged);
		enforceLChanged.addPostAction(mergeState);
		mergeState.addPostAction(mergeCalate);
		
		actions.add(select);
		return actions;
	}
}
