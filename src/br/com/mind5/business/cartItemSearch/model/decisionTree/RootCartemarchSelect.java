package br.com.mind5.business.cartItemSearch.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.cartItemSearch.info.CartemarchInfo;
import br.com.mind5.business.cartItemSearch.model.action.StdCartemarchMergeToSelect;
import br.com.mind5.business.cartItemSearch.model.checker.CartemarchCheckRead;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeWriteTemplate;

public final class RootCartemarchSelect extends DeciTreeWriteTemplate<CartemarchInfo> {
	
	public RootCartemarchSelect(DeciTreeOption<CartemarchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<CartemarchInfo> buildDecisionCheckerHook(DeciTreeOption<CartemarchInfo> option) {
		List<ModelChecker<CartemarchInfo>> queue = new ArrayList<>();		
		ModelChecker<CartemarchInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new CartemarchCheckRead(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<CartemarchInfo>> buildActionsOnPassedHook(DeciTreeOption<CartemarchInfo> option) {
		List<ActionStdV1<CartemarchInfo>> actions = new ArrayList<>();
		
		ActionStdV1<CartemarchInfo> select = new StdCartemarchMergeToSelect(option);
		
		actions.add(select);
		return actions;
	}
}
