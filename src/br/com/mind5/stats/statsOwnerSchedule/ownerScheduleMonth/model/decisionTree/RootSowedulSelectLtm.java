package br.com.mind5.stats.statsOwnerSchedule.ownerScheduleMonth.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.common.ModelCheckerDummy;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;
import br.com.mind5.stats.statsOwnerSchedule.ownerScheduleMonth.info.SowedulInfo;
import br.com.mind5.stats.statsOwnerSchedule.ownerScheduleMonth.model.action.LazySowedulNodeSelectLtm;
import br.com.mind5.stats.statsOwnerSchedule.ownerScheduleMonth.model.action.LazySowedulNodeZerofy;
import br.com.mind5.stats.statsOwnerSchedule.ownerScheduleMonth.model.action.StdSowedulMergeCalonthLtm;


public final class RootSowedulSelectLtm extends DeciTreeTemplateWrite<SowedulInfo> {
	
	public RootSowedulSelectLtm(DeciTreeOption<SowedulInfo> option) {
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

		ActionStd<SowedulInfo> mergeCalonthLtm = new StdSowedulMergeCalonthLtm(option);
		ActionLazy<SowedulInfo> nodeL1 = new LazySowedulNodeSelectLtm(option.conn, option.schemaName);
		ActionLazy<SowedulInfo> zerofy = new LazySowedulNodeZerofy(option.conn, option.schemaName);		
		
		mergeCalonthLtm.addPostAction(nodeL1);
		nodeL1.addPostAction(zerofy);
		
		actions.add(mergeCalonthLtm);
		return actions;
	}
}
