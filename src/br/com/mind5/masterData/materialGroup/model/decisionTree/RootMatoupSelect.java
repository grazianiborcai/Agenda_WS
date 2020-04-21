package br.com.mind5.masterData.materialGroup.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.masterData.materialGroup.info.MatoupInfo;
import br.com.mind5.masterData.materialGroup.model.action.LazyMatoupMergeBusarea;
import br.com.mind5.masterData.materialGroup.model.action.StdMatoupDaoSelect;
import br.com.mind5.masterData.materialGroup.model.checker.MatoupCheckRead;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateReadV1;

public final class RootMatoupSelect extends DeciTreeTemplateReadV1<MatoupInfo> {
	
	public RootMatoupSelect(DeciTreeOption<MatoupInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<MatoupInfo> buildCheckerHook(DeciTreeOption<MatoupInfo> option) {
		List<ModelCheckerV1<MatoupInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<MatoupInfo> checker;
		ModelCheckerOption checkerOption;	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new MatoupCheckRead(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<MatoupInfo>> buildActionsOnPassedHook(DeciTreeOption<MatoupInfo> option) {
		List<ActionStdV1<MatoupInfo>> actions = new ArrayList<>();
		
		ActionStdV1<MatoupInfo> select = new StdMatoupDaoSelect(option);
		ActionLazyV1<MatoupInfo> mergeBusarea = new LazyMatoupMergeBusarea(option.conn, option.schemaName);
		
		select.addPostAction(mergeBusarea);
		
		actions.add(select);
		return actions;
	}
}
