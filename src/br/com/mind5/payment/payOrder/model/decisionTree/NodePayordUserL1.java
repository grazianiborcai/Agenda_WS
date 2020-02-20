package br.com.mind5.payment.payOrder.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeWriteTemplate;
import br.com.mind5.payment.payOrder.info.PayordInfo;
import br.com.mind5.payment.payOrder.model.action.LazyPayordNodeUserL2;
import br.com.mind5.payment.payOrder.model.action.StdPayordMergeUsername;
import br.com.mind5.payment.payOrder.model.checker.PayordCheckDummy;

public final class NodePayordUserL1 extends DeciTreeWriteTemplate<PayordInfo> {
	
	public NodePayordUserL1(DeciTreeOption<PayordInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<PayordInfo> buildDecisionCheckerHook(DeciTreeOption<PayordInfo> option) {
		List<ModelChecker<PayordInfo>> queue = new ArrayList<>();		
		ModelChecker<PayordInfo> checker;	

		checker = new PayordCheckDummy();
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<PayordInfo>> buildActionsOnPassedHook(DeciTreeOption<PayordInfo> option) {
		List<ActionStd<PayordInfo>> actions = new ArrayList<>();		

		ActionStd<PayordInfo> mergeUsername = new StdPayordMergeUsername(option);
		ActionLazy<PayordInfo> nodeL2 = new LazyPayordNodeUserL2(option.conn, option.schemaName);
		
		mergeUsername.addPostAction(nodeL2);
		
		actions.add(mergeUsername);		
		return actions;
	}
}
