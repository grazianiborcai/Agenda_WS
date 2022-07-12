package br.com.mind5.file.fileImage.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.file.fileImage.info.FimgInfo;
import br.com.mind5.file.fileImage.model.action.FimgVisiNodeCoverOffL4;
import br.com.mind5.file.fileImage.model.action.FimgVisiMergeFimarchMat;
import br.com.mind5.file.fileImage.model.action.FimgVisiMergeToSelect;
import br.com.mind5.file.fileImage.model.checker.FimgCheckExistMat;
import br.com.mind5.file.fileImage.model.checker.FimgCheckIsCover;
import br.com.mind5.file.fileImage.model.checker.FimgCheckIsMat;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.action.commom.ActionStdSuccessCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class FimgNodeCoverOffL3 extends DeciTreeTemplateWrite<FimgInfo> {
	
	public FimgNodeCoverOffL3(DeciTreeOption<FimgInfo> option) {
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
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<FimgInfo>> buildActionsOnPassedHook(DeciTreeOption<FimgInfo> option) {
		List<ActionStd<FimgInfo>> actions = new ArrayList<>();		
		
		ActionStd<FimgInfo> mergeFimarch = new ActionStdCommom<FimgInfo>(option, FimgVisiMergeFimarchMat.class);	
		ActionLazy<FimgInfo> select = new ActionLazyCommom<FimgInfo>(option, FimgVisiMergeToSelect.class);
		ActionLazy<FimgInfo> coverOff = new ActionLazyCommom<FimgInfo>(option, FimgVisiNodeCoverOffL4.class);
		
		mergeFimarch.addPostAction(select);
		select.addPostAction(coverOff);
		
		actions.add(mergeFimarch);		
		return actions;
	}
	
	
	
	@Override protected List<ActionStd<FimgInfo>> buildActionsOnFailedHook(DeciTreeOption<FimgInfo> option) {
		List<ActionStd<FimgInfo>> actions = new ArrayList<>();		
		
		ActionStd<FimgInfo> success = new ActionStdSuccessCommom<FimgInfo>(option);
		
		actions.add(success);		
		return actions;
	}
}
