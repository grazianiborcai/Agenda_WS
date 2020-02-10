package br.com.mind5.paymentPartner.partnerMoip.refundMoip.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeWriteTemplate;
import br.com.mind5.paymentPartner.partnerMoip.refundMoip.info.RefumoipInfo;
import br.com.mind5.paymentPartner.partnerMoip.refundMoip.model.action.LazyRefumoipEnforceSetupNonsys;
import br.com.mind5.paymentPartner.partnerMoip.refundMoip.model.action.LazyRefumoipMergeSysEnviron;
import br.com.mind5.paymentPartner.partnerMoip.refundMoip.model.action.StdRefumoipMergeStopar;
import br.com.mind5.paymentPartner.partnerMoip.refundMoip.model.checker.RefumoipCheckNonSystem;
import br.com.mind5.paymentPartner.partnerMoip.refundMoip.model.checker.RefumoipCheckStore;

public final class NodeRefumoipNonSystem extends DeciTreeWriteTemplate<RefumoipInfo> {
	
	public NodeRefumoipNonSystem(DeciTreeOption<RefumoipInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<RefumoipInfo> buildDecisionCheckerHook(DeciTreeOption<RefumoipInfo> option) {			
		List<ModelChecker<RefumoipInfo>> queue = new ArrayList<>();		
		ModelChecker<RefumoipInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new RefumoipCheckNonSystem(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new RefumoipCheckStore(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	

	@Override protected List<ActionStd<RefumoipInfo>> buildActionsOnPassedHook(DeciTreeOption<RefumoipInfo> option) {
		List<ActionStd<RefumoipInfo>> actions = new ArrayList<>();	
		
		ActionStd<RefumoipInfo> mergeStopar = new StdRefumoipMergeStopar(option);	
		ActionLazy<RefumoipInfo> mergeSysEnviron = new LazyRefumoipMergeSysEnviron(option.conn, option.schemaName);
		ActionLazy<RefumoipInfo> enforceSetup = new LazyRefumoipEnforceSetupNonsys(option.conn, option.schemaName);	
		
		mergeStopar.addPostAction(mergeSysEnviron);
		mergeSysEnviron.addPostAction(enforceSetup);
		
		actions.add(mergeStopar);		
		return actions;
	}
}
