package br.com.mind5.file.fileImageList.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.file.fileImageList.info.FimistInfo;
import br.com.mind5.file.fileImageList.model.action.StdFimistMergeToSelect;
import br.com.mind5.file.fileImageList.model.checker.FimistCheckLangu;
import br.com.mind5.file.fileImageList.model.checker.FimistCheckOwner;
import br.com.mind5.file.fileImageList.model.checker.FimistCheckRead;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeReadTemplate;

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
	
	
	
	@Override protected List<ActionStdV1<FimistInfo>> buildActionsOnPassedHook(DeciTreeOption<FimistInfo> option) {
		List<ActionStdV1<FimistInfo>> actions = new ArrayList<>();
		
		ActionStdV1<FimistInfo> select = new StdFimistMergeToSelect(option);
		
		actions.add(select);
		return actions;
	}
}
