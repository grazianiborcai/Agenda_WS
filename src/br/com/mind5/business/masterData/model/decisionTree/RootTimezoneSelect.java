package br.com.mind5.business.masterData.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.masterData.info.TimezoneInfo;
import br.com.mind5.business.masterData.model.action.StdTimezoneSelect;
import br.com.mind5.business.masterData.model.checker.TimezoneCheckRead;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeReadTemplate;

public final class RootTimezoneSelect extends DeciTreeReadTemplate<TimezoneInfo> {
	
	public RootTimezoneSelect(DeciTreeOption<TimezoneInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<TimezoneInfo> buildDecisionCheckerHook(DeciTreeOption<TimezoneInfo> option) {
		List<ModelChecker<TimezoneInfo>> queue = new ArrayList<>();		
		ModelChecker<TimezoneInfo> checker;
		
		checker = new TimezoneCheckRead();
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}

		
	
	@Override protected List<ActionStd<TimezoneInfo>> buildActionsOnPassedHook(DeciTreeOption<TimezoneInfo> option) {
		List<ActionStd<TimezoneInfo>> actions = new ArrayList<>();
		
		actions.add(new StdTimezoneSelect(option));
		return actions;
	}
}
