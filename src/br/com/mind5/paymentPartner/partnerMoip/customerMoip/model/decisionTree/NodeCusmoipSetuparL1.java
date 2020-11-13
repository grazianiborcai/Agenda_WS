package br.com.mind5.paymentPartner.partnerMoip.customerMoip.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.common.ModelCheckerDummy;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;
import br.com.mind5.paymentPartner.partnerMoip.customerMoip.info.CusmoipInfo;
import br.com.mind5.paymentPartner.partnerMoip.customerMoip.model.action.LazyCusmoipEnforceSetup;
import br.com.mind5.paymentPartner.partnerMoip.customerMoip.model.action.LazyCusmoipMergeSetupar;
import br.com.mind5.paymentPartner.partnerMoip.customerMoip.model.action.StdCusmoipEnforcePaypar;

public final class NodeCusmoipSetuparL1 extends DeciTreeTemplateWrite<CusmoipInfo> {
	
	public NodeCusmoipSetuparL1(DeciTreeOption<CusmoipInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<CusmoipInfo> buildCheckerHook(DeciTreeOption<CusmoipInfo> option) {
		List<ModelChecker<CusmoipInfo>> queue = new ArrayList<>();		
		ModelChecker<CusmoipInfo> checker;	

		checker = new ModelCheckerDummy<>();
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<CusmoipInfo>> buildActionsOnPassedHook(DeciTreeOption<CusmoipInfo> option) {
		List<ActionStd<CusmoipInfo>> actions = new ArrayList<>();
		
		ActionStd<CusmoipInfo> enforcePaypar = new StdCusmoipEnforcePaypar(option);
		ActionLazy<CusmoipInfo> mergeSetupar = new LazyCusmoipMergeSetupar(option.conn, option.schemaName);
		ActionLazy<CusmoipInfo> enforceSetup = new LazyCusmoipEnforceSetup(option.conn, option.schemaName);
		
		enforcePaypar.addPostAction(mergeSetupar);
		mergeSetupar.addPostAction(enforceSetup);
		
		actions.add(enforcePaypar);
		return actions;
	}
}
