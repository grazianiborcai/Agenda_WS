package br.com.mind5.stats.statsStoreOrder.storeOrderDayLive.model.decisionTree;

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
import br.com.mind5.stats.statsStoreOrder.storeOrderDayLive.info.StordiveInfo;
import br.com.mind5.stats.statsStoreOrder.storeOrderDayLive.model.action.StordiveVisiEnforceLChanged;
import br.com.mind5.stats.statsStoreOrder.storeOrderDayLive.model.action.StordiveVisiMergeCalate;
import br.com.mind5.stats.statsStoreOrder.storeOrderDayLive.model.action.StordiveVisiMergeState;
import br.com.mind5.stats.statsStoreOrder.storeOrderDayLive.model.action.StordiveVisiMergeToSelect;
import br.com.mind5.stats.statsStoreOrder.storeOrderDayLive.model.checker.StordiveCheckLangu;
import br.com.mind5.stats.statsStoreOrder.storeOrderDayLive.model.checker.StordiveCheckOwner;
import br.com.mind5.stats.statsStoreOrder.storeOrderDayLive.model.checker.StordiveCheckRead;
import br.com.mind5.stats.statsStoreOrder.storeOrderDayLive.model.checker.StordiveCheckStore;


public final class StordiveRootSelect extends DeciTreeTemplateWrite<StordiveInfo> {
	
	public StordiveRootSelect(DeciTreeOption<StordiveInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<StordiveInfo> buildCheckerHook(DeciTreeOption<StordiveInfo> option) {
		List<ModelChecker<StordiveInfo>> queue = new ArrayList<>();
		ModelChecker<StordiveInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;
		checker = new StordiveCheckRead(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;
		checker = new StordiveCheckLangu(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;
		checker = new StordiveCheckOwner(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;
		checker = new StordiveCheckStore(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<StordiveInfo>> buildActionsOnPassedHook(DeciTreeOption<StordiveInfo> option) {
		List<ActionStd<StordiveInfo>> actions = new ArrayList<>();

		ActionStd<StordiveInfo> select = new ActionStdCommom<StordiveInfo>(option, StordiveVisiMergeToSelect.class);
		ActionLazy<StordiveInfo> enforceLChanged = new ActionLazyCommom<StordiveInfo>(option, StordiveVisiEnforceLChanged.class);
		ActionLazy<StordiveInfo> mergeState = new ActionLazyCommom<StordiveInfo>(option, StordiveVisiMergeState.class);
		ActionLazy<StordiveInfo> mergeCalate = new ActionLazyCommom<StordiveInfo>(option, StordiveVisiMergeCalate.class);
		
		select.addPostAction(enforceLChanged);
		enforceLChanged.addPostAction(mergeState);
		mergeState.addPostAction(mergeCalate);
		
		actions.add(select);
		return actions;
	}
}
