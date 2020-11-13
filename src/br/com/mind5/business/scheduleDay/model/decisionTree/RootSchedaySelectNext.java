package br.com.mind5.business.scheduleDay.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.scheduleDay.info.SchedayInfo;
import br.com.mind5.business.scheduleDay.model.action.LazySchedayRootSelect;
import br.com.mind5.business.scheduleDay.model.action.StdSchedayMergeNext;
import br.com.mind5.business.scheduleDay.model.checker.SchedayCheckRead;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWriteV2;

public final class RootSchedaySelectNext extends DeciTreeTemplateWriteV2<SchedayInfo> {
	
	public RootSchedaySelectNext(DeciTreeOption<SchedayInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<SchedayInfo> buildCheckerHook(DeciTreeOption<SchedayInfo> option) {
		List<ModelCheckerV1<SchedayInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<SchedayInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new SchedayCheckRead(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<SchedayInfo>> buildActionsOnPassedHook(DeciTreeOption<SchedayInfo> option) {
		List<ActionStdV1<SchedayInfo>> actions = new ArrayList<>();
		
		ActionStdV1<SchedayInfo> mergeNext = new StdSchedayMergeNext(option);
		ActionLazy<SchedayInfo> select = new LazySchedayRootSelect(option.conn, option.schemaName);
		
		mergeNext.addPostAction(select);
		
		actions.add(mergeNext);
		return actions;
	}
}
