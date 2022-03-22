package br.com.mind5.stats.statsCustomerSchedule.customerScheduleMonth.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;
import br.com.mind5.stats.statsCustomerSchedule.customerScheduleMonth.info.CustamonInfo;
import br.com.mind5.stats.statsCustomerSchedule.customerScheduleMonth.model.action.CustamonVisiCustamonagrUpsert;
import br.com.mind5.stats.statsCustomerSchedule.customerScheduleMonth.model.action.CustamonVisiMergeCustamonive;
import br.com.mind5.stats.statsCustomerSchedule.customerScheduleMonth.model.action.CustamonVisiNodeZerofy;
import br.com.mind5.stats.statsCustomerSchedule.customerScheduleMonth.model.checker.CustamonCheckCustamonive;


public final class CustamonNodeUpsert extends DeciTreeTemplateWrite<CustamonInfo> {
	
	public CustamonNodeUpsert(DeciTreeOption<CustamonInfo> option) {
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
		checker = new CustamonCheckCustamonive(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<CustamonInfo>> buildActionsOnPassedHook(DeciTreeOption<CustamonInfo> option) {
		List<ActionStd<CustamonInfo>> actions = new ArrayList<>();

		ActionStd<CustamonInfo> mergeCustamonive = new ActionStdCommom<CustamonInfo>(option, CustamonVisiMergeCustamonive.class);
		ActionLazy<CustamonInfo> upsertCustamonagr = new ActionLazyCommom<CustamonInfo>(option, CustamonVisiCustamonagrUpsert.class);
		
		mergeCustamonive.addPostAction(upsertCustamonagr);
		
		
		actions.add(mergeCustamonive);
		return actions;
	}
	
	
	
	@Override protected List<ActionStd<CustamonInfo>> buildActionsOnFailedHook(DeciTreeOption<CustamonInfo> option) {
		List<ActionStd<CustamonInfo>> actions = new ArrayList<>();

		ActionStd<CustamonInfo> nodeZerofy = new ActionStdCommom<CustamonInfo>(option, CustamonVisiNodeZerofy.class);
		ActionLazy<CustamonInfo> upsertCustamonagr = new ActionLazyCommom<CustamonInfo>(option, CustamonVisiCustamonagrUpsert.class);
		
		nodeZerofy.addPostAction(upsertCustamonagr);
		
		
		actions.add(nodeZerofy);
		return actions;
	}
}
