package br.com.mind5.config.sysOwnerConfig.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.config.sysOwnerConfig.info.SysonfigInfo;
import br.com.mind5.config.sysOwnerConfig.model.action.SysonfigVisiDaoInsert;
import br.com.mind5.config.sysOwnerConfig.model.action.SysonfigVisiMergeSysdistr;
import br.com.mind5.config.sysOwnerConfig.model.action.SysonfigVisiMergeSysotup;
import br.com.mind5.config.sysOwnerConfig.model.action.SysonfigVisiMergeSytorbc;
import br.com.mind5.config.sysOwnerConfig.model.action.SysonfigVisiMergeSytotin;
import br.com.mind5.config.sysOwnerConfig.model.checker.SysonfigCheckRead;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;

public final class SysonfigRootInsert extends DeciTreeTemplateRead<SysonfigInfo> {
	
	public SysonfigRootInsert(DeciTreeOption<SysonfigInfo> option) {
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
		
		ActionStd<SysonfigInfo> mergeSytotin = new ActionStdCommom<SysonfigInfo>(option, SysonfigVisiMergeSytotin.class);
		ActionLazy<SysonfigInfo> mergeSysotup = new ActionLazyCommom<SysonfigInfo>(option, SysonfigVisiMergeSysotup.class);
		ActionLazy<SysonfigInfo> mergeSytorbc = new ActionLazyCommom<SysonfigInfo>(option, SysonfigVisiMergeSytorbc.class);
		ActionLazy<SysonfigInfo> mergeSysdistr = new ActionLazyCommom<SysonfigInfo>(option, SysonfigVisiMergeSysdistr.class);
		ActionLazy<SysonfigInfo> insert = new ActionLazyCommom<SysonfigInfo>(option, SysonfigVisiDaoInsert.class);
		
		mergeSytotin.addPostAction(mergeSysotup);
		mergeSysotup.addPostAction(mergeSytorbc);
		mergeSytorbc.addPostAction(mergeSysdistr);
		mergeSysdistr.addPostAction(insert);
		
		actions.add(mergeSytotin);
		return actions;
	}
}
