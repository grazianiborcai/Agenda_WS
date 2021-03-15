package br.com.mind5.stats.statsUserOrderYear.userOrderYearAggrSearch.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.common.ModelCheckerDummy;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;
import br.com.mind5.stats.statsUserOrderYear.userOrderYearAggrSearch.info.StusorygrarchInfo;
import br.com.mind5.stats.statsUserOrderYear.userOrderYearAggrSearch.model.action.LazyStusorygrarchRootSelect;
import br.com.mind5.stats.statsUserOrderYear.userOrderYearAggrSearch.model.action.StdStusorygrarchEnforceUserKey;


public final class RootStusorygrarchSelectByUser extends DeciTreeTemplateWrite<StusorygrarchInfo> {
	
	public RootStusorygrarchSelectByUser(DeciTreeOption<StusorygrarchInfo> option) {
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

		ActionStd<StusorygrarchInfo> enforceUserKey = new StdStusorygrarchEnforceUserKey(option);
		ActionLazy<StusorygrarchInfo> select = new LazyStusorygrarchRootSelect(option.conn, option.schemaName);
		
		enforceUserKey.addPostAction(select);
		
		actions.add(enforceUserKey);
		return actions;
	}
}
