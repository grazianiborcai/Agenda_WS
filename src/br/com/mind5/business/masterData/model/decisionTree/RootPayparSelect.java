package br.com.mind5.business.masterData.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.masterData.info.PayparInfo;
import br.com.mind5.business.masterData.model.action.StdPayparSelect;
import br.com.mind5.business.masterData.model.checker.PayparCheckRead;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeReadTemplate;

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
