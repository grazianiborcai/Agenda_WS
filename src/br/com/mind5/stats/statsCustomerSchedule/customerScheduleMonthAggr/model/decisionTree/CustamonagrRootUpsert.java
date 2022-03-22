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
import br.com.mind5.stats.statsCustomerSchedule.customerScheduleMonthAggr.model.checker.CustamonagrCheckLangu;
import br.com.mind5.stats.statsCustomerSchedule.customerScheduleMonthAggr.model.checker.CustamonagrCheckOwner;
import br.com.mind5.stats.statsCustomerSchedule.customerScheduleMonthAggr.model.checker.CustamonagrCheckCus;
import br.com.mind5.stats.statsCustomerSchedule.customerScheduleMonthAggr.model.checker.CustamonagrCheckWrite;


public final class CustamonagrRootUpsert extends DeciTreeTemplateWrite<CustamonagrInfo> {
	
	public CustamonagrRootUpsert(DeciTreeOption<CustamonagrInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<CustamonagrInfo> buildCheckerHook(DeciTreeOption<CustamonagrInfo> option) {
		List<ModelChecker<CustamonagrInfo>> queue = new ArrayList<>();		
		ModelChecker<CustamonagrInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;		
		checker = new CustamonagrCheckWrite(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new CustamonagrCheckLangu(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new CustamonagrCheckOwner(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new CustamonagrCheckCus(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<CustamonagrInfo>> buildActionsOnPassedHook(DeciTreeOption<CustamonagrInfo> option) {
		List<ActionStd<CustamonagrInfo>> actions = new ArrayList<>();

		ActionStd<CustamonagrInfo> nodeL1 = new CustamonagrNodeUpsert(option).toAction();
		
		actions.add(nodeL1);
		return actions;
	}
}
