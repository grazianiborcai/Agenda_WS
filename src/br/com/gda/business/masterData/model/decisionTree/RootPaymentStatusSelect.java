package br.com.gda.business.masterData.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.masterData.info.PaymentStatusInfo;
import br.com.gda.business.masterData.model.action.StdPaymentStatusSelect;
import br.com.gda.business.masterData.model.checker.PaymentStatusCheckRead;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciChoice;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTree;
import br.com.gda.model.decisionTree.DeciTreeHelper;
import br.com.gda.model.decisionTree.DeciTreeHelperOption;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class RootPaymentStatusSelect implements DeciTree<PaymentStatusInfo> {
	private DeciTree<PaymentStatusInfo> tree;
	
	
	public RootPaymentStatusSelect(DeciTreeOption<PaymentStatusInfo> option) {
		DeciTreeHelperOption<PaymentStatusInfo> helperOption = new DeciTreeHelperOption<>();
		
		helperOption.visitorChecker = buildDecisionChecker();
		helperOption.recordInfos = option.recordInfos;
		helperOption.conn = option.conn;
		helperOption.actionsOnPassed = buildActionsOnPassed(option);
		
		tree = new DeciTreeHelper<>(helperOption);
	}
	
	
	
	private ModelChecker<PaymentStatusInfo> buildDecisionChecker() {
		List<ModelChecker<PaymentStatusInfo>> queue = new ArrayList<>();		
		ModelChecker<PaymentStatusInfo> checker;
		
		checker = new PaymentStatusCheckRead();
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}

		
	
	private List<ActionStd<PaymentStatusInfo>> buildActionsOnPassed(DeciTreeOption<PaymentStatusInfo> option) {
		List<ActionStd<PaymentStatusInfo>> actions = new ArrayList<>();
		
		actions.add(new StdPaymentStatusSelect(option));
		return actions;
	}
	
	
	
	@Override public void makeDecision() {
		tree.makeDecision();
	}
		

	
	@Override public DeciChoice getDecisionMade() {
		return tree.getDecisionMade();
	}
	
	
	
	@Override public DeciResult<PaymentStatusInfo> getDecisionResult() {
		return tree.getDecisionResult();
	}
	
	
	
	@Override public ActionStd<PaymentStatusInfo> toAction() {
		return tree.toAction();
	}
}
