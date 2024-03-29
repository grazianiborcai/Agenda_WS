package br.com.mind5.config.sysStorePartitioning.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.config.sysStorePartitioning.info.SytotinInfo;
import br.com.mind5.config.sysStorePartitioning.model.action.SytotinVisiRootSelect;
import br.com.mind5.config.sysStorePartitioning.model.action.SytotinVisiEnforceEnabled;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.common.ModelCheckerDummy;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;

public final class SytotinRootSelectEnabled extends DeciTreeTemplateRead<SytotinInfo> {
	
	public SytotinRootSelectEnabled(DeciTreeOption<SytotinInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<SytotinInfo> buildCheckerHook(DeciTreeOption<SytotinInfo> option) {
		List<ModelChecker<SytotinInfo>> queue = new ArrayList<>();		
		ModelChecker<SytotinInfo> checker;

		checker = new ModelCheckerDummy<>();
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<SytotinInfo>> buildActionsOnPassedHook(DeciTreeOption<SytotinInfo> option) {
		List<ActionStd<SytotinInfo>> actions = new ArrayList<>();
		
		ActionStd<SytotinInfo> enforceEnabled = new ActionStdCommom<SytotinInfo>(option, SytotinVisiEnforceEnabled.class);
		ActionLazy<SytotinInfo> select = new ActionLazyCommom<SytotinInfo>(option, SytotinVisiRootSelect.class);
		
		enforceEnabled.addPostAction(select);
		
		actions.add(enforceEnabled);
		return actions;
	}
}
