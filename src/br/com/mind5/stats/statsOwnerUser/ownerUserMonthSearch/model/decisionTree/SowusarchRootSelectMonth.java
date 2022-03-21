package br.com.mind5.stats.statsOwnerUser.ownerUserMonthSearch.model.decisionTree;

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
import br.com.mind5.stats.statsOwnerUser.ownerUserMonthSearch.info.SowusarchInfo;
import br.com.mind5.stats.statsOwnerUser.ownerUserMonthSearch.model.action.SowusarchVisiEnforceCalmonth;
import br.com.mind5.stats.statsOwnerUser.ownerUserMonthSearch.model.action.SowusarchVisiRootSelect;
import br.com.mind5.stats.statsOwnerUser.ownerUserMonthSearch.model.checker.SowusarchCheckReadMonth;


public final class SowusarchRootSelectMonth extends DeciTreeTemplateWrite<SowusarchInfo> {
	
	public SowusarchRootSelectMonth(DeciTreeOption<SowusarchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<SowusarchInfo> buildCheckerHook(DeciTreeOption<SowusarchInfo> option) {
		List<ModelChecker<SowusarchInfo>> queue = new ArrayList<>();
		ModelChecker<SowusarchInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;
		checker = new SowusarchCheckReadMonth(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<SowusarchInfo>> buildActionsOnPassedHook(DeciTreeOption<SowusarchInfo> option) {
		List<ActionStd<SowusarchInfo>> actions = new ArrayList<>();

		ActionStd<SowusarchInfo> enforceCalmonth = new ActionStdCommom<SowusarchInfo>(option, SowusarchVisiEnforceCalmonth.class);
		ActionLazy<SowusarchInfo> select = new ActionLazyCommom<SowusarchInfo>(option, SowusarchVisiRootSelect.class);
		
		enforceCalmonth.addPostAction(select);
		
		actions.add(enforceCalmonth);
		return actions;
	}
}
