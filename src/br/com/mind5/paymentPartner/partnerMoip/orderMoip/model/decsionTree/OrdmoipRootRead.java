package br.com.mind5.paymentPartner.partnerMoip.orderMoip.model.decsionTree;

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
import br.com.mind5.paymentPartner.partnerMoip.orderMoip.info.OrdmoipInfo;
import br.com.mind5.paymentPartner.partnerMoip.orderMoip.model.action.OrdmoipVisiEnforcePaypar;
import br.com.mind5.paymentPartner.partnerMoip.orderMoip.model.action.OrdmoipVisiEnforceResponseAttr;
import br.com.mind5.paymentPartner.partnerMoip.orderMoip.model.action.OrdmoipVisiEnforceSetup;
import br.com.mind5.paymentPartner.partnerMoip.orderMoip.model.action.OrdmoipVisiMergeSetupar;
import br.com.mind5.paymentPartner.partnerMoip.orderMoip.model.action.OrdmoipVisiMergeSysenv;
import br.com.mind5.paymentPartner.partnerMoip.orderMoip.model.action.OrdmoipVisiRead;
import br.com.mind5.paymentPartner.partnerMoip.orderMoip.model.checker.OrdmoipCheckRead;

public final class OrdmoipRootRead extends DeciTreeTemplateWrite<OrdmoipInfo> {
	
	public OrdmoipRootRead(DeciTreeOption<OrdmoipInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<OrdmoipInfo> buildCheckerHook(DeciTreeOption<OrdmoipInfo> option) {	
		List<ModelChecker<OrdmoipInfo>> queue = new ArrayList<>();		
		ModelChecker<OrdmoipInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new OrdmoipCheckRead(checkerOption);
		queue.add(checker);

		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<OrdmoipInfo>> buildActionsOnPassedHook(DeciTreeOption<OrdmoipInfo> option) {
		List<ActionStd<OrdmoipInfo>> actions = new ArrayList<>();	
		
		ActionStd<OrdmoipInfo> enforcePaypar = new ActionStdCommom<OrdmoipInfo>(option, OrdmoipVisiEnforcePaypar.class);	
		ActionLazy<OrdmoipInfo> mergeSetupar = new ActionLazyCommom<OrdmoipInfo>(option, OrdmoipVisiMergeSetupar.class);	
		ActionLazy<OrdmoipInfo> mergeSysenv = new ActionLazyCommom<OrdmoipInfo>(option, OrdmoipVisiMergeSysenv.class);	
		ActionLazy<OrdmoipInfo> enforceSetup = new ActionLazyCommom<OrdmoipInfo>(option, OrdmoipVisiEnforceSetup.class);		
		ActionLazy<OrdmoipInfo> read = new ActionLazyCommom<OrdmoipInfo>(option, OrdmoipVisiRead.class);
		ActionLazy<OrdmoipInfo> enforceResponseAttr = new ActionLazyCommom<OrdmoipInfo>(option, OrdmoipVisiEnforceResponseAttr.class);
		
		enforcePaypar.addPostAction(mergeSetupar);
		mergeSetupar.addPostAction(mergeSysenv);
		mergeSysenv.addPostAction(enforceSetup);
		enforceSetup.addPostAction(read);
		read.addPostAction(enforceResponseAttr);
		
		actions.add(enforcePaypar);		
		return actions;
	}
}
