package br.com.gda.payService.payPartnerOwner.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciChoice;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTree;
import br.com.gda.model.decisionTree.DeciTreeHelper;
import br.com.gda.model.decisionTree.DeciTreeHelperOption;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.payService.payPartnerOwner.info.PayparOwnerInfo;
import br.com.gda.payService.payPartnerOwner.model.action.StdPayparOwnerMergePayparCountry;
import br.com.gda.payService.payPartnerOwner.model.checker.PayparOwnerCheckHasCountry;
import br.com.gda.payService.payPartnerOwner.model.checker.PayparOwnerCheckPayparCountry;

public final class NodePayparOwnerSelectL1 implements DeciTree<PayparOwnerInfo> {
	private DeciTree<PayparOwnerInfo> tree;
	
	
	public NodePayparOwnerSelectL1(DeciTreeOption<PayparOwnerInfo> option) {
		DeciTreeHelperOption<PayparOwnerInfo> helperOption = new DeciTreeHelperOption<>();
		
		helperOption.visitorChecker = buildDecisionChecker(option);
		helperOption.recordInfos = option.recordInfos;
		helperOption.conn = option.conn;
		helperOption.actionsOnPassed = buildActionsOnPassed(option);
		
		tree = new DeciTreeHelper<>(helperOption);
	}
	
	
	
	private ModelChecker<PayparOwnerInfo> buildDecisionChecker(DeciTreeOption<PayparOwnerInfo> option) {
		final boolean EXIST_ON_DB = true;
		final boolean HAS_ATTRIBUTE = true;
		
		List<ModelChecker<PayparOwnerInfo>> queue = new ArrayList<>();		
		ModelChecker<PayparOwnerInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = HAS_ATTRIBUTE;		
		checker = new PayparOwnerCheckHasCountry(checkerOption);
		queue.add(checker);	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;		
		checker = new PayparOwnerCheckPayparCountry(checkerOption);
		queue.add(checker);	
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	private List<ActionStd<PayparOwnerInfo>> buildActionsOnPassed(DeciTreeOption<PayparOwnerInfo> option) {
		List<ActionStd<PayparOwnerInfo>> actions = new ArrayList<>();
		
		ActionStd<PayparOwnerInfo> mergeCountry = new StdPayparOwnerMergePayparCountry(option);
		
		actions.add(mergeCountry);
		return actions;
	}
	
	
	
	@Override public void makeDecision() {
		tree.makeDecision();
	}
		

	
	@Override public DeciChoice getDecisionMade() {
		return tree.getDecisionMade();
	}
	
	
	
	@Override public DeciResult<PayparOwnerInfo> getDecisionResult() {
		return tree.getDecisionResult();
	}
	
	
	
	@Override public ActionStd<PayparOwnerInfo> toAction() {
		return tree.toAction();
	}
}
