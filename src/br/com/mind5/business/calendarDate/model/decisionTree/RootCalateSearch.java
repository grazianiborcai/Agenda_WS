package br.com.mind5.business.calendarDate.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.calendarDate.info.CalateInfo;
import br.com.mind5.business.calendarDate.model.action.LazyCalateRootSelect;
import br.com.mind5.business.calendarDate.model.action.StdCalateMergeCalatarch;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.common.ModelCheckerDummy;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateReadV2;

public final class RootCalateSearch extends DeciTreeTemplateReadV2<CalateInfo> {
	
	public RootCalateSearch(DeciTreeOption<CalateInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<CalateInfo> buildCheckerHook(DeciTreeOption<CalateInfo> option) {
		List<ModelCheckerV1<CalateInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<CalateInfo> checker;

		checker = new ModelCheckerDummy<>();
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}

		
	
	@Override protected List<ActionStdV1<CalateInfo>> buildActionsOnPassedHook(DeciTreeOption<CalateInfo> option) {
		List<ActionStdV1<CalateInfo>> actions = new ArrayList<>();
		
		ActionStdV1<CalateInfo> mergeCalatarch = new StdCalateMergeCalatarch(option);
		ActionLazyV1<CalateInfo> select = new LazyCalateRootSelect(option.conn, option.schemaName);
		
		mergeCalatarch.addPostAction(select);
		
		actions.add(mergeCalatarch);
		return actions;
	}
}
