package br.com.mind5.stats.statsOwnerSchedule.ownerScheduleMonthSearch.model.decisionTree;

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
import br.com.mind5.stats.statsOwnerSchedule.ownerScheduleMonthSearch.info.SowedularchInfo;
import br.com.mind5.stats.statsOwnerSchedule.ownerScheduleMonthSearch.model.action.SowedularchVisiEnforceCalmonth;
import br.com.mind5.stats.statsOwnerSchedule.ownerScheduleMonthSearch.model.action.SowedularchVisiRootSelect;
import br.com.mind5.stats.statsOwnerSchedule.ownerScheduleMonthSearch.model.checker.SowedularchCheckReadMonth;


public final class SowedularchRootSelectMonth extends DeciTreeTemplateWrite<SowedularchInfo> {
	
	public SowedularchRootSelectMonth(DeciTreeOption<SowedularchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<SowedularchInfo> buildCheckerHook(DeciTreeOption<SowedularchInfo> option) {
		List<ModelChecker<SowedularchInfo>> queue = new ArrayList<>();
		ModelChecker<SowedularchInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;
		checker = new SowedularchCheckReadMonth(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<SowedularchInfo>> buildActionsOnPassedHook(DeciTreeOption<SowedularchInfo> option) {
		List<ActionStd<SowedularchInfo>> actions = new ArrayList<>();

		ActionStd<SowedularchInfo> enforceCalmonth = new ActionStdCommom<SowedularchInfo>(option, SowedularchVisiEnforceCalmonth.class);
		ActionLazy<SowedularchInfo> select = new ActionLazyCommom<SowedularchInfo>(option, SowedularchVisiRootSelect.class);
		
		enforceCalmonth.addPostAction(select);
		
		actions.add(enforceCalmonth);
		return actions;
	}
}
