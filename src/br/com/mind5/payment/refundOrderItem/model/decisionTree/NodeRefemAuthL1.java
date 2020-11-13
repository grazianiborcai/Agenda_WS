package br.com.mind5.payment.refundOrderItem.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWriteV2;
import br.com.mind5.payment.refundOrderItem.info.RefemInfo;
import br.com.mind5.payment.refundOrderItem.model.action.StdRefemSuccess;
import br.com.mind5.payment.refundOrderItem.model.checker.RefemCheckAuthOwner;

public final class NodeRefemAuthL1 extends DeciTreeTemplateWriteV2<RefemInfo> {
	
	public NodeRefemAuthL1(DeciTreeOption<RefemInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<RefemInfo> buildCheckerHook(DeciTreeOption<RefemInfo> option) {
		List<ModelCheckerV1<RefemInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<RefemInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new RefemCheckAuthOwner(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV2<RefemInfo>> buildActionsOnPassedHook(DeciTreeOption<RefemInfo> option) {
		List<ActionStdV2<RefemInfo>> actions = new ArrayList<>();		

		ActionStdV2<RefemInfo> success = new StdRefemSuccess(option);
		
		actions.add(success);		
		return actions;
	}
	
	
	
	@Override protected List<ActionStdV2<RefemInfo>> buildActionsOnFailedHook(DeciTreeOption<RefemInfo> option) {
		List<ActionStdV2<RefemInfo>> actions = new ArrayList<>();		
	
		ActionStdV2<RefemInfo> nodeL2 = new NodeRefemAuthL2(option).toAction();	
		
		actions.add(nodeL2);		
		return actions;
	}
}
