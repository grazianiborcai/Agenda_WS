package br.com.gda.business.planingData.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.model.action.ActionStd;
import br.com.gda.business.planingData.info.PlanataInfo;
import br.com.gda.business.planingData.model.action.LazyPlanataMergeToSelect;
import br.com.gda.business.planingData.model.action.StdPlanataEnforceWeekday;
import br.com.gda.business.planingData.model.checker.PlanataCheckDate;
import br.com.gda.business.planingData.model.checker.PlanataCheckRead;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciChoice;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTree;
import br.com.gda.model.decisionTree.DeciTreeHelper;
import br.com.gda.model.decisionTree.DeciTreeHelperOption;
import br.com.gda.model.decisionTree.DeciTreeOption;

public class RootPlanataSelect implements DeciTree<PlanataInfo> {
	private DeciTree<PlanataInfo> tree;
	
	
	public RootPlanataSelect(DeciTreeOption<PlanataInfo> option) {
		DeciTreeHelperOption<PlanataInfo> helperOption = new DeciTreeHelperOption<>();
		
		helperOption.visitorChecker = buildDecisionChecker();
		helperOption.recordInfos = option.recordInfos;
		helperOption.conn = option.conn;
		helperOption.actionsOnPassed = buildActionsOnPassed(option);
		
		tree = new DeciTreeHelper<>(helperOption);
	}
	
	
	
	private ModelChecker<PlanataInfo> buildDecisionChecker() {
		List<ModelChecker<PlanataInfo>> queue = new ArrayList<>();		
		ModelChecker<PlanataInfo> checker;
		
		checker = new PlanataCheckRead();
		queue.add(checker);
		
		checker = new PlanataCheckDate();
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	private List<ActionStd<PlanataInfo>> buildActionsOnPassed(DeciTreeOption<PlanataInfo> option) {
		List<ActionStd<PlanataInfo>> actions = new ArrayList<>();		
		
		ActionStd<PlanataInfo> enforceWeekday = new StdPlanataEnforceWeekday(option);		
		ActionLazy<PlanataInfo> select = new LazyPlanataMergeToSelect(option.conn, option.schemaName);		
//		ActionLazy<PlanataInfo> mergeSWT = new LazyPlanMergeSWT(option.conn, option.schemaName);
//		ActionLazy<PlanataInfo> mergeEWT = new LazyPlanMergeEWT(option.conn, option.schemaName);
//		ActionLazy<PlanataInfo> mergeEmp = new LazyPlanMergeEmp(option.conn, option.schemaName);
//		ActionLazy<PlanataInfo> mergeME = new LazyPlanMergeME(option.conn, option.schemaName);
//		ActionLazy<PlanataInfo> mergeMat = new LazyPlanMergeMat(option.conn, option.schemaName);			
//		ActionLazy<PlanataInfo> pruneSLD = new LazyPlanPruneSLD(option.conn, option.schemaName);		
//		ActionLazy<PlanataInfo> pruneELD = new LazyPlanPruneELD(option.conn, option.schemaName);			
//		ActionLazy<PlanataInfo> mergeWeekday = new LazyPlanMergeWeekday(option.conn, option.schemaName);
//		ActionLazy<PlanataInfo> pruneAge = new LazyPlanPruneAge(option.conn, option.schemaName);
//		ActionLazy<PlanataInfo> pruneReserve = new LazyPlanPruneReserve(option.conn, option.schemaName);
		
		enforceWeekday.addPostAction(select);
	/*	mergeStore.addPostAction(mergeSWT);
		mergeSWT.addPostAction(mergeEWT);
		mergeEWT.addPostAction(mergeEmp);
		mergeEmp.addPostAction(mergeME);
		mergeME.addPostAction(mergeMat);
		mergeMat.addPostAction(pruneSLD);
		pruneSLD.addPostAction(pruneELD);
		pruneELD.addPostAction(mergeWeekday);
		mergeWeekday.addPostAction(pruneAge);
		pruneAge.addPostAction(pruneReserve); **/
		
		actions.add(enforceWeekday);
		return actions;
	}
	
	
	
	@Override public void makeDecision() {
		tree.makeDecision();
	}
		

	
	@Override public DeciChoice getDecisionMade() {
		return tree.getDecisionMade();
	}
	
	
	
	@Override public DeciResult<PlanataInfo> getDecisionResult() {
		return tree.getDecisionResult();
	}
	
	
	
	@Override public ActionStd<PlanataInfo> toAction() {
		return tree.toAction();
	}
}
