package br.com.mind5.business.cartItem.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.cartItem.info.CartemInfo;
import br.com.mind5.business.cartItem.model.action.LazyCartemRootSelect;
import br.com.mind5.business.cartItem.model.action.StdCartemMergeCartemarch;
import br.com.mind5.business.cartItem.model.checker.CartemCheckDummy;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeWriteTemplate;

public final class RootCartemSearch extends DeciTreeWriteTemplate<CartemInfo> {
	
	public RootCartemSearch(DeciTreeOption<CartemInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<CartemInfo> buildDecisionCheckerHook(DeciTreeOption<CartemInfo> option) {
		List<ModelChecker<CartemInfo>> queue = new ArrayList<>();		
		ModelChecker<CartemInfo> checker;
		
		checker = new CartemCheckDummy();
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<CartemInfo>> buildActionsOnPassedHook(DeciTreeOption<CartemInfo> option) {
		List<ActionStdV1<CartemInfo>> actions = new ArrayList<>();
		
		ActionStdV1<CartemInfo> mergeCartemarch = new StdCartemMergeCartemarch(option);
		ActionLazyV1<CartemInfo> select = new LazyCartemRootSelect(option.conn, option.schemaName);
		
		mergeCartemarch.addPostAction(select);
		
		actions.add(mergeCartemarch);
		return actions;
	}
}
