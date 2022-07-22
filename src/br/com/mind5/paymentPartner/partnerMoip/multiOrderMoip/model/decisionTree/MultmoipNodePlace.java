package br.com.mind5.paymentPartner.partnerMoip.multiOrderMoip.model.decisionTree;

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
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;
import br.com.mind5.paymentPartner.partnerMoip.multiOrderMoip.info.MultmoipInfo;
import br.com.mind5.paymentPartner.partnerMoip.multiOrderMoip.model.action.MultmoipVisiCreate;
import br.com.mind5.paymentPartner.partnerMoip.multiOrderMoip.model.action.MultmoipVisiEnforceMultiorder;
import br.com.mind5.paymentPartner.partnerMoip.multiOrderMoip.model.action.MultmoipVisiEnforceOwnId;
import br.com.mind5.paymentPartner.partnerMoip.multiOrderMoip.model.action.MultmoipVisiEnforcePaypar;
import br.com.mind5.paymentPartner.partnerMoip.multiOrderMoip.model.action.MultmoipVisiEnforceResponseAttr;
import br.com.mind5.paymentPartner.partnerMoip.multiOrderMoip.model.action.MultmoipVisiEnforceResponseOrdmoip;
import br.com.mind5.paymentPartner.partnerMoip.multiOrderMoip.model.action.MultmoipVisiEnforceSetup;
import br.com.mind5.paymentPartner.partnerMoip.multiOrderMoip.model.action.MultmoipVisiMergeSetupar;
import br.com.mind5.paymentPartner.partnerMoip.multiOrderMoip.model.action.MultmoipVisiMergeSysenv;

public final class MultmoipNodePlace extends DeciTreeTemplateRead<MultmoipInfo> {
	
	public MultmoipNodePlace(DeciTreeOption<MultmoipInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<MultmoipInfo> buildCheckerHook(DeciTreeOption<MultmoipInfo> option) {	
		List<ModelChecker<MultmoipInfo>> queue = new ArrayList<>();		
		ModelChecker<MultmoipInfo> checker;

		checker = new ModelCheckerDummy<>();
		queue.add(checker);

		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<MultmoipInfo>> buildActionsOnPassedHook(DeciTreeOption<MultmoipInfo> option) {
		List<ActionStd<MultmoipInfo>> actions = new ArrayList<>();			
		
		ActionStd<MultmoipInfo> enforceMultiorder = new ActionStdCommom<MultmoipInfo>(option, MultmoipVisiEnforceMultiorder.class);		
		ActionLazy<MultmoipInfo> enforcePaypar = new ActionLazyCommom<MultmoipInfo>(option, MultmoipVisiEnforcePaypar.class);
		ActionLazy<MultmoipInfo> mergeSetupar = new ActionLazyCommom<MultmoipInfo>(option, MultmoipVisiMergeSetupar.class);
		ActionLazy<MultmoipInfo> mergeSysenv = new ActionLazyCommom<MultmoipInfo>(option, MultmoipVisiMergeSysenv.class);	
		ActionLazy<MultmoipInfo> enforceSetup = new ActionLazyCommom<MultmoipInfo>(option, MultmoipVisiEnforceSetup.class);	
		ActionLazy<MultmoipInfo> enforceOwnId = new ActionLazyCommom<MultmoipInfo>(option, MultmoipVisiEnforceOwnId.class);
		ActionLazy<MultmoipInfo> create = new ActionLazyCommom<MultmoipInfo>(option, MultmoipVisiCreate.class);
		ActionLazy<MultmoipInfo> enforceResponseAttr = new ActionLazyCommom<MultmoipInfo>(option, MultmoipVisiEnforceResponseAttr.class);
		ActionLazy<MultmoipInfo> enforceResponseOrdmoip = new ActionLazyCommom<MultmoipInfo>(option, MultmoipVisiEnforceResponseOrdmoip.class);
			
		enforceMultiorder.addPostAction(enforcePaypar);
		enforcePaypar.addPostAction(mergeSetupar);
		mergeSetupar.addPostAction(mergeSysenv);
		mergeSysenv.addPostAction(enforceSetup);
		enforceSetup.addPostAction(enforceOwnId);
		enforceOwnId.addPostAction(create);
		create.addPostAction(enforceResponseAttr);
		enforceResponseAttr.addPostAction(enforceResponseOrdmoip);
		
		actions.add(enforceMultiorder);		
		return actions;
	}
}
