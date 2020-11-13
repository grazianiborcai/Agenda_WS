package br.com.mind5.business.materialList.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.materialList.info.MatlisInfo;
import br.com.mind5.business.materialList.model.action.LazyMatlisRootSelect;
import br.com.mind5.business.materialList.model.action.StdMatlisMergeMatarch;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.common.ModelCheckerDummy;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateReadV2;

public final class RootMatlisSearch extends DeciTreeTemplateReadV2<MatlisInfo> {
	
	public RootMatlisSearch(DeciTreeOption<MatlisInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<MatlisInfo> buildCheckerHook(DeciTreeOption<MatlisInfo> option) {
		List<ModelCheckerV1<MatlisInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<MatlisInfo> checker;

		checker = new ModelCheckerDummy<>();
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<MatlisInfo>> buildActionsOnPassedHook(DeciTreeOption<MatlisInfo> option) {
		List<ActionStdV1<MatlisInfo>> actions = new ArrayList<>();
		
		ActionStdV1<MatlisInfo> mergeMatarch = new StdMatlisMergeMatarch(option);
		ActionLazy<MatlisInfo> select = new LazyMatlisRootSelect(option.conn, option.schemaName);
		
		mergeMatarch.addPostAction(select);
		
		actions.add(mergeMatarch);
		return actions;
	}
}
