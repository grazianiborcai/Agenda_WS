package br.com.mind5.stats.statsCustomerProfile.customerProfileMonthLive.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionStdSuccessCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;
import br.com.mind5.stats.statsCustomerProfile.customerProfileMonthLive.info.CutefiloniveInfo;
import br.com.mind5.stats.statsCustomerProfile.customerProfileMonthLive.model.checker.CutefiloniveCheckAuthOwner;

public final class CutefiloniveNodeAuthL1 extends DeciTreeTemplateWrite<CutefiloniveInfo> {
	
	public CutefiloniveNodeAuthL1(DeciTreeOption<CutefiloniveInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<CutefiloniveInfo> buildCheckerHook(DeciTreeOption<CutefiloniveInfo> option) {
		List<ModelChecker<CutefiloniveInfo>> queue = new ArrayList<>();		
		ModelChecker<CutefiloniveInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new CutefiloniveCheckAuthOwner(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<CutefiloniveInfo>> buildActionsOnPassedHook(DeciTreeOption<CutefiloniveInfo> option) {
		List<ActionStd<CutefiloniveInfo>> actions = new ArrayList<>();
		
		ActionStd<CutefiloniveInfo> success = new ActionStdSuccessCommom<CutefiloniveInfo>(option);
		
		actions.add(success);
		return actions;
	}
	
	
	
	@Override protected List<ActionStd<CutefiloniveInfo>> buildActionsOnFailedHook(DeciTreeOption<CutefiloniveInfo> option) {
		List<ActionStd<CutefiloniveInfo>> actions = new ArrayList<>();
		
		ActionStd<CutefiloniveInfo> nodeL2 = new CutefiloniveNodeAuthL2(option).toAction();
		
		actions.add(nodeL2);
		return actions;
	}
}
