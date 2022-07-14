package br.com.mind5.stats.statsStoreOrder.storeOrderMonthLive.model.decisionTree;

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
import br.com.mind5.stats.statsStoreOrder.storeOrderMonthLive.info.StoroniveInfo;
import br.com.mind5.stats.statsStoreOrder.storeOrderMonthLive.model.action.StoroniveVisiEnforceLChanged;
import br.com.mind5.stats.statsStoreOrder.storeOrderMonthLive.model.action.StoroniveVisiMergeCalonth;
import br.com.mind5.stats.statsStoreOrder.storeOrderMonthLive.model.action.StoroniveVisiMergeState;
import br.com.mind5.stats.statsStoreOrder.storeOrderMonthLive.model.action.StoroniveVisiMergeToSelect;
import br.com.mind5.stats.statsStoreOrder.storeOrderMonthLive.model.checker.StoroniveCheckLangu;
import br.com.mind5.stats.statsStoreOrder.storeOrderMonthLive.model.checker.StoroniveCheckOwner;
import br.com.mind5.stats.statsStoreOrder.storeOrderMonthLive.model.checker.StoroniveCheckRead;
import br.com.mind5.stats.statsStoreOrder.storeOrderMonthLive.model.checker.StoroniveCheckStore;


public final class StoroniveRootSelect extends DeciTreeTemplateWrite<StoroniveInfo> {
	
	public StoroniveRootSelect(DeciTreeOption<StoroniveInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<StoroniveInfo> buildCheckerHook(DeciTreeOption<StoroniveInfo> option) {
		List<ModelChecker<StoroniveInfo>> queue = new ArrayList<>();
		ModelChecker<StoroniveInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;
		checker = new StoroniveCheckRead(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;
		checker = new StoroniveCheckLangu(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;
		checker = new StoroniveCheckOwner(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;
		checker = new StoroniveCheckStore(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<StoroniveInfo>> buildActionsOnPassedHook(DeciTreeOption<StoroniveInfo> option) {
		List<ActionStd<StoroniveInfo>> actions = new ArrayList<>();

		ActionStd<StoroniveInfo> select = new ActionStdCommom<StoroniveInfo>(option, StoroniveVisiMergeToSelect.class);
		ActionLazy<StoroniveInfo> enforceLChanged = new ActionLazyCommom<StoroniveInfo>(option, StoroniveVisiEnforceLChanged.class);
		ActionLazy<StoroniveInfo> mergeState = new ActionLazyCommom<StoroniveInfo>(option, StoroniveVisiMergeState.class);
		ActionLazy<StoroniveInfo> mergeCalonth = new ActionLazyCommom<StoroniveInfo>(option, StoroniveVisiMergeCalonth.class);
		
		select.addPostAction(enforceLChanged);
		enforceLChanged.addPostAction(mergeState);
		mergeState.addPostAction(mergeCalonth);
		
		actions.add(select);
		return actions;
	}
}
