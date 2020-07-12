package br.com.mind5.config.sysOwnerSignup.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.config.sysOwnerSignup.info.SysonupInfo;
import br.com.mind5.config.sysOwnerSignup.model.action.StdSysonupDaoSelect;
import br.com.mind5.config.sysOwnerSignup.model.checker.SysonupCheckRead;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateReadV2;

public final class RootSysonupSelect extends DeciTreeTemplateReadV2<SysonupInfo> {
	
	public RootSysonupSelect(DeciTreeOption<SysonupInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<SysonupInfo> buildCheckerHook(DeciTreeOption<SysonupInfo> option) {
		List<ModelCheckerV1<SysonupInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<SysonupInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new SysonupCheckRead(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<SysonupInfo>> buildActionsOnPassedHook(DeciTreeOption<SysonupInfo> option) {
		List<ActionStdV1<SysonupInfo>> actions = new ArrayList<>();
		
		ActionStdV1<SysonupInfo> select = new StdSysonupDaoSelect(option);
		
		actions.add(select);
		return actions;
	}
}
