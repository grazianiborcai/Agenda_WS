package br.com.gda.payment.refundOrderItem.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.model.decisionTree.DeciTreeWriteTemplate;
import br.com.gda.payment.refundOrderItem.info.RefemInfo;
import br.com.gda.payment.refundOrderItem.model.action.LazyRefemMergeCuspar;
import br.com.gda.payment.refundOrderItem.model.action.LazyRefemMergePayord;
import br.com.gda.payment.refundOrderItem.model.action.LazyRefemrefumoipRefund;
import br.com.gda.payment.refundOrderItem.model.action.StdRefemMergePayordem;
import br.com.gda.payment.refundOrderItem.model.checker.RefemCheckLangu;
import br.com.gda.payment.refundOrderItem.model.checker.RefemCheckOwner;
import br.com.gda.payment.refundOrderItem.model.checker.RefemCheckPayord;
import br.com.gda.payment.refundOrderItem.model.checker.RefemCheckRefund;
import br.com.gda.payment.refundOrderItem.model.checker.RefemCheckUsername;

public final class RootRefemRefund extends DeciTreeWriteTemplate<RefemInfo> {
	
	public RootRefemRefund(DeciTreeOption<RefemInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<RefemInfo> buildDecisionCheckerHook(DeciTreeOption<RefemInfo> option) {
		final boolean EXIST_ON_DB = true;
		
		List<ModelChecker<RefemInfo>> queue = new ArrayList<>();		
		ModelChecker<RefemInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checker = new RefemCheckRefund();
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;	
		checker = new RefemCheckOwner(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;	
		checker = new RefemCheckLangu(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;	
		checker = new RefemCheckUsername(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;	
		checker = new RefemCheckPayord(checkerOption);
		queue.add(checker);
		
		//TODO: usuario pagador = usuario da ordem
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<RefemInfo>> buildActionsOnPassedHook(DeciTreeOption<RefemInfo> option) {
		List<ActionStd<RefemInfo>> actions = new ArrayList<>();		

		ActionStd<RefemInfo> mergePayordem = new StdRefemMergePayordem(option);	
		ActionLazy<RefemInfo> mergePayord = new LazyRefemMergePayord(option.conn, option.schemaName);
		ActionLazy<RefemInfo> mergeCuspar = new LazyRefemMergeCuspar(option.conn, option.schemaName);
		ActionLazy<RefemInfo> refund = new LazyRefemrefumoipRefund(option.conn, option.schemaName);
		
		mergePayordem.addPostAction(mergePayord);
		mergePayord.addPostAction(mergeCuspar);	
		mergeCuspar.addPostAction(refund);
		
		actions.add(mergePayordem);		
		return actions;
	}
}
