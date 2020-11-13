package br.com.mind5.payment.payOrder.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.common.ModelCheckerDummy;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWriteV2;
import br.com.mind5.payment.payOrder.info.PayordInfo;
import br.com.mind5.payment.payOrder.model.action.LazyPayordDaoInsert;
import br.com.mind5.payment.payOrder.model.action.LazyPayordEnforceFee;
import br.com.mind5.payment.payOrder.model.action.LazyPayordEnforceItem;
import br.com.mind5.payment.payOrder.model.action.LazyPayordInsertPayordem;
import br.com.mind5.payment.payOrder.model.action.StdPayordMergeCrecardAuth;

public final class NodePayordInsert extends DeciTreeTemplateWriteV2<PayordInfo> {
	
	public NodePayordInsert(DeciTreeOption<PayordInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<PayordInfo> buildCheckerHook(DeciTreeOption<PayordInfo> option) {
		List<ModelCheckerV1<PayordInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<PayordInfo> checker;	
		
		checker = new ModelCheckerDummy<>();
		queue.add(checker);

		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	

	@Override protected List<ActionStdV2<PayordInfo>> buildActionsOnPassedHook(DeciTreeOption<PayordInfo> option) {
		List<ActionStdV2<PayordInfo>> actions = new ArrayList<>();		
		
		ActionStdV2<PayordInfo> mergeCrecard = new StdPayordMergeCrecardAuth(option);
		ActionLazy<PayordInfo> insertPayord = new LazyPayordDaoInsert(option.conn, option.schemaName);	
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
