package br.com.mind5.business.masterData.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.masterData.info.MatCategInfo;
import br.com.mind5.business.masterData.model.action.StdMatCategSelect;
import br.com.mind5.business.masterData.model.checker.MatCategCheckRead;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeReadTemplate;

public final class RootMatCategSelect extends DeciTreeReadTemplate<MatCategInfo> {
	
	public RootMatCategSelect(DeciTreeOption<MatCategInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<MatCategInfo> buildDecisionCheckerHook(DeciTreeOption<MatCategInfo> option) {
		List<ModelChecker<MatCategInfo>> queue = new ArrayList<>();		
		ModelChecker<MatCategInfo> checker;
		ModelCheckerOption checkerOption;	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new MatCategCheckRead(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<MatCategInfo>> buildActionsOnPassedHook(DeciTreeOption<MatCategInfo> option) {
		List<ActionStdV1<MatCategInfo>> actions = new ArrayList<>();
		
		ActionStdV1<MatCategInfo> select = new StdMatCategSelect(option);
		
		actions.add(select);
		return actions;
	}
}
