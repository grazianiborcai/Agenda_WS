package br.com.mind5.payment.storePartner.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.common.ModelCheckerDummy;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;
import br.com.mind5.payment.storePartner.info.StoparInfo;
import br.com.mind5.payment.storePartner.model.action.StoparVisiMergePayparult;
import br.com.mind5.payment.storePartner.model.action.StoparVisiNodeCreateL1;

public final class StoparRootCreate extends DeciTreeTemplateWrite<StoparInfo> {
	
	public StoparRootCreate(DeciTreeOption<StoparInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<StoparInfo> buildCheckerHook(DeciTreeOption<StoparInfo> option) {		
		List<ModelChecker<StoparInfo>> queue = new ArrayList<>();		
		ModelChecker<StoparInfo> checker;	

		checker = new ModelCheckerDummy<StoparInfo>();
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<StoparInfo>> buildActionsOnPassedHook(DeciTreeOption<StoparInfo> option) {
		List<ActionStd<StoparInfo>> actions = new ArrayList<>();		

		ActionStd <StoparInfo> mergePayparult = new ActionStdCommom <StoparInfo>(option, StoparVisiMergePayparult.class);
		ActionLazy<StoparInfo> nodeL1         = new ActionLazyCommom<StoparInfo>(option, StoparVisiNodeCreateL1.class);
		
		mergePayparult.addPostAction(nodeL1);
		
		actions.add(mergePayparult);		
		return actions;
	}
}
