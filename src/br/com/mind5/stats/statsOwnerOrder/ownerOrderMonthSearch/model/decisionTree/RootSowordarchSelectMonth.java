package br.com.mind5.stats.statsOwnerOrder.ownerOrderMonthSearch.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;
import br.com.mind5.stats.statsOwnerOrder.ownerOrderMonthSearch.info.SowordarchInfo;
import br.com.mind5.stats.statsOwnerOrder.ownerOrderMonthSearch.model.action.LazySowordarchRootSelect;
import br.com.mind5.stats.statsOwnerOrder.ownerOrderMonthSearch.model.action.StdSowordarchEnforceCalmonth;
import br.com.mind5.stats.statsOwnerOrder.ownerOrderMonthSearch.model.checker.SowordarchCheckReadMonth;


public final class RootSowordarchSelectMonth extends DeciTreeTemplateWrite<SowordarchInfo> {
	
	public RootSowordarchSelectMonth(DeciTreeOption<SowordarchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<SowordarchInfo> buildCheckerHook(DeciTreeOption<SowordarchInfo> option) {
		List<ModelChecker<SowordarchInfo>> queue = new ArrayList<>();
		ModelChecker<SowordarchInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;
		checker = new SowordarchCheckReadMonth(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<SowordarchInfo>> buildActionsOnPassedHook(DeciTreeOption<SowordarchInfo> option) {
		List<ActionStd<SowordarchInfo>> actions = new ArrayList<>();

		ActionStd<SowordarchInfo> enforceCalmonth = new StdSowordarchEnforceCalmonth(option);
		ActionLazy<SowordarchInfo> select = new LazySowordarchRootSelect(option.conn, option.schemaName);
		
		enforceCalmonth.addPostAction(select);
		
		actions.add(enforceCalmonth);
		return actions;
	}
}
