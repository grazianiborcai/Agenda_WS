package br.com.mind5.payment.customerPartner.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeWriteTemplate;
import br.com.mind5.payment.customerPartner.info.CusparInfo;
import br.com.mind5.payment.customerPartner.model.action.LazyCusparEnforceCompoundId;
import br.com.mind5.payment.customerPartner.model.action.LazyCusparNodeCreateMoip;
import br.com.mind5.payment.customerPartner.model.action.LazyCusparUpdate;
import br.com.mind5.payment.customerPartner.model.action.StdCusparInsert;
import br.com.mind5.payment.customerPartner.model.checker.CusparCheckDummy;

public final class NodeCusparInsert extends DeciTreeWriteTemplate<CusparInfo> {
	
	public NodeCusparInsert(DeciTreeOption<CusparInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<CusparInfo> buildDecisionCheckerHook(DeciTreeOption<CusparInfo> option) {
		List<ModelChecker<CusparInfo>> queue = new ArrayList<>();		
		ModelChecker<CusparInfo> checker;	

		checker = new CusparCheckDummy();
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<CusparInfo>> buildActionsOnPassedHook(DeciTreeOption<CusparInfo> option) {
		List<ActionStdV1<CusparInfo>> actions = new ArrayList<>();
		
		ActionStdV1<CusparInfo> insert = new StdCusparInsert(option);
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
