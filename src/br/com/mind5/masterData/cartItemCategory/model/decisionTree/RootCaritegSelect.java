package br.com.mind5.masterData.cartItemCategory.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.masterData.cartItemCategory.info.CaritegInfo;
import br.com.mind5.masterData.cartItemCategory.model.action.StdCaritegDaoSelect;
import br.com.mind5.masterData.cartItemCategory.model.checker.CaritegCheckRead;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;

public final class RootCaritegSelect extends DeciTreeTemplateRead<CaritegInfo> {
	
	public RootCaritegSelect(DeciTreeOption<CaritegInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<CaritegInfo> buildCheckerHook(DeciTreeOption<CaritegInfo> option) {
		List<ModelChecker<CaritegInfo>> queue = new ArrayList<>();		
		ModelChecker<CaritegInfo> checker;
		ModelCheckerOption checkerOption;	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new CaritegCheckRead(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}

		
	
	@Override protected List<ActionStd<CaritegInfo>> buildActionsOnPassedHook(DeciTreeOption<CaritegInfo> option) {
		List<ActionStd<CaritegInfo>> actions = new ArrayList<>();
		
		ActionStd<CaritegInfo> select = new StdCaritegDaoSelect(option);
		
		actions.add(select);
		return actions;
	}
}
