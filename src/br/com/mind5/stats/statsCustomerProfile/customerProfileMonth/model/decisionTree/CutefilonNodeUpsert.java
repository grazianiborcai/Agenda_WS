package br.com.mind5.stats.statsCustomerProfile.customerProfileMonth.model.decisionTree;

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
import br.com.mind5.stats.statsCustomerProfile.customerProfileMonth.info.CutefilonInfo;
import br.com.mind5.stats.statsCustomerProfile.customerProfileMonth.model.action.CutefilonVisiEnforceZerofy;
import br.com.mind5.stats.statsCustomerProfile.customerProfileMonth.model.action.CutefilonVisiMergeCutefilonive;
import br.com.mind5.stats.statsCustomerProfile.customerProfileMonth.model.action.CutefilonVisiCutefilonagrUpsert;
import br.com.mind5.stats.statsCustomerProfile.customerProfileMonth.model.checker.CutefilonCheckStefilonive;


public final class CutefilonNodeUpsert extends DeciTreeTemplateWrite<CutefilonInfo> {
	
	public CutefilonNodeUpsert(DeciTreeOption<CutefilonInfo> option) {
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
		checker = new CutefilonCheckStefilonive(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<CutefilonInfo>> buildActionsOnPassedHook(DeciTreeOption<CutefilonInfo> option) {
		List<ActionStd<CutefilonInfo>> actions = new ArrayList<>();

		ActionStd<CutefilonInfo> mergeCutefilonive = new ActionStdCommom<CutefilonInfo>(option, CutefilonVisiMergeCutefilonive.class);
		ActionLazy<CutefilonInfo> upsertCutefilonagr = new ActionLazyCommom<CutefilonInfo>(option, CutefilonVisiCutefilonagrUpsert.class);
		
		mergeCutefilonive.addPostAction(upsertCutefilonagr);
		
		
		actions.add(mergeCutefilonive);
		return actions;
	}
	
	
	
	@Override protected List<ActionStd<CutefilonInfo>> buildActionsOnFailedHook(DeciTreeOption<CutefilonInfo> option) {
		List<ActionStd<CutefilonInfo>> actions = new ArrayList<>();

		ActionStd<CutefilonInfo> zerofy = new ActionStdCommom<CutefilonInfo>(option, CutefilonVisiEnforceZerofy.class);
		ActionLazy<CutefilonInfo> upsertCutefilonagr = new ActionLazyCommom<CutefilonInfo>(option, CutefilonVisiCutefilonagrUpsert.class);
		
		zerofy.addPostAction(upsertCutefilonagr);
		
		
		actions.add(zerofy);
		return actions;
	}
}
