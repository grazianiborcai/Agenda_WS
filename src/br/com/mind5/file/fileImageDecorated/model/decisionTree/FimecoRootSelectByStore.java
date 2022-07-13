package br.com.mind5.file.fileImageDecorated.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.file.fileImageDecorated.info.FimecoInfo;
import br.com.mind5.file.fileImageDecorated.model.action.FimecoVisiRootSelect;
import br.com.mind5.file.fileImageDecorated.model.action.FimecoVisiEnforceStoreKey;
import br.com.mind5.file.fileImageDecorated.model.checker.FimecoCheckReadByStore;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;

public final class FimecoRootSelectByStore extends DeciTreeTemplateRead<FimecoInfo> {
	
	public FimecoRootSelectByStore(DeciTreeOption<FimecoInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<FimecoInfo> buildCheckerHook(DeciTreeOption<FimecoInfo> option) {
		List<ModelChecker<FimecoInfo>> queue = new ArrayList<>();		
		ModelChecker<FimecoInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new FimecoCheckReadByStore(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<FimecoInfo>> buildActionsOnPassedHook(DeciTreeOption<FimecoInfo> option) {
		List<ActionStd<FimecoInfo>> actions = new ArrayList<>();
		
		ActionStd<FimecoInfo> enforceStoreKey = new ActionStdCommom<FimecoInfo>(option, FimecoVisiEnforceStoreKey.class);
		ActionLazy<FimecoInfo> select = new ActionLazyCommom<FimecoInfo>(option, FimecoVisiRootSelect.class);
		
		enforceStoreKey.addPostAction(select);
		
		actions.add(enforceStoreKey);
		return actions;
	}
}
