package br.com.gda.payment.systemPartner.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.model.decisionTree.DeciTreeReadTemplate;
import br.com.gda.payment.systemPartner.info.SysparInfo;
import br.com.gda.payment.systemPartner.model.action.StdSysparSelect;
import br.com.gda.payment.systemPartner.model.checker.SysparCheckRead;

public final class RootSysparSelect extends DeciTreeReadTemplate<SysparInfo> {
	
	public RootSysparSelect(DeciTreeOption<SysparInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<SysparInfo> buildDecisionCheckerHook(DeciTreeOption<SysparInfo> option) {
		List<ModelChecker<SysparInfo>> queue = new ArrayList<>();		
		ModelChecker<SysparInfo> checker;
		
		checker = new SysparCheckRead();
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<SysparInfo>> buildActionsOnPassedHook(DeciTreeOption<SysparInfo> option) {
		List<ActionStd<SysparInfo>> actions = new ArrayList<>();
		
		ActionStd<SysparInfo> select = new StdSysparSelect(option);
		
		actions.add(select);
		return actions;
	}
}
