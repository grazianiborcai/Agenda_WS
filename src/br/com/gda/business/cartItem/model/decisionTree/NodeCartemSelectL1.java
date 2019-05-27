package br.com.gda.business.cartItem.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.model.action.ActionStd;
import br.com.gda.business.cartItem.info.CartemInfo;
import br.com.gda.business.cartItem.model.action.LazyCartemEnforceWeekday;
import br.com.gda.business.cartItem.model.action.LazyCartemMergeEmplis;
import br.com.gda.business.cartItem.model.action.LazyCartemMergeMatore;
import br.com.gda.business.cartItem.model.action.LazyCartemMergeWeekday;
import br.com.gda.business.cartItem.model.action.StdCartemMergeStolis;
import br.com.gda.business.cartItem.model.checker.CartemCheckIsService;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.model.decisionTree.DeciTreeWriteTemplate;

public final class NodeCartemSelectL1 extends DeciTreeWriteTemplate<CartemInfo> {
	
	public NodeCartemSelectL1(DeciTreeOption<CartemInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<CartemInfo> buildDecisionCheckerHook(DeciTreeOption<CartemInfo> option) {
		List<ModelChecker<CartemInfo>> queue = new ArrayList<>();		
		ModelChecker<CartemInfo> checker;
		
		checker = new CartemCheckIsService();
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<CartemInfo>> buildActionsOnPassedHook(DeciTreeOption<CartemInfo> option) {
		List<ActionStd<CartemInfo>> actions = new ArrayList<>();
		
		ActionStd<CartemInfo> mergeStolis = new StdCartemMergeStolis(option);
		ActionLazy<CartemInfo> mergeEmplis = new LazyCartemMergeEmplis(option.conn, option.schemaName);
		ActionLazy<CartemInfo> enforceWeekday = new LazyCartemEnforceWeekday(option.conn, option.schemaName);
		ActionLazy<CartemInfo> mergeWeekday = new LazyCartemMergeWeekday(option.conn, option.schemaName);
		ActionLazy<CartemInfo> mergeMatore = new LazyCartemMergeMatore(option.conn, option.schemaName);
		
		mergeStolis.addPostAction(mergeEmplis);
		mergeEmplis.addPostAction(enforceWeekday);
		enforceWeekday.addPostAction(mergeWeekday);
		mergeWeekday.addPostAction(mergeMatore);
		
		actions.add(mergeStolis);
		return actions;
	}
}
