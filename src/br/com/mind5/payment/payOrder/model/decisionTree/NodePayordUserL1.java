package br.com.mind5.payment.payOrder.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeWriteTemplate;
import br.com.mind5.payment.payOrder.info.PayordInfo;
import br.com.mind5.payment.payOrder.model.action.LazyPayordEnforceLChanged;
import br.com.mind5.payment.payOrder.model.action.LazyPayordMergeUsername;
import br.com.mind5.payment.payOrder.model.action.LazyPayordNodeUserL2;
import br.com.mind5.payment.payOrder.model.action.StdPayordEnforceCreatedOn;
import br.com.mind5.payment.payOrder.model.checker.PayordCheckDummy;

public final class NodePayordUserL1 extends DeciTreeWriteTemplate<PayordInfo> {
	
	public NodePayordUserL1(DeciTreeOption<PayordInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<PayordInfo> buildCheckerHook(DeciTreeOption<PayordInfo> option) {
		List<ModelChecker<PayordInfo>> queue = new ArrayList<>();		
		ModelChecker<PayordInfo> checker;	

		checker = new PayordCheckDummy();
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<PayordInfo>> buildActionsOnPassedHook(DeciTreeOption<PayordInfo> option) {
		List<ActionStdV1<PayordInfo>> actions = new ArrayList<>();		

		ActionStdV1<PayordInfo> enforceCreatedOn = new StdPayordEnforceCreatedOn(option);	
		ActionLazyV1<PayordInfo> enforceLChanged = new LazyPayordEnforceLChanged(option.conn, option.schemaName);
		ActionLazyV1<PayordInfo> mergeUsername = new LazyPayordMergeUsername(option.conn, option.schemaName);
		ActionLazyV1<PayordInfo> nodeL2 = new LazyPayordNodeUserL2(option.conn, option.schemaName);
		
		enforceCreatedOn.addPostAction(enforceLChanged);
		enforceLChanged.addPostAction(mergeUsername);
		mergeUsername.addPostAction(nodeL2);
		
		actions.add(enforceCreatedOn);		
		return actions;
	}
}
