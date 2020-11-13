package br.com.mind5.file.filePath.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.file.filePath.info.FathInfo;
import br.com.mind5.file.filePath.model.action.LazyFathRootSelect;
import br.com.mind5.file.filePath.model.action.StdFathEnforceCodImage;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.common.ModelCheckerDummy;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateReadV2;

public final class RootFathSelectImage extends DeciTreeTemplateReadV2<FathInfo> {
	
	public RootFathSelectImage(DeciTreeOption<FathInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<FathInfo> buildCheckerHook(DeciTreeOption<FathInfo> option) {
		List<ModelCheckerV1<FathInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<FathInfo> checker;
		
		checker = new ModelCheckerDummy<>();
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV2<FathInfo>> buildActionsOnPassedHook(DeciTreeOption<FathInfo> option) {
		List<ActionStdV2<FathInfo>> actions = new ArrayList<>();
		
		ActionStdV2<FathInfo> enforceCodImage = new StdFathEnforceCodImage(option);
		ActionLazy<FathInfo> select = new LazyFathRootSelect(option.conn, option.schemaName);
		
		enforceCodImage.addPostAction(select);
		
		actions.add(enforceCodImage);
		return actions;
	}
}
