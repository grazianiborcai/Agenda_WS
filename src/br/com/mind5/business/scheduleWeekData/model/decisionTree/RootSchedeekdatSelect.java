package br.com.mind5.business.scheduleWeekData.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.scheduleWeekData.info.SchedeekdatInfo;
import br.com.mind5.business.scheduleWeekData.model.action.LazySchedeekdatEnforceWeekday;
import br.com.mind5.business.scheduleWeekData.model.action.StdSchedeekdatMergeToSelect;
import br.com.mind5.business.scheduleWeekData.model.checker.SchedeekdatCheckRead;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class RootSchedeekdatSelect extends DeciTreeTemplateWrite<SchedeekdatInfo> {
	
	public RootSchedeekdatSelect(DeciTreeOption<SchedeekdatInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<SchedeekdatInfo> buildCheckerHook(DeciTreeOption<SchedeekdatInfo> option) {
		List<ModelChecker<SchedeekdatInfo>> queue = new ArrayList<>();		
		ModelChecker<SchedeekdatInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;		
		checker = new SchedeekdatCheckRead(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<SchedeekdatInfo>> buildActionsOnPassedHook(DeciTreeOption<SchedeekdatInfo> option) {
		List<ActionStd<SchedeekdatInfo>> actions = new ArrayList<>();
		
		ActionStd<SchedeekdatInfo> mergeToSelect = new StdSchedeekdatMergeToSelect(option);
		ActionLazy<SchedeekdatInfo> enforceWeekday = new LazySchedeekdatEnforceWeekday(option.conn, option.schemaName);
		
		mergeToSelect.addPostAction(enforceWeekday);
		
		actions.add(mergeToSelect);
		return actions;
	}
}
