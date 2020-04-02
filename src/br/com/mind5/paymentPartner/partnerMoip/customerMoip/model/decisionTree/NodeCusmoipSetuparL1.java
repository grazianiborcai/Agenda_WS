package br.com.mind5.paymentPartner.partnerMoip.customerMoip.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeWriteTemplate;
import br.com.mind5.paymentPartner.partnerMoip.customerMoip.info.CusmoipInfo;
import br.com.mind5.paymentPartner.partnerMoip.customerMoip.model.action.LazyCusmoipEnforceSetup;
import br.com.mind5.paymentPartner.partnerMoip.customerMoip.model.action.LazyCusmoipMergeSetupar;
import br.com.mind5.paymentPartner.partnerMoip.customerMoip.model.action.StdCusmoipEnforcePaypar;
import br.com.mind5.paymentPartner.partnerMoip.customerMoip.model.checker.CusmoipCheckDummy;

public final class NodeCusmoipSetuparL1 extends DeciTreeWriteTemplate<CusmoipInfo> {
	
	public NodeCusmoipSetuparL1(DeciTreeOption<CusmoipInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<CusmoipInfo> buildDecisionCheckerHook(DeciTreeOption<CusmoipInfo> option) {
		List<ModelChecker<CusmoipInfo>> queue = new ArrayList<>();		
		ModelChecker<CusmoipInfo> checker;	

		checker = new CusmoipCheckDummy();
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<CusmoipInfo>> buildActionsOnPassedHook(DeciTreeOption<CusmoipInfo> option) {
		List<ActionStdV1<CusmoipInfo>> actions = new ArrayList<>();
		
		ActionStdV1<CusmoipInfo> enforcePaypar = new StdCusmoipEnforcePaypar(option);
		ActionLazyV1<CusmoipInfo> mergeSetupar = new LazyCusmoipMergeSetupar(option.conn, option.schemaName);
		ActionLazyV1<CusmoipInfo> enforceSetup = new LazyCusmoipEnforceSetup(option.conn, option.schemaName);
		
		enforcePaypar.addPostAction(mergeSetupar);
		mergeSetupar.addPostAction(enforceSetup);
		
		actions.add(enforcePaypar);
		return actions;
	}
}
