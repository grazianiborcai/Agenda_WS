package br.com.mind5.business.calendarDateSearch.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.calendarDateSearch.info.CalatarchInfo;
import br.com.mind5.business.calendarDateSearch.model.action.StdCalatarchMergeToSelect;
import br.com.mind5.business.calendarDateSearch.model.checker.CalatarchCheckRead;
import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateReadV2;

public final class RootCalatarchSelect extends DeciTreeTemplateReadV2<CalatarchInfo> {
	
	public RootCalatarchSelect(DeciTreeOption<CalatarchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<CalatarchInfo> buildCheckerHook(DeciTreeOption<CalatarchInfo> option) {
		List<ModelCheckerV1<CalatarchInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<CalatarchInfo> checker;
		ModelCheckerOption checkerOption;	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new CalatarchCheckRead(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}

		
	
	@Override protected List<ActionStdV2<CalatarchInfo>> buildActionsOnPassedHook(DeciTreeOption<CalatarchInfo> option) {
		List<ActionStdV2<CalatarchInfo>> actions = new ArrayList<>();
		
		ActionStdV2<CalatarchInfo> mergeToSelect = new StdCalatarchMergeToSelect(option);
		
		actions.add(mergeToSelect);
		return actions;
	}
}
