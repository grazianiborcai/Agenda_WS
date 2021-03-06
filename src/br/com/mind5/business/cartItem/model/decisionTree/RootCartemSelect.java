package br.com.mind5.business.cartItem.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.cartItem.info.CartemInfo;
import br.com.mind5.business.cartItem.model.action.LazyCartemNodeAged;
import br.com.mind5.business.cartItem.model.action.LazyCartemNodeSelect;
import br.com.mind5.business.cartItem.model.action.StdCartemMergeToSelect;
import br.com.mind5.business.cartItem.model.checker.CartemCheckRead;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class RootCartemSelect extends DeciTreeTemplateWrite<CartemInfo> {
	
	public RootCartemSelect(DeciTreeOption<CartemInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<CartemInfo> buildCheckerHook(DeciTreeOption<CartemInfo> option) {
		List<ModelChecker<CartemInfo>> queue = new ArrayList<>();		
		ModelChecker<CartemInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new CartemCheckRead(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<CartemInfo>> buildActionsOnPassedHook(DeciTreeOption<CartemInfo> option) {
		List<ActionStd<CartemInfo>> actions = new ArrayList<>();
		
		ActionStd<CartemInfo> select = new StdCartemMergeToSelect(option);
		ActionLazy<CartemInfo> nodeSelect = new LazyCartemNodeSelect(option.conn, option.schemaName);		
		ActionLazy<CartemInfo> nodeAged = new LazyCartemNodeAged(option.conn, option.schemaName);	
		
		select.addPostAction(nodeSelect);
		nodeSelect.addPostAction(nodeAged);
		
		actions.add(select);
		return actions;
	}
}
