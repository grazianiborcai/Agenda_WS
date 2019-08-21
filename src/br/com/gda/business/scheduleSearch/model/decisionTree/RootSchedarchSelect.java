package br.com.gda.business.scheduleSearch.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.scheduleSearch.info.SchedarchInfo;
import br.com.gda.business.scheduleSearch.model.action.StdSchedarchMergeToSelect;
import br.com.gda.business.scheduleSearch.model.checker.SchedarchCheckLangu;
import br.com.gda.business.scheduleSearch.model.checker.SchedarchCheckRead;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.model.decisionTree.DeciTreeWriteTemplate;

public final class RootSchedarchSelect extends DeciTreeWriteTemplate<SchedarchInfo> {
	
	public RootSchedarchSelect(DeciTreeOption<SchedarchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<SchedarchInfo> buildDecisionCheckerHook(DeciTreeOption<SchedarchInfo> option) {
		final boolean EXIST_ON_DB = true;
		
		List<ModelChecker<SchedarchInfo>> queue = new ArrayList<>();		
		ModelChecker<SchedarchInfo> checker;
		ModelCheckerOption checkerOption;
		
		checker = new SchedarchCheckRead();
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;	
		checker = new SchedarchCheckLangu(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<SchedarchInfo>> buildActionsOnPassedHook(DeciTreeOption<SchedarchInfo> option) {
		List<ActionStd<SchedarchInfo>> actions = new ArrayList<>();
		
		ActionStd<SchedarchInfo> select = new StdSchedarchMergeToSelect(option);
		
		actions.add(select);
		return actions;
	}
}
