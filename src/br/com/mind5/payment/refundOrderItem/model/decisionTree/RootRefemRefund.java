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

public final class RootRefemRefund extends DeciTreeTemplateWrite<RefemInfo> {
	
	public RootRefemRefund(DeciTreeOption<RefemInfo> option) {
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
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<RefemInfo>> buildActionsOnPassedHook(DeciTreeOption<RefemInfo> option) {
		List<ActionStd<RefemInfo>> actions = new ArrayList<>();		

		ActionStd<RefemInfo> mergePayordem = new StdRefemMergePayordem(option);	
		ActionLazy<RefemInfo> mergePayord = new LazyRefemMergePayord(option.conn, option.schemaName);
		ActionLazy<RefemInfo> mergeCuspar = new LazyRefemMergeCuspar(option.conn, option.schemaName);
		ActionLazy<RefemInfo> refund = new LazyRefemNodeRefundL1(option.conn, option.schemaName);
		
		mergePayordem.addPostAction(mergePayord);
		mergePayord.addPostAction(mergeCuspar);	
		mergeCuspar.addPostAction(refund);
		
		actions.add(mergePayordem);		
		return actions;
	}
}
