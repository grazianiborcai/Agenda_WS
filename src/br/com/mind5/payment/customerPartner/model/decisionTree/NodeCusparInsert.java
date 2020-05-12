package br.com.mind5.payment.customerPartner.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.common.ModelCheckerDummy;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWriteV2;
import br.com.mind5.payment.customerPartner.info.CusparInfo;
import br.com.mind5.payment.customerPartner.model.action.LazyCusparEnforceCompoundId;
import br.com.mind5.payment.customerPartner.model.action.LazyCusparNodeCreateMoip;
import br.com.mind5.payment.customerPartner.model.action.LazyCusparUpdate;
import br.com.mind5.payment.customerPartner.model.action.StdCusparDaoInsert;

public final class NodeCusparInsert extends DeciTreeTemplateWriteV2<CusparInfo> {
	
	public NodeCusparInsert(DeciTreeOption<CusparInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<CusparInfo> buildCheckerHook(DeciTreeOption<CusparInfo> option) {
		List<ModelCheckerV1<CusparInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<CusparInfo> checker;	

		checker = new ModelCheckerDummy<>();
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<CusparInfo>> buildActionsOnPassedHook(DeciTreeOption<CusparInfo> option) {
		List<ActionStdV1<CusparInfo>> actions = new ArrayList<>();
		
		ActionStdV1<CusparInfo> insert = new StdCusparDaoInsert(option);
		ActionLazyV1<CusparInfo> enforceCompoundId = new LazyCusparEnforceCompoundId(option.conn, option.schemaName);	
		ActionLazyV1<CusparInfo> createMoip = new LazyCusparNodeCreateMoip(option.conn, option.schemaName);
		ActionLazyV1<CusparInfo> update = new LazyCusparUpdate(option.conn, option.schemaName);
		
		insert.addPostAction(enforceCompoundId);
		enforceCompoundId.addPostAction(createMoip);
		createMoip.addPostAction(update);
		
		actions.add(insert);
		return actions;
	}
}
