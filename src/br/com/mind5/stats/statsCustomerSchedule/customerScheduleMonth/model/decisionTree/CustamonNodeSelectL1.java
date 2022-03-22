package br.com.mind5.stats.statsCustomerSchedule.customerScheduleMonth.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;
import br.com.mind5.stats.statsCustomerSchedule.customerScheduleMonth.info.CustamonInfo;
import br.com.mind5.stats.statsCustomerSchedule.customerScheduleMonth.model.action.CustamonVisiMergeCustamonagr;
import br.com.mind5.stats.statsCustomerSchedule.customerScheduleMonth.model.checker.CustamonCheckCustamonagr;


public final class CustamonNodeSelectL1 extends DeciTreeTemplateWrite<CustamonInfo> {
	
	public CustamonNodeSelectL1(DeciTreeOption<CustamonInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<CustamonInfo> buildCheckerHook(DeciTreeOption<CustamonInfo> option) {
		List<ModelChecker<CustamonInfo>> queue = new ArrayList<>();		
		ModelChecker<CustamonInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new CustamonCheckCustamonagr(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<CustamonInfo>> buildActionsOnPassedHook(DeciTreeOption<CustamonInfo> option) {
		List<ActionStd<CustamonInfo>> actions = new ArrayList<>();

		ActionStd<CustamonInfo> mergeCustamonagr = new ActionStdCommom<CustamonInfo>(option, CustamonVisiMergeCustamonagr.class);
		
		actions.add(mergeCustamonagr);
		return actions;
	}
	
	
	
	@Override protected List<ActionStd<CustamonInfo>> buildActionsOnFailedHook(DeciTreeOption<CustamonInfo> option) {
		List<ActionStd<CustamonInfo>> actions = new ArrayList<>();

		ActionStd<CustamonInfo> nodeL2 = new CustamonNodeSelectL2(option).toAction();
		
		actions.add(nodeL2);
		return actions;
	}
}
