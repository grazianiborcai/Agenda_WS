package br.com.mind5.business.masterData.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.masterData.info.UserCategInfo;
import br.com.mind5.business.masterData.model.action.StdUserCategSelect;
import br.com.mind5.business.masterData.model.checker.UserCategCheckRead;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateReadV1;

public final class RootUserCategSelect extends DeciTreeTemplateReadV1<UserCategInfo> {
	
	public RootUserCategSelect(DeciTreeOption<UserCategInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<UserCategInfo> buildCheckerHook(DeciTreeOption<UserCategInfo> option) {
		List<ModelCheckerV1<UserCategInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<UserCategInfo> checker;
		ModelCheckerOption checkerOption;	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new UserCategCheckRead(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<UserCategInfo>> buildActionsOnPassedHook(DeciTreeOption<UserCategInfo> option) {
		List<ActionStdV1<UserCategInfo>> actions = new ArrayList<>();
		
		ActionStdV1<UserCategInfo> select = new StdUserCategSelect(option);
		
		actions.add(select);
		return actions;
	}
}
