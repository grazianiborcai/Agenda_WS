package br.com.mind5.business.masterData.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.masterData.info.CartCategInfo;
import br.com.mind5.business.masterData.model.action.StdCartCategSelect;
import br.com.mind5.business.masterData.model.checker.CartCategCheckRead;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;

public final class RootCartCategSelect extends DeciTreeTemplateRead<CartCategInfo> {
	
	public RootCartCategSelect(DeciTreeOption<CartCategInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<CartCategInfo> buildCheckerHook(DeciTreeOption<CartCategInfo> option) {
		List<ModelCheckerV1<CartCategInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<CartCategInfo> checker;
		ModelCheckerOption checkerOption;	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new CartCategCheckRead(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}

		
	
	@Override protected List<ActionStdV1<CartCategInfo>> buildActionsOnPassedHook(DeciTreeOption<CartCategInfo> option) {
		List<ActionStdV1<CartCategInfo>> actions = new ArrayList<>();
		
		ActionStdV1<CartCategInfo> select = new StdCartCategSelect(option);
		
		actions.add(select);
		return actions;
	}
}
