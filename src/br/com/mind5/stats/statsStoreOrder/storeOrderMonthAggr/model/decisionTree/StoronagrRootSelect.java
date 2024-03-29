package br.com.mind5.stats.statsStoreOrder.storeOrderMonthAggr.model.decisionTree;

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
import br.com.mind5.stats.statsStoreOrder.storeOrderMonthAggr.info.StoronagrInfo;
import br.com.mind5.stats.statsStoreOrder.storeOrderMonthAggr.model.action.StoronagrVisiMergeCalonth;
import br.com.mind5.stats.statsStoreOrder.storeOrderMonthAggr.model.action.StoronagrVisiMergeState;
import br.com.mind5.stats.statsStoreOrder.storeOrderMonthAggr.model.action.StoronagrVisiMergeToSelect;
import br.com.mind5.stats.statsStoreOrder.storeOrderMonthAggr.model.checker.StoronagrCheckLangu;
import br.com.mind5.stats.statsStoreOrder.storeOrderMonthAggr.model.checker.StoronagrCheckOwner;
import br.com.mind5.stats.statsStoreOrder.storeOrderMonthAggr.model.checker.StoronagrCheckRead;
import br.com.mind5.stats.statsStoreOrder.storeOrderMonthAggr.model.checker.StoronagrCheckStore;


public final class StoronagrRootSelect extends DeciTreeTemplateWrite<StoronagrInfo> {
	
	public StoronagrRootSelect(DeciTreeOption<StoronagrInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<StoronagrInfo> buildCheckerHook(DeciTreeOption<StoronagrInfo> option) {
		List<ModelChecker<StoronagrInfo>> queue = new ArrayList<>();
		ModelChecker<StoronagrInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;
		checker = new StoronagrCheckRead(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;
		checker = new StoronagrCheckLangu(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;
		checker = new StoronagrCheckOwner(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;
		checker = new StoronagrCheckStore(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<StoronagrInfo>> buildActionsOnPassedHook(DeciTreeOption<StoronagrInfo> option) {
		List<ActionStd<StoronagrInfo>> actions = new ArrayList<>();

		ActionStd<StoronagrInfo> select = new ActionStdCommom<StoronagrInfo>(option, StoronagrVisiMergeToSelect.class);
		ActionLazy<StoronagrInfo> mergeState = new ActionLazyCommom<StoronagrInfo>(option, StoronagrVisiMergeState.class);
		ActionLazy<StoronagrInfo> mergeCalonth = new ActionLazyCommom<StoronagrInfo>(option, StoronagrVisiMergeCalonth.class);
		
		select.addPostAction(mergeState);
		mergeState.addPostAction(mergeCalonth);
		
		actions.add(select);
		return actions;
	}
}
