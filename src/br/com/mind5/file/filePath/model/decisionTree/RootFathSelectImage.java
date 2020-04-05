package br.com.mind5.file.filePath.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.file.filePath.info.FathInfo;
import br.com.mind5.file.filePath.model.action.LazyFathRootSelect;
import br.com.mind5.file.filePath.model.action.StdFathEnforceCodImage;
import br.com.mind5.file.filePath.model.checker.FathCheckDummy;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeReadTemplate;

public final class RootFathSelectImage extends DeciTreeReadTemplate<FathInfo> {
	
	public RootFathSelectImage(DeciTreeOption<FathInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<FathInfo> buildCheckerHook(DeciTreeOption<FathInfo> option) {
		List<ModelChecker<FathInfo>> queue = new ArrayList<>();		
		ModelChecker<FathInfo> checker;
		
		checker = new FathCheckDummy();
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<FathInfo>> buildActionsOnPassedHook(DeciTreeOption<FathInfo> option) {
		List<ActionStdV1<FathInfo>> actions = new ArrayList<>();
		
		ActionStdV1<FathInfo> enforceCodImage = new StdFathEnforceCodImage(option);
		ActionLazyV1<FathInfo> select = new LazyFathRootSelect(option.conn, option.schemaName);
		
		enforceCodImage.addPostAction(select);
		
		actions.add(enforceCodImage);
		return actions;
	}
}
