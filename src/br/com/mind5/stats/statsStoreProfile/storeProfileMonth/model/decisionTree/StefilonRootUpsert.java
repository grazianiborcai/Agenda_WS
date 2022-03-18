package br.com.mind5.stats.statsStoreProfile.storeProfileMonth.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;
import br.com.mind5.stats.statsStoreProfile.storeProfileMonth.info.StefilonInfo;
import br.com.mind5.stats.statsStoreProfile.storeProfileMonth.model.checker.StefilonCheckWrite;


public final class StefilonRootUpsert extends DeciTreeTemplateWrite<StefilonInfo> {
	
	public StefilonRootUpsert(DeciTreeOption<StefilonInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<StefilonInfo> buildCheckerHook(DeciTreeOption<StefilonInfo> option) {
		List<ModelChecker<StefilonInfo>> queue = new ArrayList<>();		
		ModelChecker<StefilonInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;		
		checker = new StefilonCheckWrite(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<StefilonInfo>> buildActionsOnPassedHook(DeciTreeOption<StefilonInfo> option) {
		List<ActionStd<StefilonInfo>> actions = new ArrayList<>();

		ActionStd<StefilonInfo> nodeL1 = new StefilonNodeUpsert(option).toAction();		
		
		actions.add(nodeL1);
		return actions;
	}
}
