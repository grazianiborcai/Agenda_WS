package br.com.mind5.business.masterData.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.masterData.info.MatTypeInfo;
import br.com.mind5.business.masterData.model.action.StdMatTypeSelect;
import br.com.mind5.business.masterData.model.checker.MatTypeCheckRead;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateReadV1;

public final class RootMatTypeSelect extends DeciTreeTemplateReadV1<MatTypeInfo> {
	
	public RootMatTypeSelect(DeciTreeOption<MatTypeInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<MatTypeInfo> buildCheckerHook(DeciTreeOption<MatTypeInfo> option) {
		List<ModelCheckerV1<MatTypeInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<MatTypeInfo> checker;
		ModelCheckerOption checkerOption;	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new MatTypeCheckRead(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<MatTypeInfo>> buildActionsOnPassedHook(DeciTreeOption<MatTypeInfo> option) {
		List<ActionStdV1<MatTypeInfo>> actions = new ArrayList<>();
		
		ActionStdV1<MatTypeInfo> select = new StdMatTypeSelect(option);
		
		actions.add(select);
		return actions;
	}
}
