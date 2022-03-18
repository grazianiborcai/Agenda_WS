package br.com.mind5.stats.statsStoreProfile.storeProfileMonth.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;
import br.com.mind5.stats.statsStoreProfile.storeProfileMonth.info.StefilonInfo;
import br.com.mind5.stats.statsStoreProfile.storeProfileMonth.model.action.StefilonVisiMergeStefilonagr;
import br.com.mind5.stats.statsStoreProfile.storeProfileMonth.model.checker.StefilonCheckStefilonagr;


public final class StefilonNodeSelectL1 extends DeciTreeTemplateWrite<StefilonInfo> {
	
	public StefilonNodeSelectL1(DeciTreeOption<StefilonInfo> option) {
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
		checker = new StefilonCheckStefilonagr(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<StefilonInfo>> buildActionsOnPassedHook(DeciTreeOption<StefilonInfo> option) {
		List<ActionStd<StefilonInfo>> actions = new ArrayList<>();

		ActionStd<StefilonInfo> mergeStefilonagr = new ActionStdCommom<StefilonInfo>(option, StefilonVisiMergeStefilonagr.class);
		
		actions.add(mergeStefilonagr);
		return actions;
	}
	
	
	
	@Override protected List<ActionStd<StefilonInfo>> buildActionsOnFailedHook(DeciTreeOption<StefilonInfo> option) {
		List<ActionStd<StefilonInfo>> actions = new ArrayList<>();

		ActionStd<StefilonInfo> nodeL2 = new StefilonNodeSelectL2(option).toAction();
		
		actions.add(nodeL2);
		return actions;
	}
}
