package br.com.gda.business.masterData.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.masterData.info.FeeCategInfo;
import br.com.gda.business.masterData.model.action.StdFeeCategSelect;
import br.com.gda.business.masterData.model.checker.FeeCategCheckRead;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciTreeReadTemplate;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class RootFeeCategSelect extends DeciTreeReadTemplate<FeeCategInfo> {
	
	public RootFeeCategSelect(DeciTreeOption<FeeCategInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<FeeCategInfo> buildDecisionCheckerHook(DeciTreeOption<FeeCategInfo> option) {
		List<ModelChecker<FeeCategInfo>> queue = new ArrayList<>();		
		ModelChecker<FeeCategInfo> checker;
		
		checker = new FeeCategCheckRead();
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}

		
	
	@Override protected List<ActionStd<FeeCategInfo>> buildActionsOnPassedHook(DeciTreeOption<FeeCategInfo> option) {
		List<ActionStd<FeeCategInfo>> actions = new ArrayList<>();
		
		actions.add(new StdFeeCategSelect(option));
		return actions;
	}
}
