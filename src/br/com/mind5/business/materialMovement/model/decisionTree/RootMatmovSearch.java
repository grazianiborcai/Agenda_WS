package br.com.mind5.business.materialMovement.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.materialMovement.info.MatmovInfo;
import br.com.mind5.business.materialMovement.model.action.LazyMatmovRootSelect;
import br.com.mind5.business.materialMovement.model.action.StdMatmovMergeMatmarch;
import br.com.mind5.business.materialMovement.model.checker.MatmovCheckDummy;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateReadV1;


public final class RootMatmovSearch extends DeciTreeTemplateReadV1<MatmovInfo> {
	
	public RootMatmovSearch(DeciTreeOption<MatmovInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<MatmovInfo> buildCheckerHook(DeciTreeOption<MatmovInfo> option) {
		List<ModelCheckerV1<MatmovInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<MatmovInfo> checker;
	
		checker = new MatmovCheckDummy();
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<MatmovInfo>> buildActionsOnPassedHook(DeciTreeOption<MatmovInfo> option) {
		List<ActionStdV1<MatmovInfo>> actions = new ArrayList<>();

		ActionStdV1<MatmovInfo> mergeMatmarch = new StdMatmovMergeMatmarch(option);
		ActionLazyV1<MatmovInfo> select = new LazyMatmovRootSelect(option.conn, option.schemaName);
		
		mergeMatmarch.addPostAction(select);
		
		actions.add(mergeMatmarch);
		return actions;
	}
}
