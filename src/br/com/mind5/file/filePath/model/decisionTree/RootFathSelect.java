package br.com.mind5.file.filePath.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.file.filePath.info.FathInfo;
import br.com.mind5.file.filePath.model.action.StdFathDaoSelect;
import br.com.mind5.file.filePath.model.checker.FathCheckRead;
import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateReadV2;

public final class RootFathSelect extends DeciTreeTemplateReadV2<FathInfo> {
	
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
	
	
	
	@Override protected List<ActionStdV2<FathInfo>> buildActionsOnPassedHook(DeciTreeOption<FathInfo> option) {
		List<ActionStdV2<FathInfo>> actions = new ArrayList<>();
		
		ActionStdV2<FathInfo> select = new StdFathDaoSelect(option);
		
		actions.add(select);
		return actions;
	}
}
