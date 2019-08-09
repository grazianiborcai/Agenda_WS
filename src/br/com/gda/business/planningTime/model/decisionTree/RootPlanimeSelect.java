package br.com.gda.business.planningTime.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.model.action.ActionStd;
import br.com.gda.business.planningTime.info.PlanimeInfo;
import br.com.gda.business.planningTime.model.action.LazyPlanimeMergeEmplis;
import br.com.gda.business.planningTime.model.action.LazyPlanimeMergeMat;
import br.com.gda.business.planningTime.model.action.LazyPlanimeMergeStolis;
import br.com.gda.business.planningTime.model.action.LazyPlanimeMergeWeekday;
import br.com.gda.business.planningTime.model.action.StdPlanimeMergePlanata;
import br.com.gda.business.planningTime.model.checker.PlanimeCheckRead;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.model.decisionTree.DeciTreeReadTemplate;

public class RootPlanimeSelect extends DeciTreeReadTemplate<PlanimeInfo> {
	
	public RootPlanimeSelect(DeciTreeOption<PlanimeInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<PlanimeInfo> buildDecisionCheckerHook(DeciTreeOption<PlanimeInfo> option) {
		List<ModelChecker<PlanimeInfo>> queue = new ArrayList<>();		
		ModelChecker<PlanimeInfo> checker;
		
		checker = new PlanimeCheckRead();
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<PlanimeInfo>> buildActionsOnPassedHook(DeciTreeOption<PlanimeInfo> option) {
		List<ActionStd<PlanimeInfo>> actions = new ArrayList<>();		

		ActionStd<PlanimeInfo> mergePlanata = new StdPlanimeMergePlanata(option);		
		ActionLazy<PlanimeInfo> mergeStolis = new LazyPlanimeMergeStolis(option.conn, option.schemaName);	
		ActionLazy<PlanimeInfo> mergeEmplis = new LazyPlanimeMergeEmplis(option.conn, option.schemaName);
		ActionLazy<PlanimeInfo> mergeMat = new LazyPlanimeMergeMat(option.conn, option.schemaName);			
		ActionLazy<PlanimeInfo> mergeWeekday = new LazyPlanimeMergeWeekday(option.conn, option.schemaName);
		
		mergePlanata.addPostAction(mergeStolis);
		mergeStolis.addPostAction(mergeEmplis);
		mergeEmplis.addPostAction(mergeMat);
		mergeMat.addPostAction(mergeWeekday);
		
		actions.add(mergePlanata);
		return actions;
	}
}
