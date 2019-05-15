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
import br.com.gda.model.decisionTree.DeciChoice;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTree;
import br.com.gda.model.decisionTree.DeciTreeHelper;
import br.com.gda.model.decisionTree.DeciTreeHelperOption;
import br.com.gda.model.decisionTree.DeciTreeOption;

public class RootPlanimeSelect implements DeciTree<PlanimeInfo> {
	private DeciTree<PlanimeInfo> tree;
	
	
	public RootPlanimeSelect(DeciTreeOption<PlanimeInfo> option) {
		DeciTreeHelperOption<PlanimeInfo> helperOption = new DeciTreeHelperOption<>();
		
		helperOption.visitorChecker = buildDecisionChecker();
		helperOption.recordInfos = option.recordInfos;
		helperOption.conn = option.conn;
		helperOption.actionsOnPassed = buildActionsOnPassed(option);
		
		tree = new DeciTreeHelper<>(helperOption);
	}
	
	
	
	private ModelChecker<PlanimeInfo> buildDecisionChecker() {
		List<ModelChecker<PlanimeInfo>> queue = new ArrayList<>();		
		ModelChecker<PlanimeInfo> checker;
		
		checker = new PlanimeCheckRead();
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	private List<ActionStd<PlanimeInfo>> buildActionsOnPassed(DeciTreeOption<PlanimeInfo> option) {
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
	
	
	
	@Override public void makeDecision() {
		tree.makeDecision();
	}
		

	
	@Override public DeciChoice getDecisionMade() {
		return tree.getDecisionMade();
	}
	
	
	
	@Override public DeciResult<PlanimeInfo> getDecisionResult() {
		return tree.getDecisionResult();
	}
	
	
	
	@Override public ActionStd<PlanimeInfo> toAction() {
		return tree.toAction();
	}
}
