package br.com.gda.business.scheduleLine.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.model.action.ActionStd;
import br.com.gda.business.scheduleLine.info.SchedineInfo;
import br.com.gda.business.scheduleLine.model.action.LazyOrderemMergeEmplis;
import br.com.gda.business.scheduleLine.model.action.LazyOrderemMergeMatore;
import br.com.gda.business.scheduleLine.model.action.LazyOrderemMergeWeekday;
import br.com.gda.business.scheduleLine.model.action.LazySchedineEnforceWeekday;
import br.com.gda.business.scheduleLine.model.action.StdOrderemMergeStolis;
import br.com.gda.business.scheduleLine.model.checker.ShedineCheckIsService;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.model.decisionTree.DeciTreeWriteTemplate;

public final class NodeOrderemSelectService extends DeciTreeWriteTemplate<SchedineInfo> {
	
	public NodeOrderemSelectService(DeciTreeOption<SchedineInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<SchedineInfo> buildDecisionCheckerHook(DeciTreeOption<SchedineInfo> option) {
		List<ModelChecker<SchedineInfo>> queue = new ArrayList<>();		
		ModelChecker<SchedineInfo> checker;
		
		checker = new ShedineCheckIsService();
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<SchedineInfo>> buildActionsOnPassedHook(DeciTreeOption<SchedineInfo> option) {
		List<ActionStd<SchedineInfo>> actions = new ArrayList<>();
		
		ActionStd<SchedineInfo> mergeStolis = new StdOrderemMergeStolis(option);
		ActionLazy<SchedineInfo> mergeEmplis = new LazyOrderemMergeEmplis(option.conn, option.schemaName);
		ActionLazy<SchedineInfo> enforceWeekday = new LazySchedineEnforceWeekday(option.conn, option.schemaName);
		ActionLazy<SchedineInfo> mergeWeekday = new LazyOrderemMergeWeekday(option.conn, option.schemaName);
		ActionLazy<SchedineInfo> mergeMatore = new LazyOrderemMergeMatore(option.conn, option.schemaName);
		
		mergeStolis.addPostAction(mergeEmplis);
		mergeEmplis.addPostAction(enforceWeekday);
		enforceWeekday.addPostAction(mergeWeekday);
		mergeWeekday.addPostAction(mergeMatore);
		
		actions.add(mergeStolis);
		return actions;
	}
}
