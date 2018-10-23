package br.com.gda.business.order.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.order.info.OrderInfo;
import br.com.gda.business.order.model.action.StdOrderCopyCart;
import br.com.gda.business.order.model.action.LazyOrderEnforceExtid;
import br.com.gda.business.order.model.action.LazyOrderEnforceLChanged;
import br.com.gda.business.order.model.action.LazyOrderFilterExtra;
import br.com.gda.business.order.model.action.LazyOrderFilterItm;
import br.com.gda.business.order.model.action.LazyOrderFlagExtra;
import br.com.gda.business.order.model.action.LazyOrderFlagItem;
import br.com.gda.business.order.model.action.LazyOrderInsertHdrFirst;
import br.com.gda.business.order.model.action.LazyOrderInsertItm;
import br.com.gda.business.order.model.action.LazyOrderMergeCus;
import br.com.gda.business.order.model.action.LazyOrderMergeEmp;
import br.com.gda.business.order.model.action.LazyOrderMergeMat;
import br.com.gda.business.order.model.action.LazyOrderMergeStore;
import br.com.gda.business.order.model.action.MultiOrderMergeExtra;
import br.com.gda.business.order.model.checker.OrderCheckCart;
import br.com.gda.business.order.model.checker.OrderCheckWrite;
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

public final class RootOrderInsert implements DeciTree<OrderInfo> {
	private DeciTree<OrderInfo> tree;
	
	
	public RootOrderInsert(DeciTreeOption<OrderInfo> option) {
		DeciTreeHelperOption<OrderInfo> helperOption = new DeciTreeHelperOption<>();
		
		helperOption.visitorChecker = buildDecisionChecker(option);
		helperOption.recordInfos = option.recordInfos;
		helperOption.conn = option.conn;
		helperOption.actionsOnPassed = buildActionsOnPassed(option);
		
		tree = new DeciTreeHelper<>(helperOption);
	}
	
	
	
	private ModelChecker<OrderInfo> buildDecisionChecker(DeciTreeOption<OrderInfo> option) {
		final boolean EXIST_ON_DB = true;
		
		List<ModelChecker<OrderInfo>> queue = new ArrayList<>();		
		ModelChecker<OrderInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checker = new OrderCheckWrite();
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;	
		checker = new OrderCheckCart(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	private List<ActionStd<OrderInfo>> buildActionsOnPassed(DeciTreeOption<OrderInfo> option) {
		List<ActionStd<OrderInfo>> actions = new ArrayList<>();		
		
		ActionStd<OrderInfo> copyCart = new StdOrderCopyCart(option);
		ActionLazy<OrderInfo> filterItm = new LazyOrderFilterItm(option.conn, option.schemaName);
		ActionLazy<OrderInfo> flagItm = new LazyOrderFlagItem(option.conn, option.schemaName);
		ActionLazy<OrderInfo> filterExtra = new LazyOrderFilterExtra(option.conn, option.schemaName);
		ActionLazy<OrderInfo> flagExtra = new LazyOrderFlagExtra(option.conn, option.schemaName);
		ActionLazy<OrderInfo> enforceLChanged = new LazyOrderEnforceLChanged(option.conn, option.schemaName);
		ActionLazy<OrderInfo> enforceExtid = new LazyOrderEnforceExtid(option.conn, option.schemaName);
		ActionLazy<OrderInfo> mergeEmp = new LazyOrderMergeEmp(option.conn, option.schemaName);
		ActionLazy<OrderInfo> mergeCus = new LazyOrderMergeCus(option.conn, option.schemaName);
		ActionLazy<OrderInfo> mergeMat = new LazyOrderMergeMat(option.conn, option.schemaName);
		ActionLazy<OrderInfo> mergeStore = new LazyOrderMergeStore(option.conn, option.schemaName);
		ActionLazy<OrderInfo> insertHdr = new LazyOrderInsertHdrFirst(option.conn, option.schemaName);
		ActionLazy<OrderInfo> insertItm = new LazyOrderInsertItm(option.conn, option.schemaName);
		ActionLazy<OrderInfo> mergeExtra = new MultiOrderMergeExtra(option.conn, option.schemaName);
		ActionLazy<OrderInfo> insertExtra = new LazyOrderInsertItm(option.conn, option.schemaName);
		
		copyCart.addPostAction(filterItm);
		copyCart.addPostAction(filterExtra);
		filterExtra.addPostAction(flagExtra);
		flagExtra.addPostAction(mergeExtra);
		filterItm.addPostAction(flagItm);
		flagItm.addPostAction(enforceLChanged);
		enforceLChanged.addPostAction(enforceExtid);
		enforceExtid.addPostAction(mergeEmp);
		mergeEmp.addPostAction(mergeCus);
		mergeCus.addPostAction(mergeMat);		
		mergeMat.addPostAction(mergeStore);
		mergeStore.addPostAction(insertHdr);
		insertHdr.addPostAction(insertItm);	
		insertHdr.addPostAction(mergeExtra);
		mergeExtra.addPostAction(insertExtra);		
		//TODO: Adicinar Acao para leitura da Ordem ou retornar msg de sucesso
		actions.add(copyCart);		
		return actions;
	}
	
	
	
	@Override public void makeDecision() {
		tree.makeDecision();
	}
		

	
	@Override public DeciChoice getDecisionMade() {
		return tree.getDecisionMade();
	}
	
	
	
	@Override public DeciResult<OrderInfo> getDecisionResult() {
		return tree.getDecisionResult();
	}
	
	
	
	@Override public ActionStd<OrderInfo> toAction() {
		return tree.toAction();
	}
}
