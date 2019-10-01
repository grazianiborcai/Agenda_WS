package br.com.gda.file.fileImage.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.file.fileImage.info.FimgInfo;
import br.com.gda.file.fileImage.model.action.LazyFimgEnforceFullname;
import br.com.gda.file.fileImage.model.action.LazyFimgMergeFath;
import br.com.gda.file.fileImage.model.action.StdFimgMergeToSelect;
import br.com.gda.file.fileImage.model.checker.FimgCheckRead;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.model.decisionTree.DeciTreeReadTemplate;

public final class RootFimgSearch extends DeciTreeReadTemplate<FimgInfo> {
	
	public RootFimgSearch(DeciTreeOption<FimgInfo> option) {
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
		checker = new FimgCheckRead(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<FimgInfo>> buildActionsOnPassedHook(DeciTreeOption<FimgInfo> option) {
		List<ActionStd<FimgInfo>> actions = new ArrayList<>();
		
		ActionStd<FimgInfo> select = new StdFimgMergeToSelect(option);
		ActionLazy<FimgInfo> mergeFath = new LazyFimgMergeFath(option.conn, option.schemaName);
		ActionLazy<FimgInfo> enforceFullname = new LazyFimgEnforceFullname(option.conn, option.schemaName);
		
		select.addPostAction(mergeFath);
		mergeFath.addPostAction(enforceFullname);
		
		actions.add(select);
		return actions;
	}
}
