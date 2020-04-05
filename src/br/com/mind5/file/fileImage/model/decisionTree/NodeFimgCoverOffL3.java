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
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeWriteTemplate;

public final class NodeFimgCoverOffL3 extends DeciTreeWriteTemplate<FimgInfo> {
	
	public NodeFimgCoverOffL3(DeciTreeOption<FimgInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<FimgInfo> buildCheckerHook(DeciTreeOption<FimgInfo> option) {
		List<ModelChecker<FimgInfo>> queue = new ArrayList<>();		
		ModelChecker<FimgInfo> checker;	
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
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<FimgInfo>> buildActionsOnPassedHook(DeciTreeOption<FimgInfo> option) {
		List<ActionStdV1<FimgInfo>> actions = new ArrayList<>();		
		
		ActionStdV1<FimgInfo> mergeFimarch = new StdFimgMergeFimarchMat(option);	
		ActionLazyV1<FimgInfo> select = new LazyFimgMergeToSelect(option.conn, option.schemaName);
		ActionLazyV1<FimgInfo> coverOff = new LazyFimgNodeCoverOffL4(option.conn, option.schemaName);
		
		mergeFimarch.addPostAction(select);
		select.addPostAction(coverOff);
		
		actions.add(mergeFimarch);		
		return actions;
	}
	
	
	
	@Override protected List<ActionStdV1<FimgInfo>> buildActionsOnFailedHook(DeciTreeOption<FimgInfo> option) {
		List<ActionStdV1<FimgInfo>> actions = new ArrayList<>();		
		
		ActionStdV1<FimgInfo> success = new StdFimgSuccess(option);	
		
		actions.add(success);		
		return actions;
	}
}
