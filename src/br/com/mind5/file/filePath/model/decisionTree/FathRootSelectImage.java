package br.com.mind5.file.filePath.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.file.filePath.info.FathInfo;
import br.com.mind5.file.filePath.model.action.FathVisiRootSelect;
import br.com.mind5.file.filePath.model.action.FathVisiEnforceCodImage;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.common.ModelCheckerDummy;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;

public final class FathRootSelectImage extends DeciTreeTemplateRead<FathInfo> {
	
	public FathRootSelectImage(DeciTreeOption<FathInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<FathInfo> buildCheckerHook(DeciTreeOption<FathInfo> option) {
		List<ModelChecker<FathInfo>> queue = new ArrayList<>();		
		ModelChecker<FathInfo> checker;
		
		checker = new ModelCheckerDummy<>();
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<FathInfo>> buildActionsOnPassedHook(DeciTreeOption<FathInfo> option) {
		List<ActionStd<FathInfo>> actions = new ArrayList<>();
		
		ActionStd<FathInfo> enforceCodImage = new ActionStdCommom<FathInfo>(option, FathVisiEnforceCodImage.class);
		ActionLazy<FathInfo> select = new ActionLazyCommom<FathInfo>(option, FathVisiRootSelect.class);
		
		enforceCodImage.addPostAction(select);
		
		actions.add(enforceCodImage);
		return actions;
	}
}
