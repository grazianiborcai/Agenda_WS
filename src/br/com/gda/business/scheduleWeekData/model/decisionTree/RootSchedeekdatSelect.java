package br.com.gda.business.scheduleWeekData.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStd;
import br.com.gda.business.scheduleWeekData.info.SchedeekdatInfo;
import br.com.gda.business.scheduleWeekData.model.action.LazySchedeekdatEnforceWeekday;
import br.com.gda.business.scheduleWeekData.model.action.LazySchedeekdatMergeMonth;
import br.com.gda.business.scheduleWeekData.model.action.LazySchedeekdatMergeWeekday;
import br.com.gda.business.scheduleWeekData.model.action.StdSchedeekdatMergeToSelect;
import br.com.gda.business.scheduleWeekData.model.checker.SchedeekdatCheckRead;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.model.decisionTree.DeciTreeWriteTemplate;

public final class RootSchedeekdatSelect extends DeciTreeWriteTemplate<SchedeekdatInfo> {
	
	public RootSchedeekdatSelect(DeciTreeOption<SchedeekdatInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<SchedeekdatInfo> buildDecisionCheckerHook(DeciTreeOption<SchedeekdatInfo> option) {
		List<ModelChecker<SchedeekdatInfo>> queue = new ArrayList<>();		
		ModelChecker<SchedeekdatInfo> checker;	
		
		checker = new SchedeekdatCheckRead();
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<SchedeekdatInfo>> buildActionsOnPassedHook(DeciTreeOption<SchedeekdatInfo> option) {
		List<ActionStd<SchedeekdatInfo>> actions = new ArrayList<>();
		
		ActionStd<SchedeekdatInfo> mergeToSelect = new StdSchedeekdatMergeToSelect(option);
		ActionLazy<SchedeekdatInfo> mergeMonth = new LazySchedeekdatMergeMonth(option.conn, option.schemaName);
		ActionLazy<SchedeekdatInfo> enforceWeekday = new LazySchedeekdatEnforceWeekday(option.conn, option.schemaName);
		ActionLazy<SchedeekdatInfo> mergeWeekday = new LazySchedeekdatMergeWeekday(option.conn, option.schemaName);
		
		mergeToSelect.addPostAction(mergeMonth);
		mergeMonth.addPostAction(enforceWeekday);
		enforceWeekday.addPostAction(mergeWeekday);
		
		actions.add(mergeToSelect);
		return actions;
	}
}
