package br.com.mind5.business.cartReserve.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.cartReserve.info.CarterveInfo;
import br.com.mind5.business.cartReserve.model.action.LazyCarterveMergeToSelect;
import br.com.mind5.business.cartReserve.model.action.StdCarterveEnforceLChanged;
import br.com.mind5.business.cartReserve.model.checker.CarterveCheckRead;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateReadV2;

public final class RootCarterveSelect extends DeciTreeTemplateReadV2<CarterveInfo> {
	
	public RootCarterveSelect(DeciTreeOption<CarterveInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<CarterveInfo> buildCheckerHook(DeciTreeOption<CarterveInfo> option) {
		List<ModelCheckerV1<CarterveInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<CarterveInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new CarterveCheckRead(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<CarterveInfo>> buildActionsOnPassedHook(DeciTreeOption<CarterveInfo> option) {
		List<ActionStdV1<CarterveInfo>> actions = new ArrayList<>();	
		
		ActionStdV1<CarterveInfo> enforceLChanged = new StdCarterveEnforceLChanged(option);
		ActionLazyV1<CarterveInfo> select = new LazyCarterveMergeToSelect(option.conn, option.schemaName);
		
		enforceLChanged.addPostAction(select);
		
		actions.add(enforceLChanged);			
		return actions;
	}
}
