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
	
	

	@Override protected List<ActionStd<PayordInfo>> buildActionsOnPassedHook(DeciTreeOption<PayordInfo> option) {
		List<ActionStd<PayordInfo>> actions = new ArrayList<>();		
		
		ActionStd<PayordInfo> mergeCrecard = new StdPayordMergeCrecard(option);
		ActionLazy<PayordInfo> insertPayord = new LazyPayordInsert(option.conn, option.schemaName);	
		ActionLazy<PayordInfo> enforceFee = new LazyPayordEnforceFee(option.conn, option.schemaName);
		ActionLazy<PayordInfo> enforceItem = new LazyPayordEnforceItem(option.conn, option.schemaName);		
		ActionLazy<PayordInfo> insertPayordem = new LazyPayordInsertPayordem(option.conn, option.schemaName);
		
		mergeCrecard.addPostAction(insertPayord);
		insertPayord.addPostAction(enforceFee);
		enforceFee.addPostAction(enforceItem);
		enforceItem.addPostAction(insertPayordem);
		
		actions.add(mergeCrecard);		
		return actions;
	}
}
