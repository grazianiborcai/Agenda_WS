package br.com.mind5.business.calendarMonthSearch.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.calendarMonthSearch.info.CalontharchInfo;
import br.com.mind5.business.calendarMonthSearch.model.action.LazyCalontharchRootSelect;
import br.com.mind5.business.calendarMonthSearch.model.action.StdCalontharchEnforceL2m;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.common.ModelCheckerDummy;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;

public final class RootCalontharchSelectL2m extends DeciTreeTemplateRead<CalontharchInfo> {
	
	public RootCalontharchSelectL2m(DeciTreeOption<CalontharchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<CalontharchInfo> buildCheckerHook(DeciTreeOption<CalontharchInfo> option) {
		List<ModelChecker<CalontharchInfo>> queue = new ArrayList<>();
		ModelChecker<CalontharchInfo> checker;
		
		checker = new ModelCheckerDummy<>();
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}

		
	
	@Override protected List<ActionStd<CalontharchInfo>> buildActionsOnPassedHook(DeciTreeOption<CalontharchInfo> option) {
		List<ActionStd<CalontharchInfo>> actions = new ArrayList<>();
		
		ActionStd<CalontharchInfo> enforceL2m = new StdCalontharchEnforceL2m(option);
		ActionLazy<CalontharchInfo> select = new LazyCalontharchRootSelect(option.conn, option.schemaName);
		
		enforceL2m.addPostAction(select);
		
		actions.add(enforceL2m);
		return actions;
	}
}
