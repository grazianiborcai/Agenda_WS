package br.com.mind5.paymentPartner.partnerMoip.orderMoip.model.decsionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.common.ModelCheckerDummy;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;
import br.com.mind5.paymentPartner.partnerMoip.orderMoip.info.OrdmoipInfo;
import br.com.mind5.paymentPartner.partnerMoip.orderMoip.model.action.OrdmoipVisiNodeSetuparL2;
import br.com.mind5.paymentPartner.partnerMoip.orderMoip.model.action.OrdmoipVisiEnforcePaypar;
import br.com.mind5.paymentPartner.partnerMoip.orderMoip.model.action.OrdmoipVisiMergeSetupar;

public final class OrdmoipNodeSetuparL1 extends DeciTreeTemplateWrite<OrdmoipInfo> {
	
	public OrdmoipNodeSetuparL1(DeciTreeOption<OrdmoipInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<OrdmoipInfo> buildCheckerHook(DeciTreeOption<OrdmoipInfo> option) {
		List<ModelChecker<OrdmoipInfo>> queue = new ArrayList<>();		
		ModelChecker<OrdmoipInfo> checker;	
	
		checker = new ModelCheckerDummy<>();
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<OrdmoipInfo>> buildActionsOnPassedHook(DeciTreeOption<OrdmoipInfo> option) {
		List<ActionStd<OrdmoipInfo>> actions = new ArrayList<>();	
		
		ActionStd<OrdmoipInfo> enforcePaypar = new ActionStdCommom<OrdmoipInfo>(option, OrdmoipVisiEnforcePaypar.class);
		ActionLazy<OrdmoipInfo> mergeSetupar = new ActionLazyCommom<OrdmoipInfo>(option, OrdmoipVisiMergeSetupar.class);	
		ActionLazy<OrdmoipInfo> nodeL2 = new ActionLazyCommom<OrdmoipInfo>(option, OrdmoipVisiNodeSetuparL2.class);
		
		enforcePaypar.addPostAction(mergeSetupar);
		mergeSetupar.addPostAction(nodeL2);
		
		actions.add(enforcePaypar);		
		return actions;
	}
}
