package br.com.mind5.stats.statsStoreOrder.storeOrderDayAggr.model.decisionTree;

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
import br.com.mind5.stats.statsStoreOrder.storeOrderDayAggr.info.StordagrInfo;
import br.com.mind5.stats.statsStoreOrder.storeOrderDayAggr.model.action.StordagrVisiMergeCalate;
import br.com.mind5.stats.statsStoreOrder.storeOrderDayAggr.model.action.StordagrVisiMergeState;
import br.com.mind5.stats.statsStoreOrder.storeOrderDayAggr.model.action.StordagrVisiMergeToSelect;
import br.com.mind5.stats.statsStoreOrder.storeOrderDayAggr.model.checker.StordagrCheckLangu;
import br.com.mind5.stats.statsStoreOrder.storeOrderDayAggr.model.checker.StordagrCheckOwner;
import br.com.mind5.stats.statsStoreOrder.storeOrderDayAggr.model.checker.StordagrCheckRead;
import br.com.mind5.stats.statsStoreOrder.storeOrderDayAggr.model.checker.StordagrCheckStore;


public final class StordagrRootSelect extends DeciTreeTemplateWrite<StordagrInfo> {
	
	public StordagrRootSelect(DeciTreeOption<StordagrInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<StordagrInfo> buildCheckerHook(DeciTreeOption<StordagrInfo> option) {
		List<ModelChecker<StordagrInfo>> queue = new ArrayList<>();
		ModelChecker<StordagrInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;
		checker = new StordagrCheckRead(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;
		checker = new StordagrCheckLangu(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;
		checker = new StordagrCheckOwner(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;
		checker = new StordagrCheckStore(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<StordagrInfo>> buildActionsOnPassedHook(DeciTreeOption<StordagrInfo> option) {
		List<ActionStd<StordagrInfo>> actions = new ArrayList<>();

		ActionStd<StordagrInfo> select       = new ActionStdCommom<StordagrInfo> (option, StordagrVisiMergeToSelect.class);
		ActionLazy<StordagrInfo> mergeState  = new ActionLazyCommom<StordagrInfo>(option, StordagrVisiMergeState.class   );
		ActionLazy<StordagrInfo> mergeCalate = new ActionLazyCommom<StordagrInfo>(option, StordagrVisiMergeCalate.class  );
		
		select.addPostAction(mergeState);
		mergeState.addPostAction(mergeCalate);
		
		actions.add(select);
		return actions;
	}
}
