package br.com.gda.business.cartSnapshot.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.cartSnapshot.info.CartSnapInfo;
import br.com.gda.business.cartSnapshot.model.action.LazyCartSnapFirstRow;
import br.com.gda.business.cartSnapshot.model.action.LazyCartSnapInsertHdr;
import br.com.gda.business.cartSnapshot.model.action.LazyCartSnapInsertItm;
import br.com.gda.business.cartSnapshot.model.action.LazyCartSnapNodeInsertMatSnap;
import br.com.gda.business.cartSnapshot.model.action.StdCartSnapMergeCart;
import br.com.gda.business.cartSnapshot.model.checker.CartSnapCheckExist;
import br.com.gda.business.cartSnapshot.model.checker.CartSnapCheckSnap;
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

public final class NodeCartSnapInsertL2 implements DeciTree<CartSnapInfo> {
	private DeciTree<CartSnapInfo> tree;
	
	
	public NodeCartSnapInsertL2(DeciTreeOption<CartSnapInfo> option) {
		DeciTreeHelperOption<CartSnapInfo> helperOption = new DeciTreeHelperOption<>();
		
		helperOption.visitorChecker = buildDecisionChecker(option);
		helperOption.recordInfos = option.recordInfos;
		helperOption.conn = option.conn;
		helperOption.actionsOnPassed = buildActionsOnPassed(option);
		helperOption.actionsOnFailed = null;
		
		tree = new DeciTreeHelper<>(helperOption);
	}
	
	
	
	private ModelChecker<CartSnapInfo> buildDecisionChecker(DeciTreeOption<CartSnapInfo> option) {
		final boolean EXIST = true;
		final boolean DONT_EXIST = false;
		
		List<ModelChecker<CartSnapInfo>> queue = new ArrayList<>();		
		ModelChecker<CartSnapInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST;	
		checker = new CartSnapCheckSnap(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = DONT_EXIST;	
		checker = new CartSnapCheckExist(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	private List<ActionStd<CartSnapInfo>> buildActionsOnPassed(DeciTreeOption<CartSnapInfo> option) {
		List<ActionStd<CartSnapInfo>> actions = new ArrayList<>();	
		
		ActionStd<CartSnapInfo> mergeCart = new StdCartSnapMergeCart(option);	
		ActionLazy<CartSnapInfo> insertMatSnap = new LazyCartSnapNodeInsertMatSnap(option.conn, option.schemaName);
		ActionLazy<CartSnapInfo> firstRow = new LazyCartSnapFirstRow(option.conn, option.schemaName);
		ActionLazy<CartSnapInfo> insertHdr = new LazyCartSnapInsertHdr(option.conn, option.schemaName);
		ActionLazy<CartSnapInfo> insertItm = new LazyCartSnapInsertItm(option.conn, option.schemaName);
		//ActionLazy<CartSnapInfo> insertUserSnap = new LazyUserSnapInsert(option.conn, option.schemaName);
		//ActionLazy<CartSnapInfo> insertAddressSnap = new LazyUserSnapNodeInsertAddressSnap(option.conn, option.schemaName);
		//ActionLazy<CartSnapInfo> insertPhoneSnap = new LazyUserSnapNodeInsertPhoneSnap(option.conn, option.schemaName);
		
		mergeCart.addPostAction(insertMatSnap);
		
		mergeCart.addPostAction(firstRow);
		firstRow.addPostAction(insertHdr);
		
		mergeCart.addPostAction(insertItm);
		
		//mergeCart.addPostAction(insertUserSnap);
		//mergeCart.addPostAction(insertAddressSnap);
		//mergeCart.addPostAction(insertPhoneSnap);
		
		actions.add(mergeCart);
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
