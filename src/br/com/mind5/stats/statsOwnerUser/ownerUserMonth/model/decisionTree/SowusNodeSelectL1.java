package br.com.mind5.stats.statsOwnerUser.ownerUserMonth.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;
import br.com.mind5.stats.statsOwnerUser.ownerUserMonth.info.SowusInfo;
import br.com.mind5.stats.statsOwnerUser.ownerUserMonth.model.action.SowusVisiMergeSowusagr;
import br.com.mind5.stats.statsOwnerUser.ownerUserMonth.model.checker.SowusCheckSowusagr;


public final class SowusNodeSelectL1 extends DeciTreeTemplateWrite<SowusInfo> {
	
	public SowusNodeSelectL1(DeciTreeOption<SowusInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<SowusInfo> buildCheckerHook(DeciTreeOption<SowusInfo> option) {
		List<ModelChecker<SowusInfo>> queue = new ArrayList<>();
		ModelChecker<SowusInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;
		checker = new SowusCheckSowusagr(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<SowusInfo>> buildActionsOnPassedHook(DeciTreeOption<SowusInfo> option) {
		List<ActionStd<SowusInfo>> actions = new ArrayList<>();

		ActionStd<SowusInfo> mergeSowusagr = new ActionStdCommom<SowusInfo>(option, SowusVisiMergeSowusagr.class);
		
		actions.add(mergeSowusagr);
		return actions;
	}
	
	
	
	@Override protected List<ActionStd<SowusInfo>> buildActionsOnFailedHook(DeciTreeOption<SowusInfo> option) {
		List<ActionStd<SowusInfo>> actions = new ArrayList<>();

		ActionStd<SowusInfo> nodeL2 = new SowusNodeSelectL2(option).toAction();
		
		actions.add(nodeL2);
		return actions;
	}
}
