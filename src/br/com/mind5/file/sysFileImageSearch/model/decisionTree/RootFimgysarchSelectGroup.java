package br.com.mind5.file.sysFileImageSearch.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.file.sysFileImageSearch.info.FimgysarchInfo;
import br.com.mind5.file.sysFileImageSearch.model.action.LazyFimgysarchRootSelect;
import br.com.mind5.file.sysFileImageSearch.model.action.StdFimgysarchEnforceGroup;
import br.com.mind5.file.sysFileImageSearch.model.checker.FimgysarchCheckReadGroup;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;

public final class RootFimgysarchSelectGroup extends DeciTreeTemplateRead<FimgysarchInfo> {
	
	public RootFimgysarchSelectGroup(DeciTreeOption<FimgysarchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<FimgysarchInfo> buildCheckerHook(DeciTreeOption<FimgysarchInfo> option) {
		List<ModelChecker<FimgysarchInfo>> queue = new ArrayList<>();		
		ModelChecker<FimgysarchInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new FimgysarchCheckReadGroup(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<FimgysarchInfo>> buildActionsOnPassedHook(DeciTreeOption<FimgysarchInfo> option) {
		List<ActionStd<FimgysarchInfo>> actions = new ArrayList<>();
		
		ActionStd<FimgysarchInfo> enforceGroup = new StdFimgysarchEnforceGroup(option);
		ActionLazy<FimgysarchInfo> select = new LazyFimgysarchRootSelect(option.conn, option.schemaName);
		
		enforceGroup.addPostAction(select);
		
		actions.add(enforceGroup);
		return actions;
	}
}
