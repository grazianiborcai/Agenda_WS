package br.com.mind5.business.planningTime.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.planningTime.info.PlanimeInfo;
import br.com.mind5.business.planningTime.model.action.LazyPlanimeMergeEmplis;
import br.com.mind5.business.planningTime.model.action.LazyPlanimeMergeMatlis;
import br.com.mind5.business.planningTime.model.action.LazyPlanimeMergeStolis;
import br.com.mind5.business.planningTime.model.action.LazyPlanimeMergeWeekday;
import br.com.mind5.business.planningTime.model.action.StdPlanimeMergePlanata;
import br.com.mind5.business.planningTime.model.checker.PlanimeCheckRead;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeReadTemplate;

public class RootPlanimeSelect extends DeciTreeReadTemplate<PlanimeInfo> {
	
	public RootPlanimeSelect(DeciTreeOption<PlanimeInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<PlanimeInfo> buildDecisionCheckerHook(DeciTreeOption<PlanimeInfo> option) {
		List<ModelChecker<PlanimeInfo>> queue = new ArrayList<>();		
		ModelChecker<PlanimeInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new PlanimeCheckRead(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<PlanimeInfo>> buildActionsOnPassedHook(DeciTreeOption<PlanimeInfo> option) {
		List<ActionStd<PlanimeInfo>> actions = new ArrayList<>();		

		ActionStd<PlanimeInfo> mergePlanata = new StdPlanimeMergePlanata(option);		
		ActionLazy<PlanimeInfo> mergeStolis = new LazyPlanimeMergeStolis(option.conn, option.schemaName);	
		ActionLazy<PlanimeInfo> mergeEmplis = new LazyPlanimeMergeEmplis(option.conn, option.schemaName);
		ActionLazy<PlanimeInfo> mergeMatlis = new LazyPlanimeMergeMatlis(option.conn, option.schemaName);			
		ActionLazy<PlanimeInfo> mergeWeekday = new LazyPlanimeMergeWeekday(option.conn, option.schemaName);
		
		mergePlanata.addPostAction(mergeStolis);
		mergeStolis.addPostAction(mergeEmplis);
		mergeEmplis.addPostAction(mergeMatlis);
		mergeMatlis.addPostAction(mergeWeekday);
		
		actions.add(mergePlanata);
		return actions;
	}
}
