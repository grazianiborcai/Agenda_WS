package br.com.mind5.payment.payOrderItem.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWriteV1;
import br.com.mind5.payment.payOrderItem.info.PayordemInfo;
import br.com.mind5.payment.payOrderItem.model.action.StdPayordemMergeFeecat;
import br.com.mind5.payment.payOrderItem.model.checker.PayordemCheckIsFee;

public final class NodePayordemSelectL1 extends DeciTreeTemplateWriteV1<PayordemInfo> {
	
	public NodePayordemSelectL1(DeciTreeOption<PayordemInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<PayordemInfo> buildCheckerHook(DeciTreeOption<PayordemInfo> option) {
		List<ModelCheckerV1<PayordemInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<PayordemInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new PayordemCheckIsFee(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<PayordemInfo>> buildActionsOnPassedHook(DeciTreeOption<PayordemInfo> option) {
		List<ActionStdV1<PayordemInfo>> actions = new ArrayList<>();
		
		ActionStdV1<PayordemInfo> mergeFeecat = new StdPayordemMergeFeecat(option);
		
		actions.add(mergeFeecat);
		return actions;
	}
	
	
	
	@Override protected List<ActionStdV1<PayordemInfo>> buildActionsOnFailedHook(DeciTreeOption<PayordemInfo> option) {
		List<ActionStdV1<PayordemInfo>> actions = new ArrayList<>();
		
		ActionStdV1<PayordemInfo> nodeL2 = new NodePayordemSelectL2(option).toAction();
		
		actions.add(nodeL2);
		return actions;
	}
}
