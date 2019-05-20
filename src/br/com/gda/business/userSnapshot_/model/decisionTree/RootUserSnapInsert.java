package br.com.gda.business.userSnapshot_.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.userSnapshot_.info.UserSnapInfo;
import br.com.gda.business.userSnapshot_.model.checker.UserSnapCheckOwner;
import br.com.gda.business.userSnapshot_.model.checker.UserSnapCheckUser;
import br.com.gda.business.userSnapshot_.model.checker.UserSnapCheckWrite;
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

public final class RootUserSnapInsert implements DeciTree<UserSnapInfo> {
	private DeciTree<UserSnapInfo> tree;
	
	
	public RootUserSnapInsert(DeciTreeOption<UserSnapInfo> option) {
		DeciTreeHelperOption<UserSnapInfo> helperOption = new DeciTreeHelperOption<>();
		
		helperOption.visitorChecker = buildDecisionChecker(option);
		helperOption.recordInfos = option.recordInfos;
		helperOption.conn = option.conn;
		helperOption.actionsOnPassed = buildActionsOnPassed(option);
		
		tree = new DeciTreeHelper<>(helperOption);
	}
	
	
	
	private ModelChecker<UserSnapInfo> buildDecisionChecker(DeciTreeOption<UserSnapInfo> option) {
		final boolean EXIST = true;
		
		List<ModelChecker<UserSnapInfo>> queue = new ArrayList<>();		
		ModelChecker<UserSnapInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checker = new UserSnapCheckWrite();
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST;	
		checker = new UserSnapCheckOwner(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST;	
		checker = new UserSnapCheckUser(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	private List<ActionStd<UserSnapInfo>> buildActionsOnPassed(DeciTreeOption<UserSnapInfo> option) {
		List<ActionStd<UserSnapInfo>> actions = new ArrayList<>();	
		
		ActionStd<UserSnapInfo> nodeInsert = new NodeUserSnapInsertL1(option).toAction();
		actions.add(nodeInsert);		
		
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
