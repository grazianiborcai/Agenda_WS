package br.com.mind5.payment.refundOrderItem.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;
import br.com.mind5.payment.refundOrderItem.info.RefemInfo;
import br.com.mind5.payment.refundOrderItem.model.action.LazyRefemRefumoipRefund;
import br.com.mind5.payment.refundOrderItem.model.action.StdRefemOrderemRefunding;
import br.com.mind5.payment.refundOrderItem.model.action.StdRefemRefumoipRefund;
import br.com.mind5.payment.refundOrderItem.model.checker.RefemCheckHasOrderem;

public final class NodeRefemRefundL2 extends DeciTreeTemplateWrite<RefemInfo> {
	
	public NodeRefemRefundL2(DeciTreeOption<RefemInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<RefemInfo> buildCheckerHook(DeciTreeOption<RefemInfo> option) {
		List<ModelChecker<RefemInfo>> queue = new ArrayList<>();		
		ModelChecker<RefemInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new RefemCheckHasOrderem(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<RefemInfo>> buildActionsOnPassedHook(DeciTreeOption<RefemInfo> option) {
		List<ActionStd<RefemInfo>> actions = new ArrayList<>();		
		
		ActionStd<RefemInfo> orderemRefunding = new StdRefemOrderemRefunding(option);
		ActionLazy<RefemInfo> refund = new LazyRefemRefumoipRefund(option.conn, option.schemaName);
		
		orderemRefunding.addPostAction(refund);
		
		actions.add(orderemRefunding);		
		return actions;
	}
	
	
	
	@Override protected List<ActionStd<RefemInfo>> buildActionsOnFailedHook(DeciTreeOption<RefemInfo> option) {
		List<ActionStd<RefemInfo>> actions = new ArrayList<>();		

		ActionStd<RefemInfo> refund = new StdRefemRefumoipRefund(option);
		
		actions.add(refund);		
		return actions;
	}
}
