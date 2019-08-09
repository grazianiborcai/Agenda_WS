package br.com.gda.business.masterData.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.masterData.info.BusinessInfo;
import br.com.gda.business.masterData.model.action.StdBusinessSelect;
import br.com.gda.business.masterData.model.checker.BusinessCheckRead;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciTreeReadTemplate;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class RootBusinessSelect extends DeciTreeReadTemplate<BusinessInfo> {
	
	public RootBusinessSelect(DeciTreeOption<BusinessInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<BusinessInfo> buildDecisionCheckerHook(DeciTreeOption<BusinessInfo> option) {
		List<ModelChecker<BusinessInfo>> queue = new ArrayList<>();		
		ModelChecker<BusinessInfo> checker;
		
		checker = new BusinessCheckRead();
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}

		
	
	@Override protected List<ActionStd<BusinessInfo>> buildActionsOnPassedHook(DeciTreeOption<BusinessInfo> option) {
		List<ActionStd<BusinessInfo>> actions = new ArrayList<>();
		
		actions.add(new StdBusinessSelect(option));
		return actions;
	}
}
