package br.com.mind5.business.cartReserveConflict.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.cartReserveConflict.info.CartercoInfo;
import br.com.mind5.business.cartReserveConflict.model.action.CartercoVisiMergeCarterve;
import br.com.mind5.business.cartReserveConflict.model.action.CartercoVisiPruneUsername;
import br.com.mind5.business.cartReserveConflict.model.checker.CartercoCheckRead;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;

public final class CartercoRootSelect extends DeciTreeTemplateRead<CartercoInfo> {
	
	public CartercoRootSelect(DeciTreeOption<CartercoInfo> option) {
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
		
		ActionStd<CartercoInfo> mergeCarterve = new ActionStdCommom<CartercoInfo>(option, CartercoVisiMergeCarterve.class);
		ActionLazy<CartercoInfo> pruneUsername = new ActionLazyCommom<CartercoInfo>(option, CartercoVisiPruneUsername.class);
		
		mergeCarterve.addPostAction(pruneUsername);
		
		actions.add(mergeCarterve);			
		return actions;
	}
}
