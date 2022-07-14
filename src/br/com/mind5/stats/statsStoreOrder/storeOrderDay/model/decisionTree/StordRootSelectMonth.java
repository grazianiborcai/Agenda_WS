package br.com.mind5.stats.statsStoreOrder.storeOrderDay.model.decisionTree;

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
import br.com.mind5.stats.statsStoreOrder.storeOrderDay.info.StordInfo;
import br.com.mind5.stats.statsStoreOrder.storeOrderDay.model.action.StordVisiRootSelect;
import br.com.mind5.stats.statsStoreOrder.storeOrderDay.model.action.StordVisiEnforceYearMonth;
import br.com.mind5.stats.statsStoreOrder.storeOrderDay.model.action.StordVisiMergeCalateMonth;
import br.com.mind5.stats.statsStoreOrder.storeOrderDay.model.checker.StordCheckReadMonth;


public final class StordRootSelectMonth extends DeciTreeTemplateWrite<StordInfo> {
	
	public StordRootSelectMonth(DeciTreeOption<StordInfo> option) {
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
		checker = new StordCheckReadMonth(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<StordInfo>> buildActionsOnPassedHook(DeciTreeOption<StordInfo> option) {
		List<ActionStd<StordInfo>> actions = new ArrayList<>();


		ActionStd<StordInfo> enforceYearMonth = new ActionStdCommom<StordInfo>(option, StordVisiEnforceYearMonth.class);
		ActionLazy<StordInfo> mergeCalateMonth = new ActionLazyCommom<StordInfo>(option, StordVisiMergeCalateMonth.class);
		ActionLazy<StordInfo> select = new ActionLazyCommom<StordInfo>(option, StordVisiRootSelect.class);
		
		enforceYearMonth.addPostAction(mergeCalateMonth);
		mergeCalateMonth.addPostAction(select);
		
		actions.add(enforceYearMonth);
		return actions;
	}
}
