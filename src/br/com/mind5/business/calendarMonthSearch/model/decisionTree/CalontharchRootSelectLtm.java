package br.com.mind5.business.calendarMonthSearch.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.calendarMonthSearch.info.CalontharchInfo;
import br.com.mind5.business.calendarMonthSearch.model.action.CalontharchVisiEnforceBeginEnd;
import br.com.mind5.business.calendarMonthSearch.model.action.CalontharchVisiEnforceLtm;
import br.com.mind5.business.calendarMonthSearch.model.action.CalontharchVisiRootSelect;
import br.com.mind5.business.calendarMonthSearch.model.checker.CalontharchCheckReadLtm;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;

public final class CalontharchRootSelectLtm extends DeciTreeTemplateRead<CalontharchInfo> {
	
	public CalontharchRootSelectLtm(DeciTreeOption<CalontharchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<CalontharchInfo> buildCheckerHook(DeciTreeOption<CalontharchInfo> option) {
		List<ModelChecker<CalontharchInfo>> queue = new ArrayList<>();
		ModelChecker<CalontharchInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;
		checker = new CalontharchCheckReadLtm(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}

		
	
	@Override protected List<ActionStd<CalontharchInfo>> buildActionsOnPassedHook(DeciTreeOption<CalontharchInfo> option) {
		List<ActionStd<CalontharchInfo>> actions = new ArrayList<>();
		
		ActionStd<CalontharchInfo> enforceBeginEnd = new ActionStdCommom<CalontharchInfo>(option, CalontharchVisiEnforceBeginEnd.class);
		ActionLazy<CalontharchInfo> enforceLtm = new ActionLazyCommom<CalontharchInfo>(option, CalontharchVisiEnforceLtm.class);
		ActionLazy<CalontharchInfo> select = new ActionLazyCommom<CalontharchInfo>(option, CalontharchVisiRootSelect.class);
		
		enforceBeginEnd.addPostAction(enforceLtm);
		enforceLtm.addPostAction(select);
		
		actions.add(enforceBeginEnd);
		return actions;
	}
}
