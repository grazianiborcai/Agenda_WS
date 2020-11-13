package br.com.mind5.file.fileImage.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.file.fileImage.info.FimgInfo;
import br.com.mind5.file.fileImage.model.action.LazyFimgMergeToSelect;
import br.com.mind5.file.fileImage.model.action.LazyFimgNodeCoverOffL4;
import br.com.mind5.file.fileImage.model.action.StdFimgMergeFimarchMat;
import br.com.mind5.file.fileImage.model.action.StdFimgSuccess;
import br.com.mind5.file.fileImage.model.checker.FimgCheckExistMat;
import br.com.mind5.file.fileImage.model.checker.FimgCheckIsCover;
import br.com.mind5.file.fileImage.model.checker.FimgCheckIsMat;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWriteV2;

public final class NodeFimgCoverOffL3 extends DeciTreeTemplateWriteV2<FimgInfo> {
	
	public NodeFimgCoverOffL3(DeciTreeOption<FimgInfo> option) {
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
		checker = new FimgCheckIsMat(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new FimgCheckIsCover(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new FimgCheckExistMat(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV2<FimgInfo>> buildActionsOnPassedHook(DeciTreeOption<FimgInfo> option) {
		List<ActionStdV2<FimgInfo>> actions = new ArrayList<>();		
		
		ActionStdV2<FimgInfo> mergeFimarch = new StdFimgMergeFimarchMat(option);	
		ActionLazy<FimgInfo> select = new LazyFimgMergeToSelect(option.conn, option.schemaName);
		ActionLazy<FimgInfo> coverOff = new LazyFimgNodeCoverOffL4(option.conn, option.schemaName);
		
		mergeFimarch.addPostAction(select);
		select.addPostAction(coverOff);
		
		actions.add(mergeFimarch);		
		return actions;
	}
	
	
	
	@Override protected List<ActionStdV2<FimgInfo>> buildActionsOnFailedHook(DeciTreeOption<FimgInfo> option) {
		List<ActionStdV2<FimgInfo>> actions = new ArrayList<>();		
		
		ActionStdV2<FimgInfo> success = new StdFimgSuccess(option);	
		
		actions.add(success);		
		return actions;
	}
}
