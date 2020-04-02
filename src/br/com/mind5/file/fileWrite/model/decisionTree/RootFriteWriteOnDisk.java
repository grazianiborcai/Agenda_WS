package br.com.mind5.file.fileWrite.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.file.fileWrite.info.FriteInfo;
import br.com.mind5.file.fileWrite.model.action.StdFriteWriteOnDisk;
import br.com.mind5.file.fileWrite.model.checker.FriteCheckWrite;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeWriteTemplate;

public final class RootFriteWriteOnDisk extends DeciTreeWriteTemplate<FriteInfo> {
	
	public RootFriteWriteOnDisk(DeciTreeOption<FriteInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<FriteInfo> buildDecisionCheckerHook(DeciTreeOption<FriteInfo> option) {
		List<ModelChecker<FriteInfo>> queue = new ArrayList<>();		
		ModelChecker<FriteInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new FriteCheckWrite(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<FriteInfo>> buildActionsOnPassedHook(DeciTreeOption<FriteInfo> option) {
		List<ActionStdV1<FriteInfo>> actions = new ArrayList<>();		
		
		ActionStdV1<FriteInfo> writeOnDisk = new StdFriteWriteOnDisk(option);	
		
		actions.add(writeOnDisk);		
		return actions;
	}
}
