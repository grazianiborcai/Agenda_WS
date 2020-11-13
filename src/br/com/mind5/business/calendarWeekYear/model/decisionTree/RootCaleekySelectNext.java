package br.com.mind5.business.calendarWeekYear.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.calendarWeekYear.info.CaleekyInfo;
import br.com.mind5.business.calendarWeekYear.model.action.LazyCaleekyMergeNext;
import br.com.mind5.business.calendarWeekYear.model.action.LazyCaleekyRootSelect;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStdV2;
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

		
	
	@Override protected List<ActionStdV2<CaleekyInfo>> buildActionsOnPassedHook(DeciTreeOption<CaleekyInfo> option) {
		List<ActionStdV2<CaleekyInfo>> actions = new ArrayList<>();
		
		ActionStdV2<CaleekyInfo> selectBase = new RootCaleekySelect(option).toAction();
		ActionLazy<CaleekyInfo> mergeNext = new LazyCaleekyMergeNext(option.conn, option.schemaName);
		ActionLazy<CaleekyInfo> selectResult = new LazyCaleekyRootSelect(option.conn, option.schemaName);
		
		selectBase.addPostAction(mergeNext);
		mergeNext.addPostAction(selectResult);
		
		actions.add(selectBase);
		return actions;
	}
}
