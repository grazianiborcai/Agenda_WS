package br.com.mind5.business.scheduleLine.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.scheduleLine.info.SchedineInfo;
import br.com.mind5.business.scheduleLine.model.action.LazySchedineEnforceDay;
import br.com.mind5.business.scheduleLine.model.action.LazySchedineEnforceMonth;
import br.com.mind5.business.scheduleLine.model.action.LazySchedineEnforceQuarter;
import br.com.mind5.business.scheduleLine.model.action.LazySchedineEnforceWeekMonth;
import br.com.mind5.business.scheduleLine.model.action.LazySchedineEnforceWeekYear;
import br.com.mind5.business.scheduleLine.model.action.LazySchedineEnforceYear;
import br.com.mind5.business.scheduleLine.model.action.StdSchedineEnforceWeekday;
import br.com.mind5.business.scheduleLine.model.checker.SchedineCheckDummy;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeWriteTemplate;

public final class NodeSchedineTime extends DeciTreeWriteTemplate<SchedineInfo> {
	
	public NodeSchedineTime(DeciTreeOption<SchedineInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<SchedineInfo> buildDecisionCheckerHook(DeciTreeOption<SchedineInfo> option) {		
		List<ModelChecker<SchedineInfo>> queue = new ArrayList<>();		
		ModelChecker<SchedineInfo> checker;	

		checker = new SchedineCheckDummy();
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<SchedineInfo>> buildActionsOnPassedHook(DeciTreeOption<SchedineInfo> option) {
		List<ActionStdV1<SchedineInfo>> actions = new ArrayList<>();		
		
		ActionStdV1<SchedineInfo> enforceWeekday = new StdSchedineEnforceWeekday(option);
		ActionLazyV1<SchedineInfo> enforceDay = new LazySchedineEnforceDay(option.conn, option.schemaName);
		ActionLazyV1<SchedineInfo> enforceMonth = new LazySchedineEnforceMonth(option.conn, option.schemaName);
		ActionLazyV1<SchedineInfo> enforceYear = new LazySchedineEnforceYear(option.conn, option.schemaName);
		ActionLazyV1<SchedineInfo> enforceWeekMonth = new LazySchedineEnforceWeekMonth(option.conn, option.schemaName);
		ActionLazyV1<SchedineInfo> enforceWeekYear = new LazySchedineEnforceWeekYear(option.conn, option.schemaName);
		ActionLazyV1<SchedineInfo> enforceQuarter = new LazySchedineEnforceQuarter(option.conn, option.schemaName);
		

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
