package br.com.gda.file.fileUpload.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.file.fileUpload.info.FilupInfo;
import br.com.gda.file.fileUpload.model.action.StdFilupDelete;
import br.com.gda.file.fileUpload.model.checker.FilupCheckExist;
import br.com.gda.file.fileUpload.model.checker.FilupCheckWrite;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.model.decisionTree.DeciTreeWriteTemplate;

public final class RootFilupDelete extends DeciTreeWriteTemplate<FilupInfo> {
	
	public RootFilupDelete(DeciTreeOption<FilupInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<FilupInfo> buildDecisionCheckerHook(DeciTreeOption<FilupInfo> option) {
		final boolean EXIST_ON_DB = true;
		
		List<ModelChecker<FilupInfo>> queue = new ArrayList<>();		
		ModelChecker<FilupInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checker = new FilupCheckWrite();
		queue.add(checker);
			
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;		
		checker = new FilupCheckExist(checkerOption);
		queue.add(checker);	

		return new ModelCheckerQueue<FilupInfo>(queue);
	}
	
	
	
	@Override protected List<ActionStd<FilupInfo>> buildActionsOnPassedHook(DeciTreeOption<FilupInfo> option) {
		List<ActionStd<FilupInfo>> actions = new ArrayList<>();

		ActionStd<FilupInfo> delete = new StdFilupDelete(option);
		
		actions.add(delete);
		return actions;
	}
}
