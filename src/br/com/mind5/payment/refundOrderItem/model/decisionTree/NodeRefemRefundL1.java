package br.com.mind5.payment.refundOrderItem.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWriteV2;
import br.com.mind5.payment.refundOrderItem.info.RefemInfo;
import br.com.mind5.payment.refundOrderItem.model.action.StdRefemSuccess;
import br.com.mind5.payment.refundOrderItem.model.checker.RefemCheckReverted;

public final class NodeRefemRefundL1 extends DeciTreeTemplateWriteV2<RefemInfo> {
	
	public NodeRefemRefundL1(DeciTreeOption<RefemInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<RefemInfo> buildCheckerHook(DeciTreeOption<RefemInfo> option) {
		List<ModelCheckerV1<RefemInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<RefemInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.NOT_FOUND;	
		checker = new RefemCheckReverted(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<RefemInfo>> buildActionsOnPassedHook(DeciTreeOption<RefemInfo> option) {
		List<ActionStdV1<RefemInfo>> actions = new ArrayList<>();		
		
		ActionStdV1<RefemInfo> nodeL2 = new NodeRefemRefundL2(option).toAction();
		
		actions.add(nodeL2);		
		return actions;
	}
	
	
	
	@Override protected List<ActionStdV1<RefemInfo>> buildActionsOnFailedHook(DeciTreeOption<RefemInfo> option) {
		List<ActionStdV1<RefemInfo>> actions = new ArrayList<>();		

		ActionStdV1<RefemInfo> success = new StdRefemSuccess(option);
		
		actions.add(success);		
		return actions;
	}
}
