package br.com.gda.business.storeTime_.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.storeTime_.info.StorimeInfo;
import br.com.gda.business.storeTime_.model.action.StdStorimeSuccess;
import br.com.gda.business.storeTime_.model.checker.StorimeCheckDataFound;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.model.decisionTree.DeciTreeReadTemplate;


public final class NodeStorimeSelect extends DeciTreeReadTemplate<StorimeInfo> {
	
	public NodeStorimeSelect(DeciTreeOption<StorimeInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<StorimeInfo> buildDecisionCheckerHook(DeciTreeOption<StorimeInfo> option) {
		List<ModelChecker<StorimeInfo>> queue = new ArrayList<>();		
		ModelChecker<StorimeInfo> checker;
			
		checker = new StorimeCheckDataFound();
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<StorimeInfo>> buildActionsOnPassedHook(DeciTreeOption<StorimeInfo> option) {
		List<ActionStd<StorimeInfo>> actions = new ArrayList<>();

		ActionStd<StorimeInfo> success = new StdStorimeSuccess(option);
		
		actions.add(success);
		return actions;
	}
}
