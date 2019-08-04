package br.com.gda.payment.partnerMoip.refundMoip.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.model.decisionTree.DeciTreeWriteTemplate;
import br.com.gda.payment.partnerMoip.refundMoip.info.RefumoipInfo;
import br.com.gda.payment.partnerMoip.refundMoip.model.action.LazyRefumoipEnforceSetupSys;
import br.com.gda.payment.partnerMoip.refundMoip.model.action.StdRefumoipMergeSetupar;
import br.com.gda.payment.partnerMoip.refundMoip.model.checker.RefumoipCheckSystemReceiver;

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
		ActionLazy<RefumoipInfo> enforceSetup = new LazyRefumoipEnforceSetupSys(option.conn, option.schemaName);	
		
		mergeSetupar.addPostAction(enforceSetup);
		
		actions.add(mergeSetupar);		
		return actions;
	}
}
