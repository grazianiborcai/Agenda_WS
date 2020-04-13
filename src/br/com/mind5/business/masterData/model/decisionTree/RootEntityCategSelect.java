package br.com.mind5.business.masterData.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.masterData.info.EntityCategInfo;
import br.com.mind5.business.masterData.model.action.StdEntityCategSelect;
import br.com.mind5.business.masterData.model.checker.EntityCategCheckRead;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateReadV1;

public final class RootEntityCategSelect extends DeciTreeTemplateReadV1<EntityCategInfo> {
	
	public RootEntityCategSelect(DeciTreeOption<EntityCategInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<EntityCategInfo> buildCheckerHook(DeciTreeOption<EntityCategInfo> option) {
		List<ModelCheckerV1<EntityCategInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<EntityCategInfo> checker;
		ModelCheckerOption checkerOption;	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new EntityCategCheckRead(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}

		
	
	@Override protected List<ActionStdV1<EntityCategInfo>> buildActionsOnPassedHook(DeciTreeOption<EntityCategInfo> option) {
		List<ActionStdV1<EntityCategInfo>> actions = new ArrayList<>();
		
		ActionStdV1<EntityCategInfo> select = new StdEntityCategSelect(option);
		
		actions.add(select);
		return actions;
	}
}
