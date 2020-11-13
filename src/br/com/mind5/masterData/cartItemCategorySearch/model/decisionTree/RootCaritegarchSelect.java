package br.com.mind5.masterData.cartItemCategorySearch.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.masterData.cartItemCategorySearch.info.CaritegarchInfo;
import br.com.mind5.masterData.cartItemCategorySearch.model.action.StdCaritegarchDaoSelect;
import br.com.mind5.masterData.cartItemCategorySearch.model.checker.CaritegarchCheckRead;
import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateReadV2;

public final class RootCaritegarchSelect extends DeciTreeTemplateReadV2<CaritegarchInfo> {
	
	public RootCaritegarchSelect(DeciTreeOption<CaritegarchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<CaritegarchInfo> buildCheckerHook(DeciTreeOption<CaritegarchInfo> option) {
		List<ModelCheckerV1<CaritegarchInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<CaritegarchInfo> checker;
		ModelCheckerOption checkerOption;	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new CaritegarchCheckRead(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}

		
	
	@Override protected List<ActionStdV2<CaritegarchInfo>> buildActionsOnPassedHook(DeciTreeOption<CaritegarchInfo> option) {
		List<ActionStdV2<CaritegarchInfo>> actions = new ArrayList<>();
		
		ActionStdV2<CaritegarchInfo> select = new StdCaritegarchDaoSelect(option);
		
		actions.add(select);
		return actions;
	}
}
