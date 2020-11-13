package br.com.mind5.config.sysOwnerSignup.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.config.sysOwnerSignup.info.SysonupInfo;
import br.com.mind5.config.sysOwnerSignup.model.action.LazySysonupRootSelect;
import br.com.mind5.config.sysOwnerSignup.model.action.StdSysonupEnforceEnabled;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.common.ModelCheckerDummy;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateReadV2;

public final class RootSysonupSelectEnabled extends DeciTreeTemplateReadV2<SysonupInfo> {
	
	public RootSysonupSelectEnabled(DeciTreeOption<SysonupInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<SysonupInfo> buildCheckerHook(DeciTreeOption<SysonupInfo> option) {
		List<ModelCheckerV1<SysonupInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<SysonupInfo> checker;

		checker = new ModelCheckerDummy<>();
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<SysonupInfo>> buildActionsOnPassedHook(DeciTreeOption<SysonupInfo> option) {
		List<ActionStdV1<SysonupInfo>> actions = new ArrayList<>();
		
		ActionStdV1<SysonupInfo> enforceEnabled = new StdSysonupEnforceEnabled(option);
		ActionLazy<SysonupInfo> select = new LazySysonupRootSelect(option.conn, option.schemaName);
		
		enforceEnabled.addPostAction(select);
		
		actions.add(enforceEnabled);
		return actions;
	}
}
