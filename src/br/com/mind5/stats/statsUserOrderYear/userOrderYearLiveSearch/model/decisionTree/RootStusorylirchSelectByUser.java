package br.com.mind5.stats.statsUserOrderYear.userOrderYearLiveSearch.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.common.ModelCheckerDummy;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;
import br.com.mind5.stats.statsUserOrderYear.userOrderYearLiveSearch.info.StusorylirchInfo;
import br.com.mind5.stats.statsUserOrderYear.userOrderYearLiveSearch.model.action.LazyStusorylirchRootSelect;
import br.com.mind5.stats.statsUserOrderYear.userOrderYearLiveSearch.model.action.StdStusorylirchEnforceUserKey;


public final class RootStusorylirchSelectByUser extends DeciTreeTemplateWrite<StusorylirchInfo> {
	
	public RootStusorylirchSelectByUser(DeciTreeOption<StusorylirchInfo> option) {
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

		ActionStd<StusorylirchInfo> enforceUserKey = new StdStusorylirchEnforceUserKey(option);
		ActionLazy<StusorylirchInfo> select = new LazyStusorylirchRootSelect(option.conn, option.schemaName);
		
		enforceUserKey.addPostAction(select);
		
		actions.add(enforceUserKey);
		return actions;
	}
}
