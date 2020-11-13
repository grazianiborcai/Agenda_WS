package br.com.mind5.masterData.materialTypeSearch.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.masterData.materialTypeSearch.info.MatyparchInfo;
import br.com.mind5.masterData.materialTypeSearch.model.action.StdMatyparchDaoSelect;
import br.com.mind5.masterData.materialTypeSearch.model.checker.MatyparchCheckRead;
import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateReadV2;

public final class RootMatyparchSelect extends DeciTreeTemplateReadV2<MatyparchInfo> {
	
	public RootMatyparchSelect(DeciTreeOption<MatyparchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<MatyparchInfo> buildCheckerHook(DeciTreeOption<MatyparchInfo> option) {
		List<ModelCheckerV1<MatyparchInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<MatyparchInfo> checker;
		ModelCheckerOption checkerOption;	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new MatyparchCheckRead(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV2<MatyparchInfo>> buildActionsOnPassedHook(DeciTreeOption<MatyparchInfo> option) {
		List<ActionStdV2<MatyparchInfo>> actions = new ArrayList<>();
		
		ActionStdV2<MatyparchInfo> select = new StdMatyparchDaoSelect(option);
		
		actions.add(select);
		return actions;
	}
}
