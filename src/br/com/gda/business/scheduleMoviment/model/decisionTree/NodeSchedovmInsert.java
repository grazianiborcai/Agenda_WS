package br.com.gda.business.scheduleMoviment.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.model.action.ActionStd;
import br.com.gda.business.scheduleMoviment.info.SchedovmInfo;
import br.com.gda.business.scheduleMoviment.model.action.StdSchedovmInsert;
import br.com.gda.business.scheduleMoviment.model.action.StdSchedovmSuccess;
import br.com.gda.business.scheduleMoviment.model.checker.SchedovmCheckHasCounter;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.model.decisionTree.DeciTreeWriteTemplate;

public final class NodeSchedovmInsert extends DeciTreeWriteTemplate<SchedovmInfo> {
	
	public NodeSchedovmInsert(DeciTreeOption<SchedovmInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<SchedovmInfo> buildDecisionCheckerHook(DeciTreeOption<SchedovmInfo> option) {
		List<ModelChecker<SchedovmInfo>> queue = new ArrayList<>();		
		ModelChecker<SchedovmInfo> checker;	
		
		checker = new SchedovmCheckHasCounter();
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<SchedovmInfo>> buildActionsOnPassedHook(DeciTreeOption<SchedovmInfo> option) {
		List<ActionStd<SchedovmInfo>> actions = new ArrayList<>();
		
		ActionStd<SchedovmInfo> insert = new StdSchedovmInsert(option);
		
		actions.add(insert);
		return actions;
	}
	
	
	
	@Override protected List<ActionStd<SchedovmInfo>> buildActionsOnFailedHook(DeciTreeOption<SchedovmInfo> option) {
		List<ActionStd<SchedovmInfo>> actions = new ArrayList<>();
		
		ActionStd<SchedovmInfo> success = new StdSchedovmSuccess(option);
		
		actions.add(success);
		return actions;
	}
}
