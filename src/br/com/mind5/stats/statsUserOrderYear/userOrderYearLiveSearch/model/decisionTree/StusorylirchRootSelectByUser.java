package br.com.mind5.stats.statsUserOrderYear.userOrderYearLiveSearch.model.decisionTree;

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
import br.com.mind5.stats.statsUserOrderYear.userOrderYearLiveSearch.info.StusorylirchInfo;
import br.com.mind5.stats.statsUserOrderYear.userOrderYearLiveSearch.model.action.StusorylirchVisiRootSelect;
import br.com.mind5.stats.statsUserOrderYear.userOrderYearLiveSearch.model.action.StusorylirchVisiEnforceUserKey;


public final class StusorylirchRootSelectByUser extends DeciTreeTemplateWrite<StusorylirchInfo> {
	
	public StusorylirchRootSelectByUser(DeciTreeOption<StusorylirchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<StusorylirchInfo> buildCheckerHook(DeciTreeOption<StusorylirchInfo> option) {
		List<ModelChecker<StusorylirchInfo>> queue = new ArrayList<>();		
		ModelChecker<StusorylirchInfo> checker;

		checker = new ModelCheckerDummy<>();
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<StusorylirchInfo>> buildActionsOnPassedHook(DeciTreeOption<StusorylirchInfo> option) {
		List<ActionStd<StusorylirchInfo>> actions = new ArrayList<>();

		ActionStd<StusorylirchInfo> enforceUserKey = new ActionStdCommom<StusorylirchInfo>(option, StusorylirchVisiEnforceUserKey.class);
		ActionLazy<StusorylirchInfo> select = new ActionLazyCommom<StusorylirchInfo>(option, StusorylirchVisiRootSelect.class);
		
		enforceUserKey.addPostAction(select);
		
		actions.add(enforceUserKey);
		return actions;
	}
}
