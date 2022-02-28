package br.com.mind5.stats.statsOwnerSchedule.ownerScheduleMonthLive.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;
import br.com.mind5.stats.statsOwnerSchedule.ownerScheduleMonthLive.info.SoweduliveInfo;
import br.com.mind5.stats.statsOwnerSchedule.ownerScheduleMonthLive.model.action.LazySoweduliveEnforceLChanged;
import br.com.mind5.stats.statsOwnerSchedule.ownerScheduleMonthLive.model.action.LazySoweduliveMergeMonth;
import br.com.mind5.stats.statsOwnerSchedule.ownerScheduleMonthLive.model.action.LazySoweduliveMergeState;
import br.com.mind5.stats.statsOwnerSchedule.ownerScheduleMonthLive.model.action.StdSoweduliveMergeToSelect;
import br.com.mind5.stats.statsOwnerSchedule.ownerScheduleMonthLive.model.checker.SoweduliveCheckLangu;
import br.com.mind5.stats.statsOwnerSchedule.ownerScheduleMonthLive.model.checker.SoweduliveCheckOwner;
import br.com.mind5.stats.statsOwnerSchedule.ownerScheduleMonthLive.model.checker.SoweduliveCheckRead;


public final class RootSoweduliveSelect extends DeciTreeTemplateWrite<SoweduliveInfo> {
	
	public RootSoweduliveSelect(DeciTreeOption<SoweduliveInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<SoweduliveInfo> buildCheckerHook(DeciTreeOption<SoweduliveInfo> option) {
		List<ModelChecker<SoweduliveInfo>> queue = new ArrayList<>();		
		ModelChecker<SoweduliveInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;		
		checker = new SoweduliveCheckRead(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;		
		checker = new SoweduliveCheckLangu(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;		
		checker = new SoweduliveCheckOwner(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<SoweduliveInfo>> buildActionsOnPassedHook(DeciTreeOption<SoweduliveInfo> option) {
		List<ActionStd<SoweduliveInfo>> actions = new ArrayList<>();

		ActionStd<SoweduliveInfo> select = new StdSoweduliveMergeToSelect(option);
		ActionLazy<SoweduliveInfo> enforceLChanged = new LazySoweduliveEnforceLChanged(option.conn, option.schemaName);
		ActionLazy<SoweduliveInfo> mergeState = new LazySoweduliveMergeState(option.conn, option.schemaName);
		ActionLazy<SoweduliveInfo> mergeMonth = new LazySoweduliveMergeMonth(option.conn, option.schemaName);		
		
		select.addPostAction(enforceLChanged);
		enforceLChanged.addPostAction(mergeState);
		mergeState.addPostAction(mergeMonth);
		
		actions.add(select);
		return actions;
	}
}
