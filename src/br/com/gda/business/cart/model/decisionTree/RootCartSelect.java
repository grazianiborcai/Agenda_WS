package br.com.gda.business.cart.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.cart.info.CartInfo;
import br.com.gda.business.cart.model.action.StdCartSelect;
import br.com.gda.business.cart.model.action.LazyCartEnforceFeeCateg;
import br.com.gda.business.cart.model.action.LazyCartEnforceItmCategItem;
import br.com.gda.business.cart.model.action.LazyCartEnforceItmNum;
import br.com.gda.business.cart.model.action.LazyCartEnforceWeekday;
import br.com.gda.business.cart.model.action.LazyCartFirstRow;
import br.com.gda.business.cart.model.action.LazyCartFlagAll;
import br.com.gda.business.cart.model.action.LazyCartFlagFee;
import br.com.gda.business.cart.model.action.LazyCartFlagItem;
import br.com.gda.business.cart.model.action.LazyCartFlagTotal;
import br.com.gda.business.cart.model.action.LazyCartMergeCateg;
import br.com.gda.business.cart.model.action.LazyCartMergeFee;
import br.com.gda.business.cart.model.action.LazyCartMergeMat;
import br.com.gda.business.cart.model.action.LazyCartMergeStore;
import br.com.gda.business.cart.model.action.LazyCartMergeTotAmount;
import br.com.gda.business.cart.model.action.LazyCartMergeWeekday;
import br.com.gda.business.cart.model.action.LazyCartSort;
import br.com.gda.business.cart.model.action.MultiCartAddFee;
import br.com.gda.business.cart.model.action.MultiCartAddTotal;
import br.com.gda.business.cart.model.checker.CartCheckRead;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciChoice;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTree;
import br.com.gda.model.decisionTree.DeciTreeHelper;
import br.com.gda.model.decisionTree.DeciTreeHelperOption;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class RootCartSelect implements DeciTree<CartInfo> {
	private DeciTree<CartInfo> tree;
	
	
	public RootCartSelect(DeciTreeOption<CartInfo> option) {
		DeciTreeHelperOption<CartInfo> helperOption = new DeciTreeHelperOption<>();
		
		helperOption.visitorChecker = buildDecisionChecker(option);
		helperOption.recordInfos = option.recordInfos;
		helperOption.conn = option.conn;
		helperOption.actionsOnPassed = buildActionsOnPassed(option);
		
		tree = new DeciTreeHelper<>(helperOption);
	}
	
	
	
	private ModelChecker<CartInfo> buildDecisionChecker(DeciTreeOption<CartInfo> option) {
		List<ModelChecker<CartInfo>> queue = new ArrayList<>();		
		ModelChecker<CartInfo> checker;	
		
		checker = new CartCheckRead();
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	private List<ActionStd<CartInfo>> buildActionsOnPassed(DeciTreeOption<CartInfo> option) {
		List<ActionStd<CartInfo>> actions = new ArrayList<>();		
		
		ActionStd<CartInfo> selectCart = new StdCartSelect(option);
		ActionLazy<CartInfo> mergeMat = new LazyCartMergeMat(option.conn, option.schemaName);
		ActionLazy<CartInfo> mergeStore = new LazyCartMergeStore(option.conn, option.schemaName);
		ActionLazy<CartInfo> enforceWeekday = new LazyCartEnforceWeekday(option.conn, option.schemaName);
		ActionLazy<CartInfo> mergeWeekday = new LazyCartMergeWeekday(option.conn, option.schemaName);
		ActionLazy<CartInfo> enforceItemCateg = new LazyCartEnforceItmCategItem(option.conn, option.schemaName);
		ActionLazy<CartInfo> flagItem = new LazyCartFlagItem(option.conn, option.schemaName);
		ActionLazy<CartInfo> flagFee = new LazyCartFlagFee(option.conn, option.schemaName);
		ActionLazy<CartInfo> firstRow = new LazyCartFirstRow(option.conn, option.schemaName);
		ActionLazy<CartInfo> enforceFeeCateg = new LazyCartEnforceFeeCateg(option.conn, option.schemaName);
		ActionLazy<CartInfo> mergeFee = new LazyCartMergeFee(option.conn, option.schemaName);
		ActionLazy<CartInfo> addFee = new MultiCartAddFee(option.conn, option.schemaName);
		ActionLazy<CartInfo> flagAll = new LazyCartFlagAll(option.conn, option.schemaName);
		ActionLazy<CartInfo> flagTotal = new LazyCartFlagTotal(option.conn, option.schemaName);
		ActionLazy<CartInfo> computeTotal = new LazyCartMergeTotAmount(option.conn, option.schemaName);
		ActionLazy<CartInfo> addTotal = new MultiCartAddTotal(option.conn, option.schemaName);
		ActionLazy<CartInfo> mergeCateg = new LazyCartMergeCateg(option.conn, option.schemaName);
		ActionLazy<CartInfo> enforceItemNum = new LazyCartEnforceItmNum(option.conn, option.schemaName);
		ActionLazy<CartInfo> sort = new LazyCartSort(option.conn, option.schemaName);
		
		selectCart.addPostAction(mergeMat);
		mergeMat.addPostAction(mergeStore);
		mergeStore.addPostAction(enforceWeekday);
		enforceWeekday.addPostAction(mergeWeekday);
		mergeWeekday.addPostAction(enforceItemCateg);
		enforceItemCateg.addPostAction(flagItem);
		enforceItemCateg.addPostAction(firstRow);
		firstRow.addPostAction(enforceFeeCateg);
		enforceFeeCateg.addPostAction(mergeFee);
		mergeFee.addPostAction(flagFee);
		flagFee.addPostAction(addFee);		
		flagItem.addPostAction(addFee);
		addFee.addPostAction(flagAll);
		addFee.addPostAction(computeTotal);
		computeTotal.addPostAction(flagTotal);
		flagAll.addPostAction(addTotal);		
		flagTotal.addPostAction(addTotal);
		addTotal.addPostAction(mergeCateg);
		mergeCateg.addPostAction(enforceItemNum);
		enforceItemNum.addPostAction(sort);
		
		actions.add(selectCart);	
		
		return actions;
	}
	
	
	
	@Override public void makeDecision() {
		tree.makeDecision();
	}
		

	
	@Override public DeciChoice getDecisionMade() {
		return tree.getDecisionMade();
	}
	
	
	
	@Override public DeciResult<CartInfo> getDecisionResult() {
		return tree.getDecisionResult();
	}
	
	
	
	@Override public ActionStd<CartInfo> toAction() {
		return tree.toAction();
	}
}
