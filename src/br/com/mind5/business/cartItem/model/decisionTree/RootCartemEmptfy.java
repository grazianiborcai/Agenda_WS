package br.com.mind5.business.cartItem.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.cartItem.info.CartemInfo;
import br.com.mind5.business.cartItem.model.action.LazyCartemMergeToSelect;
import br.com.mind5.business.cartItem.model.action.LazyCartemNodeDelete;
import br.com.mind5.business.cartItem.model.action.StdCartemEnforceKey;
import br.com.mind5.business.cartItem.model.checker.CartemCheckRead;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeWriteTemplate;

public final class RootCartemEmptfy extends DeciTreeWriteTemplate<CartemInfo> {
	
	public RootCartemEmptfy(DeciTreeOption<CartemInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<CartemInfo> buildDecisionCheckerHook(DeciTreeOption<CartemInfo> option) {
		List<ModelChecker<CartemInfo>> queue = new ArrayList<>();		
		ModelChecker<CartemInfo> checker;
		
		checker = new CartemCheckRead();
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<CartemInfo>> buildActionsOnPassedHook(DeciTreeOption<CartemInfo> option) {
		List<ActionStd<CartemInfo>> actions = new ArrayList<>();
		
		ActionStd<CartemInfo> enforceKey = new StdCartemEnforceKey(option);
		ActionLazy<CartemInfo> select = new LazyCartemMergeToSelect(option.conn, option.schemaName);
		ActionLazy<CartemInfo> delete = new LazyCartemNodeDelete(option.conn, option.schemaName);
		
		enforceKey.addPostAction(select);
		select.addPostAction(delete);
		
		actions.add(enforceKey);
		return actions;
	}
}
