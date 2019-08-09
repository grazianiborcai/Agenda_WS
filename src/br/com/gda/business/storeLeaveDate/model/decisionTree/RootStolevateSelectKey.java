package br.com.gda.business.storeLeaveDate.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.storeLeaveDate.info.StolevateInfo;
import br.com.gda.business.storeLeaveDate.model.action.StdStolevateSelectKey;
import br.com.gda.business.storeLeaveDate.model.checker.StolevateCheckRead;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.model.decisionTree.DeciTreeReadTemplate;

public final class RootStolevateSelectKey extends DeciTreeReadTemplate<StolevateInfo> {
	
	public RootStolevateSelectKey(DeciTreeOption<StolevateInfo> option) {
		super(option);
	}	
	
	
	@Override protected ModelChecker<StolevateInfo> buildDecisionCheckerHook(DeciTreeOption<StolevateInfo> option) {
		List<ModelChecker<StolevateInfo>> queue = new ArrayList<>();		
		ModelChecker<StolevateInfo> checker;
		
		checker = new StolevateCheckRead();
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<StolevateInfo>> buildActionsOnPassedHook(DeciTreeOption<StolevateInfo> option) {
		List<ActionStd<StolevateInfo>> actions = new ArrayList<>();
		
		actions.add(new StdStolevateSelectKey(option));
		return actions;
	}
}
