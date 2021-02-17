package br.com.mind5.business.orderHistory.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.orderHistory.info.OrdoryInfo;
import br.com.mind5.business.orderHistory.model.action.LazyOrdoryMergeOrdemist;
import br.com.mind5.business.orderHistory.model.action.StdOrdoryMergeOrdistSearchAuth;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.common.ModelCheckerDummy;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;

public final class RootOrdorySearchAuth extends DeciTreeTemplateRead<OrdoryInfo> {
	
	public RootOrdorySearchAuth(DeciTreeOption<OrdoryInfo> option) {
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
		
		ActionStd<OrdoryInfo> mergeOrdist = new StdOrdoryMergeOrdistSearchAuth(option);
		ActionLazy<OrdoryInfo> mergeOrdemist = new LazyOrdoryMergeOrdemist(option.conn, option.schemaName);
		
		mergeOrdist.addPostAction(mergeOrdemist);
		
		actions.add(mergeOrdist);			
		return actions;
	}
}
