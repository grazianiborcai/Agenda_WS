package br.com.mind5.business.masterData.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.masterData.info.FeeCategInfo;
import br.com.mind5.business.masterData.model.action.StdFeeCategSelect;
import br.com.mind5.business.masterData.model.checker.FeeCategCheckRead;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeReadTemplate;

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
