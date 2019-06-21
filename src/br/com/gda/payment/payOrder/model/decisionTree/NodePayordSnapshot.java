package br.com.gda.payment.payOrder.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.model.decisionTree.DeciTreeWriteTemplate;
import br.com.gda.payment.payOrder.info.PayordInfo;
import br.com.gda.payment.payOrder.model.action.LazyPayordUpdate;
import br.com.gda.payment.payOrder.model.action.StdPayordInsertStoparnap;
import br.com.gda.payment.payOrder.model.checker.PayordCheckWrite;

public final class NodePayordSnapshot extends DeciTreeWriteTemplate<PayordInfo> {
	
	public NodePayordSnapshot(DeciTreeOption<PayordInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<PayordInfo> buildDecisionCheckerHook(DeciTreeOption<PayordInfo> option) {
		List<ModelChecker<PayordInfo>> queue = new ArrayList<>();		
		ModelChecker<PayordInfo> checker;

		checker = new PayordCheckWrite();
		queue.add(checker);	
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<PayordInfo>> buildActionsOnPassedHook(DeciTreeOption<PayordInfo> option) {
		List<ActionStd<PayordInfo>> actions = new ArrayList<>();
		
		ActionStd<PayordInfo> InsertStoparnap = new StdPayordInsertStoparnap(option); 
		ActionLazy<PayordInfo> updateStopar = new LazyPayordUpdate(option.conn, option.schemaName); 
		
		InsertStoparnap.addPostAction(updateStopar);
		
		actions.add(InsertStoparnap);
		return actions;
	}
}
