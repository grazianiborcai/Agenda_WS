package br.com.mind5.payment.systemPartner.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeReadTemplate;
import br.com.mind5.payment.systemPartner.info.SysparInfo;
import br.com.mind5.payment.systemPartner.model.action.StdSysparSelect;
import br.com.mind5.payment.systemPartner.model.checker.SysparCheckRead;

public final class RootSysparSelect extends DeciTreeReadTemplate<SysparInfo> {
	
	public RootSysparSelect(DeciTreeOption<SysparInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<SysparInfo> buildCheckerHook(DeciTreeOption<SysparInfo> option) {
		List<ModelChecker<SysparInfo>> queue = new ArrayList<>();		
		ModelChecker<SysparInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new SysparCheckRead(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<SysparInfo>> buildActionsOnPassedHook(DeciTreeOption<SysparInfo> option) {
		List<ActionStdV1<SysparInfo>> actions = new ArrayList<>();
		
		ActionStdV1<SysparInfo> select = new StdSysparSelect(option);
		
		actions.add(select);
		return actions;
	}
}
