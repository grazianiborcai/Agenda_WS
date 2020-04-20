package br.com.mind5.masterData.language.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.masterData.language.info.LanguInfo;
import br.com.mind5.masterData.language.model.action.StdLanguDaoSelect;
import br.com.mind5.masterData.language.model.checker.LanguCheckRead;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateReadV2;

public final class RootLanguSelect extends DeciTreeTemplateReadV2<LanguInfo> {
	
	public RootLanguSelect(DeciTreeOption<LanguInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<LanguInfo> buildCheckerHook(DeciTreeOption<LanguInfo> option) {
		List<ModelCheckerV1<LanguInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<LanguInfo> checker;
		ModelCheckerOption checkerOption;	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new LanguCheckRead(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<LanguInfo>> buildActionsOnPassedHook(DeciTreeOption<LanguInfo> option) {
		List<ActionStdV1<LanguInfo>> actions = new ArrayList<>();
		
		ActionStdV1<LanguInfo> select = new StdLanguDaoSelect(option);
		
		actions.add(select);
		return actions;
	}
}
