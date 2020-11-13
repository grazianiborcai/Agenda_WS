package br.com.mind5.business.scheduleYearData.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.scheduleYearData.info.SchedyeratInfo;
import br.com.mind5.business.scheduleYearData.model.action.StdSchedyeratMergeToSelect;
import br.com.mind5.business.scheduleYearData.model.checker.SchedyeratCheckRead;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class RootSchedyeratSelect extends DeciTreeTemplateWrite<SchedyeratInfo> {
	
	public RootSchedyeratSelect(DeciTreeOption<SchedyeratInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<SchedyeratInfo> buildCheckerHook(DeciTreeOption<SchedyeratInfo> option) {
		List<ModelChecker<SchedyeratInfo>> queue = new ArrayList<>();		
		ModelChecker<SchedyeratInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new SchedyeratCheckRead(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<SchedyeratInfo>> buildActionsOnPassedHook(DeciTreeOption<SchedyeratInfo> option) {
		List<ActionStd<SchedyeratInfo>> actions = new ArrayList<>();
		
		ActionStd<SchedyeratInfo> mergeToSelect = new StdSchedyeratMergeToSelect(option);
		
		actions.add(mergeToSelect);
		return actions;
	}
}
