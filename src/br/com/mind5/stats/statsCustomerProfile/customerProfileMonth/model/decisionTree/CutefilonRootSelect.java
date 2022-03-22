package br.com.mind5.stats.statsCustomerProfile.customerProfileMonth.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;
import br.com.mind5.stats.statsCustomerProfile.customerProfileMonth.info.CutefilonInfo;
import br.com.mind5.stats.statsCustomerProfile.customerProfileMonth.model.checker.CutefilonCheckRead;


public final class CutefilonRootSelect extends DeciTreeTemplateWrite<CutefilonInfo> {
	
	public CutefilonRootSelect(DeciTreeOption<CutefilonInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<CutefilonInfo> buildCheckerHook(DeciTreeOption<CutefilonInfo> option) {
		List<ModelChecker<CutefilonInfo>> queue = new ArrayList<>();		
		ModelChecker<CutefilonInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;		
		checker = new CutefilonCheckRead(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<CutefilonInfo>> buildActionsOnPassedHook(DeciTreeOption<CutefilonInfo> option) {
		List<ActionStd<CutefilonInfo>> actions = new ArrayList<>();

		ActionStd<CutefilonInfo> nodeL1 = new CutefilonNodeSelectL1(option).toAction();
		
		actions.add(nodeL1);
		return actions;
	}
}
