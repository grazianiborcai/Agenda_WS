package br.com.mind5.file.fileImageList.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.file.fileImageList.info.FimistInfo;
import br.com.mind5.file.fileImageList.model.action.LazyFimistRootSelect;
import br.com.mind5.file.fileImageList.model.action.StdFimistMergeFimarch;
import br.com.mind5.file.fileImageList.model.checker.FimistCheckDummy;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;

public final class RootFimistSearch extends DeciTreeTemplateRead<FimistInfo> {
	
	public RootFimistSearch(DeciTreeOption<FimistInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<FimistInfo> buildCheckerHook(DeciTreeOption<FimistInfo> option) {
		List<ModelCheckerV1<FimistInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<FimistInfo> checker;	

		checker = new FimistCheckDummy();
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<FimistInfo>> buildActionsOnPassedHook(DeciTreeOption<FimistInfo> option) {
		List<ActionStdV1<FimistInfo>> actions = new ArrayList<>();
		
		ActionStdV1<FimistInfo> mergeFimarch = new StdFimistMergeFimarch(option);
		ActionLazyV1<FimistInfo> select = new LazyFimistRootSelect(option.conn, option.schemaName);
		
		mergeFimarch.addPostAction(select);
		
		actions.add(mergeFimarch);
		return actions;
	}
}
