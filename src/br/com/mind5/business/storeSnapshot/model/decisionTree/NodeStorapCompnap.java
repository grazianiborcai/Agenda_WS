package br.com.mind5.business.storeSnapshot.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.storeSnapshot.info.StorapInfo;
import br.com.mind5.business.storeSnapshot.model.action.StdStorapMergeCompnap;
import br.com.mind5.business.storeSnapshot.model.action.StdStorapSuccess;
import br.com.mind5.business.storeSnapshot.model.checker.StorapCheckHasCompnap;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeWriteTemplate;

public final class NodeStorapCompnap extends DeciTreeWriteTemplate<StorapInfo> {
	
	public NodeStorapCompnap(DeciTreeOption<StorapInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<StorapInfo> buildDecisionCheckerHook(DeciTreeOption<StorapInfo> option) {		
		List<ModelChecker<StorapInfo>> queue = new ArrayList<>();		
		ModelChecker<StorapInfo> checker;	
		
		checker = new StorapCheckHasCompnap();
		queue.add(checker);		
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<StorapInfo>> buildActionsOnPassedHook(DeciTreeOption<StorapInfo> option) {
		List<ActionStd<StorapInfo>> actions = new ArrayList<>();

		ActionStd<StorapInfo> mergeCompnap = new StdStorapMergeCompnap(option);
		
		actions.add(mergeCompnap);	
		return actions;
	}
	
	
	
	@Override protected List<ActionStd<StorapInfo>> buildActionsOnFailedHook(DeciTreeOption<StorapInfo> option) {
		List<ActionStd<StorapInfo>> actions = new ArrayList<>();

		ActionStd<StorapInfo> success = new StdStorapSuccess(option);
		
		actions.add(success);	
		return actions;
	}
}
