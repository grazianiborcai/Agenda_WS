package br.com.mind5.paymentPartner.partnerMoip.multiOrderMoip.model.decisionTree;

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
import br.com.mind5.paymentPartner.partnerMoip.multiOrderMoip.info.MultmoipInfo;
import br.com.mind5.paymentPartner.partnerMoip.multiOrderMoip.model.action.MultmoipVisiEnforcePaypar;
import br.com.mind5.paymentPartner.partnerMoip.multiOrderMoip.model.action.MultmoipVisiEnforceResponseAttr;
import br.com.mind5.paymentPartner.partnerMoip.multiOrderMoip.model.action.MultmoipVisiEnforceSetup;
import br.com.mind5.paymentPartner.partnerMoip.multiOrderMoip.model.action.MultmoipVisiMergeSetupar;
import br.com.mind5.paymentPartner.partnerMoip.multiOrderMoip.model.action.MultmoipVisiMergeSysenv;
import br.com.mind5.paymentPartner.partnerMoip.multiOrderMoip.model.action.MultmoipVisiRead;
import br.com.mind5.paymentPartner.partnerMoip.multiOrderMoip.model.checker.MultmoipCheckRead;

public final class MultmoipRootRead extends DeciTreeTemplateWrite<MultmoipInfo> {
	
	public MultmoipRootRead(DeciTreeOption<MultmoipInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<MultmoipInfo> buildCheckerHook(DeciTreeOption<MultmoipInfo> option) {				
		List<ModelChecker<MultmoipInfo>> queue = new ArrayList<>();		
		ModelChecker<MultmoipInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;
		checker = new MultmoipCheckRead(checkerOption);
		queue.add(checker);

		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<MultmoipInfo>> buildActionsOnPassedHook(DeciTreeOption<MultmoipInfo> option) {
		List<ActionStd<MultmoipInfo>> actions = new ArrayList<>();	
		
		ActionStd<MultmoipInfo> enforcePaypar = new ActionStdCommom<MultmoipInfo>(option, MultmoipVisiEnforcePaypar.class);
		ActionLazy<MultmoipInfo> mergeSetupar = new ActionLazyCommom<MultmoipInfo>(option, MultmoipVisiMergeSetupar.class);	
		ActionLazy<MultmoipInfo> mergeSysenv = new ActionLazyCommom<MultmoipInfo>(option, MultmoipVisiMergeSysenv.class);	
		ActionLazy<MultmoipInfo> enforceSetup = new ActionLazyCommom<MultmoipInfo>(option, MultmoipVisiEnforceSetup.class);		
		ActionLazy<MultmoipInfo> read = new ActionLazyCommom<MultmoipInfo>(option, MultmoipVisiRead.class);
		ActionLazy<MultmoipInfo> enforceResponseAttr = new ActionLazyCommom<MultmoipInfo>(option, MultmoipVisiEnforceResponseAttr.class);
		
		enforcePaypar.addPostAction(mergeSetupar);
		mergeSetupar.addPostAction(mergeSysenv);
		mergeSysenv.addPostAction(enforceSetup);
		enforceSetup.addPostAction(read);
		read.addPostAction(enforceResponseAttr);
		
		actions.add(enforcePaypar);		
		return actions;
	}
}
