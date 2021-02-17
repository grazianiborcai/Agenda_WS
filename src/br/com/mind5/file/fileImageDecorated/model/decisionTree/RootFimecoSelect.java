package br.com.mind5.file.fileImageDecorated.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.file.fileImageDecorated.info.FimecoInfo;
import br.com.mind5.file.fileImageDecorated.model.action.StdFimecoMergeFimist;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.common.ModelCheckerDummy;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;

public final class RootFimecoSelect extends DeciTreeTemplateRead<FimecoInfo> {
	
	public RootFimecoSelect(DeciTreeOption<FimecoInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<FimecoInfo> buildCheckerHook(DeciTreeOption<FimecoInfo> option) {
		List<ModelChecker<FimecoInfo>> queue = new ArrayList<>();		
		ModelChecker<FimecoInfo> checker;	

		checker = new ModelCheckerDummy<>();
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<FimecoInfo>> buildActionsOnPassedHook(DeciTreeOption<FimecoInfo> option) {
		List<ActionStd<FimecoInfo>> actions = new ArrayList<>();
		
		ActionStd<FimecoInfo> mergeFimist = new StdFimecoMergeFimist(option);
		
		actions.add(mergeFimist);
		return actions;
	}
}
