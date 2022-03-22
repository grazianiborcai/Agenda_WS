package br.com.mind5.stats.statsCustomerSchedule.customerScheduleMonthAggr.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;
import br.com.mind5.stats.statsCustomerSchedule.customerScheduleMonthAggr.info.CustamonagrInfo;
import br.com.mind5.stats.statsCustomerSchedule.customerScheduleMonthAggr.model.checker.CustamonagrCheckExist;


public final class CustamonagrNodeUpsert extends DeciTreeTemplateWrite<CustamonagrInfo> {
	
	public CustamonagrNodeUpsert(DeciTreeOption<CustamonagrInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<CustamonagrInfo> buildCheckerHook(DeciTreeOption<CustamonagrInfo> option) {
		List<ModelChecker<CustamonagrInfo>> queue = new ArrayList<>();		
		ModelChecker<CustamonagrInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new CustamonagrCheckExist(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<CustamonagrInfo>> buildActionsOnPassedHook(DeciTreeOption<CustamonagrInfo> option) {
		List<ActionStd<CustamonagrInfo>> actions = new ArrayList<>();

		ActionStd<CustamonagrInfo> delete = new CustamonagrRootDelete(option).toAction();
		ActionStd<CustamonagrInfo> insert = new CustamonagrRootInsert(option).toAction();
		
		actions.add(delete);
		actions.add(insert);
		
		return actions;
	}
	
	
	
	@Override protected List<ActionStd<CustamonagrInfo>> buildActionsOnFailedHook(DeciTreeOption<CustamonagrInfo> option) {
		List<ActionStd<CustamonagrInfo>> actions = new ArrayList<>();

		ActionStd<CustamonagrInfo> insert = new CustamonagrRootInsert(option).toAction();
		
		actions.add(insert);
		return actions;
	}
}
