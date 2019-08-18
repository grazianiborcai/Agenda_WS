package br.com.gda.business.scheduleLine.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.model.action.ActionStd;
import br.com.gda.business.scheduleLine.info.SchedineInfo;
import br.com.gda.business.scheduleLine.model.action.LazySchedineEnforceDay;
import br.com.gda.business.scheduleLine.model.action.LazySchedineEnforceMonth;
import br.com.gda.business.scheduleLine.model.action.LazySchedineEnforceQuarter;
import br.com.gda.business.scheduleLine.model.action.LazySchedineEnforceWeekMonth;
import br.com.gda.business.scheduleLine.model.action.LazySchedineEnforceWeekYear;
import br.com.gda.business.scheduleLine.model.action.LazySchedineEnforceYear;
import br.com.gda.business.scheduleLine.model.action.StdSchedineEnforceWeekday;
import br.com.gda.business.scheduleLine.model.checker.SchedineCheckWrite;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.model.decisionTree.DeciTreeWriteTemplate;

public final class NodeSchedineTime extends DeciTreeWriteTemplate<SchedineInfo> {
	
	public NodeSchedineTime(DeciTreeOption<SchedineInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<SchedineInfo> buildDecisionCheckerHook(DeciTreeOption<SchedineInfo> option) {		
		List<ModelChecker<SchedineInfo>> queue = new ArrayList<>();		
		ModelChecker<SchedineInfo> checker;	
		
		checker = new SchedineCheckWrite();
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<SchedineInfo>> buildActionsOnPassedHook(DeciTreeOption<SchedineInfo> option) {
		List<ActionStd<SchedineInfo>> actions = new ArrayList<>();		
		
		ActionStd<SchedineInfo> enforceWeekday = new StdSchedineEnforceWeekday(option);
		ActionLazy<SchedineInfo> enforceDay = new LazySchedineEnforceDay(option.conn, option.schemaName);
		ActionLazy<SchedineInfo> enforceMonth = new LazySchedineEnforceMonth(option.conn, option.schemaName);
		ActionLazy<SchedineInfo> enforceYear = new LazySchedineEnforceYear(option.conn, option.schemaName);
		ActionLazy<SchedineInfo> enforceWeekMonth = new LazySchedineEnforceWeekMonth(option.conn, option.schemaName);
		ActionLazy<SchedineInfo> enforceWeekYear = new LazySchedineEnforceWeekYear(option.conn, option.schemaName);
		ActionLazy<SchedineInfo> enforceQuarter = new LazySchedineEnforceQuarter(option.conn, option.schemaName);
		

		enforceWeekday.addPostAction(enforceDay);
		enforceDay.addPostAction(enforceMonth);
		enforceMonth.addPostAction(enforceYear);
		enforceYear.addPostAction(enforceWeekMonth);
		enforceWeekMonth.addPostAction(enforceWeekYear);
		enforceWeekYear.addPostAction(enforceQuarter);
		
		actions.add(enforceWeekday);
		return actions;
	}
}
