package br.com.gda.business.storeSnapshot.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.storeSnapshot.info.StorapInfo;
import br.com.gda.business.storeSnapshot.model.action.StdStorapMergeUserap;
import br.com.gda.business.storeSnapshot.model.action.StdStorapSuccess;
import br.com.gda.business.storeSnapshot.model.checker.StorapCheckHasUserap;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.model.decisionTree.DeciTreeWriteTemplate;

public final class NodeStorapUserap extends DeciTreeWriteTemplate<StorapInfo> {
	
	public NodeStorapUserap(DeciTreeOption<StorapInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<StorapInfo> buildDecisionCheckerHook(DeciTreeOption<StorapInfo> option) {		
		List<ModelChecker<StorapInfo>> queue = new ArrayList<>();		
		ModelChecker<StorapInfo> checker;	
		
		checker = new StorapCheckHasUserap();
		queue.add(checker);		
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<StorapInfo>> buildActionsOnPassedHook(DeciTreeOption<StorapInfo> option) {
		List<ActionStd<StorapInfo>> actions = new ArrayList<>();

		ActionStd<StorapInfo> mergeUserap = new StdStorapMergeUserap(option);
		
		actions.add(mergeUserap);	
		return actions;
	}
	
	
	
	@Override protected List<ActionStd<StorapInfo>> buildActionsOnFailedHook(DeciTreeOption<StorapInfo> option) {
		List<ActionStd<StorapInfo>> actions = new ArrayList<>();

		ActionStd<StorapInfo> success = new StdStorapSuccess(option);
		
		actions.add(success);	
		return actions;
	}
}
