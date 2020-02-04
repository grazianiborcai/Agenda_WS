package br.com.mind5.business.cartReserveConflict.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.cartReserveConflict.info.CartercoInfo;
import br.com.mind5.business.cartReserveConflict.model.action.LazyCartercoPruneCarterve;
import br.com.mind5.business.cartReserveConflict.model.action.StdCartercoMergeUsername;
import br.com.mind5.business.cartReserveConflict.model.checker.CartercoCheckRead;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeReadTemplate;

public final class RootCartercoSelect extends DeciTreeReadTemplate<CartercoInfo> {
	
	public RootCartercoSelect(DeciTreeOption<CartercoInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<CartercoInfo> buildDecisionCheckerHook(DeciTreeOption<CartercoInfo> option) {
		List<ModelChecker<CartercoInfo>> queue = new ArrayList<>();		
		ModelChecker<CartercoInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new CartercoCheckRead(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<CartercoInfo>> buildActionsOnPassedHook(DeciTreeOption<CartercoInfo> option) {
		List<ActionStd<CartercoInfo>> actions = new ArrayList<>();	
		
		ActionStd<CartercoInfo> mergeUsername = new StdCartercoMergeUsername(option);
		ActionLazy<CartercoInfo> pruneCarterve = new LazyCartercoPruneCarterve(option.conn, option.schemaName);
		
		mergeUsername.addPostAction(pruneCarterve);
		
		actions.add(mergeUsername);			
		return actions;
	}
}
