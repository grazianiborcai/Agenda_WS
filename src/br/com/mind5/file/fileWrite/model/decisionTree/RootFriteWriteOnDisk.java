package br.com.mind5.file.fileWrite.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.file.fileWrite.info.FriteInfo;
import br.com.mind5.file.fileWrite.model.action.StdFriteWriteOnDisk;
import br.com.mind5.file.fileWrite.model.checker.FriteCheckWrite;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class RootFriteWriteOnDisk extends DeciTreeTemplateWrite<FriteInfo> {
	
	public RootFriteWriteOnDisk(DeciTreeOption<FriteInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<FriteInfo> buildCheckerHook(DeciTreeOption<FriteInfo> option) {
		List<ModelChecker<FriteInfo>> queue = new ArrayList<>();		
		ModelChecker<FriteInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new FriteCheckWrite(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<FriteInfo>> buildActionsOnPassedHook(DeciTreeOption<FriteInfo> option) {
		List<ActionStd<FriteInfo>> actions = new ArrayList<>();		
		
		ActionStd<FriteInfo> writeOnDisk = new StdFriteWriteOnDisk(option);	
		
		actions.add(writeOnDisk);		
		return actions;
	}
}
