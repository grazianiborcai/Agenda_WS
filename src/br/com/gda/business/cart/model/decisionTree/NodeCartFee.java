package br.com.gda.business.cart.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.cart.info.CartInfo;
import br.com.gda.business.cart.model.action.LazyCartFlagFee;
import br.com.gda.business.cart.model.action.LazyCartMergeFeeDefault;
import br.com.gda.business.cart.model.action.LazyCartMergeFeetore;
import br.com.gda.business.cart.model.action.MultiCartAddFee;
import br.com.gda.business.cart.model.action.StdCartFirstRow;
import br.com.gda.business.cart.model.action.StdCartFlagItem;
import br.com.gda.business.cart.model.checker.CartCheckFeeStoreService;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciChoice;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTree;
import br.com.gda.model.decisionTree.DeciTreeHelper;
import br.com.gda.model.decisionTree.DeciTreeHelperOption;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class NodeCartFee implements DeciTree<CartInfo> {
	private DeciTree<CartInfo> tree;
	
	
	public NodeCartFee(DeciTreeOption<CartInfo> option) {
		DeciTreeHelperOption<CartInfo> helperOption = new DeciTreeHelperOption<>();
		
		helperOption.visitorChecker = buildDecisionChecker(option);
		helperOption.recordInfos = option.recordInfos;
		helperOption.conn = option.conn;
		helperOption.actionsOnPassed = buildActionsOnPassed(option);
		helperOption.actionsOnFailed = buildActionsOnFailed(option);
		
		tree = new DeciTreeHelper<>(helperOption);
	}
	
	
	
	private ModelChecker<CartInfo> buildDecisionChecker(DeciTreeOption<CartInfo> option) {
		final boolean EXIST_ON_DB = true;
		
		List<ModelChecker<CartInfo>> queue = new ArrayList<>();		
		ModelChecker<CartInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;	
		checker = new CartCheckFeeStoreService(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	private List<ActionStd<CartInfo>> buildActionsOnPassed(DeciTreeOption<CartInfo> option) {
		//TODO: quando pedido contem multiplas lojas (Store), a taxa de servico e' obtida da loja da primeira linha. Melhorar isso ?
		List<ActionStd<CartInfo>> actions = new ArrayList<>();	
		
		ActionStd<CartInfo> flagItem = new StdCartFlagItem(option);
		ActionLazy<CartInfo> addFee = new MultiCartAddFee(option.conn, option.schemaName);
		ActionStd<CartInfo> firstRow = new StdCartFirstRow(option);
		ActionLazy<CartInfo> mergeFeeStore = new LazyCartMergeFeetore(option.conn, option.schemaName);
		ActionLazy<CartInfo> flagFee = new LazyCartFlagFee(option.conn, option.schemaName);
		
		
		flagItem.addPostAction(addFee);
		
		firstRow.addPostAction(mergeFeeStore);
		mergeFeeStore.addPostAction(flagFee);
		flagFee.addPostAction(addFee);
		
		
		actions.add(flagItem);	
		actions.add(firstRow);
		return actions;
	}
	
	
	
	private List<ActionStd<CartInfo>> buildActionsOnFailed(DeciTreeOption<CartInfo> option) {
		List<ActionStd<CartInfo>> actions = new ArrayList<>();	
		
		ActionStd<CartInfo> flagItem = new StdCartFlagItem(option);
		ActionLazy<CartInfo> addFee = new MultiCartAddFee(option.conn, option.schemaName);
		ActionStd<CartInfo> firstRow = new StdCartFirstRow(option);
		ActionLazy<CartInfo> mergeFeeStore = new LazyCartMergeFeeDefault(option.conn, option.schemaName);
		ActionLazy<CartInfo> flagFee = new LazyCartFlagFee(option.conn, option.schemaName);
		
		
		flagItem.addPostAction(addFee);
		
		firstRow.addPostAction(mergeFeeStore);
		mergeFeeStore.addPostAction(flagFee);
		flagFee.addPostAction(addFee);
		
		
		actions.add(flagItem);	
		actions.add(firstRow);
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
