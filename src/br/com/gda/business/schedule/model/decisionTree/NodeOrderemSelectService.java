package br.com.gda.business.schedule.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.model.action.ActionStd;
import br.com.gda.business.schedule.info.ScheduInfo;
import br.com.gda.business.schedule.model.action.LazyScheduEnforceWeekday;
import br.com.gda.business.schedule.model.action.LazyOrderemMergeEmplis;
import br.com.gda.business.schedule.model.action.LazyOrderemMergeMatore;
import br.com.gda.business.schedule.model.action.LazyOrderemMergeWeekday;
import br.com.gda.business.schedule.model.action.StdOrderemMergeStolis;
import br.com.gda.business.schedule.model.checker.SheduCheckIsService;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.model.decisionTree.DeciTreeWriteTemplate;

public final class NodeOrderemSelectService extends DeciTreeWriteTemplate<ScheduInfo> {
	
	public NodeOrderemSelectService(DeciTreeOption<ScheduInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<ScheduInfo> buildDecisionCheckerHook(DeciTreeOption<ScheduInfo> option) {
		List<ModelChecker<ScheduInfo>> queue = new ArrayList<>();		
		ModelChecker<ScheduInfo> checker;
		
		checker = new SheduCheckIsService();
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<ScheduInfo>> buildActionsOnPassedHook(DeciTreeOption<ScheduInfo> option) {
		List<ActionStd<ScheduInfo>> actions = new ArrayList<>();
		
		ActionStd<ScheduInfo> mergeStolis = new StdOrderemMergeStolis(option);
		ActionLazy<ScheduInfo> mergeEmplis = new LazyOrderemMergeEmplis(option.conn, option.schemaName);
		ActionLazy<ScheduInfo> enforceWeekday = new LazyScheduEnforceWeekday(option.conn, option.schemaName);
		ActionLazy<ScheduInfo> mergeWeekday = new LazyOrderemMergeWeekday(option.conn, option.schemaName);
		ActionLazy<ScheduInfo> mergeMatore = new LazyOrderemMergeMatore(option.conn, option.schemaName);
		
		mergeStolis.addPostAction(mergeEmplis);
		mergeEmplis.addPostAction(enforceWeekday);
		enforceWeekday.addPostAction(mergeWeekday);
		mergeWeekday.addPostAction(mergeMatore);
		
		actions.add(mergeStolis);
		return actions;
	}
}
