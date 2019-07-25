package br.com.gda.payment.payOrderItemStatus.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.model.decisionTree.DeciTreeWriteTemplate;
import br.com.gda.payment.payOrderItemStatus.info.PaytusemInfo;
import br.com.gda.payment.payOrderItemStatus.model.action.StdPaytusemSuccess;
import br.com.gda.payment.payOrderItemStatus.model.checker.PaytusemCheckIsFinished;

public final class NodePaytusemRefresh extends DeciTreeWriteTemplate<PaytusemInfo> {
	
	public NodePaytusemRefresh(DeciTreeOption<PaytusemInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<PaytusemInfo> buildDecisionCheckerHook(DeciTreeOption<PaytusemInfo> option) {		
		List<ModelChecker<PaytusemInfo>> queue = new ArrayList<>();		
		ModelChecker<PaytusemInfo> checker;	
		
		checker = new PaytusemCheckIsFinished();
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<PaytusemInfo>> buildActionsOnPassedHook(DeciTreeOption<PaytusemInfo> option) {
		List<ActionStd<PaytusemInfo>> actions = new ArrayList<>();		

		ActionStd<PaytusemInfo> select = new RootPaytusemSelect(option).toAction();	
		
		actions.add(select);		
		return actions;
	}
	
	
	
	@Override protected List<ActionStd<PaytusemInfo>> buildActionsOnFailedHook(DeciTreeOption<PaytusemInfo> option) {
		List<ActionStd<PaytusemInfo>> actions = new ArrayList<>();		

		ActionStd<PaytusemInfo> success = new StdPaytusemSuccess(option);	
		
		actions.add(success);		
		return actions;
	}
}
