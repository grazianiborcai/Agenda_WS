package br.com.gda.business.phoneSnapshot.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.phoneSnapshot.info.PhoneSnapInfo;
import br.com.gda.business.phoneSnapshot.model.checker.PhoneSnapCheckOwner;
import br.com.gda.business.phoneSnapshot.model.checker.PhoneSnapCheckPhone;
import br.com.gda.business.phoneSnapshot.model.checker.PhoneSnapCheckWrite;
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

public final class RootPhoneSnapInsert implements DeciTree<PhoneSnapInfo> {
	private DeciTree<PhoneSnapInfo> tree;
	
	
	public RootPhoneSnapInsert(DeciTreeOption<PhoneSnapInfo> option) {
		DeciTreeHelperOption<PhoneSnapInfo> helperOption = new DeciTreeHelperOption<>();
		
		helperOption.visitorChecker = buildDecisionChecker(option);
		helperOption.recordInfos = option.recordInfos;
		helperOption.conn = option.conn;
		helperOption.actionsOnPassed = buildActionsOnPassed(option);
		
		tree = new DeciTreeHelper<>(helperOption);
	}
	
	
	
	private ModelChecker<PhoneSnapInfo> buildDecisionChecker(DeciTreeOption<PhoneSnapInfo> option) {
		final boolean EXIST = true;
		
		List<ModelChecker<PhoneSnapInfo>> queue = new ArrayList<>();		
		ModelChecker<PhoneSnapInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checker = new PhoneSnapCheckWrite();
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST;	
		checker = new PhoneSnapCheckOwner(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST;	
		checker = new PhoneSnapCheckPhone(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	private List<ActionStd<PhoneSnapInfo>> buildActionsOnPassed(DeciTreeOption<PhoneSnapInfo> option) {
		List<ActionStd<PhoneSnapInfo>> actions = new ArrayList<>();	
		
		ActionStd<PhoneSnapInfo> nodeInsert = new NodePhoneSnapInsertL1(option).toAction();		
		actions.add(nodeInsert);		
		
		return actions;
	}
	
	
	
	@Override public void makeDecision() {
		tree.makeDecision();
	}
		

	
	@Override public DeciChoice getDecisionMade() {
		return tree.getDecisionMade();
	}
	
	
	
	@Override public DeciResult<PhoneSnapInfo> getDecisionResult() {
		return tree.getDecisionResult();
	}
	
	
	
	@Override public ActionStd<PhoneSnapInfo> toAction() {
		return tree.toAction();
	}
}
