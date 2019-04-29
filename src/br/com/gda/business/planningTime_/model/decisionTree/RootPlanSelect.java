package br.com.gda.business.planningTime_.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.model.action.ActionStd;
import br.com.gda.business.planningTime_.info.PlanInfo;
import br.com.gda.business.planningTime_.model.action.LazyPlanMergeEWT;
import br.com.gda.business.planningTime_.model.action.LazyPlanMergeEmp;
import br.com.gda.business.planningTime_.model.action.LazyPlanMergeME;
import br.com.gda.business.planningTime_.model.action.LazyPlanMergeMat;
import br.com.gda.business.planningTime_.model.action.LazyPlanMergeSWT;
import br.com.gda.business.planningTime_.model.action.LazyPlanMergeStore;
import br.com.gda.business.planningTime_.model.action.LazyPlanMergeWeekday;
import br.com.gda.business.planningTime_.model.action.LazyPlanPruneAge;
import br.com.gda.business.planningTime_.model.action.LazyPlanPruneELD;
import br.com.gda.business.planningTime_.model.action.LazyPlanPruneReserve;
import br.com.gda.business.planningTime_.model.action.LazyPlanPruneSLD;
import br.com.gda.business.planningTime_.model.action.StdPlanEnforceCodWeekday;
import br.com.gda.business.planningTime_.model.checker.PlanCheckDate;
import br.com.gda.business.planningTime_.model.checker.PlanCheckRead;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciChoice;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTree;
import br.com.gda.model.decisionTree.DeciTreeHelper;
import br.com.gda.model.decisionTree.DeciTreeHelperOption;
import br.com.gda.model.decisionTree.DeciTreeOption;

public class RootPlanSelect implements DeciTree<PlanInfo> {
	private DeciTree<PlanInfo> tree;
	
	
	public RootPlanSelect(DeciTreeOption<PlanInfo> option) {
		DeciTreeHelperOption<PlanInfo> helperOption = new DeciTreeHelperOption<>();
		
		helperOption.visitorChecker = buildDecisionChecker();
		helperOption.recordInfos = option.recordInfos;
		helperOption.conn = option.conn;
		helperOption.actionsOnPassed = buildActionsOnPassed(option);
		
		tree = new DeciTreeHelper<>(helperOption);
	}
	
	
	
	private ModelChecker<PlanInfo> buildDecisionChecker() {
		List<ModelChecker<PlanInfo>> queue = new ArrayList<>();		
		ModelChecker<PlanInfo> checker;
		
		checker = new PlanCheckRead();
		queue.add(checker);
		
		checker = new PlanCheckDate();
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	private List<ActionStd<PlanInfo>> buildActionsOnPassed(DeciTreeOption<PlanInfo> option) {
		List<ActionStd<PlanInfo>> actions = new ArrayList<>();		
		
		ActionStd<PlanInfo> enforceCodWeekday = new StdPlanEnforceCodWeekday(option);		
		ActionLazy<PlanInfo> mergeStore = new LazyPlanMergeStore(option.conn, option.schemaName);		
		ActionLazy<PlanInfo> mergeSWT = new LazyPlanMergeSWT(option.conn, option.schemaName);
		ActionLazy<PlanInfo> mergeEWT = new LazyPlanMergeEWT(option.conn, option.schemaName);
		ActionLazy<PlanInfo> mergeEmp = new LazyPlanMergeEmp(option.conn, option.schemaName);
		ActionLazy<PlanInfo> mergeME = new LazyPlanMergeME(option.conn, option.schemaName);
		ActionLazy<PlanInfo> mergeMat = new LazyPlanMergeMat(option.conn, option.schemaName);			
		ActionLazy<PlanInfo> pruneSLD = new LazyPlanPruneSLD(option.conn, option.schemaName);		
		ActionLazy<PlanInfo> pruneELD = new LazyPlanPruneELD(option.conn, option.schemaName);			
		ActionLazy<PlanInfo> mergeWeekday = new LazyPlanMergeWeekday(option.conn, option.schemaName);
		ActionLazy<PlanInfo> pruneAge = new LazyPlanPruneAge(option.conn, option.schemaName);
		ActionLazy<PlanInfo> pruneReserve = new LazyPlanPruneReserve(option.conn, option.schemaName);
		
		enforceCodWeekday.addPostAction(mergeStore);
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
		
		actions.add(enforceCodWeekday);
		return actions;
	}
	
	
	
	@Override public void makeDecision() {
		tree.makeDecision();
	}
		

	
	@Override public DeciChoice getDecisionMade() {
		return tree.getDecisionMade();
	}
	
	
	
	@Override public DeciResult<PlanInfo> getDecisionResult() {
		return tree.getDecisionResult();
	}
	
	
	
	@Override public ActionStd<PlanInfo> toAction() {
		return tree.toAction();
	}
}
