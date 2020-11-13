package br.com.mind5.masterData.cartItemCategorySearch.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.masterData.cartItemCategorySearch.info.CaritegarchInfo;
import br.com.mind5.masterData.cartItemCategorySearch.model.action.StdCaritegarchDaoSelect;
import br.com.mind5.masterData.cartItemCategorySearch.model.checker.CaritegarchCheckRead;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;

public final class RootCaritegarchSelect extends DeciTreeTemplateRead<CaritegarchInfo> {
	
	public RootCaritegarchSelect(DeciTreeOption<CaritegarchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<CaritegarchInfo> buildCheckerHook(DeciTreeOption<CaritegarchInfo> option) {
		List<ModelChecker<CaritegarchInfo>> queue = new ArrayList<>();		
		ModelChecker<CaritegarchInfo> checker;
		ModelCheckerOption checkerOption;	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new CaritegarchCheckRead(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}

		
	
	@Override protected List<ActionStd<CaritegarchInfo>> buildActionsOnPassedHook(DeciTreeOption<CaritegarchInfo> option) {
		List<ActionStd<CaritegarchInfo>> actions = new ArrayList<>();
		
		ActionStd<CaritegarchInfo> select = new StdCaritegarchDaoSelect(option);
		
		actions.add(select);
		return actions;
	}
}
