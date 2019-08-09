package br.com.gda.business.masterData.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.masterData.info.PayparInfo;
import br.com.gda.business.masterData.model.action.StdPayparSelect;
import br.com.gda.business.masterData.model.checker.PayparCheckRead;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciTreeReadTemplate;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class RootPayparSelect extends DeciTreeReadTemplate<PayparInfo> {
	
	public RootPayparSelect(DeciTreeOption<PayparInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<PayparInfo> buildDecisionCheckerHook(DeciTreeOption<PayparInfo> option) {
		List<ModelChecker<PayparInfo>> queue = new ArrayList<>();		
		ModelChecker<PayparInfo> checker;
		
		checker = new PayparCheckRead();
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}

		
	
	@Override protected List<ActionStd<PayparInfo>> buildActionsOnPassedHook(DeciTreeOption<PayparInfo> option) {
		List<ActionStd<PayparInfo>> actions = new ArrayList<>();
		
		actions.add(new StdPayparSelect(option));
		return actions;
	}
}
