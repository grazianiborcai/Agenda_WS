package br.com.mind5.business.scheduleMonth.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.scheduleMonth.info.SchedmonInfo;
import br.com.mind5.business.scheduleMonth.model.action.SchedmonVisiRootSelect;
import br.com.mind5.business.scheduleMonth.model.action.SchedmonVisiEnforceNext;
import br.com.mind5.business.scheduleMonth.model.checker.SchedmonCheckRead;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class SchedmonRootSelectNext extends DeciTreeTemplateWrite<SchedmonInfo> {
	
	public SchedmonRootSelectNext(DeciTreeOption<SchedmonInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<SchedmonInfo> buildCheckerHook(DeciTreeOption<SchedmonInfo> option) {
		List<ModelChecker<SchedmonInfo>> queue = new ArrayList<>();		
		ModelChecker<SchedmonInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new SchedmonCheckRead(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<SchedmonInfo>> buildActionsOnPassedHook(DeciTreeOption<SchedmonInfo> option) {
		List<ActionStd<SchedmonInfo>> actions = new ArrayList<>();
		
		ActionStd<SchedmonInfo> enforceNext = new ActionStdCommom<SchedmonInfo>(option, SchedmonVisiEnforceNext.class);
		ActionLazy<SchedmonInfo> select = new ActionLazyCommom<SchedmonInfo>(option, SchedmonVisiRootSelect.class);

		enforceNext.addPostAction(select);
		
		actions.add(enforceNext);
		return actions;
	}
}
