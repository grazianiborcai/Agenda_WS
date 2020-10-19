package br.com.mind5.config.sysStoreSignup.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.config.sysStoreSignup.info.SysotupInfo;
import br.com.mind5.config.sysStoreSignup.model.action.LazySysotupRootSelect;
import br.com.mind5.config.sysStoreSignup.model.action.StdSysotupEnforceEnabled;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.common.ModelCheckerDummy;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateReadV2;

public final class RootSysotupSelectEnabled extends DeciTreeTemplateReadV2<SysotupInfo> {
	
	public RootSysotupSelectEnabled(DeciTreeOption<SysotupInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<SysotupInfo> buildCheckerHook(DeciTreeOption<SysotupInfo> option) {
		List<ModelCheckerV1<SysotupInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<SysotupInfo> checker;

		checker = new ModelCheckerDummy<>();
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<SysotupInfo>> buildActionsOnPassedHook(DeciTreeOption<SysotupInfo> option) {
		List<ActionStdV1<SysotupInfo>> actions = new ArrayList<>();
		
		ActionStdV1<SysotupInfo> enforceEnabled = new StdSysotupEnforceEnabled(option);
		ActionLazyV1<SysotupInfo> select = new LazySysotupRootSelect(option.conn, option.schemaName);
		
		enforceEnabled.addPostAction(select);
		
		actions.add(enforceEnabled);
		return actions;
	}
}
