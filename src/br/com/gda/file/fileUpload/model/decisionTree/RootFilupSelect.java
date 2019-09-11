package br.com.gda.file.fileUpload.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.file.fileUpload.info.FilupInfo;
import br.com.gda.file.fileUpload.model.action.LazyFilupMergeFath;
import br.com.gda.file.fileUpload.model.action.StdFilupMergeToSelect;
import br.com.gda.file.fileUpload.model.checker.FilupCheckRead;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.model.decisionTree.DeciTreeReadTemplate;

public final class RootFilupSelect extends DeciTreeReadTemplate<FilupInfo> {
	
	public RootFilupSelect(DeciTreeOption<FilupInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<FilupInfo> buildDecisionCheckerHook(DeciTreeOption<FilupInfo> option) {
		List<ModelChecker<FilupInfo>> queue = new ArrayList<>();		
		ModelChecker<FilupInfo> checker;
		
		checker = new FilupCheckRead();
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<FilupInfo>> buildActionsOnPassedHook(DeciTreeOption<FilupInfo> option) {
		List<ActionStd<FilupInfo>> actions = new ArrayList<>();
		
		ActionStd<FilupInfo> select = new StdFilupMergeToSelect(option);
		ActionLazy<FilupInfo> mergeFath = new LazyFilupMergeFath(option.conn, option.schemaName);
		
		select.addPostAction(mergeFath);
		
		actions.add(select);
		return actions;
	}
}
