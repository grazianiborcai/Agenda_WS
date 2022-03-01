package br.com.mind5.stats.statsOwnerStore.ownerStoreMonth.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;
import br.com.mind5.stats.statsOwnerStore.ownerStoreMonth.info.SowotInfo;
import br.com.mind5.stats.statsOwnerStore.ownerStoreMonth.model.action.SowotVisiMergeSowotagr;
import br.com.mind5.stats.statsOwnerStore.ownerStoreMonth.model.checker.SowotCheckSowotagr;


public final class SowotNodeSelectL1 extends DeciTreeTemplateWrite<SowotInfo> {
	
	public SowotNodeSelectL1(DeciTreeOption<SowotInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<SowotInfo> buildCheckerHook(DeciTreeOption<SowotInfo> option) {
		List<ModelChecker<SowotInfo>> queue = new ArrayList<>();
		ModelChecker<SowotInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;
		checker = new SowotCheckSowotagr(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<SowotInfo>> buildActionsOnPassedHook(DeciTreeOption<SowotInfo> option) {
		List<ActionStd<SowotInfo>> actions = new ArrayList<>();

		ActionStd<SowotInfo> mergeSowotagr = new ActionStdCommom<SowotInfo>(option, SowotVisiMergeSowotagr.class);
		
		actions.add(mergeSowotagr);
		return actions;
	}
	
	
	
	@Override protected List<ActionStd<SowotInfo>> buildActionsOnFailedHook(DeciTreeOption<SowotInfo> option) {
		List<ActionStd<SowotInfo>> actions = new ArrayList<>();

		ActionStd<SowotInfo> nodeL2 = new SowotNodeSelectL2(option).toAction();
		
		actions.add(nodeL2);
		return actions;
	}
}
