package br.com.mind5.paymentPartner.partnerMoip.refundMoip.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeWriteTemplate;
import br.com.mind5.paymentPartner.partnerMoip.refundMoip.info.RefumoipInfo;
import br.com.mind5.paymentPartner.partnerMoip.refundMoip.model.action.LazyRefumoipEnforceSetupSys;
import br.com.mind5.paymentPartner.partnerMoip.refundMoip.model.action.LazyRefumoipMergeSysEnviron;
import br.com.mind5.paymentPartner.partnerMoip.refundMoip.model.action.StdRefumoipMergeSetupar;
import br.com.mind5.paymentPartner.partnerMoip.refundMoip.model.checker.RefumoipCheckSysparch;

public final class NodeRefumoipSystem extends DeciTreeWriteTemplate<RefumoipInfo> {
	
	public NodeRefumoipSystem(DeciTreeOption<RefumoipInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<RefumoipInfo> buildDecisionCheckerHook(DeciTreeOption<RefumoipInfo> option) {			
		List<ModelChecker<RefumoipInfo>> queue = new ArrayList<>();		
		ModelChecker<RefumoipInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new RefumoipCheckSysparch(checkerOption);
		queue.add(checker);

		return new ModelCheckerQueue<>(queue);
	}
	
	

	@Override protected List<ActionStdV1<RefumoipInfo>> buildActionsOnPassedHook(DeciTreeOption<RefumoipInfo> option) {
		List<ActionStdV1<RefumoipInfo>> actions = new ArrayList<>();	
		
		ActionStdV1<RefumoipInfo> mergeSetupar = new StdRefumoipMergeSetupar(option);	
		ActionLazyV1<RefumoipInfo> mergeSysEnviron = new LazyRefumoipMergeSysEnviron(option.conn, option.schemaName);
		ActionLazyV1<RefumoipInfo> enforceSetup = new LazyRefumoipEnforceSetupSys(option.conn, option.schemaName);	
		
		mergeSetupar.addPostAction(mergeSysEnviron);
		mergeSysEnviron.addPostAction(enforceSetup);
		
		actions.add(mergeSetupar);		
		return actions;
	}
}
