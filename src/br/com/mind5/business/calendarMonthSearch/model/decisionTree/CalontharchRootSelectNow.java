package br.com.mind5.business.calendarMonthSearch.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.calendarMonthSearch.info.CalontharchInfo;
import br.com.mind5.business.calendarMonthSearch.model.action.CalontharchVisiEnforceNow;
import br.com.mind5.business.calendarMonthSearch.model.action.CalontharchVisiRootSelect;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.common.ModelCheckerDummy;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;

public final class CalontharchRootSelectNow extends DeciTreeTemplateRead<CalontharchInfo> {
	
	public CalontharchRootSelectNow(DeciTreeOption<CalontharchInfo> option) {
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
		
		ActionStd<CalontharchInfo> enforceNow = new ActionStdCommom<CalontharchInfo>(option, CalontharchVisiEnforceNow.class);
		ActionLazy<CalontharchInfo> select = new ActionLazyCommom<CalontharchInfo>(option, CalontharchVisiRootSelect.class);
		
		enforceNow.addPostAction(select);
		
		actions.add(enforceNow);
		return actions;
	}
}
