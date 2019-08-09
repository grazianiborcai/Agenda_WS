package br.com.gda.business.masterData.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.masterData.info.TimezoneInfo;
import br.com.gda.business.masterData.model.action.StdTimezoneSelect;
import br.com.gda.business.masterData.model.checker.TimezoneCheckRead;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciTreeReadTemplate;
import br.com.gda.model.decisionTree.DeciTreeOption;

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
