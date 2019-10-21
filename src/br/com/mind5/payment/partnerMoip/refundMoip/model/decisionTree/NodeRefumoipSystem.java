package br.com.mind5.payment.partnerMoip.refundMoip.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeWriteTemplate;
import br.com.mind5.payment.partnerMoip.refundMoip.info.RefumoipInfo;
import br.com.mind5.payment.partnerMoip.refundMoip.model.action.LazyRefumoipEnforceSetupSys;
import br.com.mind5.payment.partnerMoip.refundMoip.model.action.LazyRefumoipMergeSysEnviron;
import br.com.mind5.payment.partnerMoip.refundMoip.model.action.StdRefumoipMergeSetupar;
import br.com.mind5.payment.partnerMoip.refundMoip.model.checker.RefumoipCheckSystemReceiver;

public final class NodeRefumoipSystem extends DeciTreeWriteTemplate<RefumoipInfo> {
	
	public NodeRefumoipSystem(DeciTreeOption<RefumoipInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<RefumoipInfo> buildDecisionCheckerHook(DeciTreeOption<RefumoipInfo> option) {			
		List<ModelChecker<RefumoipInfo>> queue = new ArrayList<>();		
		ModelChecker<RefumoipInfo> checker;	
		
		checker = new RefumoipCheckSystemReceiver();
		queue.add(checker);

		return new ModelCheckerQueue<>(queue);
	}
	
	

	@Override protected List<ActionStd<RefumoipInfo>> buildActionsOnPassedHook(DeciTreeOption<RefumoipInfo> option) {
		List<ActionStd<RefumoipInfo>> actions = new ArrayList<>();	
		
		ActionStd<RefumoipInfo> mergeSetupar = new StdRefumoipMergeSetupar(option);	
		ActionLazy<RefumoipInfo> mergeSysEnviron = new LazyRefumoipMergeSysEnviron(option.conn, option.schemaName);
		ActionLazy<RefumoipInfo> enforceSetup = new LazyRefumoipEnforceSetupSys(option.conn, option.schemaName);	
		
		mergeSetupar.addPostAction(mergeSysEnviron);
		mergeSysEnviron.addPostAction(enforceSetup);
		
		actions.add(mergeSetupar);		
		return actions;
	}
}
