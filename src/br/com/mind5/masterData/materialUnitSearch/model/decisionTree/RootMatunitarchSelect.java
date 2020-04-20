package br.com.mind5.masterData.materialUnitSearch.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.masterData.materialUnitSearch.info.MatunitarchInfo;
import br.com.mind5.masterData.materialUnitSearch.model.action.StdMatunitarchDaoSelect;
import br.com.mind5.masterData.materialUnitSearch.model.checker.MatunitarchCheckRead;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateReadV2;

public final class RootMatunitarchSelect extends DeciTreeTemplateReadV2<MatunitarchInfo> {
	
	public RootMatunitarchSelect(DeciTreeOption<MatunitarchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<MatunitarchInfo> buildCheckerHook(DeciTreeOption<MatunitarchInfo> option) {
		List<ModelCheckerV1<MatunitarchInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<MatunitarchInfo> checker;
		ModelCheckerOption checkerOption;	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new MatunitarchCheckRead(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<MatunitarchInfo>> buildActionsOnPassedHook(DeciTreeOption<MatunitarchInfo> option) {
		List<ActionStdV1<MatunitarchInfo>> actions = new ArrayList<>();
		
		ActionStdV1<MatunitarchInfo> select = new StdMatunitarchDaoSelect(option);
		
		actions.add(select);
		return actions;
	}
}
