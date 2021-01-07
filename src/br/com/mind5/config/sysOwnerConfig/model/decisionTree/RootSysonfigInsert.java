package br.com.mind5.config.sysOwnerConfig.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.config.sysOwnerConfig.info.SysonfigInfo;
import br.com.mind5.config.sysOwnerConfig.model.action.LazySysonfigDaoInsert;
import br.com.mind5.config.sysOwnerConfig.model.action.LazySysonfigMergeSysdistr;
import br.com.mind5.config.sysOwnerConfig.model.action.LazySysonfigMergeSysotup;
import br.com.mind5.config.sysOwnerConfig.model.action.LazySysonfigMergeSytorbc;
import br.com.mind5.config.sysOwnerConfig.model.action.StdSysonfigMergeSytotin;
import br.com.mind5.config.sysOwnerConfig.model.checker.SysonfigCheckRead;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;

public final class RootSysonfigInsert extends DeciTreeTemplateRead<SysonfigInfo> {
	
	public RootSysonfigInsert(DeciTreeOption<SysonfigInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<SysonfigInfo> buildCheckerHook(DeciTreeOption<SysonfigInfo> option) {
		List<ModelChecker<SysonfigInfo>> queue = new ArrayList<>();		
		ModelChecker<SysonfigInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new SysonfigCheckRead(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<SysonfigInfo>> buildActionsOnPassedHook(DeciTreeOption<SysonfigInfo> option) {
		List<ActionStd<SysonfigInfo>> actions = new ArrayList<>();
		
		ActionStd<SysonfigInfo> mergeSytotin = new StdSysonfigMergeSytotin(option);
		ActionLazy<SysonfigInfo> mergeSysotup = new LazySysonfigMergeSysotup(option.conn, option.schemaName);
		ActionLazy<SysonfigInfo> mergeSytorbc = new LazySysonfigMergeSytorbc(option.conn, option.schemaName);
		ActionLazy<SysonfigInfo> mergeSysdistr = new LazySysonfigMergeSysdistr(option.conn, option.schemaName);
		ActionLazy<SysonfigInfo> insert = new LazySysonfigDaoInsert(option.conn, option.schemaName);
		
		mergeSytotin.addPostAction(mergeSysotup);
		mergeSysotup.addPostAction(mergeSytorbc);
		mergeSytorbc.addPostAction(mergeSysdistr);
		mergeSysdistr.addPostAction(insert);
		
		actions.add(mergeSytotin);
		return actions;
	}
}
