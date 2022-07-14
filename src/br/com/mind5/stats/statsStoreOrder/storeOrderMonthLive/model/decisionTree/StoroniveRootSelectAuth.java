package br.com.mind5.stats.statsStoreOrder.storeOrderMonthLive.model.decisionTree;

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
import br.com.mind5.stats.statsStoreOrder.storeOrderMonthLive.info.StoroniveInfo;
import br.com.mind5.stats.statsStoreOrder.storeOrderMonthLive.model.action.StoroniveVisiRootSelect;
import br.com.mind5.stats.statsStoreOrder.storeOrderMonthLive.model.checker.StoroniveCheckLangu;
import br.com.mind5.stats.statsStoreOrder.storeOrderMonthLive.model.checker.StoroniveCheckOwner;
import br.com.mind5.stats.statsStoreOrder.storeOrderMonthLive.model.checker.StoroniveCheckRead;
import br.com.mind5.stats.statsStoreOrder.storeOrderMonthLive.model.checker.StoroniveCheckStore;


public final class StoroniveRootSelectAuth extends DeciTreeTemplateWrite<StoroniveInfo> {
	
	public StoroniveRootSelectAuth(DeciTreeOption<StoroniveInfo> option) {
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

		ActionStd<StoroniveInfo> auth = new StoroniveNodeAuthL1(option).toAction();
		ActionLazy<StoroniveInfo> select = new ActionLazyCommom<StoroniveInfo>(option, StoroniveVisiRootSelect.class);
		
		auth.addPostAction(select);
		
		actions.add(auth);
		return actions;
	}
}
