package br.com.mind5.stats.statsOwnerSchedule.ownerScheduleMonth.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.common.ModelCheckerDummy;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;
import br.com.mind5.stats.statsOwnerSchedule.ownerScheduleMonth.info.SowedulInfo;
import br.com.mind5.stats.statsOwnerSchedule.ownerScheduleMonth.model.action.SowedulVisiMergeStolis;
import br.com.mind5.stats.statsOwnerSchedule.ownerScheduleMonth.model.action.SowedulVisiNodeUpsertL2;


public final class SowedulNodeUpsertL1 extends DeciTreeTemplateWrite<SowedulInfo> {
	
	public SowedulNodeUpsertL1(DeciTreeOption<SowedulInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<SowedulInfo> buildCheckerHook(DeciTreeOption<SowedulInfo> option) {
		List<ModelChecker<SowedulInfo>> queue = new ArrayList<>();
		ModelChecker<SowedulInfo> checker;

		checker = new ModelCheckerDummy<>();
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<SowedulInfo>> buildActionsOnPassedHook(DeciTreeOption<SowedulInfo> option) {
		List<ActionStd<SowedulInfo>> actions = new ArrayList<>();

		ActionStd<SowedulInfo> mergeStolis = new ActionStdCommom<SowedulInfo>(option, SowedulVisiMergeStolis.class);
		ActionLazy<SowedulInfo> nodeL1 = new ActionLazyCommom<SowedulInfo>(option.conn, option.schemaName, SowedulVisiNodeUpsertL2.class);
		
		mergeStolis.addPostAction(nodeL1);
		
		actions.add(mergeStolis);
		return actions;
	}
}
