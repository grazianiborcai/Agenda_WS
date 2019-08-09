package br.com.gda.business.masterData.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.masterData.info.SysEnvironInfo;
import br.com.gda.business.masterData.model.action.StdSysEnvironSelect;
import br.com.gda.business.masterData.model.checker.SysEnvironCheckRead;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciTreeReadTemplate;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class RootSysEnvironSelect extends DeciTreeReadTemplate<SysEnvironInfo> {
	
	public RootSysEnvironSelect(DeciTreeOption<SysEnvironInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<SysEnvironInfo> buildDecisionCheckerHook(DeciTreeOption<SysEnvironInfo> option) {
		List<ModelChecker<SysEnvironInfo>> queue = new ArrayList<>();		
		ModelChecker<SysEnvironInfo> checker;
		
		checker = new SysEnvironCheckRead();
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<SysEnvironInfo>> buildActionsOnPassedHook(DeciTreeOption<SysEnvironInfo> option) {
		List<ActionStd<SysEnvironInfo>> actions = new ArrayList<>();
		
		ActionStd<SysEnvironInfo> select = new StdSysEnvironSelect(option);
		
		actions.add(select);
		return actions;
	}
}
