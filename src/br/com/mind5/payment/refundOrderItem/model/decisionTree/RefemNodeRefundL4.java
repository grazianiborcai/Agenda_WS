package br.com.mind5.payment.refundOrderItem.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;
import br.com.mind5.payment.refundOrderItem.info.RefemInfo;
import br.com.mind5.payment.refundOrderItem.model.action.RefemVisiRefumoipRefund;
import br.com.mind5.payment.refundOrderItem.model.checker.RefemCheckIsMoip;

public final class RefemNodeRefundL4 extends DeciTreeTemplateWrite<RefemInfo> {
	
	public RefemNodeRefundL4(DeciTreeOption<RefemInfo> option) {
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
		checker = new RefemCheckIsMoip(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<RefemInfo>> buildActionsOnPassedHook(DeciTreeOption<RefemInfo> option) {
		List<ActionStd<RefemInfo>> actions = new ArrayList<>();		
		
		ActionStd <RefemInfo> refund = new ActionStdCommom <RefemInfo>(option, RefemVisiRefumoipRefund.class);
		
		actions.add(refund);		
		return actions;
	}
}
