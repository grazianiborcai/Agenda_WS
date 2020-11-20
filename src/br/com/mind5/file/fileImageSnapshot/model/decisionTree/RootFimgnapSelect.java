package br.com.mind5.file.fileImageSnapshot.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.file.fileImageSnapshot.info.FimgnapInfo;
import br.com.mind5.file.fileImageSnapshot.model.action.StdFimgnapMergeToSelect;
import br.com.mind5.file.fileImageSnapshot.model.checker.FimgnapCheckRead;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;

public final class RootFimgnapSelect extends DeciTreeTemplateRead<FimgnapInfo> {
	
	public RootFimgnapSelect(DeciTreeOption<FimgnapInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<FimgnapInfo> buildCheckerHook(DeciTreeOption<FimgnapInfo> option) {
		List<ModelChecker<FimgnapInfo>> queue = new ArrayList<>();		
		ModelChecker<FimgnapInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new FimgnapCheckRead(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<FimgnapInfo>> buildActionsOnPassedHook(DeciTreeOption<FimgnapInfo> option) {
		List<ActionStd<FimgnapInfo>> actions = new ArrayList<>();
		
		ActionStd<FimgnapInfo> select = new StdFimgnapMergeToSelect(option);
		
		actions.add(select);
		return actions;
	}
}
