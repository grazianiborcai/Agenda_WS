package br.com.mind5.payment.refundOrderItem.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeWriteTemplate;
import br.com.mind5.payment.refundOrderItem.info.RefemInfo;
import br.com.mind5.payment.refundOrderItem.model.action.LazyRefemMergeCuspar;
import br.com.mind5.payment.refundOrderItem.model.action.LazyRefemMergePayord;
import br.com.mind5.payment.refundOrderItem.model.action.LazyRefemRefumoipRefund;
import br.com.mind5.payment.refundOrderItem.model.action.StdRefemMergePayordem;
import br.com.mind5.payment.refundOrderItem.model.checker.RefemCheckLangu;
import br.com.mind5.payment.refundOrderItem.model.checker.RefemCheckOwner;
import br.com.mind5.payment.refundOrderItem.model.checker.RefemCheckPayord;
import br.com.mind5.payment.refundOrderItem.model.checker.RefemCheckRefund;
import br.com.mind5.payment.refundOrderItem.model.checker.RefemCheckUsername;

public final class RootRefemRefund extends DeciTreeWriteTemplate<RefemInfo> {
	
	public RootRefemRefund(DeciTreeOption<RefemInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<RefemInfo> buildDecisionCheckerHook(DeciTreeOption<RefemInfo> option) {
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
		
		//TODO: somente Manager pode estornar ?
		//TODO: Cada Manager somente pode estornar sua Ordem ?
		//TODO: verificar se ja foi estornado
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<RefemInfo>> buildActionsOnPassedHook(DeciTreeOption<RefemInfo> option) {
		List<ActionStd<RefemInfo>> actions = new ArrayList<>();		

		ActionStd<RefemInfo> mergePayordem = new StdRefemMergePayordem(option);	
		ActionLazy<RefemInfo> mergePayord = new LazyRefemMergePayord(option.conn, option.schemaName);
		ActionLazy<RefemInfo> mergeCuspar = new LazyRefemMergeCuspar(option.conn, option.schemaName);
		ActionLazy<RefemInfo> refund = new LazyRefemRefumoipRefund(option.conn, option.schemaName);
		
		mergePayordem.addPostAction(mergePayord);
		mergePayord.addPostAction(mergeCuspar);	
		mergeCuspar.addPostAction(refund);
		
		actions.add(mergePayordem);		
		return actions;
	}
}
