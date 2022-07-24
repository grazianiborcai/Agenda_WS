package br.com.mind5.paymentPartner.partnerMoip.refundMoip.model.decisionTree;

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
import br.com.mind5.paymentPartner.partnerMoip.refundMoip.info.RefumoipInfo;
import br.com.mind5.paymentPartner.partnerMoip.refundMoip.model.action.RefumoipVisiEnforceSetupNonsys;
import br.com.mind5.paymentPartner.partnerMoip.refundMoip.model.action.RefumoipVisiMergeStopar;
import br.com.mind5.paymentPartner.partnerMoip.refundMoip.model.action.RefumoipVisiMergeSysenv;
import br.com.mind5.paymentPartner.partnerMoip.refundMoip.model.checker.RefumoipCheckStopar;

public final class RefumoipNodeNonSystem extends DeciTreeTemplateWrite<RefumoipInfo> {
	
	public RefumoipNodeNonSystem(DeciTreeOption<RefumoipInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<RefumoipInfo> buildCheckerHook(DeciTreeOption<RefumoipInfo> option) {			
		List<ModelChecker<RefumoipInfo>> queue = new ArrayList<>();		
		ModelChecker<RefumoipInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new RefumoipCheckStopar(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	

	@Override protected List<ActionStd<RefumoipInfo>> buildActionsOnPassedHook(DeciTreeOption<RefumoipInfo> option) {
		List<ActionStd<RefumoipInfo>> actions = new ArrayList<>();	
		
		ActionStd<RefumoipInfo> mergeStopar = new ActionStdCommom<RefumoipInfo>(option, RefumoipVisiMergeStopar.class);	
		ActionLazy<RefumoipInfo> mergeSysenv = new ActionLazyCommom<RefumoipInfo>(option, RefumoipVisiMergeSysenv.class);
		ActionLazy<RefumoipInfo> enforceSetup = new ActionLazyCommom<RefumoipInfo>(option, RefumoipVisiEnforceSetupNonsys.class);	
		
		mergeStopar.addPostAction(mergeSysenv);
		mergeSysenv.addPostAction(enforceSetup);
		
		actions.add(mergeStopar);		
		return actions;
	}
}
