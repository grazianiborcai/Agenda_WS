package br.com.gda.payment.partnerMoip.refundMoip.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.model.decisionTree.DeciTreeWriteTemplate;
import br.com.gda.payment.partnerMoip.refundMoip.info.RefumoipInfo;
import br.com.gda.payment.partnerMoip.refundMoip.model.action.LazyRefumoipEnforceSetupNonsys;
import br.com.gda.payment.partnerMoip.refundMoip.model.action.LazyRefumoipMergeSysEnviron;
import br.com.gda.payment.partnerMoip.refundMoip.model.action.StdRefumoipMergeStopar;
import br.com.gda.payment.partnerMoip.refundMoip.model.checker.RefumoipCheckNonSystem;
import br.com.gda.payment.partnerMoip.refundMoip.model.checker.RefumoipCheckStore;

public final class NodeRefumoipNonSystem extends DeciTreeWriteTemplate<RefumoipInfo> {
	
	public NodeRefumoipNonSystem(DeciTreeOption<RefumoipInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<RefumoipInfo> buildDecisionCheckerHook(DeciTreeOption<RefumoipInfo> option) {		
		final boolean EXIST_ON_DB = true;
		
		List<ModelChecker<RefumoipInfo>> queue = new ArrayList<>();		
		ModelChecker<RefumoipInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checker = new RefumoipCheckNonSystem();
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;	
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
