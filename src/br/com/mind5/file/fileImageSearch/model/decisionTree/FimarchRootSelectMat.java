package br.com.mind5.file.fileImageSearch.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.file.fileImageSearch.info.FimarchInfo;
import br.com.mind5.file.fileImageSearch.model.action.FimarchVisiRootSelect;
import br.com.mind5.file.fileImageSearch.model.action.FimarchVisiEnforceMat;
import br.com.mind5.file.fileImageSearch.model.checker.FimarchCheckReadMat;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;

public final class FimarchRootSelectMat extends DeciTreeTemplateRead<FimarchInfo> {
	
	public FimarchRootSelectMat(DeciTreeOption<FimarchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<FimarchInfo> buildCheckerHook(DeciTreeOption<FimarchInfo> option) {
		List<ModelChecker<FimarchInfo>> queue = new ArrayList<>();		
		ModelChecker<FimarchInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new FimarchCheckReadMat(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<FimarchInfo>> buildActionsOnPassedHook(DeciTreeOption<FimarchInfo> option) {
		List<ActionStd<FimarchInfo>> actions = new ArrayList<>();
		
		ActionStd<FimarchInfo> enforceMat = new ActionStdCommom<FimarchInfo>(option, FimarchVisiEnforceMat.class);
		ActionLazy<FimarchInfo> select = new ActionLazyCommom<FimarchInfo>(option, FimarchVisiRootSelect.class);
		
		enforceMat.addPostAction(select);
		
		actions.add(enforceMat);
		return actions;
	}
}
