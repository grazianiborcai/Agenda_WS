package br.com.gda.file.fileImage.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.file.fileImage.info.FimgInfo;
import br.com.gda.file.fileImage.model.action.StdFimgDelete;
import br.com.gda.file.fileImage.model.checker.FimgCheckExist;
import br.com.gda.file.fileImage.model.checker.FimgCheckWrite;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.model.decisionTree.DeciTreeWriteTemplate;

public final class RootFimgDelete extends DeciTreeWriteTemplate<FimgInfo> {
	
	public RootFimgDelete(DeciTreeOption<FimgInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<FimgInfo> buildDecisionCheckerHook(DeciTreeOption<FimgInfo> option) {
		final boolean EXIST_ON_DB = true;
		
		List<ModelChecker<FimgInfo>> queue = new ArrayList<>();		
		ModelChecker<FimgInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checker = new FimgCheckWrite();
		queue.add(checker);
			
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;		
		checker = new FimgCheckExist(checkerOption);
		queue.add(checker);	

		return new ModelCheckerQueue<FimgInfo>(queue);
	}
	
	
	
	@Override protected List<ActionStd<FimgInfo>> buildActionsOnPassedHook(DeciTreeOption<FimgInfo> option) {
		List<ActionStd<FimgInfo>> actions = new ArrayList<>();

		ActionStd<FimgInfo> delete = new StdFimgDelete(option);
		
		actions.add(delete);
		return actions;
	}
}
