package br.com.gda.business.scheduleList.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.scheduleList.info.SchedistInfo;
import br.com.gda.business.scheduleList.model.action.StdSchedistMergeToSelect;
import br.com.gda.business.scheduleList.model.checker.SchedistCheckLangu;
import br.com.gda.business.scheduleList.model.checker.SchedistCheckRead;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.model.decisionTree.DeciTreeWriteTemplate;

public final class RootSchedistSelect extends DeciTreeWriteTemplate<SchedistInfo> {
	
	public RootSchedistSelect(DeciTreeOption<SchedistInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<SchedistInfo> buildDecisionCheckerHook(DeciTreeOption<SchedistInfo> option) {
		final boolean EXIST_ON_DB = true;
		
		List<ModelChecker<SchedistInfo>> queue = new ArrayList<>();		
		ModelChecker<SchedistInfo> checker;
		ModelCheckerOption checkerOption;
		
		checker = new SchedistCheckRead();
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;	
		checker = new SchedistCheckLangu(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<SchedistInfo>> buildActionsOnPassedHook(DeciTreeOption<SchedistInfo> option) {
		List<ActionStd<SchedistInfo>> actions = new ArrayList<>();
		
		ActionStd<SchedistInfo> select = new StdSchedistMergeToSelect(option);
		
		actions.add(select);
		return actions;
	}
}
