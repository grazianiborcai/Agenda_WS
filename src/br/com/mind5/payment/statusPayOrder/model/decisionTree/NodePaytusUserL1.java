package br.com.mind5.payment.statusPayOrder.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;
import br.com.mind5.payment.statusPayOrder.info.PaytusInfo;
import br.com.mind5.payment.statusPayOrder.model.action.LazyPaytusNodeUserL2;
import br.com.mind5.payment.statusPayOrder.model.action.StdPaytusMergeUsername;
import br.com.mind5.payment.statusPayOrder.model.checker.PaytusCheckDummy;

public final class NodePaytusUserL1 extends DeciTreeTemplateWrite<PaytusInfo> {
	
	public NodePaytusUserL1(DeciTreeOption<PaytusInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<PaytusInfo> buildCheckerHook(DeciTreeOption<PaytusInfo> option) {
		List<ModelCheckerV1<PaytusInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<PaytusInfo> checker;	

		checker = new PaytusCheckDummy();
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<PaytusInfo>> buildActionsOnPassedHook(DeciTreeOption<PaytusInfo> option) {
		List<ActionStdV1<PaytusInfo>> actions = new ArrayList<>();		

		ActionStdV1<PaytusInfo> mergeUsername = new StdPaytusMergeUsername(option);
		ActionLazyV1<PaytusInfo> nodeL2 = new LazyPaytusNodeUserL2(option.conn, option.schemaName);
		
		mergeUsername.addPostAction(nodeL2);
		
		actions.add(mergeUsername);		
		return actions;
	}
}
