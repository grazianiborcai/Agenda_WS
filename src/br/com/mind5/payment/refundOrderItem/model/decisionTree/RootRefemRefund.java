package br.com.mind5.payment.refundOrderItem.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWriteV2;
import br.com.mind5.payment.refundOrderItem.info.RefemInfo;
import br.com.mind5.payment.refundOrderItem.model.action.LazyRefemMergeCuspar;
import br.com.mind5.payment.refundOrderItem.model.action.LazyRefemMergePayord;
import br.com.mind5.payment.refundOrderItem.model.action.LazyRefemNodeRefundL1;
import br.com.mind5.payment.refundOrderItem.model.action.StdRefemMergePayordem;
import br.com.mind5.payment.refundOrderItem.model.checker.RefemCheckLangu;
import br.com.mind5.payment.refundOrderItem.model.checker.RefemCheckOwner;
import br.com.mind5.payment.refundOrderItem.model.checker.RefemCheckPayord;
import br.com.mind5.payment.refundOrderItem.model.checker.RefemCheckPayordem;
import br.com.mind5.payment.refundOrderItem.model.checker.RefemCheckRefund;
import br.com.mind5.payment.refundOrderItem.model.checker.RefemCheckUsername;

public final class RootRefemRefund extends DeciTreeTemplateWriteV2<RefemInfo> {
	
	public RootRefemRefund(DeciTreeOption<RefemInfo> option) {
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
		checker = new RefemCheckRefund(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new RefemCheckOwner(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new RefemCheckLangu(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new RefemCheckUsername(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new RefemCheckPayord(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new RefemCheckPayordem(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<RefemInfo>> buildActionsOnPassedHook(DeciTreeOption<RefemInfo> option) {
		List<ActionStdV1<RefemInfo>> actions = new ArrayList<>();		

		ActionStdV1<RefemInfo> mergePayordem = new StdRefemMergePayordem(option);	
		ActionLazyV1<RefemInfo> mergePayord = new LazyRefemMergePayord(option.conn, option.schemaName);
		ActionLazyV1<RefemInfo> mergeCuspar = new LazyRefemMergeCuspar(option.conn, option.schemaName);
		ActionLazyV1<RefemInfo> refund = new LazyRefemNodeRefundL1(option.conn, option.schemaName);
		
		mergePayordem.addPostAction(mergePayord);
		mergePayord.addPostAction(mergeCuspar);	
		mergeCuspar.addPostAction(refund);
		
		actions.add(mergePayordem);		
		return actions;
	}
}
