package br.com.mind5.config.sysOwnerSignup.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.config.sysOwnerSignup.info.SysonupInfo;
import br.com.mind5.config.sysOwnerSignup.model.action.LazySysonupRootSelect;
import br.com.mind5.config.sysOwnerSignup.model.action.StdSysonupEnforceEnabled;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.common.ModelCheckerDummy;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;

public final class RootSysonupSelectEnabled extends DeciTreeTemplateRead<SysonupInfo> {
	
	public RootSysonupSelectEnabled(DeciTreeOption<SysonupInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<SysonupInfo> buildCheckerHook(DeciTreeOption<SysonupInfo> option) {
		List<ModelChecker<SysonupInfo>> queue = new ArrayList<>();		
		ModelChecker<SysonupInfo> checker;

		checker = new ModelCheckerDummy<>();
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<SysonupInfo>> buildActionsOnPassedHook(DeciTreeOption<SysonupInfo> option) {
		List<ActionStd<SysonupInfo>> actions = new ArrayList<>();
		
		ActionStd<SysonupInfo> enforceEnabled = new StdSysonupEnforceEnabled(option);
		ActionLazy<SysonupInfo> select = new LazySysonupRootSelect(option.conn, option.schemaName);
		
		enforceEnabled.addPostAction(select);
		
		actions.add(enforceEnabled);
		return actions;
	}
}
