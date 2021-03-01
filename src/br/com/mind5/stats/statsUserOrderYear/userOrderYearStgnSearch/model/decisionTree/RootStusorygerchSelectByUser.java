package br.com.mind5.stats.statsUserOrderYear.userOrderYearStgnSearch.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.common.ModelCheckerDummy;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;
import br.com.mind5.stats.statsUserOrderYear.userOrderYearStgnSearch.info.StusorygerchInfo;
import br.com.mind5.stats.statsUserOrderYear.userOrderYearStgnSearch.model.action.LazyStusorygerchRootSelect;
import br.com.mind5.stats.statsUserOrderYear.userOrderYearStgnSearch.model.action.StdStusorygerchEnforceUserKey;


public final class RootStusorygerchSelectByUser extends DeciTreeTemplateWrite<StusorygerchInfo> {
	
	public RootStusorygerchSelectByUser(DeciTreeOption<StusorygerchInfo> option) {
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

		ActionStd<StusorygerchInfo> enforceUserKey = new StdStusorygerchEnforceUserKey(option);
		ActionLazy<StusorygerchInfo> select = new LazyStusorygerchRootSelect(option.conn, option.schemaName);
		
		enforceUserKey.addPostAction(select);
		
		actions.add(enforceUserKey);
		return actions;
	}
}
