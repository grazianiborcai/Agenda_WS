package br.com.mind5.stats.statsStoreProfile.storeProfileMonth.model.decisionTree;

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
import br.com.mind5.stats.statsStoreProfile.storeProfileMonth.info.StefilonInfo;
import br.com.mind5.stats.statsStoreProfile.storeProfileMonth.model.action.StefilonVisiEnforceZerofy;
import br.com.mind5.stats.statsStoreProfile.storeProfileMonth.model.action.StefilonVisiMergeStefilonive;
import br.com.mind5.stats.statsStoreProfile.storeProfileMonth.model.action.StefilonVisiStefilonagrInsert;
import br.com.mind5.stats.statsStoreProfile.storeProfileMonth.model.checker.StefilonCheckStefilonive;


public final class StefilonNodeSelectL2 extends DeciTreeTemplateWrite<StefilonInfo> {
	
	public StefilonNodeSelectL2(DeciTreeOption<StefilonInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<StefilonInfo> buildCheckerHook(DeciTreeOption<StefilonInfo> option) {
		List<ModelChecker<StefilonInfo>> queue = new ArrayList<>();		
		ModelChecker<StefilonInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new StefilonCheckStefilonive(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<StefilonInfo>> buildActionsOnPassedHook(DeciTreeOption<StefilonInfo> option) {
		List<ActionStd<StefilonInfo>> actions = new ArrayList<>();

		ActionStd<StefilonInfo> mergeStefilonive = new ActionStdCommom<StefilonInfo>(option, StefilonVisiMergeStefilonive.class);
		ActionLazy<StefilonInfo> insertStefilonagr = new ActionLazyCommom<StefilonInfo>(option.conn, option.schemaName, StefilonVisiStefilonagrInsert.class);
		
		mergeStefilonive.addPostAction(insertStefilonagr);
		
		
		actions.add(mergeStefilonive);
		return actions;
	}
	
	
	
	@Override protected List<ActionStd<StefilonInfo>> buildActionsOnFailedHook(DeciTreeOption<StefilonInfo> option) {
		List<ActionStd<StefilonInfo>> actions = new ArrayList<>();

		ActionStd<StefilonInfo> zerofy = new ActionStdCommom<StefilonInfo>(option, StefilonVisiEnforceZerofy.class);
		ActionLazy<StefilonInfo> insertStefilonagr = new ActionLazyCommom<StefilonInfo>(option.conn, option.schemaName, StefilonVisiStefilonagrInsert.class);
		
		zerofy.addPostAction(insertStefilonagr);
		
		actions.add(zerofy);
		return actions;
	}
}
