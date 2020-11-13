package br.com.mind5.masterData.materialCategorySearch.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.masterData.materialCategorySearch.info.MategarchInfo;
import br.com.mind5.masterData.materialCategorySearch.model.action.StdMategarchDaoSelect;
import br.com.mind5.masterData.materialCategorySearch.model.checker.MategarchCheckRead;
import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateReadV2;

public final class RootMategarchSelect extends DeciTreeTemplateReadV2<MategarchInfo> {
	
	public RootMategarchSelect(DeciTreeOption<MategarchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<MategarchInfo> buildCheckerHook(DeciTreeOption<MategarchInfo> option) {
		List<ModelCheckerV1<MategarchInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<MategarchInfo> checker;
		ModelCheckerOption checkerOption;	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new MategarchCheckRead(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV2<MategarchInfo>> buildActionsOnPassedHook(DeciTreeOption<MategarchInfo> option) {
		List<ActionStdV2<MategarchInfo>> actions = new ArrayList<>();
		
		ActionStdV2<MategarchInfo> select = new StdMategarchDaoSelect(option);
		
		actions.add(select);
		return actions;
	}
}
