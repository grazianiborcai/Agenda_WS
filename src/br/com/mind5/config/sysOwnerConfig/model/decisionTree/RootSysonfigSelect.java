package br.com.mind5.config.sysOwnerConfig.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.config.sysOwnerConfig.info.SysonfigInfo;
import br.com.mind5.config.sysOwnerConfig.model.action.StdSysonfigMergeToSelect;
import br.com.mind5.config.sysOwnerConfig.model.checker.SysonfigCheckRead;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateReadV2;

public final class RootSysonfigSelect extends DeciTreeTemplateReadV2<SysonfigInfo> {
	
	public RootSysonfigSelect(DeciTreeOption<SysonfigInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<SysonfigInfo> buildCheckerHook(DeciTreeOption<SysonfigInfo> option) {
		List<ModelCheckerV1<SysonfigInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<SysonfigInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new SysonfigCheckRead(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<SysonfigInfo>> buildActionsOnPassedHook(DeciTreeOption<SysonfigInfo> option) {
		List<ActionStdV1<SysonfigInfo>> actions = new ArrayList<>();
		
		ActionStdV1<SysonfigInfo> select = new StdSysonfigMergeToSelect(option);
		
		actions.add(select);
		return actions;
	}
}
