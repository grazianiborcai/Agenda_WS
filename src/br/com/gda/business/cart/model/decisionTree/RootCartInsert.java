package br.com.gda.business.cart.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.cart.info.CartInfo;
import br.com.gda.business.cart.model.action.StdCartEnforceItemNext;
import br.com.gda.business.cart.model.action.StdCartMergeUsername;
import br.com.gda.business.cart.model.action.LazyCartEnforceItmCategItem;
import br.com.gda.business.cart.model.action.LazyCartEnforceLChanged;
import br.com.gda.business.cart.model.action.LazyCartMergeUser;
import br.com.gda.business.cart.model.action.LazyCartNodetInsertL1;
import br.com.gda.business.cart.model.checker.CartCheckLangu;
import br.com.gda.business.cart.model.checker.CartCheckMatore;
import br.com.gda.business.cart.model.checker.CartCheckMat;
import br.com.gda.business.cart.model.checker.CartCheckOwner;
import br.com.gda.business.cart.model.checker.CartCheckStore;
import br.com.gda.business.cart.model.checker.CartCheckWriteRoot;
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

public final class RootCartInsert implements DeciTree<CartInfo> {
	private DeciTree<CartInfo> tree;
	
	
	public RootCartInsert(DeciTreeOption<CartInfo> option) {
		DeciTreeHelperOption<CartInfo> helperOption = new DeciTreeHelperOption<>();
		
		helperOption.visitorChecker = buildDecisionChecker(option);
		helperOption.recordInfos = option.recordInfos;
		helperOption.conn = option.conn;
		helperOption.actionsOnPassed = buildActionsOnPassed(option);
		
		tree = new DeciTreeHelper<>(helperOption);
	}
	
	
	
	private ModelChecker<CartInfo> buildDecisionChecker(DeciTreeOption<CartInfo> option) {
		final boolean EXIST_ON_DB = true;
		
		List<ModelChecker<CartInfo>> queue = new ArrayList<>();		
		ModelChecker<CartInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checker = new CartCheckWriteRoot();
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;	
		checker = new CartCheckLangu(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;	
		checker = new CartCheckOwner(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;	
		checker = new CartCheckStore(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;	
		checker = new CartCheckMat(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;	
		checker = new CartCheckMatore(checkerOption);
		queue.add(checker);
		
		//TODO: verificar serico
		//TODO: verificar limite de itens no carrinho
		//TODO: verificar quantidade. Somente 1 para servico. Nao pode ser negativa para todos os casos
		//TODO: verificar valores negativos
		//TODO: verificar Ordem em aberto
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	private List<ActionStd<CartInfo>> buildActionsOnPassed(DeciTreeOption<CartInfo> option) {
		List<ActionStd<CartInfo>> actions = new ArrayList<>();
		
		ActionStd<CartInfo> nodeHeader = new NodeCartHdr(option).toAction();
		
		
		actions.add(nodeHeader);
		return actions;
		
		/*

		ActionStd<CartInfo> enforceItem = new StdCartEnforceItemNext(option);
		ActionLazy<CartInfo> enforceItemCateg = new LazyCartEnforceItmCategItem(option.conn, option.schemaName);
		
		ActionLazy<CartInfo> mergeUser = new LazyCartMergeUser(option.conn, option.schemaName);
		ActionLazy<CartInfo> nodeL1 = new LazyCartNodetInsertL1(option.conn, option.schemaName);
		
		enforceItem.addPostAction(enforceItemCateg);
		enforceItemCateg.addPostAction(enforceLChanged);
		enforceLChanged.addPostAction(mergeUser);
		mergeUser.addPostAction(nodeL1);
		
		actions.add(nodeCus);
		actions.add(nodePerson);
		actions.add(enforceItem);
		return actions; */
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
