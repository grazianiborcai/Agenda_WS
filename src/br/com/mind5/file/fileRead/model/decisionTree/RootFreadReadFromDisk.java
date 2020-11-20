package br.com.mind5.file.fileRead.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.file.fileRead.info.FreadInfo;
import br.com.mind5.file.fileRead.model.action.StdFreadReadFromDisk;
import br.com.mind5.file.fileRead.model.checker.FreadCheckWrite;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class RootFreadReadFromDisk extends DeciTreeTemplateWrite<FreadInfo> {
	
	public RootFreadReadFromDisk(DeciTreeOption<FreadInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<FreadInfo> buildCheckerHook(DeciTreeOption<FreadInfo> option) {
		List<ModelChecker<FreadInfo>> queue = new ArrayList<>();		
		ModelChecker<FreadInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new FreadCheckWrite(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<FreadInfo>> buildActionsOnPassedHook(DeciTreeOption<FreadInfo> option) {
		List<ActionStd<FreadInfo>> actions = new ArrayList<>();		
		
		ActionStd<FreadInfo> writeOnDisk = new StdFreadReadFromDisk(option);	
		
		actions.add(writeOnDisk);		
		return actions;
	}
}
