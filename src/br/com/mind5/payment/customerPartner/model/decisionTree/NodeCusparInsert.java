package br.com.mind5.payment.customerPartner.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
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
	
	
	
	@Override protected List<ActionStd<CusparInfo>> buildActionsOnPassedHook(DeciTreeOption<CusparInfo> option) {
		List<ActionStd<CusparInfo>> actions = new ArrayList<>();
		
		ActionStd<CusparInfo> insert = new StdCusparInsert(option);
		ActionLazy<CusparInfo> enforceCompoundId = new LazyCusparEnforceCompoundId(option.conn, option.schemaName);	
		ActionLazy<CusparInfo> createMoip = new LazyCusparNodeCreateMoip(option.conn, option.schemaName);
		ActionLazy<CusparInfo> update = new LazyCusparUpdate(option.conn, option.schemaName);
		
		insert.addPostAction(enforceCompoundId);
		enforceCompoundId.addPostAction(createMoip);
		createMoip.addPostAction(update);
		
		actions.add(insert);
		return actions;
	}
}
