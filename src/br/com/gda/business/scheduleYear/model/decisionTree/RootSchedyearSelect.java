package br.com.gda.business.scheduleYear.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStd;
import br.com.gda.business.scheduleYear.info.SchedyearInfo;
import br.com.gda.business.scheduleYear.model.action.LazySchedyearMergeStolis;
import br.com.gda.business.scheduleYear.model.action.StdSchedyearMergeSchedyerat;
import br.com.gda.business.scheduleYear.model.checker.SchedyearCheckRead;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.model.decisionTree.DeciTreeWriteTemplate;

public final class RootSchedyearSelect extends DeciTreeWriteTemplate<SchedyearInfo> {
	
	public RootSchedyearSelect(DeciTreeOption<SchedyearInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<SchedyearInfo> buildDecisionCheckerHook(DeciTreeOption<SchedyearInfo> option) {
		List<ModelChecker<SchedyearInfo>> queue = new ArrayList<>();		
		ModelChecker<SchedyearInfo> checker;	
		
		checker = new SchedyearCheckRead();
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
