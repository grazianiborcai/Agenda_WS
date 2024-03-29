package br.com.mind5.stats.statsStoreOrder.storeOrderDayLive.model.decisionTree;

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
import br.com.mind5.stats.statsStoreOrder.storeOrderDayLive.info.StordiveInfo;
import br.com.mind5.stats.statsStoreOrder.storeOrderDayLive.model.action.StordiveVisiRootSelect;
import br.com.mind5.stats.statsStoreOrder.storeOrderDayLive.model.checker.StordiveCheckLangu;
import br.com.mind5.stats.statsStoreOrder.storeOrderDayLive.model.checker.StordiveCheckOwner;
import br.com.mind5.stats.statsStoreOrder.storeOrderDayLive.model.checker.StordiveCheckRead;
import br.com.mind5.stats.statsStoreOrder.storeOrderDayLive.model.checker.StordiveCheckStore;


public final class StordiveRootSelectAuth extends DeciTreeTemplateWrite<StordiveInfo> {
	
	public StordiveRootSelectAuth(DeciTreeOption<StordiveInfo> option) {
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

		ActionStd<StordiveInfo> auth = new StordiveNodeAuthL1(option).toAction();
		ActionLazy<StordiveInfo> select = new ActionLazyCommom<StordiveInfo>(option, StordiveVisiRootSelect.class);
		
		auth.addPostAction(select);
		
		actions.add(auth);
		return actions;
	}
}
