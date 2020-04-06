package br.com.mind5.business.masterData.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.masterData.info.MatCategInfo;
import br.com.mind5.business.masterData.model.action.StdMatCategSelect;
import br.com.mind5.business.masterData.model.checker.MatCategCheckRead;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;

public final class RootMatCategSelect extends DeciTreeTemplateRead<MatCategInfo> {
	
	public RootMatCategSelect(DeciTreeOption<MatCategInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<MatCategInfo> buildCheckerHook(DeciTreeOption<MatCategInfo> option) {
		List<ModelCheckerV1<MatCategInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<MatCategInfo> checker;
		ModelCheckerOption checkerOption;	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new MatCategCheckRead(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<MatCategInfo>> buildActionsOnPassedHook(DeciTreeOption<MatCategInfo> option) {
		List<ActionStdV1<MatCategInfo>> actions = new ArrayList<>();
		
		ActionStdV1<MatCategInfo> select = new StdMatCategSelect(option);
		
		actions.add(select);
		return actions;
	}
}
