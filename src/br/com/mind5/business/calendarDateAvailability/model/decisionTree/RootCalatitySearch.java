package br.com.mind5.business.calendarDateAvailability.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.calendarDateAvailability.info.CalatityInfo;
import br.com.mind5.business.calendarDateAvailability.model.action.StdCalatityMergeCalate;
import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.common.ModelCheckerDummy;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateReadV2;

public final class RootCalatitySearch extends DeciTreeTemplateReadV2<CalatityInfo> {
	
	public RootCalatitySearch(DeciTreeOption<CalatityInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<CalatityInfo> buildCheckerHook(DeciTreeOption<CalatityInfo> option) {
		List<ModelCheckerV1<CalatityInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<CalatityInfo> checker;

		checker = new ModelCheckerDummy<>();
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}

		
	
	@Override protected List<ActionStdV2<CalatityInfo>> buildActionsOnPassedHook(DeciTreeOption<CalatityInfo> option) {
		List<ActionStdV2<CalatityInfo>> actions = new ArrayList<>();
		
		ActionStdV2<CalatityInfo> mergeCalate = new StdCalatityMergeCalate(option);
		
		actions.add(mergeCalate);
		return actions;
	}
}
