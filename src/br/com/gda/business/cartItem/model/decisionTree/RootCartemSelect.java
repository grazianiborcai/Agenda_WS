package br.com.gda.business.cartItem.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStd;
import br.com.gda.business.cartItem.info.CartemInfo;
import br.com.gda.business.cartItem.model.action.LazyCartemMergeMat;
import br.com.gda.business.cartItem.model.action.LazyCartemNodeSelectL1;
import br.com.gda.business.cartItem.model.action.StdCartemMergeToSelect;
import br.com.gda.business.cartItem.model.checker.CartemCheckRead;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.model.decisionTree.DeciTreeWriteTemplate;

public final class RootCartemSelect extends DeciTreeWriteTemplate<CartemInfo> {
	
	public RootCartemSelect(DeciTreeOption<CartemInfo> option) {
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
		
		ActionStd<CartemInfo> select = new StdCartemMergeToSelect(option);
		ActionLazy<CartemInfo> mergeMat = new LazyCartemMergeMat(option.conn, option.schemaName);
		ActionLazy<CartemInfo> nodeL1 = new LazyCartemNodeSelectL1(option.conn, option.schemaName);		
		
		select.addPostAction(mergeMat);
		mergeMat.addPostAction(nodeL1);
		
		actions.add(select);
		return actions;
	}
}
