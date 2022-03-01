package br.com.mind5.stats.statsOwnerSchedule.ownerScheduleMonthSearch.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;
import br.com.mind5.stats.statsOwnerSchedule.ownerScheduleMonthSearch.info.SowedularchInfo;
import br.com.mind5.stats.statsOwnerSchedule.ownerScheduleMonthSearch.model.action.SowedularchVisiMergeToSelect;
import br.com.mind5.stats.statsOwnerSchedule.ownerScheduleMonthSearch.model.checker.SowedularchCheckLangu;
import br.com.mind5.stats.statsOwnerSchedule.ownerScheduleMonthSearch.model.checker.SowedularchCheckOwner;
import br.com.mind5.stats.statsOwnerSchedule.ownerScheduleMonthSearch.model.checker.SowedularchCheckRead;


public final class SowedularchRootSelect extends DeciTreeTemplateWrite<SowedularchInfo> {
	
	public SowedularchRootSelect(DeciTreeOption<SowedularchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<SowedularchInfo> buildCheckerHook(DeciTreeOption<SowedularchInfo> option) {
		List<ModelChecker<SowedularchInfo>> queue = new ArrayList<>();
		ModelChecker<SowedularchInfo> checker;
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
	
	
	
	@Override protected List<ActionStd<SowedularchInfo>> buildActionsOnPassedHook(DeciTreeOption<SowedularchInfo> option) {
		List<ActionStd<SowedularchInfo>> actions = new ArrayList<>();

		ActionStd<SowedularchInfo> select = new ActionStdCommom<SowedularchInfo>(option, SowedularchVisiMergeToSelect.class);
		
		actions.add(select);
		return actions;
	}
}
