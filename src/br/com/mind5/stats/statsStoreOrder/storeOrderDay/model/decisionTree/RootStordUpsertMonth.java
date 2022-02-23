package br.com.mind5.stats.statsStoreOrder.storeOrderDay.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;
import br.com.mind5.stats.statsStoreOrder.storeOrderDay.info.StordInfo;
import br.com.mind5.stats.statsStoreOrder.storeOrderDay.model.action.LazySteddMergeCalateMonth;
import br.com.mind5.stats.statsStoreOrder.storeOrderDay.model.action.LazySteddRootUpsert;
import br.com.mind5.stats.statsStoreOrder.storeOrderDay.model.action.StdStordEnforceYearMonth;
import br.com.mind5.stats.statsStoreOrder.storeOrderDay.model.checker.StordCheckWriteMonth;


public final class RootStordUpsertMonth extends DeciTreeTemplateWrite<StordInfo> {
	
	public RootStordUpsertMonth(DeciTreeOption<StordInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<StordInfo> buildCheckerHook(DeciTreeOption<StordInfo> option) {
		List<ModelChecker<StordInfo>> queue = new ArrayList<>();
		ModelChecker<StordInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;
		checker = new StordCheckWriteMonth(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<StordInfo>> buildActionsOnPassedHook(DeciTreeOption<StordInfo> option) {
		List<ActionStd<StordInfo>> actions = new ArrayList<>();


		ActionStd<StordInfo> enforceYearMonth = new StdStordEnforceYearMonth(option);
		ActionLazy<StordInfo> mergeCalateMonth = new LazySteddMergeCalateMonth(option.conn, option.schemaName);
		ActionLazy<StordInfo> upsert = new LazySteddRootUpsert(option.conn, option.schemaName);
		
		enforceYearMonth.addPostAction(mergeCalateMonth);
		mergeCalateMonth.addPostAction(upsert);
		
		actions.add(enforceYearMonth);
		return actions;
	}
}
