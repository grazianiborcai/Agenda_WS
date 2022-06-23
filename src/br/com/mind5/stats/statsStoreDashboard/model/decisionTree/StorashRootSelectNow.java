package br.com.mind5.stats.statsStoreDashboard.model.decisionTree;

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
import br.com.mind5.stats.statsStoreDashboard.info.StorashInfo;
import br.com.mind5.stats.statsStoreDashboard.model.action.StorashVisiMergeCalonthNow;
import br.com.mind5.stats.statsStoreDashboard.model.action.StorashVisiRootSelect;


public final class StorashRootSelectNow extends DeciTreeTemplateWrite<StorashInfo> {
	
	public StorashRootSelectNow(DeciTreeOption<StorashInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<StorashInfo> buildCheckerHook(DeciTreeOption<StorashInfo> option) {
		List<ModelChecker<StorashInfo>> queue = new ArrayList<>();
		ModelChecker<StorashInfo> checker;

		checker = new ModelCheckerDummy<StorashInfo>();
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<StorashInfo>> buildActionsOnPassedHook(DeciTreeOption<StorashInfo> option) {
		List<ActionStd<StorashInfo>> actions = new ArrayList<>();

		ActionStd<StorashInfo> mergeCalonthNow = new ActionStdCommom<StorashInfo>(option, StorashVisiMergeCalonthNow.class);
		ActionLazy<StorashInfo> select = new ActionLazyCommom<StorashInfo>(option, StorashVisiRootSelect.class);
		
		
		mergeCalonthNow.addPostAction(select);
		
		actions.add(mergeCalonthNow);
		return actions;
	}
}
