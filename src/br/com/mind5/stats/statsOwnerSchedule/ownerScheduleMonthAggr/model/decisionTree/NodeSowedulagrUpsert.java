package br.com.mind5.stats.statsOwnerSchedule.ownerScheduleMonthAggr.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;
import br.com.mind5.stats.statsOwnerSchedule.ownerScheduleMonthAggr.info.SowedulagrInfo;
import br.com.mind5.stats.statsOwnerSchedule.ownerScheduleMonthAggr.model.checker.SowedulagrCheckExist;


public final class NodeSowedulagrUpsert extends DeciTreeTemplateWrite<SowedulagrInfo> {
	
	public NodeSowedulagrUpsert(DeciTreeOption<SowedulagrInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<SowedulagrInfo> buildCheckerHook(DeciTreeOption<SowedulagrInfo> option) {
		List<ModelChecker<SowedulagrInfo>> queue = new ArrayList<>();		
		ModelChecker<SowedulagrInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new SowedulagrCheckExist(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<SowedulagrInfo>> buildActionsOnPassedHook(DeciTreeOption<SowedulagrInfo> option) {
		List<ActionStd<SowedulagrInfo>> actions = new ArrayList<>();

		ActionStd<SowedulagrInfo> delete = new RootSowedulagrDelete(option).toAction();
		ActionStd<SowedulagrInfo> insert = new RootSowedulagrInsert(option).toAction();
		
		actions.add(delete);
		actions.add(insert);
		
		return actions;
	}
	
	
	
	@Override protected List<ActionStd<SowedulagrInfo>> buildActionsOnFailedHook(DeciTreeOption<SowedulagrInfo> option) {
		List<ActionStd<SowedulagrInfo>> actions = new ArrayList<>();

		ActionStd<SowedulagrInfo> insert = new RootSowedulagrInsert(option).toAction();
		
		actions.add(insert);
		return actions;
	}
}
