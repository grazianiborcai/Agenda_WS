package br.com.gda.file.fileWrite.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.file.fileWrite.info.FriteInfo;
import br.com.gda.file.fileWrite.model.action.StdFriteWriteOnDisk;
import br.com.gda.file.fileWrite.model.checker.FriteCheckWrite;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.model.decisionTree.DeciTreeWriteTemplate;

public final class RootFriteWriteOnDisk extends DeciTreeWriteTemplate<FriteInfo> {
	
	public RootFriteWriteOnDisk(DeciTreeOption<FriteInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<FriteInfo> buildDecisionCheckerHook(DeciTreeOption<FriteInfo> option) {
		List<ModelChecker<FriteInfo>> queue = new ArrayList<>();		
		ModelChecker<FriteInfo> checker;
		
		checker = new FriteCheckWrite();
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<FriteInfo>> buildActionsOnPassedHook(DeciTreeOption<FriteInfo> option) {
		List<ActionStd<FriteInfo>> actions = new ArrayList<>();		
		
		ActionStd<FriteInfo> writeOnDisk = new StdFriteWriteOnDisk(option);	
		
		actions.add(writeOnDisk);		
		return actions;
	}
}
