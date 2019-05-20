package br.com.gda.business.userSnapshot_.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.userSnapshot_.info.UserSnapInfo;
import br.com.gda.business.userSnapshot_.model.action.LazyUserSnapInsert;
import br.com.gda.business.userSnapshot_.model.action.LazyUserSnapInsertPersonSnap;
import br.com.gda.business.userSnapshot_.model.action.LazyUserSnapNodeInsertAddressSnap;
import br.com.gda.business.userSnapshot_.model.action.LazyUserSnapNodeInsertPhoneSnap;
import br.com.gda.business.userSnapshot_.model.action.StdUserSnapMergeUser;
import br.com.gda.business.userSnapshot_.model.checker.UserSnapCheckExist;
import br.com.gda.business.userSnapshot_.model.checker.UserSnapCheckSnap;
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

public final class NodeUserSnapInsertL2 implements DeciTree<UserSnapInfo> {
	private DeciTree<UserSnapInfo> tree;
	
	
	public NodeUserSnapInsertL2(DeciTreeOption<UserSnapInfo> option) {
		DeciTreeHelperOption<UserSnapInfo> helperOption = new DeciTreeHelperOption<>();
		
		helperOption.visitorChecker = buildDecisionChecker(option);
		helperOption.recordInfos = option.recordInfos;
		helperOption.conn = option.conn;
		helperOption.actionsOnPassed = buildActionsOnPassed(option);
		helperOption.actionsOnFailed = null;
		
		tree = new DeciTreeHelper<>(helperOption);
	}
	
	
	
	private ModelChecker<UserSnapInfo> buildDecisionChecker(DeciTreeOption<UserSnapInfo> option) {
		final boolean EXIST = true;
		final boolean DONT_EXIST = false;
		
		List<ModelChecker<UserSnapInfo>> queue = new ArrayList<>();		
		ModelChecker<UserSnapInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST;	
		checker = new UserSnapCheckSnap(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = DONT_EXIST;	
		checker = new UserSnapCheckExist(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	private List<ActionStd<UserSnapInfo>> buildActionsOnPassed(DeciTreeOption<UserSnapInfo> option) {
		List<ActionStd<UserSnapInfo>> actions = new ArrayList<>();	
		
		ActionStd<UserSnapInfo> mergeUser = new StdUserSnapMergeUser(option);	
		ActionLazy<UserSnapInfo> insertPersonSnap = new LazyUserSnapInsertPersonSnap(option.conn, option.schemaName);
		ActionLazy<UserSnapInfo> insertUserSnap = new LazyUserSnapInsert(option.conn, option.schemaName);
		ActionLazy<UserSnapInfo> insertAddressSnap = new LazyUserSnapNodeInsertAddressSnap(option.conn, option.schemaName);
		ActionLazy<UserSnapInfo> insertPhoneSnap = new LazyUserSnapNodeInsertPhoneSnap(option.conn, option.schemaName);
		
		mergeUser.addPostAction(insertPersonSnap);
		mergeUser.addPostAction(insertUserSnap);
		mergeUser.addPostAction(insertAddressSnap);
		mergeUser.addPostAction(insertPhoneSnap);
		
		actions.add(mergeUser);
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
