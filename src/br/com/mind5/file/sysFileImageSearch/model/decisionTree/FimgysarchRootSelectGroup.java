package br.com.mind5.file.sysFileImageSearch.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.file.sysFileImageSearch.info.FimgysarchInfo;
import br.com.mind5.file.sysFileImageSearch.model.action.FimgysarchVisiRootSelect;
import br.com.mind5.file.sysFileImageSearch.model.action.FimgysarchVisiEnforceGroup;
import br.com.mind5.file.sysFileImageSearch.model.checker.FimgysarchCheckReadGroup;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;

public final class FimgysarchRootSelectGroup extends DeciTreeTemplateRead<FimgysarchInfo> {
	
	public FimgysarchRootSelectGroup(DeciTreeOption<FimgysarchInfo> option) {
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
		
		ActionStd<FimgysarchInfo> enforceGroup = new ActionStdCommom<FimgysarchInfo>(option, FimgysarchVisiEnforceGroup.class);
		ActionLazy<FimgysarchInfo> select = new ActionLazyCommom<FimgysarchInfo>(option, FimgysarchVisiRootSelect.class);
		
		enforceGroup.addPostAction(select);
		
		actions.add(enforceGroup);
		return actions;
	}
}
