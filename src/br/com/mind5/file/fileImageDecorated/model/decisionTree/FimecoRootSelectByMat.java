package br.com.mind5.file.fileImageDecorated.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.file.fileImageDecorated.info.FimecoInfo;
import br.com.mind5.file.fileImageDecorated.model.action.FimecoVisiRootSelect;
import br.com.mind5.file.fileImageDecorated.model.action.FimecoVisiEnforceMatKey;
import br.com.mind5.file.fileImageDecorated.model.checker.FimecoCheckReadByMat;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;

public final class FimecoRootSelectByMat extends DeciTreeTemplateRead<FimecoInfo> {
	
	public FimecoRootSelectByMat(DeciTreeOption<FimecoInfo> option) {
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
		checker = new FimecoCheckReadByMat(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<FimecoInfo>> buildActionsOnPassedHook(DeciTreeOption<FimecoInfo> option) {
		List<ActionStd<FimecoInfo>> actions = new ArrayList<>();
		
		ActionStd<FimecoInfo> enforceMatKey = new ActionStdCommom<FimecoInfo>(option, FimecoVisiEnforceMatKey.class);
		ActionLazy<FimecoInfo> select = new ActionLazyCommom<FimecoInfo>(option, FimecoVisiRootSelect.class);
		
		enforceMatKey.addPostAction(select);
		
		actions.add(enforceMatKey);
		return actions;
	}
}
