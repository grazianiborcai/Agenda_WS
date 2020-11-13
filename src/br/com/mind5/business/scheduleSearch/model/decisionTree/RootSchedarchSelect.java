package br.com.mind5.business.scheduleSearch.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.scheduleSearch.info.SchedarchInfo;
import br.com.mind5.business.scheduleSearch.model.action.StdSchedarchMergeToSelect;
import br.com.mind5.business.scheduleSearch.model.checker.SchedarchCheckLangu;
import br.com.mind5.business.scheduleSearch.model.checker.SchedarchCheckOwner;
import br.com.mind5.business.scheduleSearch.model.checker.SchedarchCheckRead;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class RootSchedarchSelect extends DeciTreeTemplateWrite<SchedarchInfo> {
	
	public RootSchedarchSelect(DeciTreeOption<SchedarchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<SchedarchInfo> buildCheckerHook(DeciTreeOption<SchedarchInfo> option) {
		List<ModelChecker<SchedarchInfo>> queue = new ArrayList<>();		
		ModelChecker<SchedarchInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new SchedarchCheckRead(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new SchedarchCheckLangu(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new SchedarchCheckOwner(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<SchedarchInfo>> buildActionsOnPassedHook(DeciTreeOption<SchedarchInfo> option) {
		List<ActionStd<SchedarchInfo>> actions = new ArrayList<>();
		
		ActionStd<SchedarchInfo> select = new StdSchedarchMergeToSelect(option);
		
		actions.add(select);
		return actions;
	}
}
