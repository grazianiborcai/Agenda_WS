package br.com.mind5.file.filePath.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.file.filePath.info.FathInfo;
import br.com.mind5.file.filePath.model.action.StdFathSelect;
import br.com.mind5.file.filePath.model.checker.FathCheckRead;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateReadV1;

public final class RootFathSelect extends DeciTreeTemplateReadV1<FathInfo> {
	
	public RootFathSelect(DeciTreeOption<FathInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<FathInfo> buildCheckerHook(DeciTreeOption<FathInfo> option) {
		List<ModelCheckerV1<FathInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<FathInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new FathCheckRead(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<FathInfo>> buildActionsOnPassedHook(DeciTreeOption<FathInfo> option) {
		List<ActionStdV1<FathInfo>> actions = new ArrayList<>();
		
		ActionStdV1<FathInfo> select = new StdFathSelect(option);
		
		actions.add(select);
		return actions;
	}
}
