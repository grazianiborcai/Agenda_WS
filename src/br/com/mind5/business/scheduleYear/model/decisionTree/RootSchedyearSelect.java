package br.com.mind5.business.scheduleYear.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.scheduleYear.info.SchedyearInfo;
import br.com.mind5.business.scheduleYear.model.action.LazySchedyearMergeStolis;
import br.com.mind5.business.scheduleYear.model.action.StdSchedyearMergeSchedyerat;
import br.com.mind5.business.scheduleYear.model.checker.SchedyearCheckRead;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeWriteTemplate;

public final class RootSchedyearSelect extends DeciTreeWriteTemplate<SchedyearInfo> {
	
	public RootSchedyearSelect(DeciTreeOption<SchedyearInfo> option) {
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
		checker = new SchedyearCheckRead(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<SchedyearInfo>> buildActionsOnPassedHook(DeciTreeOption<SchedyearInfo> option) {
		List<ActionStdV1<SchedyearInfo>> actions = new ArrayList<>();
		
		ActionStdV1<SchedyearInfo> mergeSchedyerat = new StdSchedyearMergeSchedyerat(option);
		ActionLazyV1<SchedyearInfo> mergeMonth = new LazySchedyearMergeStolis(option.conn, option.schemaName);
		
		mergeSchedyerat.addPostAction(mergeMonth);
		
		actions.add(mergeSchedyerat);
		return actions;
	}
}
