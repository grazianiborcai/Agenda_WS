package br.com.mind5.stats.statsOwnerDashboard.model.decisionTree;

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
import br.com.mind5.stats.statsOwnerDashboard.info.SowashInfo;
import br.com.mind5.stats.statsOwnerDashboard.model.action.SowashVisiMergeCalonthNow;
import br.com.mind5.stats.statsOwnerDashboard.model.action.SowashVisiRootSelect;


public final class SowashRootSelectNow extends DeciTreeTemplateWrite<SowashInfo> {
	
	public SowashRootSelectNow(DeciTreeOption<SowashInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<SowashInfo> buildCheckerHook(DeciTreeOption<SowashInfo> option) {
		List<ModelChecker<SowashInfo>> queue = new ArrayList<>();
		ModelChecker<SowashInfo> checker;

		checker = new ModelCheckerDummy<SowashInfo>();
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<SowashInfo>> buildActionsOnPassedHook(DeciTreeOption<SowashInfo> option) {
		List<ActionStd<SowashInfo>> actions = new ArrayList<>();

		ActionStd <SowashInfo> mergeCalonthNow = new ActionStdCommom <SowashInfo>(option, SowashVisiMergeCalonthNow.class);
		ActionLazy<SowashInfo> select          = new ActionLazyCommom<SowashInfo>(option, SowashVisiRootSelect.class);
		
		
		mergeCalonthNow.addPostAction(select);
		
		actions.add(mergeCalonthNow);
		return actions;
	}
}
