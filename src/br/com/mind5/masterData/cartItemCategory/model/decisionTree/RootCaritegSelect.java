package br.com.mind5.masterData.cartItemCategory.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.masterData.cartItemCategory.info.CaritegInfo;
import br.com.mind5.masterData.cartItemCategory.model.action.StdCaritegDaoSelect;
import br.com.mind5.masterData.cartItemCategory.model.checker.CaritegCheckRead;
import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateReadV2;

public final class RootCaritegSelect extends DeciTreeTemplateReadV2<CaritegInfo> {
	
	public RootCaritegSelect(DeciTreeOption<CaritegInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<CaritegInfo> buildCheckerHook(DeciTreeOption<CaritegInfo> option) {
		List<ModelCheckerV1<CaritegInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<CaritegInfo> checker;
		ModelCheckerOption checkerOption;	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new CaritegCheckRead(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}

		
	
	@Override protected List<ActionStdV2<CaritegInfo>> buildActionsOnPassedHook(DeciTreeOption<CaritegInfo> option) {
		List<ActionStdV2<CaritegInfo>> actions = new ArrayList<>();
		
		ActionStdV2<CaritegInfo> select = new StdCaritegDaoSelect(option);
		
		actions.add(select);
		return actions;
	}
}
