package br.com.mind5.business.cartItem.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.cartItem.info.CartemInfo;
import br.com.mind5.business.cartItem.model.action.LazyCartemEnforceTotitem;
import br.com.mind5.business.cartItem.model.action.LazyCartemEnforceWeekday;
import br.com.mind5.business.cartItem.model.action.LazyCartemMergeEmplis;
import br.com.mind5.business.cartItem.model.action.LazyCartemMergeMatlis;
import br.com.mind5.business.cartItem.model.action.LazyCartemMergeMatore;
import br.com.mind5.business.cartItem.model.action.LazyCartemMergeWeekday;
import br.com.mind5.business.cartItem.model.action.StdCartemMergeStolis;
import br.com.mind5.business.cartItem.model.checker.CartemCheckService;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeWriteTemplate;

public final class NodeCartemSelectService extends DeciTreeWriteTemplate<CartemInfo> {
	
	public NodeCartemSelectService(DeciTreeOption<CartemInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<CartemInfo> buildDecisionCheckerHook(DeciTreeOption<CartemInfo> option) {
		List<ModelChecker<CartemInfo>> queue = new ArrayList<>();		
		ModelChecker<CartemInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new CartemCheckService(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<CartemInfo>> buildActionsOnPassedHook(DeciTreeOption<CartemInfo> option) {
		List<ActionStdV1<CartemInfo>> actions = new ArrayList<>();
		
		ActionStdV1<CartemInfo> mergeStolis = new StdCartemMergeStolis(option);
		ActionLazyV1<CartemInfo> mergeMatlis = new LazyCartemMergeMatlis(option.conn, option.schemaName);
		ActionLazyV1<CartemInfo> mergeEmplis = new LazyCartemMergeEmplis(option.conn, option.schemaName);
		ActionLazyV1<CartemInfo> enforceWeekday = new LazyCartemEnforceWeekday(option.conn, option.schemaName);
		ActionLazyV1<CartemInfo> mergeWeekday = new LazyCartemMergeWeekday(option.conn, option.schemaName);
		ActionLazyV1<CartemInfo> mergeMatore = new LazyCartemMergeMatore(option.conn, option.schemaName);
		ActionLazyV1<CartemInfo> enforceTotitem = new LazyCartemEnforceTotitem(option.conn, option.schemaName);
		
		mergeStolis.addPostAction(mergeMatlis);
		mergeMatlis.addPostAction(mergeEmplis);
		mergeEmplis.addPostAction(enforceWeekday);
		enforceWeekday.addPostAction(mergeWeekday);
		mergeWeekday.addPostAction(mergeMatore);
		mergeMatore.addPostAction(enforceTotitem);
		
		actions.add(mergeStolis);
		return actions;
	}
}
