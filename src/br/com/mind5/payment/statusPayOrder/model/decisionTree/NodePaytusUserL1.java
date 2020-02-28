package br.com.mind5.payment.statusPayOrder.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeWriteTemplate;
import br.com.mind5.payment.statusPayOrder.info.PaytusInfo;
import br.com.mind5.payment.statusPayOrder.model.action.LazyPaytusNodeUserL2;
import br.com.mind5.payment.statusPayOrder.model.action.StdPaytusMergeUsername;
import br.com.mind5.payment.statusPayOrder.model.checker.PaytusCheckDummy;

public final class NodePaytusUserL1 extends DeciTreeWriteTemplate<PaytusInfo> {
	
	public NodePaytusUserL1(DeciTreeOption<PaytusInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<PaytusInfo> buildDecisionCheckerHook(DeciTreeOption<PaytusInfo> option) {
		List<ModelChecker<PaytusInfo>> queue = new ArrayList<>();		
		ModelChecker<PaytusInfo> checker;	

		checker = new PaytusCheckDummy();
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<PaytusInfo>> buildActionsOnPassedHook(DeciTreeOption<PaytusInfo> option) {
		List<ActionStd<PaytusInfo>> actions = new ArrayList<>();		

		ActionStd<PaytusInfo> mergeUsername = new StdPaytusMergeUsername(option);
		ActionLazy<PaytusInfo> nodeL2 = new LazyPaytusNodeUserL2(option.conn, option.schemaName);
		
		mergeUsername.addPostAction(nodeL2);
		
		actions.add(mergeUsername);		
		return actions;
	}
}
