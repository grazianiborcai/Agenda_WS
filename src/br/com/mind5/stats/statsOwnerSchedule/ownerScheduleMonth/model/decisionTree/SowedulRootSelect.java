package br.com.mind5.stats.statsOwnerSchedule.ownerScheduleMonth.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;
import br.com.mind5.stats.statsOwnerSchedule.ownerScheduleMonth.info.SowedulInfo;
import br.com.mind5.stats.statsOwnerSchedule.ownerScheduleMonth.model.action.SowedulVisiMergeStolis;
import br.com.mind5.stats.statsOwnerSchedule.ownerScheduleMonth.model.action.SowedulVisiNodeSelectL1;
import br.com.mind5.stats.statsOwnerSchedule.ownerScheduleMonth.model.checker.SowedulCheckLangu;
import br.com.mind5.stats.statsOwnerSchedule.ownerScheduleMonth.model.checker.SowedulCheckOwner;
import br.com.mind5.stats.statsOwnerSchedule.ownerScheduleMonth.model.checker.SowedulCheckRead;


public final class SowedulRootSelect extends DeciTreeTemplateWrite<SowedulInfo> {
	
	public SowedulRootSelect(DeciTreeOption<SowedulInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<SowedulInfo> buildCheckerHook(DeciTreeOption<SowedulInfo> option) {
		List<ModelChecker<SowedulInfo>> queue = new ArrayList<>();
		ModelChecker<SowedulInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;
		checker = new SowedulCheckRead(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;
		checker = new SowedulCheckLangu(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;
		checker = new SowedulCheckOwner(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<SowedulInfo>> buildActionsOnPassedHook(DeciTreeOption<SowedulInfo> option) {
		List<ActionStd<SowedulInfo>> actions = new ArrayList<>();

		ActionStd<SowedulInfo> mergeStolis = new ActionStdCommom<SowedulInfo>(option, SowedulVisiMergeStolis.class);
		ActionLazy<SowedulInfo> nodeL1 = new ActionLazyCommom<SowedulInfo>(option.conn, option.schemaName, SowedulVisiNodeSelectL1.class);
		
		mergeStolis.addPostAction(nodeL1);
		
		actions.add(mergeStolis);
		return actions;
	}
}
