package br.com.mind5.stats.statsOwnerSchedule.ownerSchedule.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;
import br.com.mind5.stats.statsOwnerSchedule.ownerSchedule.info.SowedulInfo;
import br.com.mind5.stats.statsOwnerSchedule.ownerSchedule.model.action.StdSowedulMergeSowedulive;
import br.com.mind5.stats.statsOwnerSchedule.ownerSchedule.model.action.StdSowedulSuccess;
import br.com.mind5.stats.statsOwnerSchedule.ownerSchedule.model.checker.SowedulCheckSowedulive;


public final class NodeSowedulSelectLtm extends DeciTreeTemplateWrite<SowedulInfo> {
	
	public NodeSowedulSelectLtm(DeciTreeOption<SowedulInfo> option) {
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
		
		actions.add(mergeSowedulive);
		return actions;
	}
	
	
	
	@Override protected List<ActionStd<SowedulInfo>> buildActionsOnFailedHook(DeciTreeOption<SowedulInfo> option) {
		List<ActionStd<SowedulInfo>> actions = new ArrayList<>();

		ActionStd<SowedulInfo> success = new StdSowedulSuccess(option);
		
		actions.add(success);
		return actions;
	}
}
