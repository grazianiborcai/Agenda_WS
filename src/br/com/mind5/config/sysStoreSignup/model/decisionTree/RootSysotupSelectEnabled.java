package br.com.mind5.config.sysStoreSignup.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.config.sysStoreSignup.info.SysotupInfo;
import br.com.mind5.config.sysStoreSignup.model.action.LazySysotupRootSelect;
import br.com.mind5.config.sysStoreSignup.model.action.StdSysotupEnforceEnabled;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.common.ModelCheckerDummy;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;

public final class RootSysotupSelectEnabled extends DeciTreeTemplateRead<SysotupInfo> {
	
	public RootSysotupSelectEnabled(DeciTreeOption<SysotupInfo> option) {
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
		
		ActionStd<SysotupInfo> enforceEnabled = new StdSysotupEnforceEnabled(option);
		ActionLazy<SysotupInfo> select = new LazySysotupRootSelect(option.conn, option.schemaName);
		
		enforceEnabled.addPostAction(select);
		
		actions.add(enforceEnabled);
		return actions;
	}
}
