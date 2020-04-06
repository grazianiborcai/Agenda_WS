package br.com.mind5.payment.refundOrder.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;
import br.com.mind5.payment.refundOrder.info.RefuInfo;
import br.com.mind5.payment.refundOrder.model.action.LazyRefuNodeRefund;
import br.com.mind5.payment.refundOrder.model.checker.RefuCheckLangu;
import br.com.mind5.payment.refundOrder.model.checker.RefuCheckOrder;
import br.com.mind5.payment.refundOrder.model.checker.RefuCheckOwner;
import br.com.mind5.payment.refundOrder.model.checker.RefuCheckRefund;
import br.com.mind5.payment.refundOrder.model.checker.RefuCheckUsername;

public final class RootRefuRefund extends DeciTreeTemplateWrite<RefuInfo> {
	
	public RootRefuRefund(DeciTreeOption<RefuInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<RefuInfo> buildCheckerHook(DeciTreeOption<RefuInfo> option) {
		List<ModelCheckerV1<RefuInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<RefuInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new RefuCheckRefund(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new RefuCheckOwner(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new RefuCheckLangu(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new RefuCheckUsername(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new RefuCheckOrder(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<RefuInfo>> buildActionsOnPassedHook(DeciTreeOption<RefuInfo> option) {
		List<ActionStdV1<RefuInfo>> actions = new ArrayList<>();		

		ActionStdV1<RefuInfo> nodeOrder = new NodeRefuOrder(option).toAction();
		ActionLazyV1<RefuInfo> nodeRefund = new LazyRefuNodeRefund(option.conn, option.schemaName);
		
		nodeOrder.addPostAction(nodeRefund);
		
		actions.add(nodeOrder);		
		return actions;
	}
}
