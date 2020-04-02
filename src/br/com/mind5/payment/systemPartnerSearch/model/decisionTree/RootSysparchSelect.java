package br.com.mind5.payment.systemPartnerSearch.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeReadTemplate;
import br.com.mind5.payment.systemPartnerSearch.info.SysparchInfo;
import br.com.mind5.payment.systemPartnerSearch.model.action.StdSysparchSelect;
import br.com.mind5.payment.systemPartnerSearch.model.checker.SysparchCheckRead;

public final class RootSysparchSelect extends DeciTreeReadTemplate<SysparchInfo> {
	
	public RootSysparchSelect(DeciTreeOption<SysparchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<SysparchInfo> buildDecisionCheckerHook(DeciTreeOption<SysparchInfo> option) {
		List<ModelChecker<SysparchInfo>> queue = new ArrayList<>();		
		ModelChecker<SysparchInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new SysparchCheckRead(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<SysparchInfo>> buildActionsOnPassedHook(DeciTreeOption<SysparchInfo> option) {
		List<ActionStdV1<SysparchInfo>> actions = new ArrayList<>();
		
		ActionStdV1<SysparchInfo> select = new StdSysparchSelect(option);
		
		actions.add(select);
		return actions;
	}
}
