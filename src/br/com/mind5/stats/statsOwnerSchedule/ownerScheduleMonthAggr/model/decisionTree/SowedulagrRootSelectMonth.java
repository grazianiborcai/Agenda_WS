package br.com.mind5.stats.statsOwnerSchedule.ownerScheduleMonthAggr.model.decisionTree;

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
import br.com.mind5.stats.statsOwnerSchedule.ownerScheduleMonthAggr.info.SowedulagrInfo;
import br.com.mind5.stats.statsOwnerSchedule.ownerScheduleMonthAggr.model.action.SowedulagrVisiMergeSowedularchMonth;
import br.com.mind5.stats.statsOwnerSchedule.ownerScheduleMonthAggr.model.action.SowedulagrVisiRootSelect;


public final class SowedulagrRootSelectMonth extends DeciTreeTemplateWrite<SowedulagrInfo> {
	
	public SowedulagrRootSelectMonth(DeciTreeOption<SowedulagrInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<SowedulagrInfo> buildCheckerHook(DeciTreeOption<SowedulagrInfo> option) {
		List<ModelChecker<SowedulagrInfo>> queue = new ArrayList<>();
		ModelChecker<SowedulagrInfo> checker;

		checker = new ModelCheckerDummy<SowedulagrInfo>();
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<SowedulagrInfo>> buildActionsOnPassedHook(DeciTreeOption<SowedulagrInfo> option) {
		List<ActionStd<SowedulagrInfo>> actions = new ArrayList<>();

		ActionStd<SowedulagrInfo> mergeSowedularchMonth = new ActionStdCommom<SowedulagrInfo>(option, SowedulagrVisiMergeSowedularchMonth.class);
		ActionLazy<SowedulagrInfo> select = new ActionLazyCommom<SowedulagrInfo>(option, SowedulagrVisiRootSelect.class);
		
		mergeSowedularchMonth.addPostAction(select);
		
		actions.add(mergeSowedularchMonth);
		return actions;
	}
}
