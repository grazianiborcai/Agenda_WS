package br.com.mind5.payment.partnerMoip.customerMoip.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeWriteTemplate;
import br.com.mind5.payment.partnerMoip.customerMoip.info.CusmoipInfo;
import br.com.mind5.payment.partnerMoip.customerMoip.model.action.LazyCusmoipEnforceSetup;
import br.com.mind5.payment.partnerMoip.customerMoip.model.action.LazyCusmoipMergeSetupar;
import br.com.mind5.payment.partnerMoip.customerMoip.model.action.StdCusmoipEnforcePayPartner;
import br.com.mind5.payment.partnerMoip.customerMoip.model.checker.CusmoipCheckDummy;

public final class NodeCusmoipSetupar extends DeciTreeWriteTemplate<CusmoipInfo> {
	
	public NodeCusmoipSetupar(DeciTreeOption<CusmoipInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<CusmoipInfo> buildDecisionCheckerHook(DeciTreeOption<CusmoipInfo> option) {
		List<ModelChecker<CusmoipInfo>> queue = new ArrayList<>();		
		ModelChecker<CusmoipInfo> checker;	

		checker = new CusmoipCheckDummy();
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<CusmoipInfo>> buildActionsOnPassedHook(DeciTreeOption<CusmoipInfo> option) {
		List<ActionStd<CusmoipInfo>> actions = new ArrayList<>();
		
		ActionStd<CusmoipInfo> enforcePayPartner = new StdCusmoipEnforcePayPartner(option);
		ActionLazy<CusmoipInfo> mergeSetupar = new LazyCusmoipMergeSetupar(option.conn, option.schemaName);
		ActionLazy<CusmoipInfo> enforceSetup = new LazyCusmoipEnforceSetup(option.conn, option.schemaName);
		
		enforcePayPartner.addPostAction(mergeSetupar);
		mergeSetupar.addPostAction(enforceSetup);
		
		actions.add(enforcePayPartner);
		return actions;
	}
}
