package br.com.mind5.stats.statsOwnerSchedule.ownerScheduleMonth.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;
import br.com.mind5.stats.statsOwnerSchedule.ownerScheduleMonth.info.SowedulInfo;
import br.com.mind5.stats.statsOwnerSchedule.ownerScheduleMonth.model.action.SowedulVisiMergeSowedulagr;
import br.com.mind5.stats.statsOwnerSchedule.ownerScheduleMonth.model.checker.SowedulCheckSowedulagr;


public final class SowedulNodeSelectL1 extends DeciTreeTemplateWrite<SowedulInfo> {
	
	public SowedulNodeSelectL1(DeciTreeOption<SowedulInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<SowedulInfo> buildCheckerHook(DeciTreeOption<SowedulInfo> option) {
		List<ModelChecker<SowedulInfo>> queue = new ArrayList<>();
		ModelChecker<SowedulInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;
		checker = new SowedulCheckSowedulagr(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<SowedulInfo>> buildActionsOnPassedHook(DeciTreeOption<SowedulInfo> option) {
		List<ActionStd<SowedulInfo>> actions = new ArrayList<>();

		ActionStd<SowedulInfo> mergeSowedulagr = new ActionStdCommom<SowedulInfo>(option, SowedulVisiMergeSowedulagr.class);
		
		actions.add(mergeSowedulagr);
		return actions;
	}
	
	
	
	@Override protected List<ActionStd<SowedulInfo>> buildActionsOnFailedHook(DeciTreeOption<SowedulInfo> option) {
		List<ActionStd<SowedulInfo>> actions = new ArrayList<>();

		ActionStd<SowedulInfo> nodeL2 = new SowedulNodeSelectL2(option).toAction();
		
		actions.add(nodeL2);
		return actions;
	}
}
