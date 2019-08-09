package br.com.gda.business.masterData.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.masterData.info.AreaPhoneInfo;
import br.com.gda.business.masterData.model.action.StdAreaPhoneSelect;
import br.com.gda.business.masterData.model.checker.AreaPhoneCheckRead;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciTreeReadTemplate;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class RootAreaPhoneSelect extends DeciTreeReadTemplate<AreaPhoneInfo> {
	
	public RootAreaPhoneSelect(DeciTreeOption<AreaPhoneInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<AreaPhoneInfo> buildDecisionCheckerHook(DeciTreeOption<AreaPhoneInfo> option) {
		List<ModelChecker<AreaPhoneInfo>> queue = new ArrayList<>();		
		ModelChecker<AreaPhoneInfo> checker;
		
		checker = new AreaPhoneCheckRead();
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}

		
	
	@Override protected List<ActionStd<AreaPhoneInfo>> buildActionsOnPassedHook(DeciTreeOption<AreaPhoneInfo> option) {
		List<ActionStd<AreaPhoneInfo>> actions = new ArrayList<>();
		
		actions.add(new StdAreaPhoneSelect(option));
		return actions;
	}
}
