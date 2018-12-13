package br.com.gda.business.phoneSnapshot.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.phoneSnapshot.info.PhoneSnapInfo;
import br.com.gda.business.phoneSnapshot.model.action.LazyPhoneSnapInsert;
import br.com.gda.business.phoneSnapshot.model.action.LazyPhoneSnapMergePhone;
import br.com.gda.business.phoneSnapshot.model.action.StdPhoneSnapMergeSnap;
import br.com.gda.business.phoneSnapshot.model.checker.PhoneSnapCheckHasSnap;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciChoice;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTree;
import br.com.gda.model.decisionTree.DeciTreeHelper;
import br.com.gda.model.decisionTree.DeciTreeHelperOption;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class NodePhoneSnapInsertL1 implements DeciTree<PhoneSnapInfo> {
	private DeciTree<PhoneSnapInfo> tree;
	
	
	public NodePhoneSnapInsertL1(DeciTreeOption<PhoneSnapInfo> option) {
		DeciTreeHelperOption<PhoneSnapInfo> helperOption = new DeciTreeHelperOption<>();
		
		helperOption.visitorChecker = buildDecisionChecker(option);
		helperOption.recordInfos = option.recordInfos;
		helperOption.conn = option.conn;
		helperOption.actionsOnPassed = buildActionsOnPassed(option);
		helperOption.actionsOnFailed = buildActionsOnFailed(option);
		
		tree = new DeciTreeHelper<>(helperOption);
	}
	
	
	
	private ModelChecker<PhoneSnapInfo> buildDecisionChecker(DeciTreeOption<PhoneSnapInfo> option) {
		List<ModelChecker<PhoneSnapInfo>> queue = new ArrayList<>();		
		ModelChecker<PhoneSnapInfo> checker;	
		
		checker = new PhoneSnapCheckHasSnap();
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	private List<ActionStd<PhoneSnapInfo>> buildActionsOnPassed(DeciTreeOption<PhoneSnapInfo> option) {
		List<ActionStd<PhoneSnapInfo>> actions = new ArrayList<>();	
		
		ActionStd<PhoneSnapInfo> nodeL2 = new NodePhoneSnapInsertL2(option).toAction();	
		
		actions.add(nodeL2);
		return actions;
	}
	
	
	
	private List<ActionStd<PhoneSnapInfo>> buildActionsOnFailed(DeciTreeOption<PhoneSnapInfo> option) {
		List<ActionStd<PhoneSnapInfo>> actions = new ArrayList<>();	
		
		ActionStd<PhoneSnapInfo> mergeSnap = new StdPhoneSnapMergeSnap(option);	
		ActionLazy<PhoneSnapInfo> mergePhone = new LazyPhoneSnapMergePhone(option.conn, option.schemaName);	
		ActionLazy<PhoneSnapInfo> insert = new LazyPhoneSnapInsert(option.conn, option.schemaName);
		
		mergeSnap.addPostAction(mergePhone);
		mergePhone.addPostAction(insert);
		
		actions.add(mergeSnap);
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
