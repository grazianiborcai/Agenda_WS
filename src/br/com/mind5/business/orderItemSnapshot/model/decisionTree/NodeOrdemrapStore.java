package br.com.mind5.business.orderItemSnapshot.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.orderItemSnapshot.info.OrdemrapInfo;
import br.com.mind5.business.orderItemSnapshot.model.action.StdOrdemrapMergeStolis;
import br.com.mind5.business.orderItemSnapshot.model.action.StdOrdemrapSuccess;
import br.com.mind5.business.orderItemSnapshot.model.checker.OrdemrapCheckHasStore;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeWriteTemplate;

public final class NodeOrdemrapStore extends DeciTreeWriteTemplate<OrdemrapInfo> {
	
	public NodeOrdemrapStore(DeciTreeOption<OrdemrapInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<OrdemrapInfo> buildDecisionCheckerHook(DeciTreeOption<OrdemrapInfo> option) {
		List<ModelChecker<OrdemrapInfo>> queue = new ArrayList<>();		
		ModelChecker<OrdemrapInfo> checker;	
		
		checker = new OrdemrapCheckHasStore();
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<OrdemrapInfo>> buildActionsOnPassedHook(DeciTreeOption<OrdemrapInfo> option) {
		List<ActionStd<OrdemrapInfo>> actions = new ArrayList<>();
		
		ActionStd<OrdemrapInfo> mergeStolis = new StdOrdemrapMergeStolis(option);
		
		actions.add(mergeStolis);
		return actions;
	}
	
	
	
	@Override protected List<ActionStd<OrdemrapInfo>> buildActionsOnFailedHook(DeciTreeOption<OrdemrapInfo> option) {
		List<ActionStd<OrdemrapInfo>> actions = new ArrayList<>();
		
		ActionStd<OrdemrapInfo> success = new StdOrdemrapSuccess(option);
		
		actions.add(success);
		return actions;
	}	
}
