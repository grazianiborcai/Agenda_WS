package br.com.mind5.business.scheduleYearData.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.scheduleYearData.info.SchedyeratInfo;
import br.com.mind5.business.scheduleYearData.model.action.LazySchedyeratMergeMonth;
import br.com.mind5.business.scheduleYearData.model.action.StdSchedyeratMergeToSelect;
import br.com.mind5.business.scheduleYearData.model.checker.SchedyeratCheckRead;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWriteV1;

public final class RootSchedyeratSelect extends DeciTreeTemplateWriteV1<SchedyeratInfo> {
	
	public RootSchedyeratSelect(DeciTreeOption<SchedyeratInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<SchedyeratInfo> buildCheckerHook(DeciTreeOption<SchedyeratInfo> option) {
		List<ModelCheckerV1<SchedyeratInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<SchedyeratInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new SchedyeratCheckRead(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<SchedyeratInfo>> buildActionsOnPassedHook(DeciTreeOption<SchedyeratInfo> option) {
		List<ActionStdV1<SchedyeratInfo>> actions = new ArrayList<>();
		
		ActionStdV1<SchedyeratInfo> mergeToSelect = new StdSchedyeratMergeToSelect(option);
		ActionLazyV1<SchedyeratInfo> mergeMonth = new LazySchedyeratMergeMonth(option.conn, option.schemaName);
		
		mergeToSelect.addPostAction(mergeMonth);
		
		actions.add(mergeToSelect);
		return actions;
	}
}
