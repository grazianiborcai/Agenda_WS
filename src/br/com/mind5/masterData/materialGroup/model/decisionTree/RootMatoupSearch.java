package br.com.mind5.masterData.materialGroup.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.masterData.materialGroup.info.MatoupInfo;
import br.com.mind5.masterData.materialGroup.model.action.LazyMatoupRootSelect;
import br.com.mind5.masterData.materialGroup.model.action.StdMatoupMergeMatouparch;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.common.ModelCheckerDummy;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateReadV1;

public final class RootMatoupSearch extends DeciTreeTemplateReadV1<MatoupInfo> {
	
	public RootMatoupSearch(DeciTreeOption<MatoupInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<MatoupInfo> buildCheckerHook(DeciTreeOption<MatoupInfo> option) {
		List<ModelCheckerV1<MatoupInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<MatoupInfo> checker;

		checker = new ModelCheckerDummy<>();
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV2<MatoupInfo>> buildActionsOnPassedHook(DeciTreeOption<MatoupInfo> option) {
		List<ActionStdV2<MatoupInfo>> actions = new ArrayList<>();
		
		ActionStdV2<MatoupInfo> mergeMatouparch = new StdMatoupMergeMatouparch(option);
		ActionLazy<MatoupInfo> select = new LazyMatoupRootSelect(option.conn, option.schemaName);
		
		mergeMatouparch.addPostAction(select);
		
		actions.add(mergeMatouparch);
		return actions;
	}
}
