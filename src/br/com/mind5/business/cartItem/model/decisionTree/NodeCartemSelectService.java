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
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWriteV2;

public final class NodeCartemSelectService extends DeciTreeTemplateWriteV2<CartemInfo> {
	
	public NodeCartemSelectService(DeciTreeOption<CartemInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<CartemInfo> buildCheckerHook(DeciTreeOption<CartemInfo> option) {
		List<ModelCheckerV1<CartemInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<CartemInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new CartemCheckService(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<CartemInfo>> buildActionsOnPassedHook(DeciTreeOption<CartemInfo> option) {
		List<ActionStdV1<CartemInfo>> actions = new ArrayList<>();
		
		ActionStdV1<CartemInfo> mergeStolis = new StdCartemMergeStolis(option);
		ActionLazy<CartemInfo> mergeMatlis = new LazyCartemMergeMatlis(option.conn, option.schemaName);
		ActionLazy<CartemInfo> mergeEmplis = new LazyCartemMergeEmplis(option.conn, option.schemaName);
		ActionLazy<CartemInfo> enforceWeekday = new LazyCartemEnforceWeekday(option.conn, option.schemaName);
		ActionLazy<CartemInfo> mergeWeekday = new LazyCartemMergeWeekday(option.conn, option.schemaName);
		ActionLazy<CartemInfo> mergeMatore = new LazyCartemMergeMatore(option.conn, option.schemaName);
		ActionLazy<CartemInfo> enforceTotitem = new LazyCartemEnforceTotitem(option.conn, option.schemaName);
		
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
