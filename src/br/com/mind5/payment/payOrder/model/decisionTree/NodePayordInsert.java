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
import br.com.mind5.payment.payOrder.model.action.LazyPayordEnforceFee;
import br.com.mind5.payment.payOrder.model.action.LazyPayordEnforceItem;
import br.com.mind5.payment.payOrder.model.action.LazyPayordInsert;
import br.com.mind5.payment.payOrder.model.action.LazyPayordInsertPayordem;
import br.com.mind5.payment.payOrder.model.action.StdPayordMergeCrecard;
import br.com.mind5.payment.payOrder.model.checker.PayordCheckDummy;

public final class NodePayordInsert extends DeciTreeWriteTemplate<PayordInfo> {
	
	public NodePayordInsert(DeciTreeOption<PayordInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<PayordInfo> buildDecisionCheckerHook(DeciTreeOption<PayordInfo> option) {
		List<ModelChecker<PayordInfo>> queue = new ArrayList<>();		
		ModelChecker<PayordInfo> checker;	
		
		checker = new PayordCheckDummy();
		queue.add(checker);

		return new ModelCheckerQueue<>(queue);
	}
	
	

	@Override protected List<ActionStdV1<PayordInfo>> buildActionsOnPassedHook(DeciTreeOption<PayordInfo> option) {
		List<ActionStdV1<PayordInfo>> actions = new ArrayList<>();		
		
		ActionStdV1<PayordInfo> mergeCrecard = new StdPayordMergeCrecard(option);
		ActionLazyV1<PayordInfo> insertPayord = new LazyPayordInsert(option.conn, option.schemaName);	
		ActionLazyV1<PayordInfo> enforceFee = new LazyPayordEnforceFee(option.conn, option.schemaName);
		ActionLazyV1<PayordInfo> enforceItem = new LazyPayordEnforceItem(option.conn, option.schemaName);		
		ActionLazyV1<PayordInfo> insertPayordem = new LazyPayordInsertPayordem(option.conn, option.schemaName);
		
		mergeCrecard.addPostAction(insertPayord);
		insertPayord.addPostAction(enforceFee);
		enforceFee.addPostAction(enforceItem);
		enforceItem.addPostAction(insertPayordem);
		
		actions.add(mergeCrecard);		
		return actions;
	}
}
