package br.com.mind5.stats.statsStoreOrder.storeOrderMonthAggr.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;
import br.com.mind5.stats.statsStoreOrder.storeOrderMonthAggr.info.StoronagrInfo;
import br.com.mind5.stats.statsStoreOrder.storeOrderMonthAggr.model.action.StoronagrVisiDaoDelete;
import br.com.mind5.stats.statsStoreOrder.storeOrderMonthAggr.model.checker.StoronagrCheckExist;
import br.com.mind5.stats.statsStoreOrder.storeOrderMonthAggr.model.checker.StoronagrCheckLangu;
import br.com.mind5.stats.statsStoreOrder.storeOrderMonthAggr.model.checker.StoronagrCheckOwner;
import br.com.mind5.stats.statsStoreOrder.storeOrderMonthAggr.model.checker.StoronagrCheckStore;
import br.com.mind5.stats.statsStoreOrder.storeOrderMonthAggr.model.checker.StoronagrCheckWrite;

public final class StoronagrRootDelete extends DeciTreeTemplateWrite<StoronagrInfo> {
	
	public StoronagrRootDelete(DeciTreeOption<StoronagrInfo> option) {
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
		checker = new StoronagrCheckWrite(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;
		checker = new StoronagrCheckLangu(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;
		checker = new StoronagrCheckOwner(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;
		checker = new StoronagrCheckStore(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;
		checker = new StoronagrCheckExist(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<StoronagrInfo>> buildActionsOnPassedHook(DeciTreeOption<StoronagrInfo> option) {
		List<ActionStd<StoronagrInfo>> actions = new ArrayList<>();
		
		ActionStd<StoronagrInfo> delete = new ActionStdCommom<StoronagrInfo>(option, StoronagrVisiDaoDelete.class);
		
		actions.add(delete);
		
		return actions;
	}
}
