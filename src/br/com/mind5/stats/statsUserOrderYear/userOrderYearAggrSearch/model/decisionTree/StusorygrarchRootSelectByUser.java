package br.com.mind5.stats.statsUserOrderYear.userOrderYearAggrSearch.model.decisionTree;

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
import br.com.mind5.stats.statsUserOrderYear.userOrderYearAggrSearch.info.StusorygrarchInfo;
import br.com.mind5.stats.statsUserOrderYear.userOrderYearAggrSearch.model.action.StusorygrarchVisiRootSelect;
import br.com.mind5.stats.statsUserOrderYear.userOrderYearAggrSearch.model.action.StusorygrarchVisiEnforceUserKey;


public final class StusorygrarchRootSelectByUser extends DeciTreeTemplateWrite<StusorygrarchInfo> {
	
	public StusorygrarchRootSelectByUser(DeciTreeOption<StusorygrarchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<StusorygrarchInfo> buildCheckerHook(DeciTreeOption<StusorygrarchInfo> option) {
		List<ModelChecker<StusorygrarchInfo>> queue = new ArrayList<>();		
		ModelChecker<StusorygrarchInfo> checker;

		checker = new ModelCheckerDummy<>();
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<StusorygrarchInfo>> buildActionsOnPassedHook(DeciTreeOption<StusorygrarchInfo> option) {
		List<ActionStd<StusorygrarchInfo>> actions = new ArrayList<>();

		ActionStd<StusorygrarchInfo> enforceUserKey = new ActionStdCommom<StusorygrarchInfo>(option, StusorygrarchVisiEnforceUserKey.class);
		ActionLazy<StusorygrarchInfo> select = new ActionLazyCommom<StusorygrarchInfo>(option, StusorygrarchVisiRootSelect.class);
		
		enforceUserKey.addPostAction(select);
		
		actions.add(enforceUserKey);
		return actions;
	}
}
