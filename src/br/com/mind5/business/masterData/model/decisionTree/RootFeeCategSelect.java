package br.com.mind5.business.masterData.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.masterData.info.FeeCategInfo;
import br.com.mind5.business.masterData.model.action.StdFeeCategSelect;
import br.com.mind5.business.masterData.model.checker.FeeCategCheckRead;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;

public final class RootFeeCategSelect extends DeciTreeTemplateRead<FeeCategInfo> {
	
	public RootFeeCategSelect(DeciTreeOption<FeeCategInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<FeeCategInfo> buildCheckerHook(DeciTreeOption<FeeCategInfo> option) {
		List<ModelCheckerV1<FeeCategInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<FeeCategInfo> checker;
		ModelCheckerOption checkerOption;	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new FeeCategCheckRead(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}

		
	
	@Override protected List<ActionStdV1<FeeCategInfo>> buildActionsOnPassedHook(DeciTreeOption<FeeCategInfo> option) {
		List<ActionStdV1<FeeCategInfo>> actions = new ArrayList<>();
		
		ActionStdV1<FeeCategInfo> select = new StdFeeCategSelect(option);
		
		actions.add(select);
		return actions;
	}
}
