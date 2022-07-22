package br.com.mind5.paymentPartner.partnerMoip.multiPayMoip.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;
import br.com.mind5.paymentPartner.partnerMoip.multiPayMoip.info.PaymoipInfo;
import br.com.mind5.paymentPartner.partnerMoip.multiPayMoip.model.action.PaymoipVisiEnforcePaypar;
import br.com.mind5.paymentPartner.partnerMoip.multiPayMoip.model.action.PaymoipVisiEnforceResponseAttr;
import br.com.mind5.paymentPartner.partnerMoip.multiPayMoip.model.action.PaymoipVisiEnforceSetup;
import br.com.mind5.paymentPartner.partnerMoip.multiPayMoip.model.action.PaymoipVisiMergeSetupar;
import br.com.mind5.paymentPartner.partnerMoip.multiPayMoip.model.action.PaymoipVisiMergeSysenv;
import br.com.mind5.paymentPartner.partnerMoip.multiPayMoip.model.action.PaymoipVisiRead;
import br.com.mind5.paymentPartner.partnerMoip.multiPayMoip.model.checker.PaymoipCheckRead;

public final class PaymoipRootRead extends DeciTreeTemplateWrite<PaymoipInfo> {
	
	public PaymoipRootRead(DeciTreeOption<PaymoipInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<PaymoipInfo> buildCheckerHook(DeciTreeOption<PaymoipInfo> option) {	
		List<ModelChecker<PaymoipInfo>> queue = new ArrayList<>();		
		ModelChecker<PaymoipInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new PaymoipCheckRead(checkerOption);
		queue.add(checker);

		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<PaymoipInfo>> buildActionsOnPassedHook(DeciTreeOption<PaymoipInfo> option) {
		List<ActionStd<PaymoipInfo>> actions = new ArrayList<>();	
		
		ActionStd<PaymoipInfo> enforcePaypar = new ActionStdCommom<PaymoipInfo>(option, PaymoipVisiEnforcePaypar.class);
		ActionLazy<PaymoipInfo> mergeSysenv = new ActionLazyCommom<PaymoipInfo>(option, PaymoipVisiMergeSysenv.class);
		ActionLazy<PaymoipInfo> mergeSetupar = new ActionLazyCommom<PaymoipInfo>(option, PaymoipVisiMergeSetupar.class);
		ActionLazy<PaymoipInfo> enforceSetup = new ActionLazyCommom<PaymoipInfo>(option, PaymoipVisiEnforceSetup.class);
		ActionLazy<PaymoipInfo> read = new ActionLazyCommom<PaymoipInfo>(option, PaymoipVisiRead.class);
		ActionLazy<PaymoipInfo> enforceReponseAttr = new ActionLazyCommom<PaymoipInfo>(option, PaymoipVisiEnforceResponseAttr.class);
		
		enforcePaypar.addPostAction(mergeSysenv);
		mergeSysenv.addPostAction(mergeSetupar);
		mergeSetupar.addPostAction(enforceSetup);
		enforceSetup.addPostAction(read);
		read.addPostAction(enforceReponseAttr);
		
		actions.add(enforcePaypar);		
		return actions;
	}
}
