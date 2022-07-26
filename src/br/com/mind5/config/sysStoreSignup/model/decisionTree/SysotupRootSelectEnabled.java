package br.com.mind5.config.sysStoreSignup.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.config.sysStoreSignup.info.SysotupInfo;
import br.com.mind5.config.sysStoreSignup.model.action.SysotupVisiRootSelect;
import br.com.mind5.config.sysStoreSignup.model.action.SysotupVisiEnforceEnabled;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.common.ModelCheckerDummy;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;

public final class SysotupRootSelectEnabled extends DeciTreeTemplateRead<SysotupInfo> {
	
	public SysotupRootSelectEnabled(DeciTreeOption<SysotupInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<SysotupInfo> buildCheckerHook(DeciTreeOption<SysotupInfo> option) {
		List<ModelChecker<SysotupInfo>> queue = new ArrayList<>();		
		ModelChecker<SysotupInfo> checker;

		checker = new ModelCheckerDummy<>();
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<SysotupInfo>> buildActionsOnPassedHook(DeciTreeOption<SysotupInfo> option) {
		List<ActionStd<SysotupInfo>> actions = new ArrayList<>();
		
		ActionStd<SysotupInfo> enforceEnabled = new ActionStdCommom<SysotupInfo>(option, SysotupVisiEnforceEnabled.class);
		ActionLazy<SysotupInfo> select = new ActionLazyCommom<SysotupInfo>(option, SysotupVisiRootSelect.class);
		
		enforceEnabled.addPostAction(select);
		
		actions.add(enforceEnabled);
		return actions;
	}
}
