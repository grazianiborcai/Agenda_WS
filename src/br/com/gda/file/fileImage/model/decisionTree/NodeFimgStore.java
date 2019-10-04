package br.com.gda.file.fileImage.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.model.action.ActionStd;
import br.com.gda.file.fileImage.info.FimgInfo;
import br.com.gda.file.fileImage.model.action.LazyFimgMergeToSelect;
import br.com.gda.file.fileImage.model.action.LazyFimgNodeCover;
import br.com.gda.file.fileImage.model.action.StdFimgMergeFimarchStore;
import br.com.gda.file.fileImage.model.action.StdFimgSuccess;
import br.com.gda.file.fileImage.model.checker.FimgCheckExistStore;
import br.com.gda.file.fileImage.model.checker.FimgCheckIsCover;
import br.com.gda.file.fileImage.model.checker.FimgCheckIsStore;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.model.decisionTree.DeciTreeWriteTemplate;

public final class NodeFimgStore extends DeciTreeWriteTemplate<FimgInfo> {
	
	public NodeFimgStore(DeciTreeOption<FimgInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<FimgInfo> buildDecisionCheckerHook(DeciTreeOption<FimgInfo> option) {
		List<ModelChecker<FimgInfo>> queue = new ArrayList<>();		
		ModelChecker<FimgInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new FimgCheckIsStore(checkerOption);
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
		checker = new FimgCheckExistStore(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<FimgInfo>> buildActionsOnPassedHook(DeciTreeOption<FimgInfo> option) {
		List<ActionStd<FimgInfo>> actions = new ArrayList<>();		
		
		ActionStd<FimgInfo> mergeFimarch = new StdFimgMergeFimarchStore(option);	
		ActionLazy<FimgInfo> select = new LazyFimgMergeToSelect(option.conn, option.schemaName);
		ActionLazy<FimgInfo> cover = new LazyFimgNodeCover(option.conn, option.schemaName);
		
		mergeFimarch.addPostAction(select);
		select.addPostAction(cover);
		
		actions.add(mergeFimarch);		
		return actions;
	}
	
	
	
	@Override protected List<ActionStd<FimgInfo>> buildActionsOnFailedHook(DeciTreeOption<FimgInfo> option) {
		List<ActionStd<FimgInfo>> actions = new ArrayList<>();		
		
		ActionStd<FimgInfo> success = new StdFimgSuccess(option);	
		
		actions.add(success);		
		return actions;
	}
}
