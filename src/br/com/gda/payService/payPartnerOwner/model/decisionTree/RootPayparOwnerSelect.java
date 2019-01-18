package br.com.gda.payService.payPartnerOwner.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.model.action.ActionLazy;
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
import br.com.gda.payService.payPartnerOwner.model.action.LazyPayparOwnerNodeSelectL1;
import br.com.gda.payService.payPartnerOwner.model.action.StdPayparOwnerMergeOwner;
import br.com.gda.payService.payPartnerOwner.model.checker.PayparOwnerCheckOwner;
import br.com.gda.payService.payPartnerOwner.model.checker.PayparOwnerCheckRead;

public final class RootPayparOwnerSelect implements DeciTree<PayparOwnerInfo> {
	private DeciTree<PayparOwnerInfo> tree;
	
	
	public RootPayparOwnerSelect(DeciTreeOption<PayparOwnerInfo> option) {
		DeciTreeHelperOption<PayparOwnerInfo> helperOption = new DeciTreeHelperOption<>();
		
		helperOption.visitorChecker = buildDecisionChecker(option);
		helperOption.recordInfos = option.recordInfos;
		helperOption.conn = option.conn;
		helperOption.actionsOnPassed = buildActionsOnPassed(option);
		
		tree = new DeciTreeHelper<>(helperOption);
	}
	
	
	
	private ModelChecker<PayparOwnerInfo> buildDecisionChecker(DeciTreeOption<PayparOwnerInfo> option) {
		final boolean EXIST_ON_DB = true;
		
		List<ModelChecker<PayparOwnerInfo>> queue = new ArrayList<>();		
		ModelChecker<PayparOwnerInfo> checker;
		ModelCheckerOption checkerOption;
		
		checker = new PayparOwnerCheckRead();
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;		
		checker = new PayparOwnerCheckOwner(checkerOption);
		queue.add(checker);	
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	private List<ActionStd<PayparOwnerInfo>> buildActionsOnPassed(DeciTreeOption<PayparOwnerInfo> option) {
		List<ActionStd<PayparOwnerInfo>> actions = new ArrayList<>();
		
		ActionStd<PayparOwnerInfo> mergeOwner = new StdPayparOwnerMergeOwner(option);
		ActionLazy<PayparOwnerInfo> nodeSelectL1 = new LazyPayparOwnerNodeSelectL1(option.conn, option.schemaName);
		
		mergeOwner.addPostAction(nodeSelectL1);
		
		actions.add(mergeOwner);
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
