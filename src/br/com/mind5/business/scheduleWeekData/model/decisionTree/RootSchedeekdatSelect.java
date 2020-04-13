package br.com.mind5.business.scheduleWeekData.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.scheduleWeekData.info.SchedeekdatInfo;
import br.com.mind5.business.scheduleWeekData.model.action.LazySchedeekdatEnforceWeekday;
import br.com.mind5.business.scheduleWeekData.model.action.LazySchedeekdatMergeMonth;
import br.com.mind5.business.scheduleWeekData.model.action.LazySchedeekdatMergeWeekday;
import br.com.mind5.business.scheduleWeekData.model.action.StdSchedeekdatMergeToSelect;
import br.com.mind5.business.scheduleWeekData.model.checker.SchedeekdatCheckRead;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWriteV1;

public final class RootSchedeekdatSelect extends DeciTreeTemplateWriteV1<SchedeekdatInfo> {
	
	public RootSchedeekdatSelect(DeciTreeOption<SchedeekdatInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<SchedeekdatInfo> buildCheckerHook(DeciTreeOption<SchedeekdatInfo> option) {
		List<ModelCheckerV1<SchedeekdatInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<SchedeekdatInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;		
		checker = new SchedeekdatCheckRead(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<SchedeekdatInfo>> buildActionsOnPassedHook(DeciTreeOption<SchedeekdatInfo> option) {
		List<ActionStdV1<SchedeekdatInfo>> actions = new ArrayList<>();
		
		ActionStdV1<SchedeekdatInfo> mergeToSelect = new StdSchedeekdatMergeToSelect(option);
		ActionLazyV1<SchedeekdatInfo> mergeMonth = new LazySchedeekdatMergeMonth(option.conn, option.schemaName);
		ActionLazyV1<SchedeekdatInfo> enforceWeekday = new LazySchedeekdatEnforceWeekday(option.conn, option.schemaName);
		ActionLazyV1<SchedeekdatInfo> mergeWeekday = new LazySchedeekdatMergeWeekday(option.conn, option.schemaName);
		
		mergeToSelect.addPostAction(mergeMonth);
		mergeMonth.addPostAction(enforceWeekday);
		enforceWeekday.addPostAction(mergeWeekday);
		
		actions.add(mergeToSelect);
		return actions;
	}
}
