package br.com.mind5.masterData.entityCategory.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.masterData.entityCategory.info.EntitegInfo;
import br.com.mind5.masterData.entityCategory.model.action.StdEntitegDaoSelect;
import br.com.mind5.masterData.entityCategory.model.checker.EntitegCheckRead;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateReadV2;

public final class RootEntitegSelect extends DeciTreeTemplateReadV2<EntitegInfo> {
	
	public RootEntitegSelect(DeciTreeOption<EntitegInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<EntitegInfo> buildCheckerHook(DeciTreeOption<EntitegInfo> option) {
		List<ModelCheckerV1<EntitegInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<EntitegInfo> checker;
		ModelCheckerOption checkerOption;	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new EntitegCheckRead(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}

		
	
	@Override protected List<ActionStdV1<EntitegInfo>> buildActionsOnPassedHook(DeciTreeOption<EntitegInfo> option) {
		List<ActionStdV1<EntitegInfo>> actions = new ArrayList<>();
		
		ActionStdV1<EntitegInfo> select = new StdEntitegDaoSelect(option);
		
		actions.add(select);
		return actions;
	}
}
