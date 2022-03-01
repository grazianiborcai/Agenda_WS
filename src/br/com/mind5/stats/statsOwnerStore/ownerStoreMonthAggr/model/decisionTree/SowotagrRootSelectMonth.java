package br.com.mind5.stats.statsOwnerStore.ownerStoreMonthAggr.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.common.ModelCheckerDummy;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;
import br.com.mind5.stats.statsOwnerStore.ownerStoreMonthAggr.info.SowotagrInfo;
import br.com.mind5.stats.statsOwnerStore.ownerStoreMonthAggr.model.action.SowotagrVisiMergeSowotarchMonth;
import br.com.mind5.stats.statsOwnerStore.ownerStoreMonthAggr.model.action.SowotagrVisiRootSelect;


public final class SowotagrRootSelectMonth extends DeciTreeTemplateWrite<SowotagrInfo> {
	
	public SowotagrRootSelectMonth(DeciTreeOption<SowotagrInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<SowotagrInfo> buildCheckerHook(DeciTreeOption<SowotagrInfo> option) {
		List<ModelChecker<SowotagrInfo>> queue = new ArrayList<>();
		ModelChecker<SowotagrInfo> checker;

		checker = new ModelCheckerDummy<SowotagrInfo>();
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<SowotagrInfo>> buildActionsOnPassedHook(DeciTreeOption<SowotagrInfo> option) {
		List<ActionStd<SowotagrInfo>> actions = new ArrayList<>();

		ActionStd<SowotagrInfo> mergeSowotarchMonth = new ActionStdCommom<SowotagrInfo>(option, SowotagrVisiMergeSowotarchMonth.class);
		ActionLazy<SowotagrInfo> select = new ActionLazyCommom<SowotagrInfo>(option.conn, option.schemaName, SowotagrVisiRootSelect.class);
		
		mergeSowotarchMonth.addPostAction(select);
		
		actions.add(mergeSowotarchMonth);
		return actions;
	}
}
