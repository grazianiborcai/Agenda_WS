package br.com.gda.business.userSnapshot.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.userSnapshot.info.UserSnapInfo;
import br.com.gda.business.userSnapshot.model.action.LazyUserSnapInsertAddressSnap;
import br.com.gda.business.userSnapshot.model.action.StdUserSnapEnforceAddress;
import br.com.gda.business.userSnapshot.model.action.StdUserSnapSuccess;
import br.com.gda.business.userSnapshot.model.checker.UserSnapCheckHasAddress;
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

public final class NodeUserSnapInsertAddressSnap implements DeciTree<UserSnapInfo> {
	private DeciTree<UserSnapInfo> tree;
	
	
	public NodeUserSnapInsertAddressSnap(DeciTreeOption<UserSnapInfo> option) {
		DeciTreeHelperOption<UserSnapInfo> helperOption = new DeciTreeHelperOption<>();
		
		helperOption.visitorChecker = buildDecisionChecker(option);
		helperOption.recordInfos = option.recordInfos;
		helperOption.conn = option.conn;
		helperOption.actionsOnPassed = buildActionsOnPassed(option);
		helperOption.actionsOnFailed = buildActionsOnFailed(option);
		
		tree = new DeciTreeHelper<>(helperOption);
	}
	
	
	
	private ModelChecker<UserSnapInfo> buildDecisionChecker(DeciTreeOption<UserSnapInfo> option) {
		List<ModelChecker<UserSnapInfo>> queue = new ArrayList<>();		
		ModelChecker<UserSnapInfo> checker;	
		
		checker = new UserSnapCheckHasAddress();
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	private List<ActionStd<UserSnapInfo>> buildActionsOnPassed(DeciTreeOption<UserSnapInfo> option) {
		List<ActionStd<UserSnapInfo>> actions = new ArrayList<>();	
		
		ActionStd<UserSnapInfo> enforceAddress = new StdUserSnapEnforceAddress(option);	
		ActionLazy<UserSnapInfo> insertAddress = new LazyUserSnapInsertAddressSnap(option.conn, option.schemaName);
		
		enforceAddress.addPostAction(insertAddress);
		
		actions.add(enforceAddress);
		return actions;
	}
	
	
	
	private List<ActionStd<UserSnapInfo>> buildActionsOnFailed(DeciTreeOption<UserSnapInfo> option) {
		List<ActionStd<UserSnapInfo>> actions = new ArrayList<>();	
		
		ActionStd<UserSnapInfo> success = new StdUserSnapSuccess(option);
		actions.add(success);
		return actions;
	}
	
	
	
	@Override public void makeDecision() {
		tree.makeDecision();
	}
		

	
	@Override public DeciChoice getDecisionMade() {
		return tree.getDecisionMade();
	}
	
	
	
	@Override public DeciResult<UserSnapInfo> getDecisionResult() {
		return tree.getDecisionResult();
	}
	
	
	
	@Override public ActionStd<UserSnapInfo> toAction() {
		return tree.toAction();
	}
}
