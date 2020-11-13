package br.com.mind5.config.sysOwnerConfig.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.config.sysOwnerConfig.info.SysonfigInfo;
import br.com.mind5.config.sysOwnerConfig.model.action.LazySysonfigDaoInsert;
import br.com.mind5.config.sysOwnerConfig.model.action.LazySysonfigMergeSysotup;
import br.com.mind5.config.sysOwnerConfig.model.action.LazySysonfigMergeSytorbc;
import br.com.mind5.config.sysOwnerConfig.model.action.StdSysonfigMergeSytotin;
import br.com.mind5.config.sysOwnerConfig.model.checker.SysonfigCheckRead;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateReadV2;

public final class RootSysonfigInsert extends DeciTreeTemplateReadV2<SysonfigInfo> {
	
	public RootSysonfigInsert(DeciTreeOption<SysonfigInfo> option) {
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
	
	
	
	@Override protected List<ActionStdV2<SysonfigInfo>> buildActionsOnPassedHook(DeciTreeOption<SysonfigInfo> option) {
		List<ActionStdV2<SysonfigInfo>> actions = new ArrayList<>();
		
		ActionStdV2<SysonfigInfo> mergeSytotin = new StdSysonfigMergeSytotin(option);
		ActionLazy<SysonfigInfo> mergeSysotup = new LazySysonfigMergeSysotup(option.conn, option.schemaName);
		ActionLazy<SysonfigInfo> mergeSytorbc = new LazySysonfigMergeSytorbc(option.conn, option.schemaName);		
		ActionLazy<SysonfigInfo> insert = new LazySysonfigDaoInsert(option.conn, option.schemaName);
		
		mergeSytotin.addPostAction(mergeSysotup);
		mergeSysotup.addPostAction(mergeSytorbc);
		mergeSytorbc.addPostAction(insert);
		
		actions.add(mergeSytotin);
		return actions;
	}
}
