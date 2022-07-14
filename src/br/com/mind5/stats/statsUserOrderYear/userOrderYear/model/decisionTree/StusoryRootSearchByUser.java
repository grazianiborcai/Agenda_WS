package br.com.mind5.stats.statsUserOrderYear.userOrderYear.model.decisionTree;

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
import br.com.mind5.stats.statsUserOrderYear.userOrderYear.info.StusoryInfo;
import br.com.mind5.stats.statsUserOrderYear.userOrderYear.model.action.StusoryVisiRootSelect;
import br.com.mind5.stats.statsUserOrderYear.userOrderYear.model.action.StusoryVisiMergeStusoryrchByUser;


public final class StusoryRootSearchByUser extends DeciTreeTemplateWrite<StusoryInfo> {
	
	public StusoryRootSearchByUser(DeciTreeOption<StusoryInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<StusoryInfo> buildCheckerHook(DeciTreeOption<StusoryInfo> option) {
		List<ModelChecker<StusoryInfo>> queue = new ArrayList<>();		
		ModelChecker<StusoryInfo> checker;

		checker = new ModelCheckerDummy<>();
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<StusoryInfo>> buildActionsOnPassedHook(DeciTreeOption<StusoryInfo> option) {
		List<ActionStd<StusoryInfo>> actions = new ArrayList<>();

		ActionStd<StusoryInfo> search = new ActionStdCommom<StusoryInfo>(option, StusoryVisiMergeStusoryrchByUser.class);
		ActionLazy<StusoryInfo> select = new ActionLazyCommom<StusoryInfo>(option, StusoryVisiRootSelect.class);
		
		search.addPostAction(select);
		
		actions.add(search);
		return actions;
	}
}
