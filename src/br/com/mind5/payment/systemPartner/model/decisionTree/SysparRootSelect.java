package br.com.mind5.payment.systemPartner.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;
import br.com.mind5.payment.systemPartner.info.SysparInfo;
import br.com.mind5.payment.systemPartner.model.action.SysparVisiDaoSelect;
import br.com.mind5.payment.systemPartner.model.checker.SysparCheckRead;

public final class SysparRootSelect extends DeciTreeTemplateRead<SysparInfo> {
	
	public SysparRootSelect(DeciTreeOption<SysparInfo> option) {
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
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<SysparInfo>> buildActionsOnPassedHook(DeciTreeOption<SysparInfo> option) {
		List<ActionStd<SysparInfo>> actions = new ArrayList<>();
		
		ActionStd<SysparInfo> select = new ActionStdCommom<SysparInfo>(option, SysparVisiDaoSelect.class);
		
		actions.add(select);
		return actions;
	}
}
