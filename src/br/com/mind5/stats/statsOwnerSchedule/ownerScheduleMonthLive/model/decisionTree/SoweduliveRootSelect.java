package br.com.mind5.stats.statsOwnerSchedule.ownerScheduleMonthLive.model.decisionTree;

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
import br.com.mind5.stats.statsOwnerSchedule.ownerScheduleMonthLive.info.SoweduliveInfo;
import br.com.mind5.stats.statsOwnerSchedule.ownerScheduleMonthLive.model.action.SoweduliveVisiEnforceLChanged;
import br.com.mind5.stats.statsOwnerSchedule.ownerScheduleMonthLive.model.action.SoweduliveVisiMergeMonth;
import br.com.mind5.stats.statsOwnerSchedule.ownerScheduleMonthLive.model.action.SoweduliveVisiMergeState;
import br.com.mind5.stats.statsOwnerSchedule.ownerScheduleMonthLive.model.action.SoweduliveVisiMergeToSelect;
import br.com.mind5.stats.statsOwnerSchedule.ownerScheduleMonthLive.model.checker.SoweduliveCheckLangu;
import br.com.mind5.stats.statsOwnerSchedule.ownerScheduleMonthLive.model.checker.SoweduliveCheckOwner;
import br.com.mind5.stats.statsOwnerSchedule.ownerScheduleMonthLive.model.checker.SoweduliveCheckRead;


public final class SoweduliveRootSelect extends DeciTreeTemplateWrite<SoweduliveInfo> {
	
	public SoweduliveRootSelect(DeciTreeOption<SoweduliveInfo> option) {
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

		ActionStd<SoweduliveInfo> select = new ActionStdCommom<SoweduliveInfo>(option, SoweduliveVisiMergeToSelect.class);
		ActionLazy<SoweduliveInfo> enforceLChanged = new ActionLazyCommom<SoweduliveInfo>(option.conn, option.schemaName, SoweduliveVisiEnforceLChanged.class);
		ActionLazy<SoweduliveInfo> mergeState = new ActionLazyCommom<SoweduliveInfo>(option.conn, option.schemaName, SoweduliveVisiMergeState.class);
		ActionLazy<SoweduliveInfo> mergeMonth = new ActionLazyCommom<SoweduliveInfo>(option.conn, option.schemaName, SoweduliveVisiMergeMonth.class);		
		
		select.addPostAction(enforceLChanged);
		enforceLChanged.addPostAction(mergeState);
		mergeState.addPostAction(mergeMonth);
		
		actions.add(select);
		return actions;
	}
}
