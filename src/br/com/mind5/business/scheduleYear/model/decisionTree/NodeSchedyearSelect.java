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
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class NodeSchedyearSelect extends DeciTreeTemplateWrite<SchedyearInfo> {
	
	public NodeSchedyearSelect(DeciTreeOption<SchedyearInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<SchedyearInfo> buildCheckerHook(DeciTreeOption<SchedyearInfo> option) {
		List<ModelChecker<SchedyearInfo>> queue = new ArrayList<>();		
		ModelChecker<SchedyearInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new SchedyearCheckSchedyerat(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<SchedyearInfo>> buildActionsOnPassedHook(DeciTreeOption<SchedyearInfo> option) {
		List<ActionStd<SchedyearInfo>> actions = new ArrayList<>();
		
		ActionStd<SchedyearInfo> mergeSchedyerat = new StdSchedyearMergeSchedyerat(option);
		ActionLazy<SchedyearInfo> mergeStolis = new LazySchedyearMergeStolis(option.conn, option.schemaName);
		ActionLazy<SchedyearInfo> mergeMontharch = new LazySchedyearMergeMontharch(option.conn, option.schemaName);
		
		mergeSchedyerat.addPostAction(mergeStolis);
		mergeStolis.addPostAction(mergeMontharch);
		
		actions.add(mergeSchedyerat);
		return actions;
	}
	
	
	
	@Override protected List<ActionStd<SchedyearInfo>> buildActionsOnFailedHook(DeciTreeOption<SchedyearInfo> option) {
		List<ActionStd<SchedyearInfo>> actions = new ArrayList<>();
		
		ActionStd<SchedyearInfo> mergeMontharch = new StdSchedyearMergeMontharch(option);
		
		actions.add(mergeMontharch);
		return actions;
	}
}
