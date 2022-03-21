package br.com.mind5.stats.statsCustomerSchedule.customerScheduleMonthLive.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionStdSuccessCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;
import br.com.mind5.stats.statsCustomerSchedule.customerScheduleMonthLive.info.CustamoniveInfo;
import br.com.mind5.stats.statsCustomerSchedule.customerScheduleMonthLive.model.checker.CustamoniveCheckAuthOwner;

public final class CustamoniveNodeAuthL1 extends DeciTreeTemplateWrite<CustamoniveInfo> {
	
	public CustamoniveNodeAuthL1(DeciTreeOption<CustamoniveInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<CustamoniveInfo> buildCheckerHook(DeciTreeOption<CustamoniveInfo> option) {
		List<ModelChecker<CustamoniveInfo>> queue = new ArrayList<>();		
		ModelChecker<CustamoniveInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new CustamoniveCheckAuthOwner(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<CustamoniveInfo>> buildActionsOnPassedHook(DeciTreeOption<CustamoniveInfo> option) {
		List<ActionStd<CustamoniveInfo>> actions = new ArrayList<>();
		
		ActionStd<CustamoniveInfo> success = new ActionStdSuccessCommom<CustamoniveInfo>(option);
		
		actions.add(success);
		return actions;
	}
	
	
	
	@Override protected List<ActionStd<CustamoniveInfo>> buildActionsOnFailedHook(DeciTreeOption<CustamoniveInfo> option) {
		List<ActionStd<CustamoniveInfo>> actions = new ArrayList<>();
		
		ActionStd<CustamoniveInfo> nodeL2 = new CustamoniveNodeAuthL2(option).toAction();
		
		actions.add(nodeL2);
		return actions;
	}
}
