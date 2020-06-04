package br.com.mind5.business.calendarWeekYear.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.calendarWeekYear.info.CaleekyInfo;
import br.com.mind5.business.calendarWeekYear.model.action.LazyCaleekyMergeNext;
import br.com.mind5.business.calendarWeekYear.model.action.LazyCaleekyRootSelect;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.common.ModelCheckerDummy;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateReadV2;

public final class RootCaleekySelectNext extends DeciTreeTemplateReadV2<CaleekyInfo> {
	
	public RootCaleekySelectNext(DeciTreeOption<CaleekyInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<CaleekyInfo> buildCheckerHook(DeciTreeOption<CaleekyInfo> option) {
		List<ModelCheckerV1<CaleekyInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<CaleekyInfo> checker;

		checker = new ModelCheckerDummy<>();
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}

		
	
	@Override protected List<ActionStdV1<CaleekyInfo>> buildActionsOnPassedHook(DeciTreeOption<CaleekyInfo> option) {
		List<ActionStdV1<CaleekyInfo>> actions = new ArrayList<>();
		
		ActionStdV1<CaleekyInfo> selectBase = new RootCaleekySelect(option).toAction();
		ActionLazyV1<CaleekyInfo> mergeNext = new LazyCaleekyMergeNext(option.conn, option.schemaName);
		ActionLazyV1<CaleekyInfo> selectResult = new LazyCaleekyRootSelect(option.conn, option.schemaName);
		
		selectBase.addPostAction(mergeNext);
		mergeNext.addPostAction(selectResult);
		
		actions.add(selectBase);
		return actions;
	}
}
