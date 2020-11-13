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
import br.com.mind5.payment.refundOrderItem.model.action.LazyRefemMergeUsername;
import br.com.mind5.payment.refundOrderItem.model.action.LazyRefemNodeAuthL1;
import br.com.mind5.payment.refundOrderItem.model.action.LazyRefemRootRefund;
import br.com.mind5.payment.refundOrderItem.model.action.StdRefemMergePayormarch;
import br.com.mind5.payment.refundOrderItem.model.checker.RefemCheckLangu;
import br.com.mind5.payment.refundOrderItem.model.checker.RefemCheckOrder;
import br.com.mind5.payment.refundOrderItem.model.checker.RefemCheckOrderem;
import br.com.mind5.payment.refundOrderItem.model.checker.RefemCheckOwner;
import br.com.mind5.payment.refundOrderItem.model.checker.RefemCheckRefundAuth;
import br.com.mind5.payment.refundOrderItem.model.checker.RefemCheckUsername;

public final class RootRefemRefundAuth extends DeciTreeTemplateWrite<RefemInfo> {
	
	public RootRefemRefundAuth(DeciTreeOption<RefemInfo> option) {
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
		checker = new RefemCheckRefundAuth(checkerOption);
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
		checker = new RefemCheckOrder(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new RefemCheckOrderem(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<RefemInfo>> buildActionsOnPassedHook(DeciTreeOption<RefemInfo> option) {
		List<ActionStd<RefemInfo>> actions = new ArrayList<>();		

		ActionStd<RefemInfo> mergePayormarch = new StdRefemMergePayormarch(option);	
		ActionLazy<RefemInfo> mergeUsername = new LazyRefemMergeUsername(option.conn, option.schemaName);
		ActionLazy<RefemInfo> nodeAuth = new LazyRefemNodeAuthL1(option.conn, option.schemaName);
		ActionLazy<RefemInfo> refund = new LazyRefemRootRefund(option.conn, option.schemaName);
		
		mergePayormarch.addPostAction(mergeUsername);
		mergeUsername.addPostAction(nodeAuth);	
		nodeAuth.addPostAction(refund);
		
		actions.add(mergePayormarch);		
		return actions;
	}
}
