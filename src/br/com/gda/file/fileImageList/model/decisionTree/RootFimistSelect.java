package br.com.gda.file.fileImageList.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.file.fileImageList.info.FimistInfo;
import br.com.gda.file.fileImageList.model.action.StdFimistMergeToSelect;
import br.com.gda.file.fileImageList.model.checker.FimistCheckLangu;
import br.com.gda.file.fileImageList.model.checker.FimistCheckOwner;
import br.com.gda.file.fileImageList.model.checker.FimistCheckRead;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.model.decisionTree.DeciTreeReadTemplate;

public final class RootFimistSelect extends DeciTreeReadTemplate<FimistInfo> {
	
	public RootFimistSelect(DeciTreeOption<FimistInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<FimistInfo> buildDecisionCheckerHook(DeciTreeOption<FimistInfo> option) {
		List<ModelChecker<FimistInfo>> queue = new ArrayList<>();		
		ModelChecker<FimistInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new FimistCheckRead(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new FimistCheckLangu(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new FimistCheckOwner(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<FimistInfo>> buildActionsOnPassedHook(DeciTreeOption<FimistInfo> option) {
		List<ActionStd<FimistInfo>> actions = new ArrayList<>();
		
		ActionStd<FimistInfo> select = new StdFimistMergeToSelect(option);
		
		actions.add(select);
		return actions;
	}
}
