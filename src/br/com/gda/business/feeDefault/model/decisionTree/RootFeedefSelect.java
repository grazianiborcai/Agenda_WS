package br.com.gda.business.feeDefault.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.feeDefault.info.FeedefInfo;
import br.com.gda.business.feeDefault.model.action.StdFeedefSelect;
import br.com.gda.business.feeDefault.model.checker.FeedefCheckRead;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.model.decisionTree.DeciTreeReadTemplate;

public final class RootFeedefSelect extends DeciTreeReadTemplate<FeedefInfo> {
	
	public RootFeedefSelect(DeciTreeOption<FeedefInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<FeedefInfo> buildDecisionCheckerHook(DeciTreeOption<FeedefInfo> option) {
		List<ModelChecker<FeedefInfo>> queue = new ArrayList<>();		
		ModelChecker<FeedefInfo> checker;
		
		checker = new FeedefCheckRead();
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<FeedefInfo>> buildActionsOnPassedHook(DeciTreeOption<FeedefInfo> option) {
		List<ActionStd<FeedefInfo>> actions = new ArrayList<>();
		
		actions.add(new StdFeedefSelect(option));
		return actions;
	}
}
