package br.com.mind5.business.scheduleYear.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.scheduleYear.info.SchedyearInfo;
import br.com.mind5.business.scheduleYear.model.action.LazySchedyearMergeMontharch;
import br.com.mind5.business.scheduleYear.model.action.LazySchedyearMergeStolis;
import br.com.mind5.business.scheduleYear.model.action.StdSchedyearMergeMontharch;
import br.com.mind5.business.scheduleYear.model.action.StdSchedyearMergeSchedyerat;
import br.com.mind5.business.scheduleYear.model.checker.SchedyearCheckSchedyerat;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWriteV2;

public final class NodeSchedyearSelect extends DeciTreeTemplateWriteV2<SchedyearInfo> {
	
	public NodeSchedyearSelect(DeciTreeOption<SchedyearInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<SchedyearInfo> buildCheckerHook(DeciTreeOption<SchedyearInfo> option) {
		List<ModelCheckerV1<SchedyearInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<SchedyearInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new SchedyearCheckSchedyerat(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<SchedyearInfo>> buildActionsOnPassedHook(DeciTreeOption<SchedyearInfo> option) {
		List<ActionStdV1<SchedyearInfo>> actions = new ArrayList<>();
		
		ActionStdV1<SchedyearInfo> mergeSchedyerat = new StdSchedyearMergeSchedyerat(option);
		ActionLazy<SchedyearInfo> mergeStolis = new LazySchedyearMergeStolis(option.conn, option.schemaName);
		ActionLazy<SchedyearInfo> mergeMontharch = new LazySchedyearMergeMontharch(option.conn, option.schemaName);
		
		mergeSchedyerat.addPostAction(mergeStolis);
		mergeStolis.addPostAction(mergeMontharch);
		
		actions.add(mergeSchedyerat);
		return actions;
	}
	
	
	
	@Override protected List<ActionStdV1<SchedyearInfo>> buildActionsOnFailedHook(DeciTreeOption<SchedyearInfo> option) {
		List<ActionStdV1<SchedyearInfo>> actions = new ArrayList<>();
		
		ActionStdV1<SchedyearInfo> mergeMontharch = new StdSchedyearMergeMontharch(option);
		
		actions.add(mergeMontharch);
		return actions;
	}
}
