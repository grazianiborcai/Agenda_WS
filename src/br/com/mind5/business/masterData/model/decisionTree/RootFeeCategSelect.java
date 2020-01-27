package br.com.mind5.business.masterData.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.masterData.info.FeeCategInfo;
import br.com.mind5.business.masterData.model.action.StdFeeCategSelect;
import br.com.mind5.business.masterData.model.checker.FeeCategCheckRead;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
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
		ModelCheckerOption checkerOption;	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new FeeCategCheckRead(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}

		
	
	@Override protected List<ActionStd<FeeCategInfo>> buildActionsOnPassedHook(DeciTreeOption<FeeCategInfo> option) {
		List<ActionStd<FeeCategInfo>> actions = new ArrayList<>();
		
		ActionStd<FeeCategInfo> select = new StdFeeCategSelect(option);
		
		actions.add(select);
		return actions;
	}
}
