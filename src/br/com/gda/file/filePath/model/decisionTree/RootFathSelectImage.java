package br.com.gda.file.filePath.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.file.filePath.info.FathInfo;
import br.com.gda.file.filePath.model.action.LazyFathRootSelect;
import br.com.gda.file.filePath.model.action.StdFathEnforceCodImage;
import br.com.gda.file.filePath.model.checker.FathCheckDummy;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.model.decisionTree.DeciTreeReadTemplate;

public final class RootFathSelectImage extends DeciTreeReadTemplate<FathInfo> {
	
	public RootFathSelectImage(DeciTreeOption<FathInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<FathInfo> buildDecisionCheckerHook(DeciTreeOption<FathInfo> option) {
		List<ModelChecker<FathInfo>> queue = new ArrayList<>();		
		ModelChecker<FathInfo> checker;
		
		checker = new FathCheckDummy();
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<FathInfo>> buildActionsOnPassedHook(DeciTreeOption<FathInfo> option) {
		List<ActionStd<FathInfo>> actions = new ArrayList<>();
		
		ActionStd<FathInfo> enforceCodImage = new StdFathEnforceCodImage(option);
		ActionLazy<FathInfo> select = new LazyFathRootSelect(option.conn, option.schemaName);
		
		enforceCodImage.addPostAction(select);
		
		actions.add(enforceCodImage);
		return actions;
	}
}
