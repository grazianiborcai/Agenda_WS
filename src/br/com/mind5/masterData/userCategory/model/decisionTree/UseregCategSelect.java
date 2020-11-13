package br.com.mind5.masterData.userCategory.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.masterData.userCategory.info.UseregInfo;
import br.com.mind5.masterData.userCategory.model.action.StdUseregDaoSelect;
import br.com.mind5.masterData.userCategory.model.checker.UseregCheckRead;
import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateReadV1;

public final class UseregCategSelect extends DeciTreeTemplateReadV1<UseregInfo> {
	
	public UseregCategSelect(DeciTreeOption<UseregInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<UseregInfo> buildCheckerHook(DeciTreeOption<UseregInfo> option) {
		List<ModelCheckerV1<UseregInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<UseregInfo> checker;
		ModelCheckerOption checkerOption;	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new UseregCheckRead(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV2<UseregInfo>> buildActionsOnPassedHook(DeciTreeOption<UseregInfo> option) {
		List<ActionStdV2<UseregInfo>> actions = new ArrayList<>();
		
		ActionStdV2<UseregInfo> select = new StdUseregDaoSelect(option);
		
		actions.add(select);
		return actions;
	}
}
