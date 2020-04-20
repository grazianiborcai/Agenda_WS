package br.com.mind5.masterData.materialCategory.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.masterData.materialCategory.info.MategInfo;
import br.com.mind5.masterData.materialCategory.model.action.StdMategDaoSelect;
import br.com.mind5.masterData.materialCategory.model.checker.MategCheckRead;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateReadV2;

public final class RootMategSelect extends DeciTreeTemplateReadV2<MategInfo> {
	
	public RootMategSelect(DeciTreeOption<MategInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<MategInfo> buildCheckerHook(DeciTreeOption<MategInfo> option) {
		List<ModelCheckerV1<MategInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<MategInfo> checker;
		ModelCheckerOption checkerOption;	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new MategCheckRead(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<MategInfo>> buildActionsOnPassedHook(DeciTreeOption<MategInfo> option) {
		List<ActionStdV1<MategInfo>> actions = new ArrayList<>();
		
		ActionStdV1<MategInfo> select = new StdMategDaoSelect(option);
		
		actions.add(select);
		return actions;
	}
}
