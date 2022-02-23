package br.com.mind5.stats.statsStoreOrder.storeOrderDayAggr.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;
import br.com.mind5.stats.statsStoreOrder.storeOrderDayAggr.info.StordagrInfo;
import br.com.mind5.stats.statsStoreOrder.storeOrderDayAggr.model.action.LazyStordagrDaoInsert;
import br.com.mind5.stats.statsStoreOrder.storeOrderDayAggr.model.action.StdStordagrEnforceLChanged;
import br.com.mind5.stats.statsStoreOrder.storeOrderDayAggr.model.checker.StordagrCheckExist;
import br.com.mind5.stats.statsStoreOrder.storeOrderDayAggr.model.checker.StordagrCheckLangu;
import br.com.mind5.stats.statsStoreOrder.storeOrderDayAggr.model.checker.StordagrCheckOwner;
import br.com.mind5.stats.statsStoreOrder.storeOrderDayAggr.model.checker.StordagrCheckStore;
import br.com.mind5.stats.statsStoreOrder.storeOrderDayAggr.model.checker.StordagrCheckWrite;


public final class RootStordagrInsert extends DeciTreeTemplateWrite<StordagrInfo> {
	
	public RootStordagrInsert(DeciTreeOption<StordagrInfo> option) {
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
		checker = new StordagrCheckWrite(checkerOption);
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
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.NOT_FOUND;
		checker = new StordagrCheckExist(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<StordagrInfo>> buildActionsOnPassedHook(DeciTreeOption<StordagrInfo> option) {
		List<ActionStd<StordagrInfo>> actions = new ArrayList<>();

		ActionStd<StordagrInfo> enforceLChanged = new StdStordagrEnforceLChanged(option);
		ActionLazy<StordagrInfo> insert = new LazyStordagrDaoInsert(option.conn, option.schemaName);
		
		enforceLChanged.addPostAction(insert);
		
		actions.add(enforceLChanged);
		return actions;
	}
}
