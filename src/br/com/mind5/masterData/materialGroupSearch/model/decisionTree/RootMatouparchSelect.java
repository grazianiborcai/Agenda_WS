package br.com.mind5.masterData.materialGroupSearch.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.masterData.materialGroupSearch.info.MatouparchInfo;
import br.com.mind5.masterData.materialGroupSearch.model.action.StdMatouparchDaoSelect;
import br.com.mind5.masterData.materialGroupSearch.model.checker.MatouparchCheckRead;
import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateReadV1;

public final class RootMatouparchSelect extends DeciTreeTemplateReadV1<MatouparchInfo> {
	
	public RootMatouparchSelect(DeciTreeOption<MatouparchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<MatouparchInfo> buildCheckerHook(DeciTreeOption<MatouparchInfo> option) {
		List<ModelCheckerV1<MatouparchInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<MatouparchInfo> checker;
		ModelCheckerOption checkerOption;	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new MatouparchCheckRead(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV2<MatouparchInfo>> buildActionsOnPassedHook(DeciTreeOption<MatouparchInfo> option) {
		List<ActionStdV2<MatouparchInfo>> actions = new ArrayList<>();
		
		ActionStdV2<MatouparchInfo> select = new StdMatouparchDaoSelect(option);
		
		actions.add(select);
		return actions;
	}
}
