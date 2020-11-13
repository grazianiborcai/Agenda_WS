package br.com.mind5.business.materialMovement.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.materialMovement.info.MatmovInfo;
import br.com.mind5.business.materialMovement.model.action.LazyMatmovRootSelect;
import br.com.mind5.business.materialMovement.model.action.StdMatmovMergeMatmarch;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.common.ModelCheckerDummy;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;


public final class RootMatmovSearch extends DeciTreeTemplateRead<MatmovInfo> {
	
	public RootMatmovSearch(DeciTreeOption<MatmovInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<MatmovInfo> buildCheckerHook(DeciTreeOption<MatmovInfo> option) {
		List<ModelChecker<MatmovInfo>> queue = new ArrayList<>();		
		ModelChecker<MatmovInfo> checker;
	
		checker = new ModelCheckerDummy<>();
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
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
