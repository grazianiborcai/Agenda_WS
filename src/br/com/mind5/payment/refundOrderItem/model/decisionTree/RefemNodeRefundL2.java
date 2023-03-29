package br.com.mind5.payment.refundOrderItem.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;
import br.com.mind5.payment.refundOrderItem.info.RefemInfo;
import br.com.mind5.payment.refundOrderItem.model.action.RefemVisiNodeRefundL3;
import br.com.mind5.payment.refundOrderItem.model.action.RefemVisiOrderemRefunding;
import br.com.mind5.payment.refundOrderItem.model.checker.RefemCheckHasOrderem;

public final class RefemNodeRefundL2 extends DeciTreeTemplateWrite<RefemInfo> {
	
	public RefemNodeRefundL2(DeciTreeOption<RefemInfo> option) {
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
		
		ActionStd <RefemInfo> orderemRefunding = new ActionStdCommom <RefemInfo>(option, RefemVisiOrderemRefunding.class);
		ActionLazy<RefemInfo> nodeL3           = new ActionLazyCommom<RefemInfo>(option, RefemVisiNodeRefundL3.class);
		
		orderemRefunding.addPostAction(nodeL3);
		
		actions.add(orderemRefunding);		
		return actions;
	}
	
	
	
	@Override protected List<ActionStd<RefemInfo>> buildActionsOnFailedHook(DeciTreeOption<RefemInfo> option) {
		List<ActionStd<RefemInfo>> actions = new ArrayList<>();		

		ActionStd<RefemInfo> nodeL3 = new ActionStdCommom<RefemInfo>(option, RefemVisiNodeRefundL3.class);
		
		actions.add(nodeL3);		
		return actions;
	}
}
