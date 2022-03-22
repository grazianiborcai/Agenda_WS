package br.com.mind5.stats.statsCustomerProfile.customerProfileMonth.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;
import br.com.mind5.stats.statsCustomerProfile.customerProfileMonth.info.CutefilonInfo;
import br.com.mind5.stats.statsCustomerProfile.customerProfileMonth.model.action.CutefilonVisiMergeCutefilonagr;
import br.com.mind5.stats.statsCustomerProfile.customerProfileMonth.model.checker.CutefilonCheckStefilonagr;


public final class CutefilonNodeSelectL1 extends DeciTreeTemplateWrite<CutefilonInfo> {
	
	public CutefilonNodeSelectL1(DeciTreeOption<CutefilonInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<CutefilonInfo> buildCheckerHook(DeciTreeOption<CutefilonInfo> option) {
		List<ModelChecker<CutefilonInfo>> queue = new ArrayList<>();		
		ModelChecker<CutefilonInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new CutefilonCheckStefilonagr(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<CutefilonInfo>> buildActionsOnPassedHook(DeciTreeOption<CutefilonInfo> option) {
		List<ActionStd<CutefilonInfo>> actions = new ArrayList<>();

		ActionStd<CutefilonInfo> mergeCutefilonagr = new ActionStdCommom<CutefilonInfo>(option, CutefilonVisiMergeCutefilonagr.class);
		
		actions.add(mergeCutefilonagr);
		return actions;
	}
	
	
	
	@Override protected List<ActionStd<CutefilonInfo>> buildActionsOnFailedHook(DeciTreeOption<CutefilonInfo> option) {
		List<ActionStd<CutefilonInfo>> actions = new ArrayList<>();

		ActionStd<CutefilonInfo> nodeL2 = new CutefilonNodeSelectL2(option).toAction();
		
		actions.add(nodeL2);
		return actions;
	}
}
