package br.com.mind5.stats.statsOwnerSchedule.ownerScheduleMonthAggr.model.decisionTree;

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
import br.com.mind5.stats.statsOwnerSchedule.ownerScheduleMonthAggr.info.SowedulagrInfo;
import br.com.mind5.stats.statsOwnerSchedule.ownerScheduleMonthAggr.model.action.SowedulagrVisiMergeCalonth;
import br.com.mind5.stats.statsOwnerSchedule.ownerScheduleMonthAggr.model.action.SowedulagrVisiMergeState;
import br.com.mind5.stats.statsOwnerSchedule.ownerScheduleMonthAggr.model.action.SowedulagrVisiMergeToSelect;
import br.com.mind5.stats.statsOwnerSchedule.ownerScheduleMonthAggr.model.checker.SowedulagrCheckLangu;
import br.com.mind5.stats.statsOwnerSchedule.ownerScheduleMonthAggr.model.checker.SowedulagrCheckOwner;
import br.com.mind5.stats.statsOwnerSchedule.ownerScheduleMonthAggr.model.checker.SowedulagrCheckRead;


public final class SowedulagrRootSelect extends DeciTreeTemplateWrite<SowedulagrInfo> {
	
	public SowedulagrRootSelect(DeciTreeOption<SowedulagrInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<SowedulagrInfo> buildCheckerHook(DeciTreeOption<SowedulagrInfo> option) {
		List<ModelChecker<SowedulagrInfo>> queue = new ArrayList<>();
		ModelChecker<SowedulagrInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;
		checker = new SowedulagrCheckRead(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;
		checker = new SowedulagrCheckLangu(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;
		checker = new SowedulagrCheckOwner(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<SowedulagrInfo>> buildActionsOnPassedHook(DeciTreeOption<SowedulagrInfo> option) {
		List<ActionStd<SowedulagrInfo>> actions = new ArrayList<>();

		ActionStd<SowedulagrInfo> select = new ActionStdCommom<SowedulagrInfo>(option, SowedulagrVisiMergeToSelect.class);
		ActionLazy<SowedulagrInfo> mergeState = new ActionLazyCommom<SowedulagrInfo>(option, SowedulagrVisiMergeState.class);
		ActionLazy<SowedulagrInfo> mergeCalonth = new ActionLazyCommom<SowedulagrInfo>(option, SowedulagrVisiMergeCalonth.class);
		
		select.addPostAction(mergeState);
		mergeState.addPostAction(mergeCalonth);
		
		actions.add(select);
		return actions;
	}
}
