package br.com.mind5.stats.statsCustomerSchedule.customerScheduleMonth.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;
import br.com.mind5.stats.statsCustomerSchedule.customerScheduleMonth.info.CustamonInfo;
import br.com.mind5.stats.statsCustomerSchedule.customerScheduleMonth.model.checker.CustamonCheckRead;


public final class CustamonRootSelect extends DeciTreeTemplateWrite<CustamonInfo> {
	
	public CustamonRootSelect(DeciTreeOption<CustamonInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<CustamonInfo> buildCheckerHook(DeciTreeOption<CustamonInfo> option) {
		List<ModelChecker<CustamonInfo>> queue = new ArrayList<>();		
		ModelChecker<CustamonInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;		
		checker = new CustamonCheckRead(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<CustamonInfo>> buildActionsOnPassedHook(DeciTreeOption<CustamonInfo> option) {
		List<ActionStd<CustamonInfo>> actions = new ArrayList<>();

		ActionStd<CustamonInfo> nodeL1 = new CustamonNodeSelectL1(option).toAction();
		
		actions.add(nodeL1);
		return actions;
	}
}
