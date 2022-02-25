package br.com.mind5.stats.statsOwnerSchedule.ownerScheduleMonthSearch.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;
import br.com.mind5.stats.statsOwnerSchedule.ownerScheduleMonthSearch.info.SowedularchhInfo;
import br.com.mind5.stats.statsOwnerSchedule.ownerScheduleMonthSearch.model.action.StdSowedularchMergeToSelect;
import br.com.mind5.stats.statsOwnerSchedule.ownerScheduleMonthSearch.model.checker.SowedularchCheckLangu;
import br.com.mind5.stats.statsOwnerSchedule.ownerScheduleMonthSearch.model.checker.SowedularchCheckOwner;
import br.com.mind5.stats.statsOwnerSchedule.ownerScheduleMonthSearch.model.checker.SowedularchCheckRead;


public final class RootSowedularchSelect extends DeciTreeTemplateWrite<SowedularchhInfo> {
	
	public RootSowedularchSelect(DeciTreeOption<SowedularchhInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<SowedularchhInfo> buildCheckerHook(DeciTreeOption<SowedularchhInfo> option) {
		List<ModelChecker<SowedularchhInfo>> queue = new ArrayList<>();
		ModelChecker<SowedularchhInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;
		checker = new SowedularchCheckRead(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;
		checker = new SowedularchCheckLangu(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;
		checker = new SowedularchCheckOwner(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<SowedularchhInfo>> buildActionsOnPassedHook(DeciTreeOption<SowedularchhInfo> option) {
		List<ActionStd<SowedularchhInfo>> actions = new ArrayList<>();

		ActionStd<SowedularchhInfo> select = new StdSowedularchMergeToSelect(option);
		
		actions.add(select);
		return actions;
	}
}
