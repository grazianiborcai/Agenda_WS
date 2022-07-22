package br.com.mind5.payment.systemPartnerSearch.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;
import br.com.mind5.payment.systemPartnerSearch.info.SysparchInfo;
import br.com.mind5.payment.systemPartnerSearch.model.action.SysparchVisiDaoSelect;
import br.com.mind5.payment.systemPartnerSearch.model.checker.SysparchCheckRead;

public final class SysparchRootSelect extends DeciTreeTemplateRead<SysparchInfo> {
	
	public SysparchRootSelect(DeciTreeOption<SysparchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<SysparchInfo> buildCheckerHook(DeciTreeOption<SysparchInfo> option) {
		List<ModelChecker<SysparchInfo>> queue = new ArrayList<>();		
		ModelChecker<SysparchInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new SysparchCheckRead(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<SysparchInfo>> buildActionsOnPassedHook(DeciTreeOption<SysparchInfo> option) {
		List<ActionStd<SysparchInfo>> actions = new ArrayList<>();
		
		ActionStd<SysparchInfo> select = new ActionStdCommom<SysparchInfo>(option, SysparchVisiDaoSelect.class);
		
		actions.add(select);
		return actions;
	}
}
