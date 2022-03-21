package br.com.mind5.stats.statsOwnerUser.ownerUserMonthAggr.model.decisionTree;

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
import br.com.mind5.stats.statsOwnerUser.ownerUserMonthAggr.info.SowusagrInfo;
import br.com.mind5.stats.statsOwnerUser.ownerUserMonthAggr.model.action.SowusagrVisiMergeSowusarchMonth;
import br.com.mind5.stats.statsOwnerUser.ownerUserMonthAggr.model.action.SowusagrVisiRootSelect;


public final class SowusagrRootSelectMonth extends DeciTreeTemplateWrite<SowusagrInfo> {
	
	public SowusagrRootSelectMonth(DeciTreeOption<SowusagrInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<SowusagrInfo> buildCheckerHook(DeciTreeOption<SowusagrInfo> option) {
		List<ModelChecker<SowusagrInfo>> queue = new ArrayList<>();
		ModelChecker<SowusagrInfo> checker;

		checker = new ModelCheckerDummy<SowusagrInfo>();
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<SowusagrInfo>> buildActionsOnPassedHook(DeciTreeOption<SowusagrInfo> option) {
		List<ActionStd<SowusagrInfo>> actions = new ArrayList<>();

		ActionStd<SowusagrInfo> mergeSowusarchMonth = new ActionStdCommom<SowusagrInfo>(option, SowusagrVisiMergeSowusarchMonth.class);
		ActionLazy<SowusagrInfo> select = new ActionLazyCommom<SowusagrInfo>(option, SowusagrVisiRootSelect.class);
		
		mergeSowusarchMonth.addPostAction(select);
		
		actions.add(mergeSowusarchMonth);
		return actions;
	}
}
