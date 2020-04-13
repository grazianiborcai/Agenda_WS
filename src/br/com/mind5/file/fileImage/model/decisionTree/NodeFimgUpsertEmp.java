package br.com.mind5.file.fileImage.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.file.fileImage.info.FimgInfo;
import br.com.mind5.file.fileImage.model.action.LazyFimgRootReplace;
import br.com.mind5.file.fileImage.model.action.StdFimgMergeFimarch;
import br.com.mind5.file.fileImage.model.checker.FimgCheckExistEmp;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWriteV1;

public final class NodeFimgUpsertEmp extends DeciTreeTemplateWriteV1<FimgInfo> {
	
	public NodeFimgUpsertEmp(DeciTreeOption<FimgInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<FimgInfo> buildCheckerHook(DeciTreeOption<FimgInfo> option) {
		List<ModelCheckerV1<FimgInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<FimgInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.NOT_FOUND;	
		checker = new FimgCheckExistEmp(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<FimgInfo>> buildActionsOnPassedHook(DeciTreeOption<FimgInfo> option) {
		List<ActionStdV1<FimgInfo>> actions = new ArrayList<>();		
		
		ActionStdV1<FimgInfo> insert = new RootFimgInsert(option).toAction();
		
		actions.add(insert);		
		return actions;
	}
	
	
	
	@Override protected List<ActionStdV1<FimgInfo>> buildActionsOnFailedHook(DeciTreeOption<FimgInfo> option) {
		List<ActionStdV1<FimgInfo>> actions = new ArrayList<>();		
		
		ActionStdV1<FimgInfo> mergeFimarch = new StdFimgMergeFimarch(option);
		ActionLazyV1<FimgInfo> replace = new LazyFimgRootReplace(option.conn, option.schemaName);
		
		mergeFimarch.addPostAction(replace);
		
		actions.add(mergeFimarch);		
		return actions;
	}
}
