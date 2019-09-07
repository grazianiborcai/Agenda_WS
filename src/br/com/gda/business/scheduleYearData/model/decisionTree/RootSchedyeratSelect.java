package br.com.gda.business.scheduleYearData.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.model.action.ActionStd;
import br.com.gda.business.scheduleYearData.info.SchedyeratInfo;
import br.com.gda.business.scheduleYearData.model.action.StdSchedyeratMergeToSelect;
import br.com.gda.business.scheduleYearData.model.checker.SchedyeratCheckRead;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.model.decisionTree.DeciTreeWriteTemplate;

public final class RootSchedyeratSelect extends DeciTreeWriteTemplate<SchedyeratInfo> {
	
	public RootSchedyeratSelect(DeciTreeOption<SchedyeratInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<SchedyeratInfo> buildDecisionCheckerHook(DeciTreeOption<SchedyeratInfo> option) {
		List<ModelChecker<SchedyeratInfo>> queue = new ArrayList<>();		
		ModelChecker<SchedyeratInfo> checker;	
		
		checker = new SchedyeratCheckRead();
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<SchedyeratInfo>> buildActionsOnPassedHook(DeciTreeOption<SchedyeratInfo> option) {
		List<ActionStd<SchedyeratInfo>> actions = new ArrayList<>();
		
		ActionStd<SchedyeratInfo> mergeToSelect = new StdSchedyeratMergeToSelect(option);
		
		actions.add(mergeToSelect);
		return actions;
	}
}
