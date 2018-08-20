package br.com.gda.business.cart.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.cart.info.CartInfo;
import br.com.gda.business.cart.model.checker.CartCheckDate;
import br.com.gda.business.cart.model.checker.CartCheckEmp;
import br.com.gda.business.cart.model.checker.CartCheckExistHdr;
import br.com.gda.business.cart.model.checker.CartCheckME;
import br.com.gda.business.cart.model.checker.CartCheckTime;
import br.com.gda.business.cart.model.checker.CartCheckWriteL3;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciAction;
import br.com.gda.model.decisionTree.DeciActionHandler;
import br.com.gda.model.decisionTree.DeciChoice;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTree;
import br.com.gda.model.decisionTree.DeciTreeHelper;
import br.com.gda.model.decisionTree.DeciTreeHelperOption;
import br.com.gda.model.decisionTree.DeciTreeOption;

final class RootCartInsertL3 implements DeciTree<CartInfo> {
	private DeciTree<CartInfo> tree;
	
	
	public RootCartInsertL3(DeciTreeOption<CartInfo> option) {
		DeciTreeHelperOption<CartInfo> helperOption = new DeciTreeHelperOption<>();
		
		helperOption.visitorChecker = buildDecisionChecker(option);
		helperOption.recordInfos = option.recordInfos;
		helperOption.conn = option.conn;
		helperOption.actionsOnPassed = buildActionsOnPassed(option);
		helperOption.actionsOnFailed = buildActionsOnFailed(option);
		
		tree = new DeciTreeHelper<>(helperOption);
	}
	
	
	
	private ModelChecker<CartInfo> buildDecisionChecker(DeciTreeOption<CartInfo> option) {
		final boolean GOOD_DATE_TIME = true;
		final boolean EXIST_ON_DB = true;
		
		List<ModelChecker<CartInfo>> queue = new ArrayList<>();		
		ModelChecker<CartInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checker = new CartCheckWriteL3();
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = GOOD_DATE_TIME;	
		checker = new CartCheckTime(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = GOOD_DATE_TIME;	
		checker = new CartCheckDate(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;	
		checker = new CartCheckEmp(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;	
		checker = new CartCheckME(checkerOption);
		queue.add(checker);
		
		//TODO: material precisa ficar em um único item
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;	
		checker = new CartCheckExistHdr(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	private List<DeciAction<CartInfo>> buildActionsOnPassed(DeciTreeOption<CartInfo> option) {
		List<DeciAction<CartInfo>> actions = new ArrayList<>();		
		
		DeciAction<CartInfo> enforceLChanged = new ActionCartEnforceLChanged(option);
		//DeciActionHandler<CartInfo> insertHdr = new HandlerCartInsertHdr(option.conn, option.schemaName);		
		DeciActionHandler<CartInfo> insertItm = new HandlerCartInsertItm(option.conn, option.schemaName);					
		DeciActionHandler<CartInfo> selectCart = new HandlerCartSelect(option.conn, option.schemaName);			
		
		//enforceLChanged.addPostAction(insertHdr);
		enforceLChanged.addPostAction(insertItm);
		enforceLChanged.addPostAction(selectCart);	
		
		actions.add(enforceLChanged);		
		return actions;
	}
	
	
	
	private List<DeciAction<CartInfo>> buildActionsOnFailed(DeciTreeOption<CartInfo> option) {
		List<DeciAction<CartInfo>> actions = new ArrayList<>();		
		
		DeciAction<CartInfo> enforceLChanged = new ActionCartEnforceLChanged(option);
		DeciActionHandler<CartInfo> insertHdr = new HandlerCartInsertHdr(option.conn, option.schemaName);		
		DeciActionHandler<CartInfo> insertItm = new HandlerCartInsertItm(option.conn, option.schemaName);					
		DeciActionHandler<CartInfo> selectCart = new HandlerCartSelect(option.conn, option.schemaName);			
		
		enforceLChanged.addPostAction(insertHdr);
		enforceLChanged.addPostAction(insertItm);
		enforceLChanged.addPostAction(selectCart);	
		
		actions.add(enforceLChanged);		
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
	
	
	
	@Override public DeciAction<CartInfo> toAction() {
		return tree.toAction();
	}
}
