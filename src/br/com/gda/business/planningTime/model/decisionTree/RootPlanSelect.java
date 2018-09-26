package br.com.gda.business.planningTime.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.planningTime.info.PlanInfo;
import br.com.gda.business.planningTime.model.checker.PlanCheckRead;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciAction;
import br.com.gda.model.decisionTree.DeciActionHandler;
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
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	private List<DeciAction<PlanInfo>> buildActionsOnPassed(DeciTreeOption<PlanInfo> option) {
		List<DeciAction<PlanInfo>> actions = new ArrayList<>();		
		
		DeciAction<PlanInfo> mainAction = new ActionPlanEnforceWeekday(option);		
		DeciActionHandler<PlanInfo> mergeStore = new HandlerPlanMergeStore(option.conn, option.schemaName);		
		DeciActionHandler<PlanInfo> mergeSWT = new HandlerPlanMergeSWT(option.conn, option.schemaName);
		DeciActionHandler<PlanInfo> mergeEWT = new HandlerPlanMergeEWT(option.conn, option.schemaName);
		DeciActionHandler<PlanInfo> mergeEmp = new HandlerPlanMergeEmp(option.conn, option.schemaName);
		DeciActionHandler<PlanInfo> mergeME = new HandlerPlanMergeME(option.conn, option.schemaName);
		DeciActionHandler<PlanInfo> mergeMat = new HandlerPlanMergeMat(option.conn, option.schemaName);			
		DeciActionHandler<PlanInfo> pruneSLD = new HandlerPlanPruneSLD(option.conn, option.schemaName);		
		DeciActionHandler<PlanInfo> pruneELD = new HandlerPlanPruneELD(option.conn, option.schemaName);			
		DeciActionHandler<PlanInfo> mergeWeekday = new HandlerPlanMergeWeekday(option.conn, option.schemaName);
		DeciActionHandler<PlanInfo> pruneReserve = new HandlerPlanPruneReserve(option.conn, option.schemaName);
		
		mainAction.addPostAction(mergeStore);
		mergeStore.addPostAction(mergeSWT);
		mergeSWT.addPostAction(mergeEWT);
		mergeEWT.addPostAction(mergeEmp);
		mergeEmp.addPostAction(mergeME);
		mergeME.addPostAction(mergeMat);
		mergeMat.addPostAction(pruneSLD);
		pruneSLD.addPostAction(pruneELD);
		pruneELD.addPostAction(mergeWeekday);
		mergeWeekday.addPostAction(pruneReserve);
		
		actions.add(mainAction);
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
	
	
	
	@Override public DeciAction<PlanInfo> toAction() {
		return tree.toAction();
	}
}
