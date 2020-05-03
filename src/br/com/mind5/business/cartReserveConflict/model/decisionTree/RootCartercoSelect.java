package br.com.mind5.business.cartReserveConflict.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.cartReserveConflict.info.CartercoInfo;
import br.com.mind5.business.cartReserveConflict.model.action.LazyCartercoPruneUsername;
import br.com.mind5.business.cartReserveConflict.model.action.StdCartercoMergeCarterve;
import br.com.mind5.business.cartReserveConflict.model.checker.CartercoCheckRead;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateReadV2;

public final class RootCartercoSelect extends DeciTreeTemplateReadV2<CartercoInfo> {
	
	public RootCartercoSelect(DeciTreeOption<CartercoInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<CartercoInfo> buildCheckerHook(DeciTreeOption<CartercoInfo> option) {
		List<ModelCheckerV1<CartercoInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<CartercoInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new CartercoCheckRead(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<CartercoInfo>> buildActionsOnPassedHook(DeciTreeOption<CartercoInfo> option) {
		List<ActionStdV1<CartercoInfo>> actions = new ArrayList<>();	
		
		ActionStdV1<CartercoInfo> mergeCarterve = new StdCartercoMergeCarterve(option);
		ActionLazyV1<CartercoInfo> pruneUsername = new LazyCartercoPruneUsername(option.conn, option.schemaName);
		
		mergeCarterve.addPostAction(pruneUsername);
		
		actions.add(mergeCarterve);			
		return actions;
	}
}
