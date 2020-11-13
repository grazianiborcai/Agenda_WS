package br.com.mind5.paymentPartner.partnerMoip.refundMoip.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;
import br.com.mind5.paymentPartner.partnerMoip.refundMoip.info.RefumoipInfo;
import br.com.mind5.paymentPartner.partnerMoip.refundMoip.model.action.LazyRefumoipEnforceSetupNonsys;
import br.com.mind5.paymentPartner.partnerMoip.refundMoip.model.action.LazyRefumoipMergeSysenv;
import br.com.mind5.paymentPartner.partnerMoip.refundMoip.model.action.StdRefumoipMergeStopar;
import br.com.mind5.paymentPartner.partnerMoip.refundMoip.model.checker.RefumoipCheckStopar;

public final class NodeRefumoipNonSystem extends DeciTreeTemplateWrite<RefumoipInfo> {
	
	public NodeRefumoipNonSystem(DeciTreeOption<RefumoipInfo> option) {
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
		
		ActionStd<RefumoipInfo> mergeStopar = new StdRefumoipMergeStopar(option);	
		ActionLazy<RefumoipInfo> mergeSysenv = new LazyRefumoipMergeSysenv(option.conn, option.schemaName);
		ActionLazy<RefumoipInfo> enforceSetup = new LazyRefumoipEnforceSetupNonsys(option.conn, option.schemaName);	
		
		mergeStopar.addPostAction(mergeSysenv);
		mergeSysenv.addPostAction(enforceSetup);
		
		actions.add(mergeStopar);		
		return actions;
	}
}
