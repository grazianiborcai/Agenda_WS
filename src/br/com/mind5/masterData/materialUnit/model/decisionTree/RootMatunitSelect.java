package br.com.mind5.masterData.materialUnit.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.masterData.materialUnit.info.MatunitInfo;
import br.com.mind5.masterData.materialUnit.model.action.StdMatunitDaoSelect;
import br.com.mind5.masterData.materialUnit.model.checker.MatunitCheckRead;
import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateReadV2;

public final class RootMatunitSelect extends DeciTreeTemplateReadV2<MatunitInfo> {
	
	public RootMatunitSelect(DeciTreeOption<MatunitInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<MatunitInfo> buildCheckerHook(DeciTreeOption<MatunitInfo> option) {
		List<ModelCheckerV1<MatunitInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<MatunitInfo> checker;
		ModelCheckerOption checkerOption;	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new MatunitCheckRead(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV2<MatunitInfo>> buildActionsOnPassedHook(DeciTreeOption<MatunitInfo> option) {
		List<ActionStdV2<MatunitInfo>> actions = new ArrayList<>();
		
		ActionStdV2<MatunitInfo> select = new StdMatunitDaoSelect(option);
		
		actions.add(select);
		return actions;
	}
}
