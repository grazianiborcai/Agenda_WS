package br.com.mind5.payment.payOrderItem.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWriteV2;
import br.com.mind5.payment.payOrderItem.info.PayordemInfo;
import br.com.mind5.payment.payOrderItem.model.action.StdPayordemOrderemPay;
import br.com.mind5.payment.payOrderItem.model.action.StdPayordemSuccess;
import br.com.mind5.payment.payOrderItem.model.checker.PayordemCheckHasOrderem;

public final class NodePayordemPay extends DeciTreeTemplateWriteV2<PayordemInfo> {
	
	public NodePayordemPay(DeciTreeOption<PayordemInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<PayordemInfo> buildCheckerHook(DeciTreeOption<PayordemInfo> option) {
		List<ModelCheckerV1<PayordemInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<PayordemInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new PayordemCheckHasOrderem(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV2<PayordemInfo>> buildActionsOnPassedHook(DeciTreeOption<PayordemInfo> option) {
		List<ActionStdV2<PayordemInfo>> actions = new ArrayList<>();
		
		ActionStdV2<PayordemInfo> orderemPay = new StdPayordemOrderemPay(option);
		
		actions.add(orderemPay);
		return actions;
	}
	
	
	
	@Override protected List<ActionStdV2<PayordemInfo>> buildActionsOnFailedHook(DeciTreeOption<PayordemInfo> option) {
		List<ActionStdV2<PayordemInfo>> actions = new ArrayList<>();
		
		ActionStdV2<PayordemInfo> success = new StdPayordemSuccess(option);
		
		actions.add(success);
		return actions;
	}
}
