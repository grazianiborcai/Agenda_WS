package br.com.mind5.business.materialMovement.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.materialMovement.info.MatmovInfo;
import br.com.mind5.business.materialMovement.model.action.LazyMatmovRootSelect;
import br.com.mind5.business.materialMovement.model.action.StdMatmovMergeMatmarch;
import br.com.mind5.business.materialMovement.model.checker.MatmovCheckDummy;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeReadTemplate;


public final class RootMatmovSearch extends DeciTreeReadTemplate<MatmovInfo> {
	
	public RootMatmovSearch(DeciTreeOption<MatmovInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<MatmovInfo> buildDecisionCheckerHook(DeciTreeOption<MatmovInfo> option) {
		List<ModelChecker<MatmovInfo>> queue = new ArrayList<>();		
		ModelChecker<MatmovInfo> checker;
	
		checker = new MatmovCheckDummy();
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<MatmovInfo>> buildActionsOnPassedHook(DeciTreeOption<MatmovInfo> option) {
		List<ActionStd<MatmovInfo>> actions = new ArrayList<>();

		ActionStd<MatmovInfo> mergeMatmarch = new StdMatmovMergeMatmarch(option);
		ActionLazy<MatmovInfo> select = new LazyMatmovRootSelect(option.conn, option.schemaName);
		
		mergeMatmarch.addPostAction(select);
		
		actions.add(mergeMatmarch);
		return actions;
	}
}
