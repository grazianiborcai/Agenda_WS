package br.com.mind5.business.orderHistory.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.orderHistory.info.OrdoryInfo;
import br.com.mind5.business.orderHistory.model.action.OrdoryVisiMergeOrdemist;
import br.com.mind5.business.orderHistory.model.action.OrdoryVisiMergeOrdistSearchAuth;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.common.ModelCheckerDummy;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;

public final class OrdoryRootSearchAuth extends DeciTreeTemplateRead<OrdoryInfo> {
	
	public OrdoryRootSearchAuth(DeciTreeOption<OrdoryInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<OrdoryInfo> buildCheckerHook(DeciTreeOption<OrdoryInfo> option) {
		List<ModelChecker<OrdoryInfo>> queue = new ArrayList<>();		
		ModelChecker<OrdoryInfo> checker;	

		checker = new ModelCheckerDummy<>();
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<OrdoryInfo>> buildActionsOnPassedHook(DeciTreeOption<OrdoryInfo> option) {
		List<ActionStd<OrdoryInfo>> actions = new ArrayList<>();		
		
		ActionStd<OrdoryInfo> mergeOrdist = new ActionStdCommom<OrdoryInfo>(option, OrdoryVisiMergeOrdistSearchAuth.class);
		ActionLazy<OrdoryInfo> mergeOrdemist = new ActionLazyCommom<OrdoryInfo>(option, OrdoryVisiMergeOrdemist.class);
		
		mergeOrdist.addPostAction(mergeOrdemist);
		
		actions.add(mergeOrdist);			
		return actions;
	}
}
