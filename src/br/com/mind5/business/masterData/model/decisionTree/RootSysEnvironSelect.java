package br.com.mind5.business.masterData.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.masterData.info.SysEnvironInfo;
import br.com.mind5.business.masterData.model.action.StdSysEnvironSelect;
import br.com.mind5.business.masterData.model.checker.SysEnvironCheckRead;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeReadTemplate;

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
