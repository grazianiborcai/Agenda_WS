package br.com.gda.business.phoneSnapshot.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.phoneSnapshot.info.PhoneSnapInfo;
import br.com.gda.business.phoneSnapshot.model.action.LazyPhoneSnapInsert;
import br.com.gda.business.phoneSnapshot.model.action.StdPhoneSnapMergePhone;
import br.com.gda.business.phoneSnapshot.model.checker.PhoneSnapCheckExist;
import br.com.gda.business.phoneSnapshot.model.checker.PhoneSnapCheckSnap;
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

public final class NodePhoneSnapInsertL2 implements DeciTree<PhoneSnapInfo> {
	private DeciTree<PhoneSnapInfo> tree;
	
	
	public NodePhoneSnapInsertL2(DeciTreeOption<PhoneSnapInfo> option) {
		DeciTreeHelperOption<PhoneSnapInfo> helperOption = new DeciTreeHelperOption<>();
		
		helperOption.visitorChecker = buildDecisionChecker(option);
		helperOption.recordInfos = option.recordInfos;
		helperOption.conn = option.conn;
		helperOption.actionsOnPassed = buildActionsOnPassed(option);
		helperOption.actionsOnFailed = null;
		
		tree = new DeciTreeHelper<>(helperOption);
	}
	
	
	
	private ModelChecker<PhoneSnapInfo> buildDecisionChecker(DeciTreeOption<PhoneSnapInfo> option) {
		final boolean EXIST = true;
		final boolean DONT_EXIST = false;
		
		List<ModelChecker<PhoneSnapInfo>> queue = new ArrayList<>();		
		ModelChecker<PhoneSnapInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST;	
		checker = new PhoneSnapCheckSnap(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = DONT_EXIST;	
		checker = new PhoneSnapCheckExist(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	private List<ActionStd<PhoneSnapInfo>> buildActionsOnPassed(DeciTreeOption<PhoneSnapInfo> option) {
		List<ActionStd<PhoneSnapInfo>> actions = new ArrayList<>();	
		
		ActionStd<PhoneSnapInfo> mergePhone = new StdPhoneSnapMergePhone(option);	
		ActionLazy<PhoneSnapInfo> insert = new LazyPhoneSnapInsert(option.conn, option.schemaName);
		
		mergePhone.addPostAction(insert);
		
		actions.add(mergePhone);
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
