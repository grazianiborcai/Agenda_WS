package br.com.gda.file.fileImage.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.model.action.ActionStd;
import br.com.gda.file.fileImage.info.FimgInfo;
import br.com.gda.file.fileImage.model.action.LazyFimgNodeUpsertOwner;
import br.com.gda.file.fileImage.model.action.StdFimgEnforceOwner;
import br.com.gda.file.fileImage.model.checker.FimgCheckInsertOwner;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.model.decisionTree.DeciTreeWriteTemplate;

public final class RootFimgInsertOwner extends DeciTreeWriteTemplate<FimgInfo> {
	
	public RootFimgInsertOwner(DeciTreeOption<FimgInfo> option) {
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
		checker = new FimgCheckInsertOwner(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<FimgInfo>> buildActionsOnPassedHook(DeciTreeOption<FimgInfo> option) {
		List<ActionStd<FimgInfo>> actions = new ArrayList<>();		
		
		ActionStd<FimgInfo> enforceOwner = new StdFimgEnforceOwner(option);	
		ActionLazy<FimgInfo> upsert = new LazyFimgNodeUpsertOwner(option.conn, option.schemaName);
		
		enforceOwner.addPostAction(upsert);
		
		actions.add(enforceOwner);		
		return actions;
	}
}
