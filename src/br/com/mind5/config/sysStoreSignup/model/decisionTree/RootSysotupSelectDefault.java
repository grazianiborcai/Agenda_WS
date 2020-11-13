package br.com.mind5.config.sysStoreSignup.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.config.sysStoreSignup.info.SysotupInfo;
import br.com.mind5.config.sysStoreSignup.model.action.StdSysotupEnforceEnabled;
import br.com.mind5.config.sysStoreSignup.model.checker.SysotupCheckRead;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;

public final class RootSysotupSelectDefault extends DeciTreeTemplateRead<SysotupInfo> {
	
	public RootSysotupSelectDefault(DeciTreeOption<SysotupInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<SysotupInfo> buildCheckerHook(DeciTreeOption<SysotupInfo> option) {
		List<ModelChecker<SysotupInfo>> queue = new ArrayList<>();		
		ModelChecker<SysotupInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new SysotupCheckRead(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<SysotupInfo>> buildActionsOnPassedHook(DeciTreeOption<SysotupInfo> option) {
		List<ActionStd<SysotupInfo>> actions = new ArrayList<>();
		
		ActionStd<SysotupInfo> enforceEnabled = new StdSysotupEnforceEnabled(option);
		
		actions.add(enforceEnabled);
		return actions;
	}
}
