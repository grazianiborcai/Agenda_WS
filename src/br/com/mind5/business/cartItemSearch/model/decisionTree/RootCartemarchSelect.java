package br.com.mind5.business.cartItemSearch.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.cartItemSearch.info.CartemarchInfo;
import br.com.mind5.business.cartItemSearch.model.action.StdCartemarchMergeToSelect;
import br.com.mind5.business.cartItemSearch.model.checker.CartemarchCheckRead;
import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWriteV2;

public final class RootCartemarchSelect extends DeciTreeTemplateWriteV2<CartemarchInfo> {
	
	public RootCartemarchSelect(DeciTreeOption<CartemarchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<CartemarchInfo> buildCheckerHook(DeciTreeOption<CartemarchInfo> option) {
		List<ModelCheckerV1<CartemarchInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<CartemarchInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new CartemarchCheckRead(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV2<CartemarchInfo>> buildActionsOnPassedHook(DeciTreeOption<CartemarchInfo> option) {
		List<ActionStdV2<CartemarchInfo>> actions = new ArrayList<>();
		
		ActionStdV2<CartemarchInfo> select = new StdCartemarchMergeToSelect(option);
		
		actions.add(select);
		return actions;
	}
}
