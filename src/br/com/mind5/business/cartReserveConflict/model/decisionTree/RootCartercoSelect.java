package br.com.mind5.business.cartReserveConflict.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.cartReserveConflict.info.CartercoInfo;
import br.com.mind5.business.cartReserveConflict.model.action.LazyCartercoPruneUsername;
import br.com.mind5.business.cartReserveConflict.model.action.StdCartercoMergeCarterve;
import br.com.mind5.business.cartReserveConflict.model.checker.CartercoCheckRead;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;

public final class RootCartercoSelect extends DeciTreeTemplateRead<CartercoInfo> {
	
	public RootCartercoSelect(DeciTreeOption<CartercoInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<CartercoInfo> buildCheckerHook(DeciTreeOption<CartercoInfo> option) {
		List<ModelChecker<CartercoInfo>> queue = new ArrayList<>();		
		ModelChecker<CartercoInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new CartercoCheckRead(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<CartercoInfo>> buildActionsOnPassedHook(DeciTreeOption<CartercoInfo> option) {
		List<ActionStd<CartercoInfo>> actions = new ArrayList<>();	
		
		ActionStd<CartercoInfo> mergeCarterve = new StdCartercoMergeCarterve(option);
		ActionLazy<CartercoInfo> pruneUsername = new LazyCartercoPruneUsername(option.conn, option.schemaName);
		
		mergeCarterve.addPostAction(pruneUsername);
		
		actions.add(mergeCarterve);			
		return actions;
	}
}
