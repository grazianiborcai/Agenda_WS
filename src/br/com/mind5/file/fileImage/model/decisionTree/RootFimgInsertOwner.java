package br.com.mind5.file.fileImage.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.file.fileImage.info.FimgInfo;
import br.com.mind5.file.fileImage.model.action.LazyFimgNodeUpsertOwner;
import br.com.mind5.file.fileImage.model.action.StdFimgEnforceOwner;
import br.com.mind5.file.fileImage.model.checker.FimgCheckInsertOwner;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWriteV2;

public final class RootFimgInsertOwner extends DeciTreeTemplateWriteV2<FimgInfo> {
	
	public RootFimgInsertOwner(DeciTreeOption<FimgInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<FimgInfo> buildCheckerHook(DeciTreeOption<FimgInfo> option) {
		List<ModelCheckerV1<FimgInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<FimgInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new FimgCheckInsertOwner(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<FimgInfo>> buildActionsOnPassedHook(DeciTreeOption<FimgInfo> option) {
		List<ActionStdV1<FimgInfo>> actions = new ArrayList<>();		
		
		ActionStdV1<FimgInfo> enforceOwner = new StdFimgEnforceOwner(option);	
		ActionLazy<FimgInfo> upsert = new LazyFimgNodeUpsertOwner(option.conn, option.schemaName);
		
		enforceOwner.addPostAction(upsert);
		
		actions.add(enforceOwner);		
		return actions;
	}
}
