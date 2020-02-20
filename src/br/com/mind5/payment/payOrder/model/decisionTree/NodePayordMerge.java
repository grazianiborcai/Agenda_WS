package br.com.mind5.payment.payOrder.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeWriteTemplate;
import br.com.mind5.payment.payOrder.info.PayordInfo;
import br.com.mind5.payment.payOrder.model.action.LazyPayordMergeCrecard;
import br.com.mind5.payment.payOrder.model.action.LazyPayordMergeLatest;
import br.com.mind5.payment.payOrder.model.action.LazyPayordMergeOrder;
import br.com.mind5.payment.payOrder.model.action.LazyPayordMergeSyspar;
import br.com.mind5.payment.payOrder.model.action.LazyPayordMergeUsername;
import br.com.mind5.payment.payOrder.model.action.StdPayordMergeCuspar;
import br.com.mind5.payment.payOrder.model.checker.PayordCheckPay;

public final class NodePayordMerge extends DeciTreeWriteTemplate<PayordInfo> {
	
	public NodePayordMerge(DeciTreeOption<PayordInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<PayordInfo> buildDecisionCheckerHook(DeciTreeOption<PayordInfo> option) {
		List<ModelChecker<PayordInfo>> queue = new ArrayList<>();		
		ModelChecker<PayordInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new PayordCheckPay(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<PayordInfo>> buildActionsOnPassedHook(DeciTreeOption<PayordInfo> option) {
		List<ActionStd<PayordInfo>> actions = new ArrayList<>();		

		ActionStd<PayordInfo> mergeCuspar = new StdPayordMergeCuspar(option);
		ActionLazy<PayordInfo> mergeSyspar = new LazyPayordMergeSyspar(option.conn, option.schemaName);
		ActionLazy<PayordInfo> mergeUsername = new LazyPayordMergeUsername(option.conn, option.schemaName);
		ActionLazy<PayordInfo> mergeOrder = new LazyPayordMergeOrder(option.conn, option.schemaName);
		ActionLazy<PayordInfo> mergeCrecard = new LazyPayordMergeCrecard(option.conn, option.schemaName);		
		ActionLazy<PayordInfo> mergeLatest = new LazyPayordMergeLatest(option.conn, option.schemaName);	
			
		mergeCuspar.addPostAction(mergeSyspar);	
		mergeSyspar.addPostAction(mergeUsername);
		mergeUsername.addPostAction(mergeOrder);
		mergeOrder.addPostAction(mergeCrecard);
		mergeCrecard.addPostAction(mergeLatest);
		
		actions.add(mergeCuspar);		
		return actions;
	}
}
