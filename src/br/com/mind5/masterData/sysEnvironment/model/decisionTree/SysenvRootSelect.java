package br.com.mind5.masterData.sysEnvironment.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.masterData.sysEnvironment.info.SysenvInfo;
import br.com.mind5.masterData.sysEnvironment.model.action.SysenvVisiDaoSelect;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.common.ModelCheckerDummy;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;

public final class SysenvRootSelect extends DeciTreeTemplateRead<SysenvInfo> {
	
	public SysenvRootSelect(DeciTreeOption<SysenvInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<SysenvInfo> buildCheckerHook(DeciTreeOption<SysenvInfo> option) {
		List<ModelChecker<SysenvInfo>> queue = new ArrayList<>();		
		ModelChecker<SysenvInfo> checker;
		
		checker = new ModelCheckerDummy<>();
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<SysenvInfo>> buildActionsOnPassedHook(DeciTreeOption<SysenvInfo> option) {
		List<ActionStd<SysenvInfo>> actions = new ArrayList<>();
		
		ActionStd<SysenvInfo> select = new ActionStdCommom<SysenvInfo>(option, SysenvVisiDaoSelect.class);
		
		actions.add(select);
		return actions;
	}
}
