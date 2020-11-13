package br.com.mind5.file.fileImageList.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.file.fileImageList.info.FimistInfo;
import br.com.mind5.file.fileImageList.model.action.LazyFimistRootSelect;
import br.com.mind5.file.fileImageList.model.action.StdFimistMergeFimarch;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.common.ModelCheckerDummy;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateReadV2;

public final class RootFimistSearch extends DeciTreeTemplateReadV2<FimistInfo> {
	
	public RootFimistSearch(DeciTreeOption<FimistInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<FimistInfo> buildCheckerHook(DeciTreeOption<FimistInfo> option) {
		List<ModelCheckerV1<FimistInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<FimistInfo> checker;	

		checker = new ModelCheckerDummy<>();
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV2<FimistInfo>> buildActionsOnPassedHook(DeciTreeOption<FimistInfo> option) {
		List<ActionStdV2<FimistInfo>> actions = new ArrayList<>();
		
		ActionStdV2<FimistInfo> mergeFimarch = new StdFimistMergeFimarch(option);
		ActionLazy<FimistInfo> select = new LazyFimistRootSelect(option.conn, option.schemaName);
		
		mergeFimarch.addPostAction(select);
		
		actions.add(mergeFimarch);
		return actions;
	}
}
