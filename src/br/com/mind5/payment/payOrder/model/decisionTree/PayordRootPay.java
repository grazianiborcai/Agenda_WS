package br.com.mind5.payment.payOrder.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;
import br.com.mind5.payment.payOrder.info.PayordInfo;
import br.com.mind5.payment.payOrder.model.action.PayordVisiNodeInsert;
import br.com.mind5.payment.payOrder.model.action.PayordVisiNodeOrder;
import br.com.mind5.payment.payOrder.model.action.PayordVisiNodePay;
import br.com.mind5.payment.payOrder.model.action.PayordVisiObfuscate;
import br.com.mind5.payment.payOrder.model.checker.PayordCheckCrecard;
import br.com.mind5.payment.payOrder.model.checker.PayordCheckLangu;
import br.com.mind5.payment.payOrder.model.checker.PayordCheckOrder;
import br.com.mind5.payment.payOrder.model.checker.PayordCheckOwner;
import br.com.mind5.payment.payOrder.model.checker.PayordCheckPay;
import br.com.mind5.payment.payOrder.model.checker.PayordCheckUsername;

public final class PayordRootPay extends DeciTreeTemplateWrite<PayordInfo> {
	
	public PayordRootPay(DeciTreeOption<PayordInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<PayordInfo> buildCheckerHook(DeciTreeOption<PayordInfo> option) {
		List<ModelChecker<PayordInfo>> queue = new ArrayList<>();		
		ModelChecker<PayordInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new PayordCheckPay(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new PayordCheckOwner(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new PayordCheckLangu(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new PayordCheckUsername(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new PayordCheckOrder(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new PayordCheckCrecard(checkerOption);
		queue.add(checker);

		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<PayordInfo>> buildActionsOnPassedHook(DeciTreeOption<PayordInfo> option) {
		List<ActionStd<PayordInfo>> actions = new ArrayList<>();		
		//TODO: Refresh Latest ???
		ActionStd<PayordInfo> nodeAuth = new PayordNodeAuthL1(option).toAction();
		ActionStd<PayordInfo> nodeUser = new PayordNodeUser(option).toAction();
		ActionLazy<PayordInfo> nodeOrder = new ActionLazyCommom<PayordInfo>(option, PayordVisiNodeOrder.class);
		ActionLazy<PayordInfo> nodeInsert = new ActionLazyCommom<PayordInfo>(option, PayordVisiNodeInsert.class);
		ActionLazy<PayordInfo> nodePay = new ActionLazyCommom<PayordInfo>(option, PayordVisiNodePay.class);
		ActionLazy<PayordInfo> obfuscate = new ActionLazyCommom<PayordInfo>(option, PayordVisiObfuscate.class);
		
		nodeUser.addPostAction(nodeOrder);
		nodeOrder.addPostAction(nodeInsert);
		nodeInsert.addPostAction(nodePay);
		nodePay.addPostAction(obfuscate);
		
		actions.add(nodeAuth);
		actions.add(nodeUser);
		return actions;
	}
}
