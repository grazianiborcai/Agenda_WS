package br.com.gda.business.cartSnapshot.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.cartSnapshot.info.CartSnapInfo;
import br.com.gda.business.cartSnapshot.model.checker.CartSnapCheckCartItm;
import br.com.gda.business.cartSnapshot.model.checker.CartSnapCheckOwner;
import br.com.gda.business.cartSnapshot.model.checker.CartSnapCheckUser;
import br.com.gda.business.cartSnapshot.model.checker.CartSnapCheckWrite;
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

public final class RootCartSnapInsert implements DeciTree<CartSnapInfo> {
	private DeciTree<CartSnapInfo> tree;
	
	
	public RootCartSnapInsert(DeciTreeOption<CartSnapInfo> option) {
		DeciTreeHelperOption<CartSnapInfo> helperOption = new DeciTreeHelperOption<>();
		
		helperOption.visitorChecker = buildDecisionChecker(option);
		helperOption.recordInfos = option.recordInfos;
		helperOption.conn = option.conn;
		helperOption.actionsOnPassed = buildActionsOnPassed(option);
		
		tree = new DeciTreeHelper<>(helperOption);
	}
	
	
	
	private ModelChecker<CartSnapInfo> buildDecisionChecker(DeciTreeOption<CartSnapInfo> option) {
		final boolean EXIST = true;
		
		List<ModelChecker<CartSnapInfo>> queue = new ArrayList<>();		
		ModelChecker<CartSnapInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checker = new CartSnapCheckWrite();
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST;	
		checker = new CartSnapCheckOwner(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST;	
		checker = new CartSnapCheckUser(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST;	
		checker = new CartSnapCheckCartItm(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	private List<ActionStd<CartSnapInfo>> buildActionsOnPassed(DeciTreeOption<CartSnapInfo> option) {
		List<ActionStd<CartSnapInfo>> actions = new ArrayList<>();	
		
		ActionStd<CartSnapInfo> nodeInsert = new NodeCartSnapInsertL1(option).toAction();
		actions.add(nodeInsert);		
		
		return actions;
	}
	
	
	
	@Override public void makeDecision() {
		tree.makeDecision();
	}
		

	
	@Override public DeciChoice getDecisionMade() {
		return tree.getDecisionMade();
	}
	
	
	
	@Override public DeciResult<CartSnapInfo> getDecisionResult() {
		return tree.getDecisionResult();
	}
	
	
	
	@Override public ActionStd<CartSnapInfo> toAction() {
		return tree.toAction();
	}
}
