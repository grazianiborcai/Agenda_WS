package br.com.gda.business.phone.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.phone.info.PhoneInfo;
import br.com.gda.business.phone.model.action.StdPhoneSuccess;
import br.com.gda.business.phone.model.checker.PhoneCheckBrNumber;
import br.com.gda.business.phone.model.checker.PhoneCheckBrSequence;
import br.com.gda.business.phone.model.checker.PhoneCheckBrAreaCode;
import br.com.gda.business.phone.model.checker.PhoneCheckBrLength;
import br.com.gda.business.phone.model.checker.PhoneCheckOnlyNumber;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciChoice;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTree;
import br.com.gda.model.decisionTree.DeciTreeHelper;
import br.com.gda.model.decisionTree.DeciTreeHelperOption;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class NodePhoneValidateBR implements DeciTree<PhoneInfo> {
	private DeciTree<PhoneInfo> tree;
	
	
	public NodePhoneValidateBR(DeciTreeOption<PhoneInfo> option) {
		DeciTreeHelperOption<PhoneInfo> helperOption = new DeciTreeHelperOption<>();
		
		helperOption.visitorChecker = buildDecisionChecker(option);
		helperOption.recordInfos = option.recordInfos;
		helperOption.conn = option.conn;
		helperOption.actionsOnPassed = buildActionsOnPassed(option);
		
		tree = new DeciTreeHelper<>(helperOption);
	}
	
	
	
	private ModelChecker<PhoneInfo> buildDecisionChecker(DeciTreeOption<PhoneInfo> option) {		
		List<ModelChecker<PhoneInfo>> queue = new ArrayList<>();		
		ModelChecker<PhoneInfo> checker;	

		checker = new PhoneCheckBrLength();
		queue.add(checker);
		
		checker = new PhoneCheckOnlyNumber();
		queue.add(checker);
		
		checker = new PhoneCheckBrAreaCode();
		queue.add(checker);
		
		checker = new PhoneCheckBrSequence();
		queue.add(checker);
		
		checker = new PhoneCheckBrNumber();
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	private List<ActionStd<PhoneInfo>> buildActionsOnPassed(DeciTreeOption<PhoneInfo> option) {
		List<ActionStd<PhoneInfo>> actions = new ArrayList<>();
		
		actions.add(new StdPhoneSuccess(option));
		return actions;
	}
	
	
	
	@Override public void makeDecision() {
		tree.makeDecision();
	}
		

	
	@Override public DeciChoice getDecisionMade() {
		return tree.getDecisionMade();
	}
	
	
	
	@Override public DeciResult<PhoneInfo> getDecisionResult() {
		return tree.getDecisionResult();
	}
	
	
	
	@Override public ActionStd<PhoneInfo> toAction() {
		return tree.toAction();
	}
}
