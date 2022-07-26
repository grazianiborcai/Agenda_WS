package br.com.mind5.config.sysOwnerSignup.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.config.sysOwnerSignup.info.SysonupInfo;
import br.com.mind5.config.sysOwnerSignup.model.action.SysonupVisiDaoSelect;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.common.ModelCheckerDummy;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;

public final class SysonupRootSelect extends DeciTreeTemplateRead<SysonupInfo> {
	
	public SysonupRootSelect(DeciTreeOption<SysonupInfo> option) {
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
		
		ActionStd<SysonupInfo> select = new ActionStdCommom<SysonupInfo>(option, SysonupVisiDaoSelect.class);
		
		actions.add(select);
		return actions;
	}
}
