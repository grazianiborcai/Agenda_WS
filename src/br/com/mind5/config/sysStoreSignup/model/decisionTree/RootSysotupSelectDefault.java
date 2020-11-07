package br.com.mind5.config.sysStoreSignup.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.config.sysStoreSignup.info.SysotupInfo;
import br.com.mind5.config.sysStoreSignup.model.action.StdSysotupEnforceEnabled;
import br.com.mind5.config.sysStoreSignup.model.checker.SysotupCheckRead;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateReadV2;

public final class RootSysotupSelectDefault extends DeciTreeTemplateReadV2<SysotupInfo> {
	
	public RootSysotupSelectDefault(DeciTreeOption<SysotupInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<SysotupInfo> buildCheckerHook(DeciTreeOption<SysotupInfo> option) {
		List<ModelCheckerV1<SysotupInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<SysotupInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new SysotupCheckRead(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<SysotupInfo>> buildActionsOnPassedHook(DeciTreeOption<SysotupInfo> option) {
		List<ActionStdV1<SysotupInfo>> actions = new ArrayList<>();
		
		ActionStdV1<SysotupInfo> enforceEnabled = new StdSysotupEnforceEnabled(option);
		
		actions.add(enforceEnabled);
		return actions;
	}
}