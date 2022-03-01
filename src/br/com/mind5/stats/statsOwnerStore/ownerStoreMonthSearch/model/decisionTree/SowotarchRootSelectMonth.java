package br.com.mind5.stats.statsOwnerStore.ownerStoreMonthSearch.model.decisionTree;

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
import br.com.mind5.stats.statsOwnerStore.ownerStoreMonthSearch.info.SowotarchInfo;
import br.com.mind5.stats.statsOwnerStore.ownerStoreMonthSearch.model.action.SowotarchVisiEnforceCalmonth;
import br.com.mind5.stats.statsOwnerStore.ownerStoreMonthSearch.model.action.SowotarchVisiRootSelect;
import br.com.mind5.stats.statsOwnerStore.ownerStoreMonthSearch.model.checker.SowotarchCheckReadMonth;


public final class SowotarchRootSelectMonth extends DeciTreeTemplateWrite<SowotarchInfo> {
	
	public SowotarchRootSelectMonth(DeciTreeOption<SowotarchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<SowotarchInfo> buildCheckerHook(DeciTreeOption<SowotarchInfo> option) {
		List<ModelChecker<SowotarchInfo>> queue = new ArrayList<>();
		ModelChecker<SowotarchInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;
		checker = new SowotarchCheckReadMonth(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<SowotarchInfo>> buildActionsOnPassedHook(DeciTreeOption<SowotarchInfo> option) {
		List<ActionStd<SowotarchInfo>> actions = new ArrayList<>();

		ActionStd<SowotarchInfo> enforceCalmonth = new ActionStdCommom<SowotarchInfo>(option, SowotarchVisiEnforceCalmonth.class);
		ActionLazy<SowotarchInfo> select = new ActionLazyCommom<SowotarchInfo>(option.conn, option.schemaName, SowotarchVisiRootSelect.class);
		
		enforceCalmonth.addPostAction(select);
		
		actions.add(enforceCalmonth);
		return actions;
	}
}
