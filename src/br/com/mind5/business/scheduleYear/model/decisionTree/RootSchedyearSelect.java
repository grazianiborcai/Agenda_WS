package br.com.mind5.business.scheduleYear.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.scheduleYear.info.SchedyearInfo;
import br.com.mind5.business.scheduleYear.model.action.LazySchedyearMergeStolis;
import br.com.mind5.business.scheduleYear.model.action.StdSchedyearMergeSchedyerat;
import br.com.mind5.business.scheduleYear.model.checker.SchedyearCheckRead;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeWriteTemplate;

public final class RootSchedyearSelect extends DeciTreeWriteTemplate<SchedyearInfo> {
	
	public RootSchedyearSelect(DeciTreeOption<SchedyearInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<SchedyearInfo> buildDecisionCheckerHook(DeciTreeOption<SchedyearInfo> option) {
		List<ModelChecker<SchedyearInfo>> queue = new ArrayList<>();		
		ModelChecker<SchedyearInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new SchedyearCheckRead(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<SchedyearInfo>> buildActionsOnPassedHook(DeciTreeOption<SchedyearInfo> option) {
		List<ActionStd<SchedyearInfo>> actions = new ArrayList<>();
		
		ActionStd<SchedyearInfo> mergeSchedyerat = new StdSchedyearMergeSchedyerat(option);
		ActionLazy<SchedyearInfo> mergeMonth = new LazySchedyearMergeStolis(option.conn, option.schemaName);
		
		mergeSchedyerat.addPostAction(mergeMonth);
		
		actions.add(mergeSchedyerat);
		return actions;
	}
}
