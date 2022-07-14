package br.com.mind5.stats.statsUserOrderYear.userOrderYearStgnSearch.model.decisionTree;

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
import br.com.mind5.stats.statsUserOrderYear.userOrderYearStgnSearch.info.StusorygerchInfo;
import br.com.mind5.stats.statsUserOrderYear.userOrderYearStgnSearch.model.action.StusorygerchVisiRootSelect;
import br.com.mind5.stats.statsUserOrderYear.userOrderYearStgnSearch.model.action.StusorygerchVisiEnforceUserKey;


public final class StusorygerchRootSelectByUser extends DeciTreeTemplateWrite<StusorygerchInfo> {
	
	public StusorygerchRootSelectByUser(DeciTreeOption<StusorygerchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<StusorygerchInfo> buildCheckerHook(DeciTreeOption<StusorygerchInfo> option) {
		List<ModelChecker<StusorygerchInfo>> queue = new ArrayList<>();		
		ModelChecker<StusorygerchInfo> checker;

		checker = new ModelCheckerDummy<>();
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<StusorygerchInfo>> buildActionsOnPassedHook(DeciTreeOption<StusorygerchInfo> option) {
		List<ActionStd<StusorygerchInfo>> actions = new ArrayList<>();

		ActionStd<StusorygerchInfo> enforceUserKey = new ActionStdCommom<StusorygerchInfo>(option, StusorygerchVisiEnforceUserKey.class);
		ActionLazy<StusorygerchInfo> select = new ActionLazyCommom<StusorygerchInfo>(option, StusorygerchVisiRootSelect.class);
		
		enforceUserKey.addPostAction(select);
		
		actions.add(enforceUserKey);
		return actions;
	}
}
