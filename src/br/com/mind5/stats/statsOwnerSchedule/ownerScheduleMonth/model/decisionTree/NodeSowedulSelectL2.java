package br.com.mind5.stats.statsOwnerSchedule.ownerScheduleMonth.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;
import br.com.mind5.stats.statsOwnerSchedule.ownerScheduleMonth.info.SowedulInfo;
import br.com.mind5.stats.statsOwnerSchedule.ownerScheduleMonth.model.action.LazySowedulSowedulagrInsert;
import br.com.mind5.stats.statsOwnerSchedule.ownerScheduleMonth.model.action.StdSowedulEnforceZerofy;
import br.com.mind5.stats.statsOwnerSchedule.ownerScheduleMonth.model.action.StdSowedulMergeSowedulive;
import br.com.mind5.stats.statsOwnerSchedule.ownerScheduleMonth.model.checker.SowedulCheckSowedulive;


public final class NodeSowedulSelectL2 extends DeciTreeTemplateWrite<SowedulInfo> {
	
	public NodeSowedulSelectL2(DeciTreeOption<SowedulInfo> option) {
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
		checker = new SowedulCheckSowedulive(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<SowedulInfo>> buildActionsOnPassedHook(DeciTreeOption<SowedulInfo> option) {
		List<ActionStd<SowedulInfo>> actions = new ArrayList<>();

		ActionStd<SowedulInfo> mergeSowedulive = new StdSowedulMergeSowedulive(option);
		ActionLazy<SowedulInfo> insertSowedulagr = new LazySowedulSowedulagrInsert(option.conn, option.schemaName);
		
		mergeSowedulive.addPostAction(insertSowedulagr);
		
		
		actions.add(mergeSowedulive);
		return actions;
	}
	
	
	
	@Override protected List<ActionStd<SowedulInfo>> buildActionsOnFailedHook(DeciTreeOption<SowedulInfo> option) {
		List<ActionStd<SowedulInfo>> actions = new ArrayList<>();

		ActionStd<SowedulInfo> zerofy = new StdSowedulEnforceZerofy(option);
		ActionLazy<SowedulInfo> insertSowedul = new LazySowedulSowedulagrInsert(option.conn, option.schemaName);
		
		zerofy.addPostAction(insertSowedul);
		
		actions.add(zerofy);
		return actions;
	}
}
