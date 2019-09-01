package br.com.gda.payment.payOrder.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.model.decisionTree.DeciTreeWriteTemplate;
import br.com.gda.payment.payOrder.info.PayordInfo;
import br.com.gda.payment.payOrder.model.action.LazyPayordEnforceLChanged;
import br.com.gda.payment.payOrder.model.action.LazyPayordNodeMerge;
import br.com.gda.payment.payOrder.model.action.LazyPayordNodePay;
import br.com.gda.payment.payOrder.model.action.LazyPayordOrderPay;
import br.com.gda.payment.payOrder.model.action.StdPayordEnforceCreatedOn;
import br.com.gda.payment.payOrder.model.checker.PayordCheckCrecard;
import br.com.gda.payment.payOrder.model.checker.PayordCheckLangu;
import br.com.gda.payment.payOrder.model.checker.PayordCheckOrder;
import br.com.gda.payment.payOrder.model.checker.PayordCheckOwner;
import br.com.gda.payment.payOrder.model.checker.PayordCheckCuspar;
import br.com.gda.payment.payOrder.model.checker.PayordCheckUsername;
import br.com.gda.payment.payOrder.model.checker.PayordCheckPay;

public final class RootPayordPay extends DeciTreeWriteTemplate<PayordInfo> {
	
	public RootPayordPay(DeciTreeOption<PayordInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<PayordInfo> buildDecisionCheckerHook(DeciTreeOption<PayordInfo> option) {
		final boolean EXIST_ON_DB = true;
		
		List<ModelChecker<PayordInfo>> queue = new ArrayList<>();		
		ModelChecker<PayordInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checker = new PayordCheckPay();
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;	
		checker = new PayordCheckOwner(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;	
		checker = new PayordCheckLangu(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;	
		checker = new PayordCheckUsername(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;	
		checker = new PayordCheckCuspar(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;	
		checker = new PayordCheckOrder(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;	
		checker = new PayordCheckCrecard(checkerOption);
		queue.add(checker);
		//TODO: pegar CUSPAR do USERNAME ?
		//TODO: usuario pagador = usuario da ordem
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<PayordInfo>> buildActionsOnPassedHook(DeciTreeOption<PayordInfo> option) {
		List<ActionStd<PayordInfo>> actions = new ArrayList<>();		
		//TODO: Refresh Latest ???
		ActionStd<PayordInfo> enforceCreatedOn = new StdPayordEnforceCreatedOn(option);	
		ActionLazy<PayordInfo> enforceLChanged = new LazyPayordEnforceLChanged(option.conn, option.schemaName);
		ActionLazy<PayordInfo> orderPay = new LazyPayordOrderPay(option.conn, option.schemaName);
		ActionLazy<PayordInfo> nodeMerge = new LazyPayordNodeMerge(option.conn, option.schemaName);
		ActionLazy<PayordInfo> nodePay = new LazyPayordNodePay(option.conn, option.schemaName);		
		
		enforceCreatedOn.addPostAction(enforceLChanged);
		enforceLChanged.addPostAction(orderPay);			
		orderPay.addPostAction(nodeMerge);
		nodeMerge.addPostAction(nodePay);
		
		actions.add(enforceCreatedOn);		
		return actions;
	}
}
