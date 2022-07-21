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
import br.com.mind5.payment.refundOrderItem.model.action.RefemVisiNodeAuthL1;
import br.com.mind5.payment.refundOrderItem.model.action.RefemVisiRootRefund;
import br.com.mind5.payment.refundOrderItem.model.action.RefemVisiMergePayormarch;
import br.com.mind5.payment.refundOrderItem.model.action.RefemVisiMergeUsername;
import br.com.mind5.payment.refundOrderItem.model.checker.RefemCheckLangu;
import br.com.mind5.payment.refundOrderItem.model.checker.RefemCheckOrder;
import br.com.mind5.payment.refundOrderItem.model.checker.RefemCheckOrderem;
import br.com.mind5.payment.refundOrderItem.model.checker.RefemCheckOwner;
import br.com.mind5.payment.refundOrderItem.model.checker.RefemCheckRefundAuth;
import br.com.mind5.payment.refundOrderItem.model.checker.RefemCheckUsername;

public final class RefemRootRefundAuth extends DeciTreeTemplateWrite<RefemInfo> {
	
	public RefemRootRefundAuth(DeciTreeOption<RefemInfo> option) {
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

		ActionStd<RefemInfo> mergePayormarch = new ActionStdCommom<RefemInfo>(option, RefemVisiMergePayormarch.class);	
		ActionLazy<RefemInfo> mergeUsername = new ActionLazyCommom<RefemInfo>(option, RefemVisiMergeUsername.class);
		ActionLazy<RefemInfo> nodeAuth = new ActionLazyCommom<RefemInfo>(option, RefemVisiNodeAuthL1.class);
		ActionLazy<RefemInfo> refund = new ActionLazyCommom<RefemInfo>(option, RefemVisiRootRefund.class);
		
		mergePayormarch.addPostAction(mergeUsername);
		mergeUsername.addPostAction(nodeAuth);	
		nodeAuth.addPostAction(refund);
		
		actions.add(mergePayormarch);		
		return actions;
	}
}
