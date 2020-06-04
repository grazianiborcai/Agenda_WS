package br.com.mind5.business.calendarWeekYear.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.calendarWeekYear.info.CaleekyInfo;
import br.com.mind5.business.calendarWeekYear.model.action.LazyCaleekyRootSelect;
import br.com.mind5.business.calendarWeekYear.model.action.StdCalateEnforceNext;
import br.com.mind5.business.calendarWeekYear.model.checker.CaleekyCheckRead;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateReadV2;

public final class RootCaleekySelectNext extends DeciTreeTemplateReadV2<CaleekyInfo> {
	
	public RootCaleekySelectNext(DeciTreeOption<CaleekyInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<CaleekyInfo> buildCheckerHook(DeciTreeOption<CaleekyInfo> option) {
		List<ModelCheckerV1<CaleekyInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<CaleekyInfo> checker;
		ModelCheckerOption checkerOption;	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new CaleekyCheckRead(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}

		
	
	@Override protected List<ActionStdV1<CaleekyInfo>> buildActionsOnPassedHook(DeciTreeOption<CaleekyInfo> option) {
		List<ActionStdV1<CaleekyInfo>> actions = new ArrayList<>();
		
		ActionStdV1<CaleekyInfo> enforceNext = new StdCalateEnforceNext(option);
		ActionLazyV1<CaleekyInfo> select = new LazyCaleekyRootSelect(option.conn, option.schemaName);
		
		enforceNext.addPostAction(select);
		
		actions.add(enforceNext);
		return actions;
	}
}
